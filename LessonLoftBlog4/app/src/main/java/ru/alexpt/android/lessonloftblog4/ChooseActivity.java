package ru.alexpt.android.lessonloftblog4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

/**
 * Created by ACERa on 21.12.2017.
 */

public class ChooseActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private Button button;

    public static String FILM = "FILM";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_activity);

        radioGroup = (RadioGroup) findViewById(R.id.radio_group_choose);
        button = (Button) findViewById(R.id.choose_button_accert);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                final Intent answerIntent = new Intent();

                switch (checkedId) {
                    case R.id.radio_button_first:
                        answerIntent.putExtra(FILM, getResources().getString(R.string.transformers));
                        break;
                    case R.id.radio_button_second:
                        answerIntent.putExtra(FILM, getResources().getString(R.string.harry_potter));
                        break;
                    case R.id.radio_button_third:
                        answerIntent.putExtra(FILM, getResources().getString(R.string.criminal));
                        break;

                        default:
                            break;
                }
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setResult(RESULT_OK, answerIntent);
                    }
                });
            }
        });
    }
}
