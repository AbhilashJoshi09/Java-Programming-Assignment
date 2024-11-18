/**
 * This class represents a Question in a quiz.
 * 
 * @author Abhilash Joshi
 */
import java.util.List;

public class Question {
    private final String text;
    private final List<String> options;
    private final int correctAnswerIndex;

    /**
     * Constructor for the Question class.
     * @param text The question text.
     * @param options The list of answer options.
     * @param correctAnswerIndex The index of the correct answer in the options list.
     */
    public Question(String text, List<String> options, int correctAnswerIndex) {
        this.text = text;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    /**
     * Gets the question text.
     * @return The question text.
     */
    public String getText() {
        return text;
    }

        /**
     * Gets the list of answer options.
     * @return The list of answer options.
     */
    public List<String> getOptions() {
        return options;
    }

    /**
     * Gets the index of the correct answer.
     * @return The index of the correct answer.
     */
    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}
