package com.ef.utils;

import java.util.HashMap;
import java.util.Map;

public class OptionParser {

    public static String ACCESS_LOG_PARAMETER = "--accesslog";
    public static String START_DATE_PARAMETER = "--atartDate";
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

}
