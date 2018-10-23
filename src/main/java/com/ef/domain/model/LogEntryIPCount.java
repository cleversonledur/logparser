package com.ef.domain.model;

public class LogEntryIPCount {

    private String ip;
    private Long count;

    public LogEntryIPCount(String ip, Long count) {
        this.ip = ip;
        this.count = count;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
