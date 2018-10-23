package com.ef.domain.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.ef.domain.model.LogEntryIPCount;

public interface LogEntryRepositoryCustom {

    @Query("SELECT " + " new com.ef.domain.model.LogEntryIPCount(v.ip, COUNT(v)) " + "FROM " + " LogEntry v "
                    + "WHERE date >= ?1 and date <= ?2" + "GROUP BY " + " v.ip")
    List<LogEntryIPCount> getLogEntriesByIpAndDateTime(LocalDateTime startDateTime, LocalDateTime endDateTime);
}
