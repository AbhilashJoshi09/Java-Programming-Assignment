/***
 * This class represents a QuizController that manages the flow of a quiz.
 * 
 * @author Abhilash Joshi
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import week
import week-5.Question;-5.Question;

public class QuizController {
    private final List<Question> questions;
    private final int timeLimitInSeconds = 10;
    private int currentQuestionIndex = 0;
    private Timer questionTimer;
    private long questionStartTime;
    private boolean questionAnswered;
    private int correctAnswerCount = 0;

    private final List<Boolean> isAttempted; 
    private final List<Long> timeTaken;      

    /**
     * Constructor for the QuizController class.
     * @param questions The list of questions for the quiz.
     */
    public QuizController(List<Question> questions) {
        this.questions = questions;
        this.isAttempted = new ArrayList<>(questions.size());
        this.timeTaken = new ArrayList<>(questions.size());
        
        for (int i = 0; i < questions.size(); i++) {
            isAttempted.add(false);
            timeTaken.add(0L);
        }
    }

    /**
     * Starts the quiz and handles user interaction.
     */
    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Constant.WELCOME_MSG);

        while (currentQuestionIndex < questions.size()) {
            displayQuestionAndOptions();

            questionAnswered = false;
            startQuestionTimer();

            String userAnswer = scanner.nextLine();
            stopQuestionTimer();
            long attemptTime = (System.currentTimeMillis() - questionStartTime) / 1000;
            timeTaken.set(currentQuestionIndex, attemptTime);

            if (!userAnswer.isEmpty()) {
                isAttempted.set(currentQuestionIndex, true);  
                checkAnswer(userAnswer);
                questionAnswered = true;
            }
            currentQuestionIndex++;
        }
        scanner.close();
        displayResults();
    }

    /**
     * Displays the current question and its options.
     */
    private void displayQuestionAndOptions() {
        Question currentQuestion = questions.get(currentQuestionIndex);
        System.out.println(Constant.QUESTION + (currentQuestionIndex + 1) + ": " + currentQuestion.getText());
        for (String option : currentQuestion.getOptions()) {
            System.out.println(option);
        }
    }
     /**
     * Starts a timer for the current question.
     */
    private void startQuestionTimer() {
        questionStartTime = System.currentTimeMillis();
        questionTimer = new Timer();
        questionTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!questionAnswered) {
                    System.out.println(Constant.TimeUP);
                    timeTaken.set(currentQuestionIndex, (System.currentTimeMillis() - questionStartTime) / 1000);
                    isAttempted.set(currentQuestionIndex, false); 
                    questionAnswered = true;
                }
            }
        }, timeLimitInSeconds * 1000);
    }

    private void stopQuestionTimer() {
        questionTimer.cancel();
    }

    /**
     * Checks the user's answer against the correct answer.
     * @param userAnswer The user's answer.
     */
    private void checkAnswer(String userAnswer) {
        try {
            int selectedOption = Integer.parseInt(userAnswer);
            if (selectedOption == questions.get(currentQuestionIndex).getCorrectAnswerIndex()) {
                correctAnswerCount++;
            }
        } catch (NumberFormatException e) {
        }
    }

    /**
     * Displays the quiz results.
     */
    private void displayResults() {
        System.out.println(Constant.QuizOver);
        System.out.println("-----------------------------------------------------");
        System.out.printf(Constant.HEADER_OF_TABLE);
        System.out.println("-----------------------------------------------------");
        for (int i = 0; i < questions.size(); i++) {
            String status = isAttempted.get(i) ? Constant.ATTEMPTED : Constant.NOT_ATTEMPTED;
            System.out.printf("%-10d | %-15s | %-15d\n", (i + 1), status, timeTaken.get(i));
        }
        System.out.println("-----------------------------------------------------");
        double scorePercentage = ((double) correctAnswerCount / questions.size()) * 100;
        System.out.printf(Constant.SCORE, correctAnswerCount, questions.size(), scorePercentage);
    }   
}
