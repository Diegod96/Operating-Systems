
import java.util.*;



class Prefix {


    // Checks if character is an operand
    static boolean isOperand(char character) {
        return
                !(character >= '0' && character <= '9');
    }


    // Gets priotity of an operator
    static int getPriority(char operator) {
        if (operator == '-' || operator == '+')
            return 1;
        else if (operator == '*' || operator == '/')
            return 2;
        else if (operator == '^')
            return 3;
        return 0;
    }

    /**
     * Converts infix expression to prefix notation
     * @param infixExpression
     * @return prefixExpression
     */
    static String infixToPrefix(String infixExpression) {

        Stack<Character> operators = new Stack<Character>();
        Stack<String> operands = new Stack<String>();

        for (int i = 0; i < infixExpression.length(); i++) {


            if (infixExpression.charAt(i) == '(') {
                operators.push(infixExpression.charAt(i));
            }

            else if (infixExpression.charAt(i) == ')') {
                while (!operators.empty() &&
                        operators.peek() != '(') {


                    String op1 = operands.peek();
                    operands.pop();

                    String op2 = operands.peek();
                    operands.pop();

                    char op = operators.peek();
                    operators.pop();


                    String tmp = op + op2 + op1;
                    operands.push(tmp);
                }


                operators.pop();
            }


            else if (!isOperand(infixExpression.charAt(i))) {
                operands.push(infixExpression.charAt(i) + "");
            }


            else {
                while (!operators.empty() &&
                        getPriority(infixExpression.charAt(i)) <=
                                getPriority(operators.peek())) {

                    String op1 = operands.peek();
                    operands.pop();

                    String op2 = operands.peek();
                    operands.pop();

                    char op = operators.peek();
                    operators.pop();

                    String tmp = op + op2 + op1;
                    operands.push(tmp);
                }

                operators.push(infixExpression.charAt(i));
            }
        }


        while (!operators.empty()) {
            String op1 = operands.peek();
            operands.pop();

            String op2 = operands.peek();
            operands.pop();

            char op = operators.peek();
            operators.pop();

            String tmp = op + op2 + op1;
            operands.push(tmp);
        }

        String prefixExpression = operands.peek();
        return prefixExpression;
    }
}
