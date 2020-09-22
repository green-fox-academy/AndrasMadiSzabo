package com.gfa.greenbay.services;

import com.gfa.greenbay.dtos.ItemRequestDTO;
import com.gfa.greenbay.models.SellableItem;
import org.springframework.stereotype.Service;

@Service
public interface ItemService {


  boolean itemNameExists(ItemRequestDTO itemRequestDTO);

  void saveItem(String name, String description, String photoUrl, int startingPrice, int purchasePrice);

  SellableItem findSellableItemByName(String name);

  String missingDimensions(ItemRequestDTO itemRequestDTO);
}
