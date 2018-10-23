package com.ef.domain.enumerator;

public enum DurationType {
    DAILY("daily"), HOURLY("hourly");

    private String type;

    DurationType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
