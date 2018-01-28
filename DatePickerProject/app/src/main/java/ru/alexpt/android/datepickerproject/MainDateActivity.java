package ru.alexpt.android.datepickerproject;

import android.graphics.Color;
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

    EditText etDate1, etDate2;
    TextView textDate, textViewDate;
    Button result;
    // Создадим объект Date
    Date date = new Date();

    String resYars;
//    int date1, date2;
    Date dateOne, dateTwo;
    long difference;
    int days, yars, months;

    int date1 = 21092009;
    int date2 = 29092017;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date);

        etDate1 = (EditText) findViewById(R.id.editText);
        etDate2 = (EditText) findViewById(R.id.editText2);
        textDate = (TextView) findViewById(R.id.textDate);
        textViewDate = (TextView) findViewById(R.id.textView2);
        result = (Button) findViewById(R.id.btnResult);

        /*date1 = etDate1.getId();
        date2 = etDate2.getId();*/

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

class MainDateMetod extends MainDateActivity {

        public void mainDateMetod(TextView textDate){

        // ---------------------------- Количество дней между датами --------------------------------------

        SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");

        dateOne = null;
        dateTwo = null;

        try {
            dateOne = format.parse(String.valueOf(date1));
            dateTwo = format.parse(String.valueOf(date2));
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
        textDate.setTextColor(Color.RED);
    }
}
