package com.greenfox.matrev_rebuild.service;

import com.greenfox.matrev_rebuild.models.Car;
import com.greenfox.matrev_rebuild.models.Owner;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface OwnerService {

  Owner findById(Long id);
  List<Owner> returnAllOwner();

  void addCarToOwner(Car car, Owner owner);

}
