package ru.alexpt.android.mybdproject;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainBDActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etText;
    Button btnSave, btnLoad;
    SharedPreferences sPref;

    final String SAVED_TEXT = "saved_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bd);

        etText = (EditText) findViewById(R.id.etText);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
        btnLoad = (Button) findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(this);

        loadText(); // автоматически загружаем ранее сохраненные данные при открытии приложения
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSave:
                // создаем метод, который будем вызывать принажатии на эту кнопку
                saveText ();
                break;
            case R.id.btnLoad:
                // создаем метод жля второй кнопки
                loadText ();
                break;
            default:
                break;
        }
    }

    // реализуем метод сохранения данных
    private void saveText (){
        // создаем объект, который позволяет работать с данными с помощью метода getPreferences
        sPref = getPreferences(MODE_PRIVATE);   // данные будут видны только этому приложениию
        SharedPreferences.Editor ed = sPref.edit(); // объект ed необходим для редактирования данных
        ed.putString(SAVED_TEXT, etText.getText().toString());
        ed.commit();    // для сохранения данных
        // для наглядности выводим сообщение о сохранении данных
        Toast.makeText(MainBDActivity.this, "Text saved", Toast.LENGTH_SHORT).show();
    }

    // реализуем метод загрузки данных
    private void loadText (){
        sPref = getPreferences(MODE_PRIVATE);
        String savedText = sPref.getString(SAVED_TEXT, ""); // "" значение по умолчанию (пустая строка)
        etText.setText(savedText);
        Toast.makeText(MainBDActivity.this, "Text loaded", Toast.LENGTH_SHORT).show();
    }

    // делаем загрузку и сохранение данных автоматическими при закрытии и открытии приложения
    // для этого метод loadText вызываем в методе onCreate, а метод saveText в методе onDestroy, реализованном ниже

    @Override
    protected void onDestroy() {    // метод onDestroy вызывается перед тем как активити будет уничтожено
        super.onDestroy();
        saveText(); // автоматически сохраняем данные при закрытии приложения
    }
}
