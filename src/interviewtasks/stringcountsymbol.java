package interviewtasks;

/**
 * This is one of the most basic tasks to find all encounter of some letter in a string.
 * The idea for you to show that you understand some elementary programming
 * including conditions and cycles.
 * TAGS: #strings
 *
 */

public class stringcountsymbol {
    private static String stringToSeachIn;
    private static int stringToSearchInLength;
    private static char symbol;

    public static void main(String[] args) {
        String helpMessage = "A strings and a char arguments are expected. If second argument is a string the first char is taken ";
        if (args.length != 2) {
            System.out.println("wrong argument count\n" + helpMessage);
            return;
        }
        stringToSeachIn = args[0];
        symbol = args[1].charAt(0);

        stringToSearchInLength = stringToSeachIn.length();


        if (stringToSearchInLength < 1) {
            System.out.println("Empty string to search in\n" + helpMessage);
        } else {
            countSymbolInString(stringToSeachIn,symbol);
            countSymbolInStringFromTwoSides(stringToSeachIn,symbol);
            countSymbolInStringUsingIndexOf(stringToSeachIn,symbol);
        }
    }
    // using loop cycle
    private static void countSymbolInString(String str, char chr) {
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == symbol) counter++;
        }
        System.out.println(counter+" encounters found");
    }

    // using loop cycle (two seeks per cycle)
    private static void countSymbolInStringFromTwoSides(String str, char chr) {
        int counter = 0;
        int low =0;
        int high=str.length()-1;
        while (low <=high) {
            if (str.charAt(low) == symbol) counter++;
            if (low !=high && str.charAt(high)==symbol) counter++;
            low++;
            high--;

        }
        System.out.println(counter+" encounters found");
    }
    // using native "indexOf" loop cycle (two seeks per cycle)
    private static void countSymbolInStringUsingIndexOf(String str, char chr) {
        int counter = 0;
        int i =str.indexOf(chr);
        while (i >=0) {
            i = str.indexOf(chr, i+1);
            counter++;
        }
        System.out.println(counter+" encounters found");
    }

}