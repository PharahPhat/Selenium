package com.sandata.common;

public enum Timezone {
    EASTERN("US/Eastern"),
    MOUNTAIN("US/Mountain");

    private final String value;

    Timezone(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}