package com.greenfox.matrev_rebuild.repositories;

import com.greenfox.matrev_rebuild.models.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

  @Query("select s from Car s where s.brand = 'BMW' ")
  Car findMyFavouriteCar();
}
