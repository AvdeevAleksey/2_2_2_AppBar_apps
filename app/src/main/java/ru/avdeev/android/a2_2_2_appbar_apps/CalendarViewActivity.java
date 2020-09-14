package ru.avdeev.android.a2_2_2_appbar_apps;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import java.util.GregorianCalendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

//import android.icu.util.GregorianCalendar;

public class CalendarViewActivity extends AppCompatActivity {

    private Button buttonChooseStartDate;
    private Button buttonChooseEndDate;
    private Button buttonOk;
    private CalendarView calendarChooseStartDate;
    private CalendarView calendarChooseEndDate;
    private long startDate;
    private String startDateTxt;
    private long endDate;
    private String endDateTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_view);
        buttonChooseStartDate = findViewById(R.id.btnChooseStartDate);
        buttonChooseEndDate = findViewById(R.id.btnChooseEndDate);
        buttonOk = findViewById(R.id.btnOk);
        calendarChooseStartDate = findViewById(R.id.startDateCalendar);
        calendarChooseEndDate = findViewById(R.id.endDateCalendar);

        calendarChooseStartDate.setVisibility(View.GONE);
        calendarChooseEndDate.setVisibility(View.GONE);
    }

    public void btnOkClocked (View view) {
        if (!(startDate==endDate)) {
            if (startDate > endDate) {
                Toast.makeText(CalendarViewActivity.this, getText(R.string.mistake), Toast.LENGTH_LONG).show();
                buttonChooseStartDate.setText(R.string.chooseStartDate);
                buttonChooseEndDate.setText(R.string.chooseEndDate);
            } else {
                Toast.makeText(CalendarViewActivity.this, getText(R.string.chooseStartDate) + startDateTxt + "\n" + getText(R.string.chooseEndDate) + endDateTxt, Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(CalendarViewActivity.this,getText(R.string.gross_error), Toast.LENGTH_LONG).show();
        }
    }

    public void btnChooseStartDateClicked (View view) {
        calendarChooseStartDate.setVisibility(View.VISIBLE);
        calendarChooseEndDate.setVisibility(View.GONE);
        buttonOk.setVisibility(View.GONE);

        calendarChooseStartDate.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            //@RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                startDateTxt = i2+"-"+ Integer.toString(i1+1) +"-"+i;
                buttonChooseStartDate.setText(getText(R.string.chooseStartDate) + startDateTxt);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.set(i, i1, i2);
                startDate = gregorianCalendar.getTimeInMillis();
                calendarView.setVisibility(View.GONE);
                buttonOk.setVisibility(View.VISIBLE);
            }
        });
    }

    public void btnChooseEndDateClicked (View view) {
        calendarChooseEndDate.setVisibility(View.VISIBLE);
        calendarChooseStartDate.setVisibility(View.GONE);
        buttonOk.setVisibility(View.GONE);

        calendarChooseEndDate.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            //@RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                endDateTxt = i2+"-"+ Integer.toString(i1+1) +"-"+i;
                buttonChooseEndDate.setText(getText(R.string.chooseEndDate) + endDateTxt);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.set(i, i1, i2);
                endDate = gregorianCalendar.getTimeInMillis();
                calendarView.setVisibility(View.GONE);
                buttonOk.setVisibility(View.VISIBLE);
            }
        });
    }
}