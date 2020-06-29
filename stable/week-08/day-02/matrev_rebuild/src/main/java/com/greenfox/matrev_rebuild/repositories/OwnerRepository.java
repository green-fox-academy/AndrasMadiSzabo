package com.greenfox.matrev_rebuild.repositories;

import com.greenfox.matrev_rebuild.models.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
