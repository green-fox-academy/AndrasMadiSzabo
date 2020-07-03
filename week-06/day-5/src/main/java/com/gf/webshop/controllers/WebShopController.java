package com.gf.webshop.controllers;

import com.gf.webshop.models.ShopItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebShopController {

  List<ShopItem> shopItemList = new ArrayList<>(Arrays.asList(
      new ShopItem("Jelly Comb MS04 Slim Triple Mode Mouse",
          "TRIPLE WIRELESS CONNECTIVITY: Compared with traditional mouse, it’s a brand-new versatile mouse with triple wireless mode - Bluetooth/USB/Type C connection.",
          300, 6),
      new ShopItem("MOSISO Laptop Sleeve",
          "Compatible with 13-13.3 inch MacBook Pro, MacBook Air, Notebook Computer, Water Repellent Neoprene Bag with Small Case, Baby Pink",
          500, 17),
      new ShopItem("Nike Mens Air Max Torch 4 Running Sneaker", "TPU overlays provide targeted support for a snug, secure fit.",
          600, 90),
      new ShopItem("USB C Hub", "Portable & Anti - overheat & plug and go",
          2, 1),
      new ShopItem("Nike Men's Benassi Just Do It Athletic Sandal", "Lightweight sports slide sandal for men with a bold Nike logo embellished on the strap for plush comfort and an athletic look.",
          20, 100),
      new ShopItem("Syntech USB C to USB Adapter", "compatible with ANY lalptop/tablet/smartphone ",
          20, 1),
      new ShopItem("External CD DVD Drive", "compatible with USB3. 0 and backwards compatible with USB2",
          200, 19)
  ));

  @GetMapping("/")
  public String webshop(Model model){
model.addAttribute("shopItemList", shopItemList);
    return "webshop";
  }
}
