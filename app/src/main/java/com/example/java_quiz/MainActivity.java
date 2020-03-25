package com.example.java_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button quiz1Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureQuiz1Button();
    }

    private void configureQuiz1Button() {
        quiz1Button = findViewById(R.id.button);
        quiz1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(sendQuizNo()));
            }
        });
    }

    private Intent sendQuizNo() {
        String quizNoString = quiz1Button.getText().toString().split(" ")[1];
        int quizNo = Integer.parseInt(quizNoString);

        Intent intent = new Intent(this, Quiz.class);
        intent.putExtra("QUIZ_NO", quizNo);
        return intent;
    }
}
