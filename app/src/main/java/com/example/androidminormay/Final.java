package com.example.androidminormay;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Final extends AppCompatActivity {
    private TextView twtextCorrect, twtextWrong, twFinalText;
    private Button btnrestart;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finalxml);
        btnrestart = findViewById(R.id.Restart);
        twFinalText = findViewById(R.id.FinalText);
        twtextCorrect = findViewById(R.id.textCorrect);
        twtextWrong = findViewById(R.id.textWrong);

        int number = getIntent().getExtras().getInt("message_key");
        twtextCorrect.setText("Correct Answers: "+ number);

        int wrong = 5 - number;
        twtextWrong.setText("Wrong Answers: "+ wrong);

        twFinalText.setText("Final Score: "+ number);


        btnrestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change();
            }
        });
    }

    public void change(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
