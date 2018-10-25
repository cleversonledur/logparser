package com.ef.domain.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ef.domain.model.LogEntry;
import com.ef.domain.model.LogEntryIPCount;

@Repository public interface LogEntryRepository extends CrudRepository<LogEntry, Integer> {

    List<LogEntry> findByStatus(String status);

    @Query("SELECT " + " new com.ef.domain.model.LogEntryIPCount(v.ip, COUNT(v)) " + " FROM " + " LogEntry v "
                    + " WHERE v.date >= ?1 AND v.date <= ?2 " + " GROUP BY " + " v.ip ")
    List<LogEntryIPCount> getLogEntriesByIpAndDateTime(LocalDateTime startDateTime, LocalDateTime endDateTime);
}
