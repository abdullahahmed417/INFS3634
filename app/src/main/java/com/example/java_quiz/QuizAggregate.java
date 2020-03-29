package com.example.java_quiz;

import java.util.ArrayList;

public class QuizAggregate {
    private Integer quizNo;
    private String quizTopic;
    private String quizDetails;
    private ArrayList quizzesImported;

    public QuizAggregate() {
    }

    public QuizAggregate(Integer quizNo, String quizTopic, String quizDetails, ArrayList quizzesImported) {
        this.quizNo = quizNo;
        this.quizTopic = quizTopic;
        this.quizDetails = quizDetails;
        this.quizzesImported = quizzesImported;
    }

    public String getQuizDetails() {
        return quizDetails;
    }

    public void setQuizDetails(String quizDetails) {
        this.quizDetails = quizDetails;
    }

    public Integer getQuizNo() {
        return quizNo;
    }

    public void setQuizNo(Integer quizNo) {
        this.quizNo = quizNo;
    }

    public String getQuizTopic() {
        return quizTopic;
    }

    public void setQuizTopic(String quizTopic) {
        this.quizTopic = quizTopic;
    }

    public ArrayList getQuizzesImported() {
        return quizzesImported;
    }

    public void setQuizzesImported(ArrayList quizzesImported) {
        this.quizzesImported = quizzesImported;
    }

    public static ArrayList<QuizAggregate> allQuizAggregate() {
        ArrayList<QuizAggregate> allQuizzes = new ArrayList<>();
        allQuizzes.add(new QuizAggregate(1, "Basics", "This quiz would test you on the rudimentary understanding of Java", Quizzes.getQuizOne()));
        allQuizzes.add(new QuizAggregate(2,"Delve into further understanding of Java", "This quiz is not a joke",Quizzes.getQuiz2()));
        allQuizzes.add(new QuizAggregate(3, "Fundamentals of Object Oriented Programming","You're going to be tested on the Rudimentaries of OOP",Quizzes.getQuiz3()));
        return allQuizzes;
    }
}
