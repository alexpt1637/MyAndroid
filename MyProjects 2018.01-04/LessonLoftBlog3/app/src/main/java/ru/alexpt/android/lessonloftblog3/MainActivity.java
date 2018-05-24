package ru.alexpt.android.lessonloftblog3;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RelativeLayout main_view = (RelativeLayout) findViewById(R.id.main_view);
        final TextView chosenButton = (TextView) findViewById(R.id.main_text);

        Button redButton = (Button) findViewById(R.id.red_button);
        Button yellowButton = (Button) findViewById(R.id.yellow_button);
        Button greenButton = (Button) findViewById(R.id.green_button);

        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_view.setBackgroundColor(getResources().getColor(R.color.redColor));
                // меняем на цвет, который у нас есть в strings.xml
                chosenButton.setText(getResources().getText(R.string.red));
                chosenButton.setTextColor(Color.WHITE);
            }
        });

        yellowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_view.setBackgroundColor(getResources().getColor(R.color.yellowColor));
                // меняем на цвет, который у нас есть в strings.xml
                chosenButton.setText(getResources().getText(R.string.yellow));
                chosenButton.setTextColor(Color.GRAY);
            }
        });

        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_view.setBackgroundColor(getResources().getColor(R.color.greenColor));
                // меняем на цвет, который у нас есть в strings.xml
                chosenButton.setText(getResources().getText(R.string.green));
                chosenButton.setTextColor(Color.DKGRAY);
            }
        });
    }
}
