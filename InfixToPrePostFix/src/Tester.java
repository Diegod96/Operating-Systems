
public class Tester {


    public static void main(String[] args) {

        DDBinarySearchTree<Integer> integerSearchTree = new DDBinarySearchTree<>();
        DDBinarySearchTree<String> stringSearchTree = new DDBinarySearchTree<>();

        String stringToSplit = "1 + 3 - 6 ^ 7 * 5";

        //Splits up string and adds to stringSearchTree
        for (String str : stringToSplit.split(" ")) {
            stringSearchTree.add(str);
        }

        stringSearchTree.printOrderedData();


    }
}

//        for (int i = 0; i < 10 ; i++) {
//            integerSearchTree.add(i);
//        }

//        stringSearchTree.printOrderedData();
//
//
//
////        /**
////         * for each loops that iterate through their tree
////         */
//////        for (int num : integerSearchTree){
//////            System.out.println(num);
//////        }
////
//////        for (String words : stringSearchTree){
//////            System.out.println(words);
//////        }
////
////    }
////}
