import java.util.Scanner;
import java.util.Stack;

/**
 * The `EvaluateExpression` class evaluates mathematical expressions using
 * the shunting-yard algorithm and stack-based computation.
 * 
 * @owner: Abhilash Joshi
 * Date: 25/11/2024
 */
public class EvaluateExpression {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print(Constant.ENTER_EXPRESSION);
        String expression = inputScanner.nextLine();
        try {
            System.out.println(expression + " = " + evaluate(expression));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(Constant.INVALID_INPUT);
        }
    }

    /**
     * The function evaluates a mathematical expression in string format using stacks for operands and
     * operators, following operator precedence and handling parentheses.
     * 
     * @param expression The code you provided is a method to evaluate a mathematical expression in
     * postfix notation. It uses two stacks, one for operands and one for operators, to perform the
     * calculations.
     * @return The method `evaluate` is returning a `double` value, which is the result of evaluating
     * the mathematical expression provided as a parameter to the method.
     */
    public static double evaluate(String expression) {
        Stack<Double> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);
            
            if (Character.isDigit(character) || character == '.') {
                StringBuilder number = new StringBuilder();
                while (i < expression.length() &&
                        (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    number.append(expression.charAt(i));
                    i++;
                }
                i--;
                operands.push(Double.parseDouble(number.toString()));

            } else if (character == '(') {
                operators.push(character);

            } else if (character == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    calculateAndPushResult(operands, operators);
                }
                if (operators.isEmpty() || operators.pop() != '(') {
                    throw new IllegalArgumentException("Mismatched parentheses");
                }

            } else if (isOperator(character)) {
                while (!operators.isEmpty() &&
                        precedence(character) <= precedence(operators.peek())) {
                    calculateAndPushResult(operands, operators);
                }
                operators.push(character);
            }
        }

        while (!operators.isEmpty()) {
            calculateAndPushResult(operands, operators);
        }

        if (operands.size() != 1) {
            throw new IllegalArgumentException("Invalid expression");
        }

        return operands.pop();
    }

   /**
    * The function calculates the result of an operation using two operands and a specified operator,
    * then pushes the result back onto the stack of operands.
    * 
    * @param operands The `operands` stack contains the numbers on which the operations will be
    * performed.
    * @param operators A stack containing mathematical operators such as +, -, *, /, etc.
    */
    private static void calculateAndPushResult(Stack<Double> operands, Stack<Character> operators) {
        if (operands.size() < 2) {
            throw new IllegalArgumentException("Insufficient operands for operation");
        }
        char operator = operators.pop();
        double operand2 = operands.pop();
        double operand1 = operands.pop();
        double result = performOperation(operand1, operand2, operator);
        operands.push(result);
    }

    /**
     * The function performs arithmetic operations (+, -, *, /, %, ^) on two operands based on the
     * specified operator.
     * 
     * @param operand1 Operand1 is the first number used in the operation.
     * @param operand2 Operand2 is the second operand used in the mathematical operation. It is the
     * value that is operated on by the operator in relation to operand1.
     * @param operator The `operator` parameter in the `performOperation` method represents the
     * mathematical operation to be performed on the two operands (`operand1` and `operand2`). 
     * @return The `performOperation` method takes two operands and an operator as input, performs the
     * specified operation based on the operator, and returns the result of the operation. 
     */
    private static double performOperation(double operand1, double operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException(Constant.DIVISION_BY_ZERO);
                }
                return operand1 / operand2;
            case '%':
                if (operand2 == 0) {
                    throw new ArithmeticException(Constant.DIVISION_MODULUS);
                }
                return operand1 % operand2;
            case '^':
                return power(operand1, (int) operand2);
            default:
                throw new IllegalArgumentException(Constant.INVALID_OPERATOR + operator);
        }
    }

    /**
     * The function checks if a given character is an arithmetic operator.
     * 
     * @param arithmetic The `isOperator` method checks if a given character is an arithmetic operator.
     * The method returns `true` if the character is one of the following operators: `+`, `-`, `*`,
     * `/`, `%`, or `^`. 
     * @return The method `isOperator` returns a boolean value indicating whether the input character
     * `arithmetic` is one of the following arithmetic operators: '+', '-', '*', '/', '%', or '^'.
     */
    private static boolean isOperator(char arithmetic) {
        return arithmetic == '+' || arithmetic == '-' || arithmetic == '*' ||
                arithmetic == '/' || arithmetic == '%' || arithmetic == '^';
    }

    /**
     * The function determines the precedence of arithmetic operators in an expression.
     * 
     * @param operator The `precedence` method takes a character `operator` as a parameter and returns
     * an integer value representing the precedence of that operator in a mathematical expression.
     * @return The method `precedence` returns an integer value representing the precedence of the
     * given operator. The return values are as follows:
     * - For '+' and '-', it returns 1.
     * - For '*', '/', and '%', it returns 2.
     * - For '^', it returns 3.
     * - For any other character, it returns 0.
     */
    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }

    /**
     * The function calculates the power of a base number raised to an exponent using a loop.
     * 
     * @param base The `base` parameter in the `power` method represents the number that will be raised
     * to the power of the `exponent` parameter.
     * @param exponent The exponent parameter in the power method represents the power to which the
     * base number is raised. 
     * @return The method `power` returns the result of raising the `base` to the power of `exponent`.
     */
    private static double power(double base, int exponent) {
        double result = 1.0;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }
}
