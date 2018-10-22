package com.ef.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.ef.domain.model.LogEntry;

public class LogParser {

    public static List<LogEntry> parseLog(String filePath) throws Exception {

        try {
            return parseLogFile(filePath);
        } catch (IOException e) {
            throw new Exception("Cannot parse file " + filePath);
        }
    }

    public static List<LogEntry> parseLogFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        List<LogEntry> log = new ArrayList<>();

        for (String line : Files.readAllLines(path, StandardCharsets.US_ASCII)) {
            log.add(LogParser.parseEntry(line));
        }
        return log;
    }

    public static LogEntry parseEntry(String logEntry) {
        String[] entryParts = logEntry.split("\\|");
        return new LogEntry(entryParts);
    }
}
