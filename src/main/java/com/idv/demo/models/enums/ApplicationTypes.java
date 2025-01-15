package com.idv.demo.models.enums;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum ApplicationTypes {
    ACTIVE_WORKER("ApplicationActiveWorkerService"),
    RETIRED_WORKER("ApplicationRetiredWorkerService");

    private final String value;

    ApplicationTypes(String value) {
        this.value = value;
    }
}
