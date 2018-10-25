package com.ef.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ef.domain.enumerator.DurationType;
import com.ef.domain.model.LogEntry;
import com.ef.utils.LogParser;
import com.ef.utils.OptionParser;

@Service public class ParserService implements CommandLineRunner {
    @Autowired LogEntryService logEntryService;

    @Override
    public void run(String[] args) throws Exception {
        Map<String, String> parameters = OptionParser.parse(args);

        String accessLogParameter = parameters.get(OptionParser.ACCESS_LOG_PARAMETER);
        String durationParameter = parameters.get(OptionParser.DURATION_PARAMETER);
        String startDateParameter = parameters.get(OptionParser.START_DATE_PARAMETER);
        String thresholdParameter = parameters.get(OptionParser.THRESHOLD_PARAMETER);

        OptionParser.validate(accessLogParameter, durationParameter, startDateParameter, thresholdParameter);

        persistDataLogToDatabase(accessLogParameter);

        processQueries(durationParameter, startDateParameter, thresholdParameter);

    }

    private void processQueries(String durationParameter, String startDateParameter, String thresholdParameter) {
        logEntryService.getLogEntriesByIpAndDateTime(OptionParser.parseDateParameter(startDateParameter),
                        DurationType.getByName(durationParameter), Integer.valueOf(thresholdParameter));
    }

    private void persistDataLogToDatabase(String accessLogParameter) throws Exception {
        if (!StringUtils.isEmpty(accessLogParameter)) {
            List<LogEntry> log = LogParser.parseLog(accessLogParameter);
            logEntryService.addLogEntryList(log);
        }
    }
}
