import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(Constant.Question1, Arrays.asList("1: Paris", "2: Berlin", "3: Rome", "4: Madrid"), 1));
        questions.add(new Question(Constant.Question2, Arrays.asList("1: Earth", "2: Mars", "3: Jupiter", "4: Saturn"), 3));
        questions.add(new Question(Constant.Question3, Arrays.asList("1: Charles Dickens", "2: Mark Twain", "3: William Shakespeare", "4: Jane Austen"), 3));
        questions.add(new Question(Constant.Question4, Arrays.asList("1: O2", "2: H2O", "3: CO2", "4: HO"), 2));
        questions.add(new Question(Constant.Question5, Arrays.asList("1: Vincent Van Gogh", "2: Pablo Picasso", "3: Leonardo da Vinci", "4: Claude Monet"), 3));

        QuizController quizController = new QuizController(questions);
        quizController.startQuiz();
    }
}
