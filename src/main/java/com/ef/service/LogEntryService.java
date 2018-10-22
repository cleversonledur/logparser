package com.ef.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ef.domain.model.LogEntry;
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

    public void addLogEntryList(List<LogEntry> log) {
        log.forEach(logEntry -> addLogEntry(logEntry));
    }
}
