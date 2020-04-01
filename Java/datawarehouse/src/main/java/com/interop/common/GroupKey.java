package com.interop.common;

public enum GroupKey {
    GROUPKEY272("272"),
    GROUPKEY270("270");

    private final String stringValue;

    GroupKey(String value) {
        stringValue = value;
    }

    @Override
    public String toString() {
        return this.stringValue;
    }
}
