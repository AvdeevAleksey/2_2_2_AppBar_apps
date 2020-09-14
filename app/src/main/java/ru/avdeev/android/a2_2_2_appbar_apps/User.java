package ru.avdeev.android.a2_2_2_appbar_apps;

public class User {
    String userFio;
    int userAge;
    Pressure pressurePulse;

    public User(String userFio, int userAge) {
        this.userFio = userFio;
        this.userAge = userAge;
    }

    public User(String userFio, int userAge, Pressure pressurePulse) {
        this.userFio = userFio;
        this.userAge = userAge;
        this.pressurePulse = pressurePulse;
    }
}
