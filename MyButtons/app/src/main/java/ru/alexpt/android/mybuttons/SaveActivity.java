package ru.alexpt.android.mybuttons;

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
        final String[] catnames = new String[] { "Рыжик", "Барсик", "Мурзик",
                "Мурка", "Васька", "Томасина", "Кристина", "Пушок", "Дымка",
                "Кузя", "Китти", "Масяня", "Симба" };

        // используем адаптер данных
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, catnames);

        listView.setAdapter(adapter);
    }
}
