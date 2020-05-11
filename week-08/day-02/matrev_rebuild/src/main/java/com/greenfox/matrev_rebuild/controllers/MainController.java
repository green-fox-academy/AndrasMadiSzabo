package com.greenfox.matrev_rebuild.controllers;

import com.greenfox.matrev_rebuild.models.Car;
import com.greenfox.matrev_rebuild.models.Owner;
import com.greenfox.matrev_rebuild.service.CarService;
import com.greenfox.matrev_rebuild.service.OwnerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
  private CarService carService;
  private OwnerService ownerService;

  @Autowired
  public MainController(CarService carService, OwnerService ownerService) {
    this.carService = carService;
    this.ownerService = ownerService;
  }

  @GetMapping("list-cars")
  @ResponseBody
  public List<Car> listCars() {
    return carService.returnAllCars();
  }

  @GetMapping("add-owner-to-car/{carId}/{ownerId}")
  public String addOwnerToCar(@PathVariable(name = "carId") Long carId,
                              @PathVariable(name = "ownerId") Long ownerId) {
    //carService.addOwnerToCar(ownerService.findById(ownerId).getId(), carService.findById(carId).getId());
    // Ugyanaz, mint  (???)
    carService.addOwnerToCar(ownerId, carId);
    return "redirect:/list-cars";
  }

  @GetMapping("list-owners")
  @ResponseBody
  public List<Owner> listOwners(){
    return ownerService.returnAllOwner();
  }
}
