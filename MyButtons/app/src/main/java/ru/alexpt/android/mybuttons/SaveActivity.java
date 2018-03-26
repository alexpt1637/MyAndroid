package ru.alexpt.android.mybuttons;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SaveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        ListView listView = (ListView) findViewById(R.id.listView1);

        // определяем массив типа String
        final String[] duration = new String[] { "период 1", "период 2", "период 3",
                "период 4", "период 5", "период 6", "период 7", "период 8" };

        // получаем Intent и извлекаем из него String-объект с именем fname, значение, которое мы помстили в коде Main.java
        Intent intent = getIntent();
        duration [0] = intent.getStringExtra("fname1");

        // рабочие пометки в массиве
        duration [5] = "Раздел находится в стадии разработки";
        duration [6] = "версия 1.0";
        duration [7] = "Замечания и предложения по работе программы прошу направлять на адрес: alexpt1637@yandex.ru";

        // используем адаптер данных для отображения сведений из массива в listView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, duration);

        listView.setAdapter(adapter);
    }
}
