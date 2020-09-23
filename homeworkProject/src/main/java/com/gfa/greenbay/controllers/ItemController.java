package com.gfa.greenbay.controllers;

import com.gfa.greenbay.dtos.BidRequestDTO;
import com.gfa.greenbay.dtos.ErrorStatusDTO;
import com.gfa.greenbay.dtos.ItemRequestDTO;
import com.gfa.greenbay.dtos.LoginRequestDTO;
import com.gfa.greenbay.models.SellableItem;
import com.gfa.greenbay.services.ItemService;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
  public String hello() {
    return "hello";
  }

  @PostMapping("/create-item")
  public ResponseEntity<?> createitem(
      @RequestBody ItemRequestDTO itemRequestDTO, Principal principal) {

    final HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);

    String checkDimensions = itemService.missingDimensions(itemRequestDTO);
    if (!checkDimensions.equals("ok")) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .headers(httpHeaders)
          .body(new ErrorStatusDTO("error", "Incomplete dimensions: " + checkDimensions + "."));
    }

    if (itemService.itemNameExists(itemRequestDTO)) {
      return ResponseEntity.status(HttpStatus.CONFLICT)
          .headers(httpHeaders)
          .body(
              "Pls. find a new name as \""
                  + itemRequestDTO.getName()
                  + "\" already exists in the database.");
    }

    itemService.saveItem(
        itemRequestDTO.getName(),
        itemRequestDTO.getDescription(),
        itemRequestDTO.getPhotoUrl(),
        itemRequestDTO.getStartingPrice(),
        itemRequestDTO.getPurchasePrice(),
        principal);

    if (itemService.itemNameExists(itemRequestDTO)) {
      return ResponseEntity.status(HttpStatus.CREATED)
          .headers(httpHeaders)
          .body(
              "Good job, a new sellable item has been created in the database. "
                  + itemService.findSellableItemByName(itemRequestDTO.getName()).toString());
    }

    return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
        .headers(httpHeaders)
        .body("Can't believe it. Didn't manage to create new item in the database.");
  }

  @PostMapping("/bid")
  public ResponseEntity<?> bid(@RequestBody BidRequestDTO bidRequestDTO, Principal principal) {

    final HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);

    String checkIfSaleIsPossible = itemService.checkIfSaleIsPossible(bidRequestDTO, principal);
    if (!checkIfSaleIsPossible.equals("ok")) {
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
          .headers(httpHeaders)
          .body(
              new ErrorStatusDTO(
                  "error", "The sale cannot be completed because " + checkIfSaleIsPossible + "."));
    }

    itemService.sellItem(bidRequestDTO, principal);

    if (itemService.itemSold(bidRequestDTO)) {
      return ResponseEntity.status(HttpStatus.OK)
          .headers(httpHeaders)
          .body("Good job, the item with id " + bidRequestDTO.getId() + " has been sold. ");
    }

    return ResponseEntity.status(HttpStatus.OK)
        .headers(httpHeaders)
        .body("The item with id " + bidRequestDTO.getId() + " has been updated with the new bid. ");
  }

  @PostMapping("/show-item/{id}")
  public ResponseEntity<?> showItem(@PathVariable Long id) {

    final HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);

    if (itemService.findSellableItemById(id) != null) {
      return ResponseEntity.status(HttpStatus.OK)
          .headers(httpHeaders)
          .body("The required item is this: \n" + itemService.findSellableItemById(id).toString());
    }

    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .headers(httpHeaders)
        .body("Can't believe it. Didn't manage to find this item in the database.");
  }

  @PostMapping({"/list-items/{pageNumber}", "/list-items"})
  public ResponseEntity<?> listItems(@PathVariable(required = false) Optional<Integer> pageNumber) {

    final HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);

    if (pageNumber.isEmpty()){
      pageNumber= Optional.of(1);
    }
    Page<SellableItem> sellableItemList = itemService.findAllSellableItems(pageNumber.get());


    if (sellableItemList != null || !sellableItemList.isEmpty()) {
      return ResponseEntity.status(HttpStatus.OK)
          .headers(httpHeaders)
          .body("The required items: \n" + sellableItemList.getContent());
    }

    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .headers(httpHeaders)
        .body("Can't believe it. Didn't manage to find these items in the database.");
  }

  @PostMapping("/create-50-items")
  public ResponseEntity<?> create50items(Principal principal) {

    final HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);

    itemService.save50Items(principal);

    return ResponseEntity.status(HttpStatus.CREATED)
        .headers(httpHeaders)
        .body("50 new sellable item have been created in the database. ");
  }
}
