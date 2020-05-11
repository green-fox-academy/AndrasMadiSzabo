package com.greenfox.matrev_rebuild.service;

import com.greenfox.matrev_rebuild.models.Car;
import com.greenfox.matrev_rebuild.models.Owner;
import com.greenfox.matrev_rebuild.repositories.CarRepository;
import com.greenfox.matrev_rebuild.repositories.OwnerRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {
  private CarRepository carRepository;
  private OwnerService ownerService;
//  This could also work (step 1)
//  private OwnerRepository ownerRepository;

  @Autowired
  public CarServiceImpl(CarRepository carRepository, OwnerService ownerService) {
    this.carRepository = carRepository;
    this.ownerService = ownerService;
  }

//  This could also work (step 2)
//  @Autowired
//  public CarServiceImpl(CarRepository carRepository, OwnerService ownerService, OwnerRepository ownerRepository) {
//    this.carRepository = carRepository;
//    this.ownerService = ownerService;
//    this.ownerRepository = ownerRepository;
//  }

  @Override
  public Car findById(Long id) {
    Car car = new Car();
    if (carRepository.findById(id).isPresent()) {
      car = carRepository.findById(id).get();
    }
    return car;
  }

  // Can it work like this?
  //  public Car findById(Long id) {
  //    if (carRepository.findById(id).isPresent()) {
  //      return carRepository.findById(id).get();
  //    } return null;
  //  }

  @Override
  public List<Car> returnAllCars() {
    List<Car> cars = new ArrayList<>();
    carRepository
        .findAll()
        .forEach(car -> cars.add(car));
    return cars;
  }

  @Override
  public void addOwnerToCar(Long ownerId, Long carId) {
    Car car = findById(carId);
    Owner owner = ownerService.findById(ownerId);
    car.setOwner(owner);
    ownerService.addCarToOwner(car, owner);
    carRepository.save(car);
  }

//  This could also work (step 3)
//  @Override
//  public void addOwnerToCar(Long ownerId, Long carId) {
//    Car car = findById(carId);
//    Owner owner = new Owner();
//    if (ownerRepository.findById(ownerId).isPresent()) {
//      owner=ownerRepository.findById(ownerId).get();
//    }
//    car.setOwner(owner);
//  }

  //////////////////////////////////////////////////////

//  Pityu today
//  @Override
//  public void addOwnerToCar(Owner owner, Car car) {
//    car.setOwner(owner);
//    List<Car> ownerCars = owner.getCars();
//    ownerCars.add(car);
//    owner.setCars(ownerCars);
//    carRepository.save(car);
//    ownerService.addCarToOwner(car, owner);
//  }
}
