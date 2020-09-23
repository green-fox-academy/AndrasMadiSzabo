package com.gfa.greenbay.services;

import com.gfa.greenbay.dtos.BidRequestDTO;
import com.gfa.greenbay.dtos.ItemRequestDTO;
import com.gfa.greenbay.dtos.ItemResponseDTO;
import com.gfa.greenbay.models.SellableItem;
import java.security.Principal;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface ItemService {

  boolean itemNameExists(ItemRequestDTO itemRequestDTO);

  void saveItem(
      String name,
      String description,
      String photoUrl,
      int startingPrice,
      int purchasePrice,
      Principal principal);

  SellableItem findSellableItemByName(String name);

  String missingDimensions(ItemRequestDTO itemRequestDTO);

  String checkIfSaleIsPossible(BidRequestDTO bidRequestDTO, Principal principal);

  void sellItem(BidRequestDTO bidRequestDTO, Principal principal);

  boolean itemUpdated(BidRequestDTO bidRequestDTO);

  boolean itemSold(BidRequestDTO bidRequestDTO);

  SellableItem findSellableItemById(Long id);
  public ItemResponseDTO findSellableItemByIdReturnDTO(Long id);

  Page<SellableItem> findAllSellableItems(Integer pageNumber);

  void save50Items(Principal principal);
}
