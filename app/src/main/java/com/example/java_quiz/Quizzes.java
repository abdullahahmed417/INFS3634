package com.example.java_quiz;

import java.util.ArrayList;

public class Quizzes {
    private String question;
    private String answer;
    private String mcq1;
    private String mcq2;
    private String mcq3;
    private String mcq4;

    public Quizzes(){}
    public Quizzes(String question, String answer, String mcq1, String mcq2, String mcq3, String mcq4) {
        this.question = question;
        this.answer = answer;
        this.mcq1 = mcq1;
        this.mcq2 = mcq2;
        this.mcq3 = mcq3;
        this.mcq4 = mcq4;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getMcq1() {
        return mcq1;
    }

    public void setMcq1(String mcq1) {
        this.mcq1 = mcq1;
    }

    public String getMcq2() {
        return mcq2;
    }

    public void setMcq2(String mcq2) {
        this.mcq2 = mcq2;
    }

    public String getMcq3() {
        return mcq3;
    }

    public void setMcq3(String mcq3) {
        this.mcq3 = mcq3;
    }

    public String getMcq4() {
        return mcq4;
    }

    public void setMcq4(String mcq4) {
        this.mcq4 = mcq4;
    }

    public static ArrayList<Quizzes> getQuizzes(){
        ArrayList<Quizzes> quizzes = new ArrayList<>();
        quizzes.add(new Quizzes("What is my name?","JAVA","JAVA", "Python", "C++", "Kotlin"));
        quizzes.add(new Quizzes("Who invented Java?", "James Gosling", "James Gosling", "Dennis Ritchie", "Steve Jobs", "Oracle Corporation"));
        quizzes.add(new Quizzes("What is Inheritance?", "transferring the properties of one class to another", "the same class name can have many different functions", "transferring the properties of one class to another", "wrapping data in a single unit", "a blueprint which describes methods, functions, and constructors"));
        quizzes.add(new Quizzes("What is Class?", "a blueprint which describes methods, functions, and constructors", "the same class name can have many different functions", "transferring the properties of one class to another", "wrapping data in a single unit", "a blueprint which describes methods, functions, and constructors"));
        quizzes.add(new Quizzes("What is Encapsulation?", "wrapping data in a single unit", "the same class name can have many different functions", "transferring the properties of one class to another", "wrapping data in a single unit", "a blueprint which describes methods, functions, and constructors"));
        quizzes.add(new Quizzes("What is Polymorphism?", "the same class name can have many different functions", "the same class name can have many different functions", "transferring the properties of one class to another", "wrapping data in a single unit", "a blueprint which describes methods, functions, and constructors"));
        return  quizzes;
    }
}

