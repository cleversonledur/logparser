package com.ef;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.util.StringUtils;

import com.ef.domain.model.LogEntry;
import com.ef.service.LogEntryService;
import com.ef.utils.LogParser;
import com.ef.utils.OptionParser;

@EnableAutoConfiguration(exclude = HibernateJpaAutoConfiguration.class) @SpringBootApplication public class Parser
                implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Parser.class, args);
    }

    @Autowired LogEntryService logEntryService;

    @Override
    public void run(String[] args) throws Exception {

        Map<String, String> parameters = OptionParser.parse(args);

        String accessLogParameter = parameters.get(OptionParser.ACCESS_LOG_PARAMETER);
        String durationParameter = parameters.get(OptionParser.DURATION_PARAMETER);
        String startDateParameter = parameters.get(OptionParser.START_DATE_PARAMETER);
        String thresholdParameter = parameters.get(OptionParser.THRESHOLD_PARAMETER);

        if (StringUtils.isEmpty(accessLogParameter)) {
            List<LogEntry> log = LogParser.parseLog(accessLogParameter);
            logEntryService.addLogEntryList(log);
        }

        System.out.println("ok");
    }
}
