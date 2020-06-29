package com.greenfoxacademy.exercise_frontend.repositories;

import com.greenfoxacademy.exercise_frontend.models.before_until.Greeter;
import org.springframework.data.repository.CrudRepository;

public interface GreeterRepository extends CrudRepository<Greeter, Long> {
}
