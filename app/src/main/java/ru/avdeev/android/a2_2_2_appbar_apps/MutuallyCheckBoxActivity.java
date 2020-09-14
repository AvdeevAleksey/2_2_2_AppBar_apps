package ru.avdeev.android.a2_2_2_appbar_apps;

import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MutuallyCheckBoxActivity extends AppCompatActivity {

    EditText editTextAmount;
    EditText editTextDescription;
    CheckBox checkBoxBank;
    CheckBox checkBoxMobile;
    CheckBox checkBoxCash;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mutualy_checkbox);
        editTextAmount = findViewById(R.id.amountEditText);
        editTextDescription = findViewById(R.id.descriptionEditText);
        checkBoxBank = findViewById(R.id.bankCardCheckBox);
        checkBoxMobile = findViewById(R.id.mobileCheckBox);
        checkBoxCash = findViewById(R.id.cashCheckBox);

        CompoundButton.OnCheckedChangeListener checkedChange = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                editTextDescription.setFocusable(true);
                if (b) {
                    switch (compoundButton.getId()) {
                        case R.id.bankCardCheckBox:
                            resetCheckBoxes();
                            checkBoxBank.setChecked(true);
                            editTextDescription.setInputType(InputType.TYPE_CLASS_NUMBER);
                            break;
                        case R.id.mobileCheckBox:
                            resetCheckBoxes();
                            checkBoxMobile.setChecked(true);
                            editTextDescription.setInputType(InputType.TYPE_CLASS_PHONE);
                            break;
                        case R.id.cashCheckBox:
                            resetCheckBoxes();
                            checkBoxCash.setChecked(true);
                            editTextDescription.setInputType(InputType.TYPE_CLASS_TEXT);
                            break;
                        default:
                    }
                }
            }
        };

        checkBoxBank.setOnCheckedChangeListener(checkedChange);
        checkBoxMobile.setOnCheckedChangeListener(checkedChange);
        checkBoxCash.setOnCheckedChangeListener(checkedChange);
    }

    private void resetCheckBoxes(){
        checkBoxCash.setChecked(false);
        checkBoxMobile.setChecked(false);
        checkBoxBank.setChecked(false);
    }

    public void btnOkClicked(View view) {
            if (checkBoxBank.isChecked() == true) {
                message = editTextAmount.getText().toString() + " " + getString(R.string.paid) + " " + getString(R.string.From_a_Bank_card) + " № " + editTextDescription.getText().toString();
                checkMyInput();
            } else {
                if (checkBoxMobile.isChecked() == true) {
                    message = editTextAmount.getText().toString() + " " + getString(R.string.paid) + " " + getString(R.string.From_mobile) + " № " + editTextDescription.getText().toString();
                    checkMyInput();
                } else {
                    if (checkBoxCash.isChecked() == true) {
                        message = getString(R.string.Payment_details_for_the_amount) + " " + editTextAmount.getText().toString() + " " + getString(R.string.used_to_pay_for) + " " + getString(R.string.In_cash_at_the_address) + " " + editTextDescription.getText().toString();
                        checkMyInput();
                    } else {
                        message = getString(R.string.Payment_method_not_selected);
                        checkMyInput();
                    }
                }
            }
            showMyMessage(message, this);
        }

    public void showMyMessage(String massage, Context context) {
        String text = massage;
        SpannableStringBuilder biggerText = new SpannableStringBuilder(text);
        biggerText.setSpan(new RelativeSizeSpan(1.35f), 0, text.length(), 0);
        Toast toast = Toast.makeText(context, biggerText, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }

    public String checkMyInput () {
        if (editTextAmount.getText().toString().equals("")) {
            message = getString(R.string.Invalid_payment_amount);
        } else {
            if (editTextDescription.getText().toString().equals("")){
                message = getString(R.string.Invalid_payment_attribute);
            }
        }
        return message;
    }
}