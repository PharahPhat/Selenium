package com.interop.common;

public enum State {
    OHIO("Ohio", "OH"),
    OHIO_UPSELL("Ohio_Upsell", "OHU"),
    CONNECTICUT("Connecticut", "CT"),
    MOLINA("Molina", "MO"),
    INDIANA("Indiana", "IN"),
    COLORADO("Colorado", "CO"),
    PENNSYLVANIA("Pennsylvania", "PA"),
    ARIZONA("Arizona", "AZ"),
    HAWAII("Hawaii", "HI"),
    RHODEISLAND("RhodeIsland", "RI"),
    VERMONT("Vermont", "VT"),
    WISCONSIN("Wisconsin", "WI");

    private final String stringValue;
    private final String stringKey;

    State(String value, String key) {
        stringValue = value; stringKey = key;
    }

    @Override
    public String toString() {
        return this.stringValue;
    }

    public String getStringKey() {
        return stringKey;
    }
}
