import javax.swing.*;

class Validator {


    /**
     * Validates user input to make sure it adheres to following format
     *
     * @return validated string expression
     */

    public String inputValidation() {
        String expression;
        boolean isExpression;
        String text = "Please enter your expression in the following format."
                + '\n' + "Spaces will separate operands and operators."
                + '\n' + "No Parenthesis."
                + '\n' + "Example: 2 + 5 * 3 + 1 ^ 6 - 7";

        JOptionPane.showMessageDialog(null, text);
        do {
            expression = JOptionPane.showInputDialog(null, "Enter your expression");
            String noSpaceExpression = expression.replaceAll(" ", "");

            //Regex pattern to see if expression contains any letters
            if (expression.matches(".*[a-zA-Z]+.*")) {
                JOptionPane.showMessageDialog(null, "Please enter only numbers");
                isExpression = false;
            }
            //Checks if expression contains any parenthesis
            else if (expression.contains(")") || expression.contains("(")) {
                JOptionPane.showMessageDialog(null, "Please do not enter parenthesis");
                isExpression = false;
            }
            //Checks to make sure expression contains an operator
            else if (!expression.contains("+") && !expression.contains("-") && !expression.contains("*") && !expression.contains("/") && !expression.contains("^")) {
                JOptionPane.showMessageDialog(null, "Please enter an operator");
                isExpression = false;
            }
            //Checks to make sure the expression contains numbers
            //Ex: user can input: "+"
            //This will pass the first three checks but fail here
            else if (!expression.matches(".*\\d.*")) {
                JOptionPane.showMessageDialog(null, "Please enter a number");
                isExpression = false;
            //Checks if user input contains "--" instead of "+"
            } else if (expression.contains("- -") || expression.contains("--")) {
                JOptionPane.showMessageDialog(null, "Please use '+' instead of '--'");
                isExpression = false;
            }

            //Checks to see if expression is more than just a trivial expression like "1+2"
            else if (noSpaceExpression.length() < 4){
                JOptionPane.showMessageDialog(null, "Please enter an expression larger than three characters");
                isExpression = false;
            }
            else {
                isExpression = true;
            }
            //Will keep on looping until the user enters a valid expression
        } while (!isExpression);
        return expression;
    }
}





