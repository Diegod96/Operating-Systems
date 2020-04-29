import java.util.Arrays;

public class Format {

    /**
     * Receives the prefix expression
     * Converts the prefix expression to a tree using bracket notation
     * @param input
     * @return result
     */


    public String converter(String input) {
        String result = null;

        char[] x = input.toCharArray();
        char[] characterArray = Arrays.copyOfRange(x, 1, x.length);

        // Loop through the char array until we hit an index out of bounds error
        try {


            for (int i = 0; i < characterArray.length; i++) {

                result = String.valueOf(characterArray);


                if (!result.matches(".*\\s+.*")) {
                    result = String.valueOf(characterArray);
                    break;
                } else if ((characterArray[i + 2] == '+' || characterArray[i + 2] == '*' || characterArray[i + 2] == '/' || characterArray[i + 2] == '^' || characterArray[i + 2] == '-') && Character.isWhitespace(characterArray[i+1])) {
                    characterArray[i + 1] = '(';

                }else if ((characterArray[i + 1] == '+' || characterArray[i + 1] == '*' || characterArray[i + 1] == '/' || characterArray[i + 1] == '^' || characterArray[i + 1] == '-') && Character.isWhitespace(characterArray[i + 2])) {
                    characterArray[i + 2] = '(';

                } else if (Character.isDigit(characterArray[i + 2]) && characterArray[i + 1] == '(') {
                    characterArray[i + 3] = ',';

                } else if (Character.isDigit(characterArray[i + 1]) && characterArray[i + 2] == ',' && Character.isDigit(characterArray[i + 3]) && Character.isWhitespace(characterArray[i + 4])) {
                    characterArray[i + 4] = ')';

                } else if (characterArray[i + 3] == ')' && (characterArray[i + 5] == '+' || characterArray[i + 5] == '*' || characterArray[i + 5] == '/' || characterArray[i + 5] == '^' || characterArray[i + 5] == '-') && Character.isWhitespace(characterArray[i + 4])) {
                    characterArray[i + 4] = '(';


                } else if ((characterArray[i + 4] == '+' || characterArray[i + 4] == '*' || characterArray[i + 4] == '/' || characterArray[i + 4] == '^' || characterArray[i + 4] == '-') && Character.isWhitespace(characterArray[i + 5]) && Character.isDigit(characterArray[i + 6])) {
                    characterArray[i + 5] = '(';

                } else if (characterArray[i + 4] == '(' && Character.isDigit(characterArray[i + 5]) && Character.isWhitespace(characterArray[i + 6]) && Character.isDigit(characterArray[i + 7])) {
                    characterArray[i + 6] = ',';

                } else if (characterArray[i + 4] == '(' && Character.isWhitespace(characterArray[i + 5]) && Character.isWhitespace(characterArray[i + 6]) && Character.isDigit(characterArray[i + 7])) {
                    characterArray[i + 6] = ',';

                } else if (characterArray[i + 5] == ',' && Character.isDigit(characterArray[i + 6]) && Character.isWhitespace(characterArray[i + 7]) && Character.isDigit(characterArray[i + 8])) {
                    characterArray[i + 7] = ')';

                }else{
                    int end = characterArray.length;
                    characterArray[end - 1] = ')';
                }
            }



        }catch (ArrayIndexOutOfBoundsException ex){

        }

        return result;


    }

}

