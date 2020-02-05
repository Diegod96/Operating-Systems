
import java.util.Stack;

public class InfixToPostfix<E> {

    /**
     * Evaluates infix notation expression and converts it to prefix notation
     * @param operator
     * @return priority of operator
     */
    public int getPrioity(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    /**
     * Converts infix expression to postfix
     * @param expression
     * @return postfix representation of infix expression
     */
    public String infixToPostFix(String expression) {

        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char charAt = expression.charAt(i);

            // Check if current character is an operator
            if (getPrioity(charAt) > 0) {
                while (!stack.isEmpty() && getPrioity(stack.peek()) >= getPrioity(charAt)) {
                    postfix.append(stack.pop());
                }
                stack.push(charAt);
            } else if (charAt == ')') {
                char x = stack.pop();
                while (x != '(') {
                    postfix.append(x);
                    x = stack.pop();
                }
            } else if (charAt == '(') {
                stack.push(charAt);
            } else {
                // Character is a number
                postfix.append(charAt);
            }
        }
        for (int i = 0; i <= stack.size(); i++) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

}
