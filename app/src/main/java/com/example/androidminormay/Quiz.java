package com.example.androidminormay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class Quiz extends AppCompatActivity {
    private TextView ncatch, questionDisp, scoreview;
    private Button btnquit, btnNext;
    RadioButton btnOption1, btnOption2, btnOption3, btnOption4;
    private ArrayList<QuizModal> quizModalArrayList;
    Random random;
    int currentScore = 0, questionAttempted = 1, currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quizxml);

        ncatch = findViewById(R.id.nameCatch);

        Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");
        ncatch.setText(str);

        btnquit = findViewById(R.id.Quit);
        scoreview = findViewById(R.id.score);


        btnNext = findViewById(R.id.next);
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.groupRadio);
        questionDisp = findViewById(R.id.QuestionGiven);
        btnOption1 = (RadioButton)findViewById(R.id.radioButton1);
        btnOption2 = (RadioButton)findViewById(R.id.radioButton2);
        btnOption3 = (RadioButton)findViewById(R.id.radioButton3);
        btnOption4 = (RadioButton)findViewById(R.id.radioButton4);
        quizModalArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestion(quizModalArrayList);
        currentPos = random.nextInt(quizModalArrayList.size());
        setDataToViews(currentPos);

        radioGroup.clearCheck();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int selectedId) {
                RadioButton radioButton = (RadioButton)radioGroup.findViewById(selectedId);
            }
        });

        btnOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(btnOption1.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
            }
        });
        btnOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(btnOption2.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
            }
        });
        btnOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(btnOption3.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
            }
        });
        btnOption4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(btnOption4.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
            }
        });

        btnquit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Final.class);
                intent.putExtra("message_key",currentScore);
                startActivity(intent);
                last();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if(selectedId == -1){
                    Toast.makeText(getApplicationContext(),"No answer has been selected", Toast.LENGTH_LONG).show();
                }
                else{
                    int num = Integer.parseInt(String.valueOf(currentScore));
                    scoreview.setText(Integer.toString(currentScore));
                }

            }
        });
    }

    private void setDataToViews(int currentPos) {
        if (questionAttempted == 6) {
            Intent intent = new Intent(getApplicationContext(), Final.class);
            intent.putExtra("message_key",currentScore);
            startActivity(intent);
            last();
        } else {
            questionDisp.setText(quizModalArrayList.get(currentPos).getQuestion());
            btnOption1.setText(quizModalArrayList.get(currentPos).getOption1());
            btnOption2.setText(quizModalArrayList.get(currentPos).getOption2());
            btnOption3.setText(quizModalArrayList.get(currentPos).getOption3());
            btnOption4.setText(quizModalArrayList.get(currentPos).getOption4());
        }
    }

    private void getQuizQuestion(ArrayList<QuizModal> quizModalArrayList) {
        quizModalArrayList.add(new QuizModal("Which method can be defined only once in a program?","finalize method", "main method", "static method", "private method","main method"));
        quizModalArrayList.add(new QuizModal("Which keyword is used by method to refer to the current object that\n" +
                "invoked it?","import", "this", "catch", "abstract","this"));
        quizModalArrayList.add(new QuizModal("Which of these access specifiers can be used for an interface?","public", "protected", "private", "All of the mentioned","public"));
        quizModalArrayList.add(new QuizModal("Which of the following is correct way of importing an entire package\n" +
                "‘pkg’?","Import pkg.", "import pkg.*", "Import pkg.*", "import pkg.","import pkg.*"));
        quizModalArrayList.add(new QuizModal("What is the return type of Constructors?","int", "float", "void", "None of the mentioned","None of the mentioned"));

    }

    public void last(){
        Intent switchActivityIntent = new Intent(this, Final.class);
        startActivity(switchActivityIntent);
    }
}
