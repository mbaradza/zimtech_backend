package com.ehr.patient.enums;


public enum HTSResult {

    REACTIVE("Reactive"),
    NONE_REACTIVE("None Reactive");
    private final String name;

    public String getName() {
        return name;
    }

    HTSResult(String name) {
        this.name = name;
    }
}
