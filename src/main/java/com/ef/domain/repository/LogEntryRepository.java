package com.ef.domain.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ef.domain.model.LogEntry;

@Repository public interface LogEntryRepository extends CrudRepository<LogEntry, Integer> {

    List<LogEntry> findByStatus(String status);
}
