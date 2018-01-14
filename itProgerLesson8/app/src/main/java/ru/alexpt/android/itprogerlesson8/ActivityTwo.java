package ru.alexpt.android.itprogerlesson8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityTwo extends AppCompatActivity {

    TextView testText, test1, test2, test3;
    Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        testText = (TextView) findViewById(R.id.textView);
        test1 = (TextView) findViewById(R.id.textView1);
        test2 = (TextView) findViewById(R.id.textView2);
        test3 = (TextView) findViewById(R.id.textView3);
        btn1 = (Button) findViewById(R.id.btnTest1);
        btn2 = (Button) findViewById(R.id.btnTest2);
        btn3 = (Button) findViewById(R.id.btnTest3);

        final Toast toast1 = Toast.makeText(ActivityTwo.this, R.string.textToast1, Toast.LENGTH_SHORT);
        final Toast toast2 = Toast.makeText(ActivityTwo.this, R.string.textToast2, Toast.LENGTH_SHORT);
        final Toast toast3 = Toast.makeText(ActivityTwo.this, R.string.textToast3, Toast.LENGTH_SHORT);

        registerForContextMenu(testText);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btnTest1:
                        testText.setText(R.string.btnTest1);
                        toast1.show();
                        break;
                    case R.id.btnTest2:
                        testText.setText(R.string.btnTest2);
                        toast2.show();
                        break;
                    case R.id.btnTest3:
                        testText.setText(R.string.btnTest3);
                        toast3.show();
                        break;
                    case R.id.textView1:
                        testText.setText(R.string.btnTest1);
                        toast1.show();
                        break;
                    case R.id.textView2:
                        testText.setText(R.string.btnTest2);
                        toast2.show();
                        break;
                    case R.id.textView3:
                        testText.setText(R.string.btnTest3);
                        toast3.setGravity(Gravity.CENTER, 0, 0);
                        toast3.show();
                        break;
                }
            }
        };

        btn1.setOnClickListener(onClickListener);
        btn2.setOnClickListener(onClickListener);
        btn3.setOnClickListener(onClickListener);
        test1.setOnClickListener(onClickListener);
        test2.setOnClickListener(onClickListener);
        test3.setOnClickListener(onClickListener);

    }

    // Создаем контекстное меню
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        switch (v.getId()) {
            case R.id.textView:

        }
    }
}
