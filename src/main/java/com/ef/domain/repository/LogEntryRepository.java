package com.ef.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.ef.domain.model.LogEntry;

public interface LogEntryRepository extends CrudRepository<LogEntry, Integer> {
}
