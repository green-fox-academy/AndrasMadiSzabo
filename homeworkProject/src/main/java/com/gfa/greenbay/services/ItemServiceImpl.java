package com.gfa.greenbay.services;

import com.gfa.greenbay.dtos.BidRequestDTO;
import com.gfa.greenbay.dtos.ItemRequestDTO;
import com.gfa.greenbay.models.Bid;
import com.gfa.greenbay.models.GreenBayUser;
import com.gfa.greenbay.models.SellableItem;
import com.gfa.greenbay.repositories.BidRepository;
import com.gfa.greenbay.repositories.ItemRepository;
import com.gfa.greenbay.repositories.UserRepository;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

  ItemRepository itemRepository;
  UserRepository userRepository;
  BidRepository bidRepository;

  @Autowired
  public ItemServiceImpl(
      ItemRepository itemRepository, UserRepository userRepository, BidRepository bidRepository) {
    this.itemRepository = itemRepository;
    this.userRepository = userRepository;
    this.bidRepository = bidRepository;
  }

  @Override
  public String missingDimensions(ItemRequestDTO itemRequestDTO) {
    ArrayList<String> missingDimensionsList = new ArrayList<>();
    if (itemRequestDTO.getName() == null || itemRequestDTO.getName().isEmpty()) {
      missingDimensionsList.add("name");
    }
    if (itemRequestDTO.getDescription() == null || itemRequestDTO.getDescription().isEmpty()) {
      missingDimensionsList.add("description");
    }
    if (itemRequestDTO.getPhotoUrl() == null
        || itemRequestDTO.getPhotoUrl().isEmpty()
        || !itemRequestDTO.getPhotoUrl().startsWith("https://")) {
      missingDimensionsList.add("photoUrl is not a valid url");
    }
    if (itemRequestDTO.getStartingPrice() == null || itemRequestDTO.getStartingPrice() <= 0) {
      missingDimensionsList.add("startingPrice must be a positive whole number");
    }
    if (itemRequestDTO.getPurchasePrice() == null || itemRequestDTO.getPurchasePrice() <= 0) {
      missingDimensionsList.add("purchasePrice must be a positive whole number");
    }

    if (missingDimensionsList.size() == 0) {
      return "ok";
    } else {
      return String.join(", ", missingDimensionsList);
    }
  }

  @Override
  public String checkIfSaleIsPossible(BidRequestDTO bidRequestDTO, Principal principal) {
    ArrayList<String> issueList = new ArrayList<>();
    if (itemRepository.findById(bidRequestDTO.getId()).isEmpty()) {
      issueList.add("this id doesn't exist");
      return String.join(", ", issueList);
    }
    if (bidRequestDTO.getId() == null) {
      issueList.add("the item is not found");
    }
    if (!itemRepository.findById(bidRequestDTO.getId()).get().isSellable()) {
      issueList.add("this item can't be bought");
    }
    if (userRepository
            .findGreenBayUserByUsername(principal.getName())
            .get()
            .getGreenBayDollarsAccount()
        <= bidRequestDTO.getLastBid()) {
      issueList.add("there's not enough money on the user's account");
    }
    if (bidRequestDTO.getLastBid()
            <= itemRepository.findById(bidRequestDTO.getId()).get().getLastBid()
        || bidRequestDTO.getLastBid()
            < itemRepository.findById(bidRequestDTO.getId()).get().getStartingPrice()) {
      issueList.add("the bid is too low");
    }

    if (issueList.size() == 0) {
      return "ok";
    } else {
      return String.join(", ", issueList);
    }
  }

  @Override
  public void sellItem(BidRequestDTO bidRequestDTO, Principal principal) {
    SellableItem sellableItem = itemRepository.findById(bidRequestDTO.getId()).get();

    if (bidRequestDTO.getLastBid() < sellableItem.getPurchasePrice()) {
      sellableItem.setLastBid(bidRequestDTO.getLastBid());
      Bid bid = new Bid(principal.getName(), bidRequestDTO.getLastBid(), sellableItem);
      bidRepository.save(bid);
      sellableItem.getBidHistory().add(bid);
      itemRepository.save(sellableItem);
    }
    if (bidRequestDTO.getLastBid() >= sellableItem.getPurchasePrice()) {
      sellableItem.setSellable(false);
      sellableItem.setBuyerName(principal.getName());
      sellableItem.setLastBid(bidRequestDTO.getLastBid());
      itemRepository.save(sellableItem);

      GreenBayUser greenBayUser =
          userRepository.findGreenBayUserByUsername(principal.getName()).get();
      greenBayUser.setGreenBayDollarsAccount(
          greenBayUser.getGreenBayDollarsAccount() - sellableItem.getPurchasePrice());
      userRepository.save(greenBayUser);
    }
  }

  @Override
  public boolean itemUpdated(BidRequestDTO bidRequestDTO) {
    SellableItem sellableItem = itemRepository.findById(bidRequestDTO.getId()).get();
    return (!sellableItem.isSellable() && sellableItem.getBuyerName() != null);
  }

  @Override
  public boolean itemSold(BidRequestDTO bidRequestDTO) {
    SellableItem sellableItem = itemRepository.findById(bidRequestDTO.getId()).get();
    return (!sellableItem.isSellable() && sellableItem.getBuyerName() != null);
  }

  @Override
  public boolean itemNameExists(ItemRequestDTO itemRequestDTO) {
    Optional<SellableItem> existingItem =
        itemRepository.findSellableItemByName(itemRequestDTO.getName());
    return existingItem.isPresent();
  }

  @Override
  public void saveItem(
      String name,
      String description,
      String photoUrl,
      int startingPrice,
      int purchasePrice,
      Principal principal) {
    String sellerName = principal.getName();
    itemRepository.save(
        new SellableItem(name, description, photoUrl, startingPrice, purchasePrice, sellerName));
  }

  @Override
  public void save50Items(Principal principal) {
    for (int i = 0; i < 50; i++) {
      String name = Integer.toString(i);
      String description = Integer.toString(i);
      String photoUrl = "https://www." + i + ".com";
      int startingPrice = i + 100;
      int purchasePrice = i + 300;
      itemRepository.save(
          new SellableItem(name, description, photoUrl, startingPrice, purchasePrice,
              principal.getName()));
    }
  }

  @Override
  public SellableItem findSellableItemByName(String name) {
    Optional<SellableItem> optionalSellableItem = itemRepository.findSellableItemByName(name);
    return optionalSellableItem.get();
  }

  @Override
  public SellableItem findSellableItemById(Long id) {
    Optional<SellableItem> optionalSellableItem = itemRepository.findById(id);
    return optionalSellableItem.orElse(null);
  }

  @Override
  public Page<SellableItem> findAllSellableItems(Integer pageNumber) {
    Pageable firstPageWithTwoElements = PageRequest.of(pageNumber-1, 5);
    return itemRepository.findAll(firstPageWithTwoElements);
  }
}
