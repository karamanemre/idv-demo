package com.idv.demo.models.enums;

public enum PassportStatus {
    OK("DeservePassportService"),
    NON_OK("DeniedPassportService");

    private final String value;

    PassportStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
