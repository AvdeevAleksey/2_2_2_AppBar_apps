package ru.avdeev.android.a2_2_2_appbar_apps;

public class Pressure {
    int highPressure;
    int lowerPressure;
    int pulse;
    boolean tachicardia;
    String dateTime;
    Vitals vitals;

    public Pressure(int highPressure, int lowerPressure, int pulse, boolean tachicardia, String dateTime) {
        this.highPressure = highPressure;
        this.lowerPressure = lowerPressure;
        this.pulse = pulse;
        this.tachicardia = tachicardia;
        this.dateTime = dateTime;
    }
}
