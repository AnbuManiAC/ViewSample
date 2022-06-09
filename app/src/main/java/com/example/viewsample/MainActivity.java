package com.example.viewsample;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name,email,pass;
    RadioGroup rg;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        rg = findViewById(R.id.rg);
        submit = findViewById(R.id.button);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(i);
                Toast.makeText(MainActivity.this
                        ,"Name "+name.getText().toString()+"\nEmail "+email.getText().toString()+"\nGender "+rb.getText().toString()+"\nPass "+pass.getText().toString()
                        ,Toast.LENGTH_SHORT).show();
            }
        });

    }
}