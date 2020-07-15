package com.gf.webshop.controllers;

import static java.lang.Math.round;

import com.gf.webshop.models.Currency;
import com.gf.webshop.models.ShopItem;
import com.gf.webshop.models.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebShopController {

  List<ShopItem> shopItemList = new ArrayList<>(Arrays.asList(
      new ShopItem("Jelly Comb MS04 Slim Triple Mode Mouse",
          "TRIPLE WIRELESS CONNECTIVITY: Compared with traditional mouse, it’s a brand-new versatile mouse with triple wireless mode - Bluetooth/USB/Type C connection.",
          300, 6, Type.ELECTRONICS),
      new ShopItem("MOSISO Laptop Sleeve",
          "Compatible with 13-13.3 inch MacBook Pro, MacBook Air, Notebook Computer, Water Repellent Neoprene Bag with Small Case, Baby Pink",
          500, 17, Type.CLOTHES),
      new ShopItem("Nike Mens Air Max Torch 4 Running Sneaker", "TPU overlays provide targeted support for a snug, secure fit.",
          600, 90, Type.CLOTHES),
      new ShopItem("USB C Hub", "Portable & Anti - overheat & plug and go",
          2, 0, Type.ELECTRONICS),
      new ShopItem("Coca-Cola", "2l 6-pack", 59, 90, Type.FOOD),
      new ShopItem("Snack", "multi-pack", 9, 900, Type.FOOD),
      new ShopItem("Nike Men's Benassi Just Do It Athletic Sandal", "Lightweight sports slide sandal for men with a bold Nike logo embellished on the strap for plush comfort and an athletic look.",
          20, 100, Type.CLOTHES),
      new ShopItem("Syntech USB C to USB Adapter", "compatible with ANY lalptop/tablet/smartphone ",
          20, 0, Type.ELECTRONICS),
      new ShopItem("External CD DVD Drive", "compatible with USB3. 0 and backwards compatible with USB2",
          200, 19, Type.ELECTRONICS)
  ));

  @GetMapping("/")
  public String webshop(Model model) {
    model.addAttribute("shopItemList", shopItemList);
    return "webshop";
  }

  @GetMapping("/only-available")
  public String only(Model model) {
    List<ShopItem> zerostock =
        shopItemList.stream()
            .filter(shopItem -> shopItem.getQuantityOfStock() == 0)
            .collect(Collectors.toList());
    model.addAttribute("shopItemList", zerostock);
    return "webshop";
  }

  @GetMapping("/cheapest-first")
  public String cheapest(Model model) {
    List<ShopItem> cheaplist =
        shopItemList.stream()
            .sorted(Comparator.comparing(ShopItem::getPrice))
            .collect(Collectors.toList());
    model.addAttribute("shopItemList", cheaplist);
    return "webshop";
  }

  @GetMapping("/contains-nike")
  public String nike(Model model) {
    List<ShopItem> nikelist =
        shopItemList.stream()
            .filter(shopItem -> shopItem.getName().toLowerCase().contains("nike") ||
                shopItem.getDescription().toLowerCase().contains("nike"))
            .collect(Collectors.toList());
    model.addAttribute("shopItemList", nikelist);
    return "webshop";
  }

  @GetMapping("/average-stock")
  public String average(Model model) {
    OptionalDouble averageStock =
        shopItemList.stream()
            .mapToDouble(ShopItem::getQuantityOfStock).average();
    if (averageStock.isPresent()) {
      model.addAttribute("averageStock", round(averageStock.getAsDouble()));
    } else {
      model.addAttribute("averageStock", "not available as the list is empty.");
    }
    return "results";
  }

  @GetMapping("/most-expensive")
  public String mostexpensive(Model model) {
    Optional<ShopItem> mostexpensive =
        shopItemList.stream()
            .max(Comparator.comparing(ShopItem::getPrice));
    if (mostexpensive.isPresent()) {
      model.addAttribute("mostExpensive", mostexpensive.get().getName());
    } else {
      model.addAttribute("mostExpensive", "not available as the list is empty.");
    }
    return "results";
  }

  @PostMapping("/search")
  public String search(@RequestParam String name, Model model) {
    List<ShopItem> searchResult = shopItemList.stream()
        .filter(shopItem -> shopItem.getName().toLowerCase().contains(name.toLowerCase()) ||
            shopItem.getDescription().toLowerCase().contains(name.toLowerCase()))
        .collect(Collectors.toList());
    model.addAttribute("shopItemList", searchResult);
    return "webshop";
  }

  @GetMapping("/more-filters")
  public String filters(Model model) {
    model.addAttribute("shopItemList", shopItemList);
    return "more-filters";
  }

  @GetMapping("/filter-by-type/{type}")
  public String typefilter(@PathVariable String type, Model model) {
    List<ShopItem> filtered = shopItemList.stream()
        .filter(shopItem -> shopItem.getType().name().toLowerCase().equals(type.toLowerCase()))
        .collect(Collectors.toList());
    model.addAttribute("shopItemList", filtered);
    return "more-filters";
  }

  @GetMapping("/currency/{inputCurrency}")
  public String euro(@PathVariable String inputCurrency, Model model) {
    List<ShopItem> newCurrencyList = new ArrayList<>();
    for (ShopItem s : shopItemList) {
      s.currencyConverter(inputCurrency);
      newCurrencyList.add(s);
    }
    model.addAttribute("shopItemList", newCurrencyList);
    return "more-filters";
  }

  @PostMapping("/filter-by-price")
  public String pricefilter(@RequestParam String priceString,
                            @RequestParam String input,
                            Model model) {
    double price = Double.parseDouble(priceString);
    switch (input) {
      case "exactly":
        List<ShopItem> filtered = shopItemList.stream()
            .filter(shopItem -> shopItem.getPrice() == price)
            .collect(Collectors.toList());
        model.addAttribute("shopItemList", filtered);
        break;
      case "above":
        filtered = shopItemList.stream()
            .filter(shopItem -> shopItem.getPrice() > price)
            .collect(Collectors.toList());
        model.addAttribute("shopItemList", filtered);
        break;
      case "below":
        filtered = shopItemList.stream()
            .filter(shopItem -> shopItem.getPrice() < price)
            .collect(Collectors.toList());
        model.addAttribute("shopItemList", filtered);
        break;
    }
    ;
    return "more-filters";
  }

}
