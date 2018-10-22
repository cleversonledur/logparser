package com.ef.utils;

import com.ef.domain.model.LogEntry;

public class LogEntryValidator {

    public static void validate(LogEntry logEntry) throws Exception {

        if (logEntry.getDate() == null) {
            throw new Exception("Log entry date is null. " + logEntry);
        }

        if (logEntry.getIp() == null) {
            throw new Exception("Log entry ip is null " + logEntry);
        }

        if (logEntry.getRequest() == null) {
            throw new Exception("Log entry request is null " + logEntry);
        }

        if (logEntry.getStatus() == null) {
            throw new Exception("Log entry status is null " + logEntry);
        }

        if (logEntry.getUserAgent() == null) {
            throw new Exception("Log entry user agent is null " + logEntry);
        }
    }
}
