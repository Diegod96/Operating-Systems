
import java.text.DecimalFormat;
import javax.swing.*;

public class Main {

    public static void main(String[] args){

        Postfix<String> postfixTree = new Postfix<>();
        Evaluation evaluation = new Evaluation();
        Validator validator = new Validator();
        DecimalFormat df = new DecimalFormat("0.0");
        Format format = new Format();
        String post, pre, answer, expression, modExpression;

        expression = validator.inputValidation();

        post = postfixTree.infixToPostFix(expression).replaceAll(" ", "");
        expression = expression.replaceAll(" ", "");
        pre = Prefix.infixToPrefix(expression);
        pre = pre.replaceAll("", " ");
        answer = df.format(evaluation.eval(expression));
        modExpression = format.converter(pre);
        modExpression = modExpression.replaceAll(" ", ")");



        JOptionPane.showMessageDialog(null, "Postfix: " + post
                + '\n' + "Prefix: " + pre
                + '\n' + "Answer: " + answer
                + '\n' + "Tree: " + modExpression);

        System.exit(0);

    }
}