package com.ef.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity public class LogEntry {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Integer id;

    private LocalDateTime date;
    private String ip;
    private String request;
    private String status;
    private String userAgent;

    public LogEntry(String[] entryParts) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

        this.date = LocalDateTime.parse(entryParts[0], formatter);
        this.ip = entryParts[1];
        this.request = entryParts[2];
        this.status = entryParts[3];
        this.userAgent = entryParts[4];
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public String toString() {
        return "LogEntry{" + "id=" + id + ", date=" + date + ", ip='" + ip + '\'' + ", request='" + request + '\'' + ", status='" + status
                        + '\'' + ", userAgent='" + userAgent + '\'' + '}';
    }
}
