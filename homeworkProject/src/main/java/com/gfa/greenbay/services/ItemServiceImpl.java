package com.gfa.greenbay.services;

import com.gfa.greenbay.dtos.ItemRequestDTO;
import com.gfa.greenbay.models.SellableItem;
import com.gfa.greenbay.repositories.ItemRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

  ItemRepository itemRepository;

  @Autowired
  public ItemServiceImpl(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
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
    if (itemRequestDTO.getPhotoUrl() == null || itemRequestDTO.getPhotoUrl().isEmpty() ||
        !itemRequestDTO.getPhotoUrl().startsWith("https://") ) {
      missingDimensionsList.add("photoUrl is not a valid url");
    }
    if (itemRequestDTO.getStartingPrice() <= 0) {
      missingDimensionsList.add("startingPrice must be a positive whole number");
    }
    if (itemRequestDTO.getPurchasePrice() <= 0) {
      missingDimensionsList.add("purchasePrice must be a positive whole number");
    }

    if (missingDimensionsList.size() == 0) {
      return "ok";
    } else {
      return String.join(", ", missingDimensionsList);
    }
  }

  @Override
  public boolean itemNameExists(ItemRequestDTO itemRequestDTO) {
    Optional<SellableItem> existingItem =
        itemRepository.findSellableItemByName(itemRequestDTO.getName());
    return existingItem.isPresent();
  }

  @Override
  public void saveItem(
      String name, String description, String photoUrl, int startingPrice, int purchasePrice) {
    itemRepository.save(
        new SellableItem(name, description, photoUrl, startingPrice, purchasePrice));
  }

  @Override
  public SellableItem findSellableItemByName(String name) {
    Optional<SellableItem> optionalSellableItem = itemRepository.findSellableItemByName(name);
    return optionalSellableItem.get();
  }
}
