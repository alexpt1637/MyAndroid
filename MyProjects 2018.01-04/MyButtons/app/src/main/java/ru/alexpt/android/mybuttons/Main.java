package ru.alexpt.android.mybuttons;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main extends AppCompatActivity {

    EditText input, input2;
    TextView output;
    Button btn, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.input);
        input2 = (EditText) findViewById(R.id.input2);
        output = (TextView) findViewById(R.id.output);
        btn = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);

    }

    public void clickButton(View view) {
        String date1 = input.getText().toString();
        String date2 = input2.getText().toString();

        // ---------------------------- Количество дней между датами ----------------------------------------

        SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");

        Date dateOne, dateTwo;

        dateOne = null;
        dateTwo = null;

        try {
            dateOne = format.parse(String.valueOf(date1));
            dateTwo = format.parse(String.valueOf(date2));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //---------------------- Количество дней между датами в миллисекундах ---------------------------------

        long difference = dateTwo.getTime() - dateOne.getTime();

        //-------------- Перевод количества дней между датами из миллисекунд в дни ----------------------------

        String resYars;
        int days, yars, months;

        days =  (int)(difference / (24 * 60 * 60 * 1000)); // миллисекунды / (24ч * 60мин * 60сек * 1000мс)
        yars = days / 365;
        months = (days - yars * 365) / 30;

        resYars = "Страховой стаж: " + yars + " лет " + months + " мес.";

        output.setText(String.valueOf(resYars));
    }

    public void clickButton2(View view) {
        input.setText(null);
        input2.setText(null);
        output.setText("Поле очищено");
    }

    /*public void clickButton3(View view) {
        Intent intent = new Intent(Main.this, SaveActivity.class);
        // поместим в Intent объект с именем: fname
        // Используется метод putExtra. Он добавляет к объекту пару. Первый параметр – это ключ(имя), второй - значение
        intent.putExtra("fname1", output.getText().toString());
        // intent.putExtra("fname2", output.getText().toString());  // 2 поле
        // intent.putExtra("fname3", output.getText().toString());  // 3 поле

        startActivity(intent);  // отправляем укомплектованный Intent с помощью метода startActivity

        final Toast toastSave = Toast.makeText(Main.this, "Переход выполнен", Toast.LENGTH_SHORT);
        toastSave.show();
    }*/
}
