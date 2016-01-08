package com.test.rest.models.enums.device;

/**
 * Created by Nazar on 01.01.2016.
 */
public enum UpdateFrequency {
    FIVE_MINUTES(5),
    TEN_MINUTES(10),
    FIFTEEN_MINUTES(15),
    THIRTY_MINUTES(30),
    FORTY_FIVE_MINUTES(45),
    ONE_HOUR(60),
    TWO_HOUR(2*60),
    FOR_HOUR(6*60),
    SIX_HOUR(6*60),
    TWELVE_HOUR(12*60),
    ONE_DAY(24*60);
    int minutes;

    UpdateFrequency(int minutes) {
        this.minutes = minutes;
    }

    public int getMinutes() {
        return minutes;
    }
}
