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
    static final int minFactor = 1;
    static final int maxFactor = 10;
    static ArrayList<Question> questions = new ArrayList<>();
    static ArrayList<Integer> answers = new ArrayList<>();

    static String getReportMessage(int numCorrect) {
        if (numCorrect == numQuestions)
            return "You got all answers correct, good job!";

        if ((float) numCorrect / (float) numQuestions >= 0.8)
            return "You got most answers correct (" + numCorrect + "/" + numQuestions + ")";
        else if ((float) numCorrect / (float) numQuestions >= 0.5)
            return "You got a good amount of answers correct (" + numCorrect + "/" + numQuestions + ")";
        else if ((float) numCorrect / (float) numQuestions >= 0.2)
            return "You got some answers correct (" + numCorrect + "/" + numQuestions + ")";
        else
            return "You should get better at multiplication... (" + numCorrect + "/" + numQuestions + ")";
    }

    static void printReport() {
        int numCorrect = 0;
        for (int i = 0; i < numQuestions; ++i) {
            Question question = questions.get(i);
            int userAnswer = answers.get(i);
            int correctAnswer = question.lhs * question.rhs;
            if (userAnswer == correctAnswer) {
                ++numCorrect;
                System.out.println(
                        "Question '" + question.lhs + " * " + question.rhs + "' correct.\n  Answer: " + correctAnswer);
            } else {
                System.out.println("Question '" + question.lhs + " * " + question.rhs + "' incorrect.\n  Your answer: "
                        + userAnswer + "\n  Correct answer: " + correctAnswer);
            }

            System.out.println();
        }

        System.out.println(getReportMessage(numCorrect));
    }

    static void promptAnswers() {
        Random randomizer = new Random();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < numQuestions; ++i) {
            int lhs = randomizer.nextInt(minFactor, maxFactor);
            int rhs = randomizer.nextInt(minFactor, maxFactor);
            System.out.println(lhs + " * " + rhs + " = ");

            questions.add(new Question(lhs, rhs));
            answers.add(scanner.nextInt());
        }
        scanner.close();
    }

    public static void main(String[] args) {
        promptAnswers();
        printReport();
    }
}
