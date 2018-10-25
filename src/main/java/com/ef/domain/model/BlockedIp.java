package com.ef.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity public class BlockedIp {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Integer id;

    private String ip;
    private Long requests;
    private String reason;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Long getRequests() {
        return requests;
    }

    public void setRequests(Long requests) {
        this.requests = requests;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "BlockedIp{" + "id=" + id + ", ip='" + ip + '\'' + ", requests=" + requests + ", reason='" + reason + '\'' + '}';
    }
}
