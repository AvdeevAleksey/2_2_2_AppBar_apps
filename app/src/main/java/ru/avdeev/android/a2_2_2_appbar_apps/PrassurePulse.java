package ru.avdeev.android.a2_2_2_appbar_apps;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.appcompat.app.AppCompatActivity;

public class PrassurePulse extends AppCompatActivity {
    EditText highPressure;
    EditText lowerPressure;
    EditText pulse;
    Switch tachicardia;
    TextView txtdateTime;
    private static final String TAGPRASSURE = "Давление и пульс";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prassure_pulse);


        highPressure = findViewById(R.id.actPressureEditTextHigh);
        lowerPressure = findViewById(R.id.actPressureEditTextLower);
        pulse = findViewById(R.id.actPressureEditTextPulse);
        tachicardia = findViewById(R.id.actPressureSwitchTachicardia);
        txtdateTime = findViewById(R.id.actPressureTxtDateTimeNow);
        txtdateTime.setText(new SimpleDateFormat("HH:mm ' ' dd.MM.yyyy").format(new Date()));
    }

    public void btnSaveClicked (View view) {
        Log.i(TAGPRASSURE, "Пользователь нажал на кнопку 'Сохранить'");
        if (highPressure.getText().toString().equals("") || lowerPressure.getText().toString().equals("") || pulse.getText().toString().equals("")) {
            Toster.showMyMessage(R.string.Not_all_values_are_entered,this);
            Log.i(TAGPRASSURE, "Пользователь ввел не все данные");
        } else {
            try {
                int newHighPressure = Integer.parseInt(highPressure.getText().toString());
                int newLowerPressure = Integer.parseInt(lowerPressure.getText().toString());
                int newPulse = Integer.parseInt(pulse.getText().toString());
                boolean newTachicardia = tachicardia.isChecked();
                String newDateTime = txtdateTime.getText().toString();
                Pressure newPressure = new Pressure(newHighPressure, newLowerPressure, newPulse, newTachicardia, newDateTime);
                Intent intent = new Intent(PrassurePulse.this, Vitals.class);
                startActivity(intent);
            } catch (Exception ex) {
                Toster.showMyMessage(R.string.pressure_invalid_input,this);
                Log.i(TAGPRASSURE, "Пользователь некорректно ввел данные");
            }
        }
    }
}