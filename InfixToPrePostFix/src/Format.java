public class Format {

//    public static String x;

    public boolean isEmpty(char[] array) {
        for (char c : array) {
            if (c == ' '){
                return false;
            }
        }
        return true;
    }


    public String converter(String input) {
        String x = null;

        char[] characterArray = input.toCharArray();

        // Check for Expression like 1 - - 2
        // Convert the "-", " ", and " " to 1 + 2

        try {


            for (int i = 0; i < characterArray.length; i++) {

                x = String.valueOf(characterArray);


                if (!x.matches(".*\\s+.*")) {
                    x = String.valueOf(characterArray);
                    break;
                } else if (characterArray[i + 2] == '+' || characterArray[i + 2] == '*' || characterArray[i + 2] == '/' || characterArray[i + 2] == '^' || characterArray[i + 2] == '-') {
                    characterArray[i + 1] = '(';
//                    System.out.println(String.valueOf(characterArray));
                } else if ((characterArray[i + 1] == '+' || characterArray[i + 1] == '*' || characterArray[i + 1] == '/' || characterArray[i + 1] == '^' || characterArray[i + 1] == '-') && Character.isWhitespace(characterArray[i + 2])) {
                    characterArray[i + 2] = '(';
//                    System.out.println(String.valueOf(characterArray));

                } else if (Character.isDigit(characterArray[i + 2]) && characterArray[i + 1] == '(') {
                    characterArray[i + 3] = ',';
//                    System.out.println(String.valueOf(characterArray));

                } else if (Character.isDigit(characterArray[i + 1]) && characterArray[i + 2] == ',' && Character.isDigit(characterArray[i + 3]) && Character.isWhitespace(characterArray[i + 4])) {
                    characterArray[i + 4] = ')';
//                    System.out.println(String.valueOf(characterArray));

                } else if (characterArray[i + 3] == ')' && (characterArray[i + 5] == '+' || characterArray[i + 5] == '*' || characterArray[i + 5] == '/' || characterArray[i + 5] == '^' || characterArray[i + 5] == '-') && Character.isWhitespace(characterArray[i + 4])) {
                    characterArray[i + 4] = '(';
//                    System.out.println(String.valueOf(characterArray));

                } else if ((characterArray[i + 4] == '+' || characterArray[i + 4] == '*' || characterArray[i + 4] == '/' || characterArray[i + 4] == '^' || characterArray[i + 4] == '-') && Character.isWhitespace(characterArray[i + 5]) && Character.isDigit(characterArray[i + 6])) {
                    characterArray[i + 5] = '(';
//                    System.out.println(String.valueOf(characterArray));

                } else if (characterArray[i + 4] == '(' && Character.isDigit(characterArray[i + 5]) && Character.isWhitespace(characterArray[i + 6]) && Character.isDigit(characterArray[i + 7])) {
                    characterArray[i + 6] = ',';
//                    System.out.println(String.valueOf(characterArray));

                } else if (characterArray[i + 4] == '(' && Character.isWhitespace(characterArray[i + 5]) && Character.isWhitespace(characterArray[i + 6]) && Character.isDigit(characterArray[i + 7])) {
                    characterArray[i + 6] = ',';
//                    System.out.println(String.valueOf(characterArray));

                } else if (characterArray[i + 5] == ',' && Character.isDigit(characterArray[i + 6]) && Character.isWhitespace(characterArray[i + 7]) && Character.isDigit(characterArray[i + 8])) {
                    characterArray[i + 7] = ')';
//                    System.out.println(String.valueOf(characterArray));

                }
//            else if (characterArray[i+5] == ')' && Character.isDigit(characterArray[i+6]) && Character.isWhitespace(characterArray[i+7])) {
//                characterArray[i+7] = ')';
//                System.out.println(String.valueOf(characterArray));
//            }
                else {
                    int end = characterArray.length;
                    characterArray[end - 1] = ')';
                }
            }



        }catch (ArrayIndexOutOfBoundsException ex){

        }

        return x;


    }

}

//        return String.valueOf(characterArray);




