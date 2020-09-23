package com.gfa.greenbay.services;

import com.gfa.greenbay.models.SellableItem;
import com.gfa.greenbay.repositories.ItemRepository;
import com.gfa.greenbay.repositories.UserRepository;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidServiceImpl implements BidService {

  ItemRepository itemRepository;
  UserRepository userRepository;

  @Autowired
  public BidServiceImpl(ItemRepository itemRepository, UserRepository userRepository) {
    this.itemRepository = itemRepository;
    this.userRepository = userRepository;
  }

  public void saveItem(
      String name, String description, String photoUrl, int startingPrice, int purchasePrice, Principal principal) {
      String sellerName = principal.getName();
    itemRepository.save(
        new SellableItem(name, description, photoUrl, startingPrice, purchasePrice, sellerName));
  }


}
