package ru.alexpt.android.mysqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SQLiteActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etName, etEmail;
    Button btnAdd, btnRead, btnClear;

    // после возвращения из класса DBHelper объявляем переменную этого класса и создаем его экземпляр в методе onCreate
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnRead = (Button) findViewById(R.id.btnRead);
        btnRead.setOnClickListener(this);

        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);

        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);

        // и создаем его экземпляр в методе onCreate, далее создаем экземпляр класса SQLiteDatabase
        dbHelper = new DBHelper(this);
    }

    @Override
    public void onClick(View view) {

        // при нажатии на любую кнопку считываем значение полей и сохраняем их в строковую переменную
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();

        // создаем экземпляр класса SQLiteDatabase
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        // создаем экземпляр класса ContentValues, он используется для добавления новых строк в таблицу
        ContentValues contentValues = new ContentValues();

        // создаем конструкцию для разделения действий по отдельным кнопкам
        switch (view.getId()){
            case R.id.btnAdd:
                // действие по нажатию кнопки btnAdd
                contentValues.put(DBHelper.KEY_NAME, name);
                contentValues.put(DBHelper.KEY_MAIL, email);    // столбец id заполнится автоматически

                database.insert(DBHelper.TABLE_CONTACTS, null, contentValues);
                break;
            case R.id.btnRead:
                // действие по нажатию кнопки btnRead
                break;
            case R.id.btnClear:
                // действие по нажатию кнопки btnClear
                break;
            // далее создаем отдельный класс DBHelper для работы с базой данных
        }
    }
}
