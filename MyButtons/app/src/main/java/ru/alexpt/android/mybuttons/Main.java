package ru.alexpt.android.mybuttons;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends AppCompatActivity {

    EditText input;
    TextView output;
    Button btn;
    ImageButton imb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.input);
        output = (TextView) findViewById(R.id.output);
        btn = (Button) findViewById(R.id.button);
        imb = (ImageButton) findViewById(R.id.imageButton);

        imb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main.this, Image.class));
            }
        });
    }

    public void clickButton(View view) {
        String s = input.getText().toString();
        int x = Integer.parseInt(s);
        output.setText(String.valueOf(x));
    }

    /*private void clickImButton() {
        startActivity(new Intent(Main.this, Image.class));
    }*/

   /* public void clickImButton(View view) {
        startActivity(new Intent(Main.this, Image.class));
    }*/
}
