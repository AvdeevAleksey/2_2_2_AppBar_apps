package ru.avdeev.android.a2_2_2_appbar_apps;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Vitals extends AppCompatActivity {
    EditText weight;
    EditText steps;
    private static final String TAGVITALS = "Жизненные показатели";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitals);

        weight = findViewById(R.id.vitalsEditTextWeight);
        steps = findViewById(R.id.vitalsEditTextSteps);
    }

    public void btnSaveClicked (View view) {
        Log.i(TAGVITALS, "Пользователь нажал на кнопку 'Сохранить'");
        if (weight.getText().toString().equals("") || steps.getText().toString().equals("")) {
            Toster.showMyMessage(R.string.Not_all_values_are_entered,this);
            Log.i(TAGVITALS, "Пользователь ввел не все данные");
        } else {
            try {
                int newWeight = Integer.parseInt(weight.getText().toString());
                int newSteps = Integer.parseInt(steps.getText().toString());
                WeightSteps newWeightSteps = new WeightSteps(newWeight, newSteps);
                Intent intent = new Intent(Vitals.this, HealthMonitoringActivity.class);
                startActivity(intent);
            } catch (Exception ex) {
                Toster.showMyMessage(R.string.pressure_invalid_input,this);
                Log.i(TAGVITALS, "Пользователь некорректно ввел данные");
            }
        }
    }
}