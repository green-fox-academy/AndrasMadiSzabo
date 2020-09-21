package com.gf.rest.repositories;

import com.gf.rest.models.entities.LogEntry;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogEntryRepository extends CrudRepository<LogEntry, Long> {
  List<LogEntry> findAllByIdGreaterThanEqual(long id);
  int countLogEntriesByIdGreaterThan(long id);
}
