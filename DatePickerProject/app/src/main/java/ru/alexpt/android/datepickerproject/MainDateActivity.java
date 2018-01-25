package ru.alexpt.android.datepickerproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.CollationElementIterator;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainDateActivity extends AppCompatActivity {

    EditText date1, date2;
    TextView textDate;
    Button result;
    // Создадим объект Date
    Date date = new Date();

    String resYars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date);

        date1 = (EditText) findViewById(R.id.editText);
        date2 = (EditText) findViewById(R.id.editText2);
        textDate = (TextView) findViewById(R.id.textDate);
        result = (Button) findViewById(R.id.btnResult);

        final Toast toast1 = Toast.makeText(MainDateActivity.this, R.string.textToast1, Toast.LENGTH_SHORT);
        final MainDateMetod mMainDateMetod = new MainDateMetod();

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btnResult:
                        mMainDateMetod.mainDateMetod(textDate);
                        toast1.show();
                        break;
                }
            }
        };

        result.setOnClickListener(onClickListener);

    }
}

class MainDateMetod {

    String date1, date2, resYars;
    Date dateOne, dateTwo;
    long difference;
    int days, yars, months;

    public void mainDateMetod(TextView textDate){

        date1 = "21.09.2009";
        date2 = "29.09.2017";

        // ---------------------------- Количество дней между датами --------------------------------------

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

        dateOne = null;
        dateTwo = null;

        try {
            dateOne = format.parse(date1);
            dateTwo = format.parse(date2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //---------------------- Количество дней между датами в миллисекундах ---------------------------------

        difference = dateTwo.getTime() - dateOne.getTime();

        //-------------- Перевод количества дней между датами из миллисекунд в дни ----------------------------

        days =  (int)(difference / (24 * 60 * 60 * 1000)); // миллисекунды / (24ч * 60мин * 60сек * 1000мс)
        yars = days / 365;
        months = (days - yars * 365) / 30;

        resYars = "Страховой стаж: " + yars + " лет " + months + " мес.";
        textDate.setText(resYars);
    }
}
