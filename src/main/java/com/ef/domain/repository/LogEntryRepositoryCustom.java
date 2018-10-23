package com.ef.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.ef.domain.model.LogEntry;

public interface LogEntryRepositoryCustom {

    @Query("SELECT l FROM LogEntry l WHERE l.ip = ?1 ")
    List<LogEntry> findUserByStatusAndName(String ip);
}
