import javax.swing.*;
import java.util.*;
import java.util.Arrays;


class Validator {
    String x;


    /**
     * Validates user input to make sure it adheres to following format
     *
     * @return validated string expression
     */

    public void removeElement(char[] arr, int removedIdx) {
        System.arraycopy(arr, removedIdx + 1, arr, removedIdx, arr.length - 1 - removedIdx);
    }
    public String inputValidation() {
        String expression;
        boolean isExpression;
//        Scanner keyboard = new Scanner(System.in);
        String text = "Please enter your expression in the following format."
                + '\n' + "Spaces will separate operands and operators."
                + '\n' + "No Parenthesis."
                + '\n' + "Example: 2 + 5 * 3 + 1 ^ 6 - 7";

        JOptionPane.showMessageDialog(null, text);
//        System.out.println("Spaces will separate operands and operators");
//        System.out.println("No Parenthesis");
//        System.out.println("Example: 2 + 5 * 3 + 1 ^ 6 - 7");

        do {
//            System.out.print("Enter expression: ");
            expression = JOptionPane.showInputDialog(null, "Enter your expression");

            //Regex pattern to see if expression contains any letters
            if (expression.matches(".*[a-zA-Z]+.*")) {
                JOptionPane.showMessageDialog(null,"Please enter only numbers");
                isExpression = false;
            }
            //Checks if expression contains any parenthesis
            else if (expression.contains(")") || expression.contains("(")) {
                JOptionPane.showMessageDialog(null,"Please do not enter parenthesis");
                isExpression = false;

            }
            //Checks to make sure expression contains an operator
            else if (!expression.contains("+") && !expression.contains("-") && !expression.contains("*") && !expression.contains("/") && !expression.contains("^") ){
                JOptionPane.showMessageDialog(null,"Please enter an operator");
                isExpression = false;

            }
            //Checks to make sure the expression contains numbers
            //Ex: user can input: "+"
            //This will pass the first three checks but fail here
            else if(!expression.matches(".*\\d.*")){
                JOptionPane.showMessageDialog(null,"Please enter a number");
                isExpression = false;
            }else{
                isExpression = true;
            }
            //Will keep on looping until the user enters a valid expression
        } while (!isExpression);
        String noSpace = expression.replaceAll(" ", "");
        char[] e = noSpace.toCharArray();

        for (int i = 0; i < e.length; i++){
            if (e[i+1] == '-' && e[i+2] == '-'){
                e[i+1] = '+';
                e[i+2] = ' ';
                String x = String.valueOf(e);
                x = x.replaceAll( " ", "");
                return x;

            }

            }

        return "0";


    }
}




