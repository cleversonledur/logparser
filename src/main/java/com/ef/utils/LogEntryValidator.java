package com.ef.utils;

import org.springframework.util.StringUtils;

import com.ef.domain.model.LogEntry;

public class LogEntryValidator {

    public static void validate(LogEntry logEntry) throws Exception {

        if (logEntry.getDate() == null) {
            throw new Exception("Log entry date is null " + logEntry);
        }

        if (StringUtils.isEmpty(logEntry.getIp())) {
            throw new Exception("Log entry ip is null " + logEntry);
        }

        if (StringUtils.isEmpty(logEntry.getRequest())) {
            throw new Exception("Log entry request is null " + logEntry);
        }

        if (StringUtils.isEmpty(logEntry.getStatus())) {
            throw new Exception("Log entry status is null " + logEntry);
        }

        if (StringUtils.isEmpty(logEntry.getUserAgent())) {
            throw new Exception("Log entry user agent is null " + logEntry);
        }
    }
}
