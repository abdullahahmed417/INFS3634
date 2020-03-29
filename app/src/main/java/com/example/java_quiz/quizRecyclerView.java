package com.example.java_quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.content.Intent;
import android.nfc.Tag;
import android.nfc.TagLostException;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Adapter;;
import java.util.ArrayList;

public class quizRecyclerView extends AppCompatActivity implements QuizListAdapter.OnNoteListener {
    public static final String QUIZ_NO = "QUIZ_NO";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter qAdapter;
    private ArrayList<QuizAggregate> quizArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_recycler_view);
        ArrayList<QuizAggregate> quizAggregates = QuizAggregate.allQuizAggregate();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        qAdapter = new QuizListAdapter(quizAggregates, this);
        recyclerView.setAdapter(qAdapter);
//        ActionBar actionBar = getActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;
    }

    @Override
    public void onNoteClick(int position) {
        Intent intent = new Intent(this, Quiz.class);
        intent.putExtra(QUIZ_NO,position);
        startActivity(intent);
            }
}
