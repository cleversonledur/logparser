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

    public static DurationType getByName(String name) {
        for (DurationType duration : values()) {
            if (duration.getType().equals(name)) {
                return duration;
            }
        }

        throw new IllegalArgumentException(name + " is not a valid duration");
    }
}
