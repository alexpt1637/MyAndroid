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
                "период 4", "период 5", "период 6", "период 7" };

        // получаем Intent и извлекаем из него String-объект с именем fname, значение, которое мы помстили в коде Main.java
        Intent intent = getIntent();
        duration [0] = intent.getStringExtra("fname1");
        // duration [1] = intent.getStringExtra("fname2");
        // duration [2] = intent.getStringExtra("fname3");

        // используем адаптер данных
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, duration);

        listView.setAdapter(adapter);
    }
}
