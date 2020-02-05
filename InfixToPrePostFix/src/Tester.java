import java.text.DecimalFormat;
import javax.swing.*;

public class Tester {

    public static void main(String[] args){

        InfixToPrefix<String> prefixTree = new InfixToPrefix<>();
        InfixToPostfix<String> postfixTree = new InfixToPostfix<>();
        Evaluation evaluation = new Evaluation();
        Validator validator = new Validator();
<<<<<<< HEAD
        DecimalFormat df = new DecimalFormat("0.0");
        String expression;
=======
        DecimalFormat df = new DecimalFormat("0.00");
        String post, pre, answer, expression, text;


//        String input = JOptionPane.showInputDialog(null, "Enter your expression");


>>>>>>> dd8b27fe23f36d389c7c272e48d218738f128fcf

        expression = validator.inputValidation();

<<<<<<< HEAD
        System.out.println("Postfix: " + postfixTree.infixToPostFix(expression));
        System.out.println("Prefix: " + prefixTree.infixToPreFix(expression));
        System.out.println("Answer: " + df.format(evaluation.eval(expression)));
=======

//        System.out.println("Postfix: " + postfixTree.infixToPostFix(expression));
//        System.out.println("Prefix: " + prefixTree.infixToPreFix(expression));
//        System.out.println("Answer: " + df.format(evaluation.eval(expression)));

        post = postfixTree.infixToPostFix(expression);
        pre = String.valueOf(prefixTree.infixToPreFix(expression));
        answer = df.format(evaluation.eval(expression));




        JOptionPane.showMessageDialog(null, "Postfix: " + post
        + '\n' + "Prefix: " + pre
        + '\n' + "Answer: " + answer);
//        JOptionPane.showMessageDialog(null, "Prefix " + pre);
//        JOptionPane.showMessageDialog(null, "Answer " + answer);
        System.exit(0);

>>>>>>> dd8b27fe23f36d389c7c272e48d218738f128fcf


    }



}
