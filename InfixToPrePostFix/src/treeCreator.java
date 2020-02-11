public class treeCreator {

    public static void main(String[] args) {
        String input = "-(+(1,2)*(^(5,6)7)";
        makeTree(input);
    }

    public static void makeTree(String expression){
        char[] charArray = expression.toCharArray();

        for(int i = 0; i < charArray.length; i++){

            if (charArray[i] == '+' || charArray[i] == '-' || charArray[i] == '*' || charArray[i] == '/' || charArray[i] == '^'){
                System.out.println("                               " + charArray[i]);
            }
            else if(charArray[i] == '(' && (charArray[i+1] == '+' || charArray[i+1] == '-' || charArray[i+1] == '*' || charArray[i+1] == '/' || charArray[i+1] == '^')){
                System.out.println("");
            }

        }


    }

}
