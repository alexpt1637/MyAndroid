package ru.alexpt.android.itprogerlesson8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btnTest1:
                        testText.setText(R.string.btnTest1);
                        break;
                    case R.id.btnTest2:
                        testText.setText(R.string.btnTest2);
                        break;
                    case R.id.btnTest3:
                        testText.setText(R.string.btnTest3);
                        break;
                    case R.id.textView1:
                        testText.setText(R.string.btnTest1);
                        break;
                    case R.id.textView2:
                        testText.setText(R.string.btnTest2);
                        break;
                    case R.id.textView3:
                        testText.setText(R.string.btnTest3);
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
}
