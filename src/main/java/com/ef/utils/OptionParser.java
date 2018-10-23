package com.ef.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

public class OptionParser {

    public static String ACCESS_LOG_PARAMETER = "--accesslog";
    public static String START_DATE_PARAMETER = "--startDate";
    public static String DURATION_PARAMETER = "--duration";
    public static String THRESHOLD_PARAMETER = "--threshold";

    public static Map<String, String> parse(String[] args) {
        Map<String, String> options = new HashMap<>();
        for (String arg : args) {
            String[] parameter = arg.split("=");
            options.put(parameter[0], parameter[1]);
        }
        return options;
    }

    public static void validate(String accessLogParameter, String durationParameter, String startDateParameter, String thresholdParameter)
                    throws Exception {

        if (StringUtils.isEmpty(durationParameter)) {
            throw new Exception("The duration information is required to retrieve log information.\n" + "Inform hourly or daily values. \n"
                            + "Ex: --duration=hourly");
        }
        if (StringUtils.isEmpty(startDateParameter)) {
            throw new Exception("The start date information is required to retrieve log information.\n"
                            + "Inform start date using the following format yyyy-MM-dd HH:mm:ss.SSS. \n"
                            + "Ex: --startDate=2017-01-01.15:00:00");
        }
        if (StringUtils.isEmpty(thresholdParameter)) {
            throw new Exception("The threshold information is required to retrieve log information.\n"
                            + "Inform the threshold value with 200 or 500 values. \n" + "Ex: --threshold=200");
        }
    }
}
