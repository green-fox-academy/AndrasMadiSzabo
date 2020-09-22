package com.gfa.greenbay.controllers;

import com.gfa.greenbay.dtos.ErrorStatusDTO;
import com.gfa.greenbay.dtos.ItemRequestDTO;
import com.gfa.greenbay.dtos.LoginRequestDTO;
import com.gfa.greenbay.models.SellableItem;
import com.gfa.greenbay.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

  ItemService itemService;

  @Autowired
  public ItemController(ItemService itemService) {
    this.itemService = itemService;
  }

  @GetMapping("/items")
  public String hello(){
    return "hello";
  }


  @PostMapping("/create-item")
  public ResponseEntity<?> createitem(@RequestBody ItemRequestDTO itemRequestDTO){

    final HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);

    String checkDimensions = itemService.missingDimensions(itemRequestDTO);
    if (!checkDimensions.equals("ok")){
      return ResponseEntity
          .status(HttpStatus.BAD_REQUEST)
          .headers(httpHeaders)
          .body(new ErrorStatusDTO("error", "Incomplete dimensions: "
              + checkDimensions + "."));
    }

    if (itemService.itemNameExists(itemRequestDTO)){
      return ResponseEntity
          .status(HttpStatus.CONFLICT)
          .headers(httpHeaders)
          .body("Pls. find a new name as \"" + itemRequestDTO.getName()
              + "\" already exists in the database.");
    }

    itemService.saveItem(itemRequestDTO.getName(), itemRequestDTO.getDescription(),
        itemRequestDTO.getPhotoUrl(), itemRequestDTO.getStartingPrice(),
        itemRequestDTO.getPurchasePrice());

    if (itemService.itemNameExists(itemRequestDTO)){
      return ResponseEntity
          .status(HttpStatus.CREATED)
          .headers(httpHeaders)
          .body("Good job, a new sellable item has been created in the database. "
              + itemService.findSellableItemByName(itemRequestDTO.getName()).toString());
    }

    return ResponseEntity
        .status(HttpStatus.NOT_IMPLEMENTED)
        .headers(httpHeaders)
        .body("Can't believe it. Didn't manage to create new item in the database.");
  }

  @PostMapping("/bid")
  public ResponseEntity<?> bid(@RequestBody ItemRequestDTO itemRequestDTO){

    final HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);

    String checkDimensions = itemService.missingDimensions(itemRequestDTO);
    if (!checkDimensions.equals("ok")){
      return ResponseEntity
          .status(HttpStatus.BAD_REQUEST)
          .headers(httpHeaders)
          .body(new ErrorStatusDTO("error", "Incomplete dimensions: "
              + checkDimensions + "."));
    }

    if (itemService.itemNameExists(itemRequestDTO)){
      return ResponseEntity
          .status(HttpStatus.CONFLICT)
          .headers(httpHeaders)
          .body("Pls. find a new name as \"" + itemRequestDTO.getName()
              + "\" already exists in the database.");
    }

    itemService.saveItem(itemRequestDTO.getName(), itemRequestDTO.getDescription(),
        itemRequestDTO.getPhotoUrl(), itemRequestDTO.getStartingPrice(),
        itemRequestDTO.getPurchasePrice());

    if (itemService.itemNameExists(itemRequestDTO)){
      return ResponseEntity
          .status(HttpStatus.CREATED)
          .headers(httpHeaders)
          .body("Good job, a new sellable item has been created in the database. "
              + itemService.findSellableItemByName(itemRequestDTO.getName()).toString());
    }

    return ResponseEntity
        .status(HttpStatus.NOT_IMPLEMENTED)
        .headers(httpHeaders)
        .body("Can't believe it. Didn't manage to create new item in the database.");
  }

}
