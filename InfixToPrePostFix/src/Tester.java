import java.text.DecimalFormat;


public class Tester {

    public static void main(String[] args){

        InfixToPrefix<String> prefixTree = new InfixToPrefix<>();
        InfixToPostfix<String> postfixTree = new InfixToPostfix<>();
        Evaluation evaluation = new Evaluation();
        Validator validator = new Validator();
        DecimalFormat df = new DecimalFormat("0.0");
        String expression;

        expression = validator.inputValidation();

        System.out.println("Postfix: " + postfixTree.infixToPostFix(expression));
        System.out.println("Prefix: " + prefixTree.infixToPreFix(expression));
        System.out.println("Answer: " + df.format(evaluation.eval(expression)));


    }



}
