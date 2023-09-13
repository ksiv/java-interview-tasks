package interviewtasks;

/**
 * Java program to check if a string is palindrome.
 * To keep things simple this it is limited to simple latin words,
 * no complicated handling of sentences and different input encodings
 * there are four implementations
 * TAGS: #strings
 */

public class stringpalindrome {
    static String inputString;

    public static void main(String[] args) throws Exception {
        String helpMessage = "one strings is expected as a parameter e.g. \"abc123 321cba\"";

        if (args.length != 1) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return;

        } else {
            inputString = args[0];
            inputString.toLowerCase();
            System.out.println("String >>" + inputString + "<<");
            Long start;
            Long stop;

            start = System.nanoTime();
            System.out.println(isPalindromeViaStringReverse(inputString));
            stop = System.nanoTime();
            System.out.println("isPalindromeViaStringReverse time taken "+(stop - start));

            start = System.nanoTime();
            System.out.println(isPalindromeViaHalfStringReverse(inputString));
            stop = System.nanoTime();
            System.out.println("isPalindromeViaHalfStringReverse time taken "+(stop - start));

            start = System.nanoTime();
            System.out.println(isPalindromeCharPairsComparisonStartEnd(inputString));
            stop = System.nanoTime();
            System.out.println("isPalindromeCharPairsComparisonStartEnd time taken "+(stop - start));

            start = System.nanoTime();
            System.out.println(isPalindromeCharPairsComparisonStartEndRecursion(inputString));
            stop = System.nanoTime();
            System.out.println("isPalindromeCharPairsComparisonStartEndRecursion time taken "+(stop - start));


        }
    }
    // The basic approach is to reverse the string and check if original string is same as reversed one.
    public static boolean isPalindromeViaStringReverse(String str) {
        String reversedString = "";

        boolean retVal = false;

        for (int i = str.length() - 1; i >= 0; i--) {
            reversedString += str.charAt(i);
        }

        if (str.equals(reversedString)) {
            retVal = true;
        }
        return retVal;
    }
    // More optimised function to reverse only half the string
    public static boolean isPalindromeViaHalfStringReverse(String str) {
        String reversedHalfString = "";

        boolean retVal = false;
        // Half string plus one symbol to check even and odd length words
        int halfStringLength = (str.length()/2)+1;
        String halfString = str.substring(0,halfStringLength);
        for (int i = (str.length()-1); i >= halfStringLength-1; i--) {
            reversedHalfString += str.charAt(i);
        }

        if (halfString.equals(reversedHalfString)) {
            retVal = true;
        }
        return retVal;
    }
    // Comparing Char pairs from two ends till the middle is reached
    public static boolean isPalindromeCharPairsComparisonStartEnd(String str) {
        int halfStringLength = (str.length()/2)+1;
        int k =0;
        for (int i = (str.length()-1); i >= halfStringLength-1; i--) {
            if (str.charAt(i) != str.charAt(k)){
                return false;
            }
            ++k;
        }
        return true;
    }
    // Same last the prev one but in recursive approach
    public static boolean isPalindromeCharPairsComparisonStartEndRecursion(String str) {
        int stringLength = str.length();
        return isPalindromeCharPairsComparisonStartEndRecursion(str, 0, stringLength - 1);
    }

    private static boolean isPalindromeCharPairsComparisonStartEndRecursion(String str, int low, int high) {
        if (low >= high) {
            return true;
        }

        return (str.charAt(low) == str.charAt(high)) &&
                isPalindromeCharPairsComparisonStartEndRecursion(str, low + 1, high - 1);
    }

}
