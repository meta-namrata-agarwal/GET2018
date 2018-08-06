/**
 * class to evaluate a valid postfix expression
 * 
 * @author Namrata Agarwal
 *
 */

import assignment1August_DS_1.*;

public class PostfixEvaluate {

    LinkedListImplementation<Double> s = new LinkedListImplementation<Double>();
/**
 * evaluates the postfix expression
 * @param expression
 * @return double value for the expression
 * @throws NumberFormatException
 */
    public double evaluate(String expression) throws NumberFormatException {

        String[] token = expression.split(" ");
        for (String temp : token) {
            if (isOperator(temp)) {
                if (s.size() < 2)
                    throw new AssertionError();
                double operandOne = s.pop();
                double operandsecond = s.pop();
                double result = applyOperation(temp, operandOne, operandsecond);
                s.push(result);
            } else {
                s.push(Double.parseDouble(temp));
            }

        }
        if (s.size() != 1)
            throw new AssertionError();
        return s.pop();

    }
/**
 * private method for the mathematical operation to perform
 * @param temp
 * @param operandOne
 * @param operandsecond
 * @return result
 */
    private double applyOperation(String temp, double operandOne, double operandsecond) {
        double result = 0;
        switch (temp) {
        case "+":
            result = operandOne + operandsecond;
            break;
        case "-":
            result = operandsecond - operandOne;
            break;
        case "*":
            result = operandOne * operandsecond;
            break;
        case "/":
            if(operandsecond==0)
                throw new ArithmeticException();
            result = operandOne / operandsecond;
            break;
        default:
            break;
        }
        return result;
    }
/**
 * private method to check the operand
 * @param temp
 * @return boolaean value
 */
    private static boolean isOperator(String temp) {

        return temp.equals("*") || temp.equals("/") || temp.equals("+")
                || temp.equals("-");
    }

}
