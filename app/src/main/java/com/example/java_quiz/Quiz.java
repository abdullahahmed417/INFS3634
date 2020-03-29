package com.example.java_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Quiz extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radioButton;
    RadioButton mcq1;
    RadioButton mcq2;
    RadioButton mcq3;
    RadioButton mcq4;
    TextView question;
    private Quizzes mQuiz;
    private QuizAggregate findQuiz;
    private Quizzes mainQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        radioGroup = findViewById(R.id.radioGroup);
        question = findViewById(R.id.text_view_selected);
        mcq1 = findViewById(R.id.radio_one);
        mcq2 = findViewById(R.id.radio_two);
        mcq3 = findViewById(R.id.radio_three);
        mcq4 = findViewById(R.id.radio_four);
        Button buttonApply = findViewById(R.id.button_apply);

//        mQuiz = Quizzes.getQuizOne().get(1);
//        question.setText(mQuiz.getQuestion());
//        mcq1.setText(mQuiz.getMcq1());
//        mcq2.setText(mQuiz.getMcq2());
//        mcq3.setText(mQuiz.getMcq3());
//        mcq4.setText(mQuiz.getMcq4());

        Intent intent = getIntent();
        final int position = intent.getIntExtra(quizRecyclerView.QUIZ_NO, 0);
//

        buttonApply.setOnClickListener(new View.OnClickListener() {
            int i = 0;

            @Override
            public void onClick(View v) {
                if (i < getItemCount()) {
//                    mQuiz = Quizzes.getQuizOne().get(i);
                    //^^^^^just there to make sure that the app doesn't break^^^^^
//                    findQuiz = QuizAggregate.allQuizAggregate().get(position);
//                    ArrayList<Quizzes> mainQuiz = (ArrayList<Quizzes>) findQuiz.getQuizzesImported().get(i);
//                    System.out.println(mainQuiz.toString());
                    mainQuiz = (Quizzes) QuizAggregate.allQuizAggregate().get(position).getQuizzesImported().get(i);
                    question.setText(mainQuiz.getQuestion());
                    mcq1.setText(mainQuiz.getMcq1());
                    mcq2.setText(mainQuiz.getMcq2());
                    mcq3.setText(mainQuiz.getMcq3());
                    mcq4.setText(mainQuiz.getMcq4());
                    i++;
                } else {
                    Toast.makeText(Quiz.this, "This Quiz is done", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Quiz.this, quizRecyclerView.class));
                }
                int radioID = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioID);
                if ((radioButton.getText()).equals(mainQuiz.getAnswer())) {
                    Toast.makeText(Quiz.this, "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Quiz.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void checkButton(View v) {
        int radioID = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioID);
        Toast.makeText(this, "SELECTED: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), quizRecyclerView.class);
        startActivityForResult(myIntent, 0);
        return true;
    }

    public int getItemCount() {
        Intent intent = getIntent();
        int position = intent.getIntExtra(quizRecyclerView.QUIZ_NO, 0);
        return QuizAggregate.allQuizAggregate().get(position).getQuizzesImported().size();
    }
}
