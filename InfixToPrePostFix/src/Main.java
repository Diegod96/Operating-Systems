
import java.text.DecimalFormat;
import javax.swing.*;

public class Main {



    public static void main(String[] args){

        Postfix<String> postfixTree = new Postfix<>();
        Evaluation evaluation = new Evaluation();
        Validator validator = new Validator();
        DecimalFormat df = new DecimalFormat("0.0");
        Format format = new Format();
        String post, pre, answer, expression, modExpression, raw;



//        String input = JOptionPane.showInputDialog(null, "Enter your expression");




        expression = validator.inputValidation();


//        System.out.println("Postfix: " + postfixTree.infixToPostFix(expression));
//        System.out.println("Prefix: " + prefixTree.infixToPreFix(expression));
//        System.out.println("Answer: " + df.format(evaluation.eval(expression)));

        post = postfixTree.infixToPostFix(expression).replaceAll(" ", "");
        expression = expression.replaceAll(" ", "");
        pre = Prefix.infixToPrefix(expression);
        pre = pre.replaceAll("", " ");
        answer = df.format(evaluation.eval(expression));
//        raw = String.valueOf(prefixTree.infixToPrefix(expression));
        modExpression = format.converter(pre);



        JOptionPane.showMessageDialog(null, "Postfix: " + post
                + '\n' + "Prefix: " + pre
                + '\n' + "Answer: " + answer
                + '\n' + "Tree: " + modExpression);
//        JOptionPane.showMessageDialog(null, "Prefix " + pre);
//        JOptionPane.showMessageDialog(null, "Answer " + answer);




        System.exit(0);



    }



}