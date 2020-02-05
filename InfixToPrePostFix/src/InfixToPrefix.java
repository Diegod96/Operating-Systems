import java.util.Stack;
public class InfixToPrefix<E> {

    /**
     * Evaluates infix notation expression and converts it to prefix notation
     * @param operator
     * @return priority of operator
     */
    static int getPriority(char operator) {
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
     * Converts infix expression to prefix
     * @param expression
     * @return prefix representation of infix expression
     */
     StringBuilder infixToPreFix(String expression) {

        StringBuilder prefix = new StringBuilder();
        StringBuilder infix = new StringBuilder(expression);
        infix.reverse();
        Stack<Character> stack = new Stack<Character>();

        char[] characters = new String(infix).toCharArray();
        for (int i = 0; i < characters.length; i++) {

            if (characters[i] == '(') {
                characters[i] = ')';
                i++;
            } else if (characters[i] == ')') {
                characters[i] = '(';
                i++;
            }
        }
        for (int i = 0; i < characters.length; i++) {
            char character = characters[i];

            //check if character is operator or operand
            if (getPriority(character) > 0) {
                while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(character)) {
                    prefix.append(stack.pop());
                }
                stack.push(character);
            } else if (character == ')') {
                char x = stack.pop();
                while (x != '(') {
                    prefix.append(x);
                    x = stack.pop();
                }
            } else if (character == '(') {
                stack.push(character);
            } else {
                //character is neither operator nor "("
                prefix.append(character);
            }
        }

        for (int i = 0; i <= stack.size(); i++) {
            prefix.append(stack.pop());
        }
        return prefix.reverse();
    }
}