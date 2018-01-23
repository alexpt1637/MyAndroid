package ru.alexpt.android.datepickerproject;

// http://developer.alexanderklimov.ru/android/views/datepicker.php

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private DatePicker mDatePicker;
    private TextView mInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mInfoTextView = (TextView) findViewById(R.id.textView);
        mDatePicker = (DatePicker) findViewById(R.id.datePicker);

        Calendar today = Calendar.getInstance();

        mDatePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
                today.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {

                    @Override
                    public void onDateChanged(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                        Toast.makeText(getApplicationContext(),
                                "onDateChanged", Toast.LENGTH_SHORT).show();

                        mInfoTextView.setText("Год: " + year + "\n" + "Месяц: "
                                + (monthOfYear + 1) + "\n" + "День: " + dayOfMonth);
                    }
                });

        Button changingDateButton = (Button) findViewById(R.id.button);
        changingDateButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mInfoTextView.setText(new StringBuilder()
                        // Месяц отсчитывается с 0, поэтому добавляем 1
                        .append(mDatePicker.getDayOfMonth()).append(".")
                        .append(mDatePicker.getMonth() + 1).append(".")
                        .append(mDatePicker.getYear()));
            }
        });

        changingDateButton.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                setCurrentDateOnView();

                return true;
            }
        });
    }

    // устанавливаем текущую дату
    public void setCurrentDateOnView() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // установить текущую дату в textView
        mInfoTextView.setText(new StringBuilder()
                // Месяц отсчитывается с 0, поэтому добавляем 1
                .append(day).append(".").append(month + 1).append(".")
                .append(year));

        // Устанавливаем текущую дату для DatePicker
        mDatePicker.init(year, month, day, null);
    }
}
