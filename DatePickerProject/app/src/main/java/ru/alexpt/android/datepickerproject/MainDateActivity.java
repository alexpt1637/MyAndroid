package ru.alexpt.android.datepickerproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainDateActivity extends AppCompatActivity {

    EditText date1, date2;
    TextView textDate;
    Button result;
    // Создадим объект Date
    Date date = new Date();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date);

        date1 = (EditText) findViewById(R.id.editText);
        date2 = (EditText) findViewById(R.id.editText2);
        textDate = (TextView) findViewById(R.id.textDate);
        result = (Button) findViewById(R.id.btnResult);

        final Toast toast1 = Toast.makeText(MainDateActivity.this, R.string.textToast1, Toast.LENGTH_SHORT);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btnResult:
//                        textDate.setText(R.string.textToast1);

                        textDate.setText(date.toString());
                        toast1.show();
                        break;
                }
            }
        };

        result.setOnClickListener(onClickListener);

    }
}
