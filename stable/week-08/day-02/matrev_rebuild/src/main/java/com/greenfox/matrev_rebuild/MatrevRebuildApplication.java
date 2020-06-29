package com.greenfox.matrev_rebuild;

import com.greenfox.matrev_rebuild.models.Car;
import com.greenfox.matrev_rebuild.models.Owner;
import com.greenfox.matrev_rebuild.repositories.CarRepository;
import com.greenfox.matrev_rebuild.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MatrevRebuildApplication implements CommandLineRunner {
  CarRepository carRepository;
  OwnerRepository ownerRepository;

  @Autowired
  public MatrevRebuildApplication(CarRepository carRepository, OwnerRepository ownerRepository) {
    this.carRepository = carRepository;
    this.ownerRepository = ownerRepository;
  }

  public static void main(String[] args) {
    SpringApplication.run(MatrevRebuildApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    carRepository.save(new Car("BMW", 200));
    carRepository.save(new Car("Audi", 250));
    carRepository.save(new Car("Suzuki", 150));

    ownerRepository.save(new Owner("Joska"));
    ownerRepository.save(new Owner("Adel"));
    ownerRepository.save(new Owner("Kinga"));

  }
}
