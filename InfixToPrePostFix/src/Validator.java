import javax.swing.*;
import java.util.*;


class Validator {


    /**
     * Validates user input to make sure it adheres to following format
     * 2 + 5 * 3 + 1 ^ 6 - 7
     * @return validated string expression
     */
    public String inputValidation() {
        String expression;
        boolean isExpression;
//        Scanner keyboard = new Scanner(System.in);
        String text = "Please enter your expression in the following format."
                + '\n' + "Spaces will separate operands and operators."
                + '\n' + "No Parenthesis."
                + '\n' + "Example: 2 + 5 * 3 + 1 ^ 6 - 7";

<<<<<<< HEAD
        System.out.println("Please enter your expression in the following format.");
        System.out.println("Spaces will separate operands and operators. No Parenthesis.");
        System.out.println("Example: 2 + 5 * 3 + 1 ^ 6 - 7");
=======
        JOptionPane.showMessageDialog(null, text);
//        System.out.println("Spaces will separate operands and operators");
//        System.out.println("No Parenthesis");
//        System.out.println("Example: 2 + 5 * 3 + 1 ^ 6 - 7");
>>>>>>> dd8b27fe23f36d389c7c272e48d218738f128fcf

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
        return expression;
    }
}








