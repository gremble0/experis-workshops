package com.booleanuk;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Quiz {
    private static class Question {
        public int lhs;
        public int rhs;

        public Question(int lhs, int rhs) {
            this.lhs = lhs;
            this.rhs = rhs;
        }
    }

    static final int numQuestions = 5;
    static Random randomizer = new Random();
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Question> questions = new ArrayList<>();
    static ArrayList<Integer> answers = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < numQuestions; ++i) {
            int lhs = randomizer.nextInt(10);
            int rhs = randomizer.nextInt(10);
            System.out.println(lhs + " * " + rhs + " = ");

            questions.add(new Question(lhs, rhs));
            answers.add(scanner.nextInt());
        }

        for (int i = 0; i < numQuestions; ++i) {
            Question question = questions.get(i);
            int userAnswer = answers.get(i);
            int correctAnswer = question.lhs * question.rhs;
            if (userAnswer == question.lhs * question.rhs)
                System.out.println(
                        "Question '" + question.lhs + " * " + question.rhs + "' correct.\n  Answer: " + correctAnswer);
            else
                System.out.println("Question '" + question.lhs + " * " + question.rhs + "' incorrect.\n  Your answer: "
                        + userAnswer + "\n  Correct answer: " + correctAnswer);

            System.out.println();
        }
    }
}
