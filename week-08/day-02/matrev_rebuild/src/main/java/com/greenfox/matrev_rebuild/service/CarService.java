package com.greenfox.matrev_rebuild.service;

import com.greenfox.matrev_rebuild.models.Car;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface CarService {

  Car findById(Long id);
  List<Car> returnAllCars();
  void addOwnerToCar(Long ownerId, Long CarId);
}

