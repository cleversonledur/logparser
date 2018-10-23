package com.ef.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ef.domain.enumerator.DurationType;
import com.ef.domain.model.LogEntry;
import com.ef.domain.model.LogEntryIPCount;
import com.ef.domain.repository.LogEntryRepository;
import com.ef.utils.LogEntryValidator;

@Service public class LogEntryService {

    @Autowired LogEntryRepository logEntryRepository;

    public void addLogEntry(LogEntry logEntry) {

        try {
            LogEntryValidator.validate(logEntry);
            logEntryRepository.save(logEntry);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getLogEntriesByIpAndDateTime(LocalDateTime startDateTime, DurationType duration, Integer threshold) {

        LocalDateTime endDateTime = startDateTime;

        if (duration.equals(DurationType.DAILY)) {
            endDateTime = startDateTime.plusDays(1);
        }

        if (duration.equals(DurationType.HOURLY)) {
            endDateTime = startDateTime.plusHours(1);
        }

        List<LogEntryIPCount> countResult = logEntryRepository.getLogEntriesByIpAndDateTime(startDateTime, endDateTime);

        countResult.stream().filter(ip -> ip.getCount() >= threshold).peek(ip -> {
            System.out.println(ip.getIp() + ' ' + ip.getCount());
            //Persist
        });

    }

    public void addLogEntryList(List<LogEntry> log) {
        log.forEach(logEntry -> addLogEntry(logEntry));
    }
}
