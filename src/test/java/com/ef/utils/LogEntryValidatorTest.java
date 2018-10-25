package com.ef.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.boot.test.context.SpringBootTest;

import com.ef.domain.model.LogEntry;

@SpringBootTest public class LogEntryValidatorTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Rule public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void validateLogEntryWithCorrectFormats() throws Exception {
        LogEntry logEntry = new LogEntry();
        logEntry.setUserAgent("Mozilla/5.0");
        logEntry.setIp("192.168 .169 .194");
        logEntry.setRequest("GET / HTTP / 1.1");
        logEntry.setStatus("200");
        logEntry.setDate(OptionParser.parseDateFromDataLog("2017-01-01 00:00:21.164"));

        LogEntryValidator.validate(logEntry);
    }

    @Test
    public void validateLogEntryWithNullIp() throws Exception {

        LogEntry logEntry = new LogEntry();
        logEntry.setUserAgent("Mozilla/5.0");
        logEntry.setIp(null);
        logEntry.setRequest("GET / HTTP / 1.1");
        logEntry.setStatus("200");
        logEntry.setDate(OptionParser.parseDateFromDataLog("2017-01-01 00:00:21.164"));

        expectedException.expect(Exception.class);
        expectedException.expectMessage("Log entry ip is null " + logEntry);

        LogEntryValidator.validate(logEntry);
    }

    @Test
    public void validateLogEntryWithNullDate() throws Exception {

        LogEntry logEntry = new LogEntry();
        logEntry.setUserAgent("Mozilla/5.0");
        logEntry.setIp("192.168 .169 .194");
        logEntry.setRequest("GET / HTTP / 1.1");
        logEntry.setStatus("200");
        logEntry.setDate(null);

        expectedException.expect(Exception.class);
        expectedException.expectMessage("Log entry date is null " + logEntry);

        LogEntryValidator.validate(logEntry);
    }

    @Test
    public void validateLogEntryWithNullStatus() throws Exception {

        LogEntry logEntry = new LogEntry();
        logEntry.setUserAgent("Mozilla/5.0");
        logEntry.setIp("192.168 .169 .194");
        logEntry.setRequest("GET / HTTP / 1.1");
        logEntry.setStatus(null);
        logEntry.setDate(OptionParser.parseDateFromDataLog("2017-01-01 00:00:21.164"));

        expectedException.expect(Exception.class);
        expectedException.expectMessage("Log entry status is null " + logEntry);

        LogEntryValidator.validate(logEntry);
    }

    @Test
    public void validateLogEntryWithNullUserAgent() throws Exception {

        LogEntry logEntry = new LogEntry();
        logEntry.setUserAgent(null);
        logEntry.setIp("192.168 .169 .194");
        logEntry.setRequest("GET / HTTP / 1.1");
        logEntry.setStatus("200");
        logEntry.setDate(OptionParser.parseDateFromDataLog("2017-01-01 00:00:21.164"));

        expectedException.expect(Exception.class);
        expectedException.expectMessage("Log entry user agent is null " + logEntry);

        LogEntryValidator.validate(logEntry);
    }

    @Test
    public void validateLogEntryWithNullRequest() throws Exception {

        LogEntry logEntry = new LogEntry();
        logEntry.setUserAgent("Mozilla/5.0");
        logEntry.setIp("192.168 .169 .194");
        logEntry.setRequest(null);
        logEntry.setStatus("200");
        logEntry.setDate(OptionParser.parseDateFromDataLog("2017-01-01 00:00:21.164"));

        expectedException.expect(Exception.class);
        expectedException.expectMessage("Log entry request is null " + logEntry);

        LogEntryValidator.validate(logEntry);
    }

    @Test
    public void validateLogEntryWithEmptyIp() throws Exception {

        LogEntry logEntry = new LogEntry();
        logEntry.setUserAgent("Mozilla/5.0");
        logEntry.setIp("");
        logEntry.setRequest("GET / HTTP / 1.1");
        logEntry.setStatus("200");
        logEntry.setDate(OptionParser.parseDateFromDataLog("2017-01-01 00:00:21.164"));

        expectedException.expect(Exception.class);
        expectedException.expectMessage("Log entry ip is null " + logEntry);

        LogEntryValidator.validate(logEntry);
    }

    @Test
    public void validateLogEntryWithEmptyStatus() throws Exception {

        LogEntry logEntry = new LogEntry();
        logEntry.setUserAgent("Mozilla/5.0");
        logEntry.setIp("192.168 .169 .194");
        logEntry.setRequest("GET / HTTP / 1.1");
        logEntry.setStatus("");
        logEntry.setDate(OptionParser.parseDateFromDataLog("2017-01-01 00:00:21.164"));

        expectedException.expect(Exception.class);
        expectedException.expectMessage("Log entry status is null " + logEntry);

        LogEntryValidator.validate(logEntry);
    }

    @Test
    public void validateLogEntryWithEmptyUserAgent() throws Exception {

        LogEntry logEntry = new LogEntry();
        logEntry.setUserAgent("");
        logEntry.setIp("192.168 .169 .194");
        logEntry.setRequest("GET / HTTP / 1.1");
        logEntry.setStatus("200");
        logEntry.setDate(OptionParser.parseDateFromDataLog("2017-01-01 00:00:21.164"));

        expectedException.expect(Exception.class);
        expectedException.expectMessage("Log entry user agent is null " + logEntry);

        LogEntryValidator.validate(logEntry);
    }

    @Test
    public void validateLogEntryWithEmptyRequest() throws Exception {

        LogEntry logEntry = new LogEntry();
        logEntry.setUserAgent("Mozilla/5.0");
        logEntry.setIp("192.168 .169 .194");
        logEntry.setRequest("");
        logEntry.setStatus("200");
        logEntry.setDate(OptionParser.parseDateFromDataLog("2017-01-01 00:00:21.164"));

        expectedException.expect(Exception.class);
        expectedException.expectMessage("Log entry request is null " + logEntry);

        LogEntryValidator.validate(logEntry);
    }
}