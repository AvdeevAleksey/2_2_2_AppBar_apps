package ru.avdeev.android.a2_2_2_appbar_apps;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SpinnerActivity extends AppCompatActivity {

    Spinner spinnerCountry;
    Spinner spinnerCity;
    Spinner spinnerHouseNumber;
    Button buttonOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        spinnerCountry=findViewById(R.id.countrySpinner);
        spinnerCity=findViewById(R.id.citySpinner);
        spinnerHouseNumber=findViewById(R.id.houseNumberSpinner);
        givCountry();
        givHouseNumber();
        //initViews();
    }

    /*private void initViews() {
        spinnerCountry=findViewById(R.id.countrySpinner);
        spinnerCity=findViewById(R.id.citySpinner);
        spinnerHouseNumber=findViewById(R.id.houseNumberSpinner);
        buttonOk = findViewById(R.id.btnOk);
        givCountry();
        givHouseNumber();
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMyMessage(spinnerCountry.getSelectedItem().toString() + " " + spinnerCity.getSelectedItem().toString() + " " + spinnerHouseNumber.getSelectedItem().toString(), MainActivity.this);
            }
        });


    }*/

    public void btnOkClicked (View view) {
        showMyMessage(spinnerCountry.getSelectedItem().toString() + " " + spinnerCity.getSelectedItem().toString() + " " + spinnerHouseNumber.getSelectedItem().toString(), SpinnerActivity.this);
    }

    private void givCountry() {
        ArrayAdapter<CharSequence> adapterCountries = ArrayAdapter.createFromResource(this, R.array.countries, android.R.layout.simple_spinner_item);
        adapterCountries.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(adapterCountries);

        spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] countries = getResources().getStringArray(R.array.countries);
                givCities(countries[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //showMyMessage("Ничего не выбрано", MainActivity.this);
            }
        });
    }

    private void givCities(String country) {
        ArrayAdapter<CharSequence> adapter = null;
        switch (country) {
            case "Россия":
                adapter = ArrayAdapter.createFromResource(this, R.array.r_cities, android.R.layout.simple_spinner_item);
                break;
            case "Украина":
                adapter = ArrayAdapter.createFromResource(this, R.array.u_cities, android.R.layout.simple_spinner_item);
                break;
            case "Белорусь":
                adapter = ArrayAdapter.createFromResource(this, R.array.b_cities, android.R.layout.simple_spinner_item);
                break;
        }
        if (adapter != null) {
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerCity.setAdapter(adapter);
        }
    }

    private void givHouseNumber() {
        Integer[] houseNumbers = new Integer[50];
        for (int i = 1; i <= 50; i++) {
            houseNumbers[i - 1] = i;
        }
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item,houseNumbers);
        spinnerHouseNumber.setAdapter(adapter);
    }

    public void showMyMessage(String massage, Context contexts) {
        String text = massage;
        SpannableStringBuilder biggerText = new SpannableStringBuilder(text);
        biggerText.setSpan(new RelativeSizeSpan(1.35f), 0, text.length(), 0);
        Toast toast = Toast.makeText(contexts, biggerText, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }
}