package com.example.androidminormay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button start = findViewById(R.id.Start);
        Button abt = findViewById(R.id.About);
        EditText name = findViewById(R.id.editTextName);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str = name.getText().toString();
                if(str.equals(null) || str.equals(" ")){
                    Toast.makeText(getApplicationContext(),"Please Enter the name to continue", Toast.LENGTH_LONG).show();
                }else {
                    Intent intent = new Intent(getApplicationContext(), Quiz.class);
                    intent.putExtra("message_key", str);
                    startActivity(intent);
                }
            }
        });
        abt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchActivityIntent = new Intent(getApplicationContext(), aboutDev.class);
                startActivity(switchActivityIntent);
            }
        });
    }


}