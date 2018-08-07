package assignmentDS2ques2;

import assignment1August_DS_1.*;

/**
 * class to convert an infix expression into ostfix expresssion with order of
 * precedence
 * 
 * @author Namrata Agarwal
 *
 */
public class InfixToPostfix {
    /**
     * Static method to convert the expression
     * 
     * @param expression
     * @return postfix expression
     */
    public static String postfix(String expression) {
        Stack<Character> stack = new LinkedListImplementation<Character>();
        char token;
        String result = new String("");
        for (int i = 0; i < expression.length(); i++) {
            token = expression.charAt(i);
            if (Character.isLetterOrDigit(token)) {
                result = result + token;
                System.out.println(result);
            } else if (token == '(') {
                stack.push(token);
            } else if (token == ')') {
                while (!stack.isEmpty() && stack.top() != '(')
                    result = result + stack.pop();
                if (!stack.isEmpty() && stack.top() != '(')
                    throw new AssertionError();
                else
                    stack.pop();
            } else {
                while (!stack.isEmpty()
                        && precedencePriority(token) <= precedencePriority(stack
                                .top())) {
                    result = result + stack.pop();
                }
                stack.push(token);
            }
        }
        while (!stack.isEmpty()) {
            result = result + stack.pop();
        }
        return result;
    }

    /**
     * static method to check the order of precedence of the operators
     * 
     * @param char token as operators
     * @return int value for the precedence
     */
    private static int precedencePriority(char token) {
        switch (Character.toString(token)) {
        case "||":
            return 1;
        case "&&":
            return 2;
        case "!=":
        case "==":
            return 3;
        case ">":
        case ">=":
        case "<":
        case "<=":
            return 4;
        case "+":
        case "-":
            return 5;
        case "*":
        case "/":
            return 6;
        case "!":
        case "^":
            return 7;
        }
        return -1;

    }
}
