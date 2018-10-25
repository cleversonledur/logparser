package com.ef.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ef.domain.enumerator.DurationType;
import com.ef.domain.model.BlockedIp;
import com.ef.domain.model.LogEntry;
import com.ef.domain.model.LogEntryIPCount;
import com.ef.domain.repository.BlockedIpRepository;
import com.ef.domain.repository.LogEntryRepository;
import com.ef.utils.LogEntryValidator;

@Service public class LogEntryService {

    @Autowired LogEntryRepository logEntryRepository;

    @Autowired BlockedIpRepository blockedIpRepository;

    public void addLogEntry(LogEntry logEntry) {

        try {
            LogEntryValidator.validate(logEntry);
            logEntryRepository.save(logEntry);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getLogEntriesByIpAndDateTime(LocalDateTime startDateTime, DurationType duration, Integer threshold) {

        LocalDateTime endDateTime = calculateEndDateTime(startDateTime, duration);

        List<LogEntryIPCount> countResult = logEntryRepository.getLogEntriesByIpAndDateTime(startDateTime, endDateTime);

        logAndPersistBlockedIps(startDateTime, threshold, countResult, endDateTime);

    }

    private LocalDateTime calculateEndDateTime(LocalDateTime startDateTime, DurationType duration) {
        LocalDateTime endDateTime = startDateTime;

        if (duration.equals(DurationType.DAILY)) {
            endDateTime = startDateTime.plusDays(1);
        }

        if (duration.equals(DurationType.HOURLY)) {
            endDateTime = startDateTime.plusHours(1);
        }
        return endDateTime;
    }

    private void logAndPersistBlockedIps(LocalDateTime startDateTime, Integer threshold, List<LogEntryIPCount> countResult,
                    LocalDateTime end) {
        for (LogEntryIPCount ip : countResult) {
            if (ip.getCount() >= threshold.longValue()) {

                logBlockedIp(ip);

                persistBlockedIp(startDateTime, end, ip);
            }
        }
    }

    private void logBlockedIp(LogEntryIPCount ip) {
        System.out.println(ip.getIp() + ' ' + ip.getCount());
    }

    private void persistBlockedIp(LocalDateTime startDateTime, LocalDateTime end, LogEntryIPCount ip) {
        BlockedIp blockedIp = new BlockedIp();
        blockedIp.setIp(ip.getIp());
        blockedIp.setReason("This ip is blocked because this made " + ip.getCount() + " request between " + startDateTime + " and " + end
                        + ".");
        blockedIp.setRequests(ip.getCount());
        blockedIpRepository.save(blockedIp);
    }

    public void addLogEntryList(List<LogEntry> log) {
        log.forEach(logEntry -> addLogEntry(logEntry));
    }
}
