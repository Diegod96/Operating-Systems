import java.util.Stack;

public class ShuntingYard {

    public static void main(String[] args) {
        String infix = "- + 1 3 * ^ 6 7 5";
        convert(infix);

        }

//        System.out.printf("infix:   %s%n", infix);
//        System.out.printf("postfix: %s%n", infixToPostfix(infix));


    public static String convert(String input){

        String raw = input + " ";

        char[] characters = raw.toCharArray();

        for(int i = 0; i < characters.length; i++){
            if (characters[i+2] == '+' || characters[i+2] == '-' || characters[i+2] == '*' || characters[i+2] == '/' || characters[i+2] == '^'){
                characters[i+1] = '(';
                System.out.println(String.valueOf(characters));
            }
            else if ((characters[i+1] == '+' || characters[i+1] == '-' || characters[i+1] == '*' || characters[i+1] == '/' || characters[i+1] == '^') && Character.isWhitespace(characters[i+2])){
                characters[i+2] = '(';
                System.out.println(String.valueOf(characters));
            }
            else if(Character.isDigit(characters[i+2]) && characters[i+1] == '('){
                characters[i+3] = ',';
                System.out.println(String.valueOf(characters));
            }
            else if (Character.isDigit(characters[i+1]) && characters[i+2] == ',' && Character.isDigit(characters[i+3]) && Character.isWhitespace(characters[i+4])){
                characters[i+4] = ')';
                System.out.println(String.valueOf(characters));
            }
            else if (characters[i+3] == ',' && (characters[i+4] == '+' || characters[i+4] == '-' || characters[i+4] == '*' || characters[i+4] == '/' || characters[i+4] == '^') && Character.isWhitespace(characters[i+5])){
                characters[i+5] = '(';
                System.out.println(String.valueOf(characters));
            }
            else if ((characters[i+4] == '+' || characters[i+4] == '-' || characters[i+4] == '*' || characters[i+4] == '/' || characters[i+4] == '^') && Character.isWhitespace(characters[i+5]) && Character.isDigit(characters[i+6])){
                characters[i+5] = '(';
                System.out.println(String.valueOf(characters));
            }
            else if (characters[i+4] == '(' && Character.isDigit(characters[i+5]) && Character.isWhitespace(characters[i+6]) && Character.isDigit(characters[i+7])){
                characters[i+6] = ',';
                System.out.println(String.valueOf(characters));
            }
            else if (characters[i+5] == ',' && Character.isDigit(characters[i+6]) && Character.isWhitespace(characters[i+7]) && Character.isDigit(characters[i+8])){
                characters[i+7] = ')';
                System.out.println(String.valueOf(characters));
            }
            else if (characters[i+5] == ')' && Character.isDigit(characters[i+6]) && Character.isWhitespace(characters[i+7])){
                characters[i+7] = ')';
                System.out.println(String.valueOf(characters));
            }
        }


        return String.valueOf(characters);

    }

}