package com.greenfox.matrev_rebuild.service;

import com.greenfox.matrev_rebuild.models.Car;
import com.greenfox.matrev_rebuild.models.Owner;
import com.greenfox.matrev_rebuild.repositories.OwnerRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService {
  private OwnerRepository ownerRepository;

  @Autowired
  public OwnerServiceImpl(OwnerRepository ownerRepository) {
    this.ownerRepository = ownerRepository;
  }

  @Override
  public Owner findById(Long id) {
    Owner owner = new Owner();
    if (ownerRepository.findById(id).isPresent()) {
      owner = ownerRepository.findById(id).get();
    }
    return owner;
  }

  @Override
  public List<Owner> returnAllOwner() {
    List<Owner> owners = new ArrayList<>();
    ownerRepository.findAll().forEach(owner -> owners.add(owner));
    return owners;
  }

  @Override
  public void addCarToOwner(Car car, Owner owner) {
    List<Car> cars = owner.getCars();
    cars.add(car);
    owner.setCars(cars);
    ownerRepository.save(owner);
  }
}
