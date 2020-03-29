package com.example.java_quiz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QuizListAdapter extends RecyclerView.Adapter<QuizListAdapter.ViewHolder> {
    private ArrayList<QuizAggregate> quizArray;
    private OnNoteListener mOnNoteListener;

    public QuizListAdapter(ArrayList<QuizAggregate> quizArray, OnNoteListener onNoteListener) {
        this.quizArray = quizArray;
        this.mOnNoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_quiz_agg, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, mOnNoteListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ArrayList<QuizAggregate> quizAggregate = QuizAggregate.allQuizAggregate();
        QuizAggregate currentQuiz = quizAggregate.get(position);
        holder.quizNo.setText(currentQuiz.getQuizNo().toString());
        holder.quizDescription.setText(currentQuiz.getQuizTopic().toString());
    }

    @Override
    public int getItemCount() {
        return quizArray.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView quizNo;
        private TextView quizDescription;
        OnNoteListener onNoteListener;

        public ViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);

            quizNo = itemView.findViewById(R.id.noTextView);
            quizDescription = itemView.findViewById(R.id.nameTextView);
            itemView.setOnClickListener(this);
            this.onNoteListener = onNoteListener;
        }

        @Override
        public void onClick(View v) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }

    public interface OnNoteListener {
        void onNoteClick(int position);
    }
}
