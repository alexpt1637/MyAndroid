package ru.alexpt.android.itprogerlesson8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Создаем переменные
    private ImageView img;
    private Button btn;
    private EditText email, pass;

    // Создаем константу (пишем const...) в последствии эти данные будем брать из базы данных
    private static final String email_txt = "admin";
    private static final String pass_txt = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login();
    }

    // Создаем экшен и прописываем его выше в функции onCreate - login();
    public void login(){
        img = (ImageView)findViewById(R.id.imageView2);
        btn = (Button)findViewById(R.id.button2);
        email = (EditText)findViewById(R.id.editText3);
        pass = (EditText)findViewById(R.id.editText4);
        final Intent intent = new Intent(this, ActivityTwo.class);

        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(email_txt.equals(String.valueOf(email.getText())) && pass_txt.equals(String.valueOf(pass.getText())))
                            startActivity(intent);
//                            img.setImageResource(R.drawable.tick);
                        else
                            img.setImageResource(R.drawable.cross);

                        // Простой переход на вторую активити без авторизации
                        /*switch (view.getId()) {
                            case R.id.button2:
                                startActivity(intent);
                                break;
                            default:
                                break;*/
                        }
                    }
        );
    }

    @Override
    public void onClick(View view) {
        /*switch (view.getId()) {
            case R.id.button2:
                Intent intent = new Intent(this, ActivityTwo.class);
                startActivity(intent);
                break;
            default:
                break;
        }*/
    }
}
