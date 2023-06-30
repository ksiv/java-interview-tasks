package interviewtasks;

/**
 * Java program to check if a string is palindrome.
 * To keep things simple this it is limited to simple latin words,
 * no complicated handling of sentences and different input encodings
 * @author ksiv
 */

public class palindrome {
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
            System.out.println("String >>" + inputString + "<< a " + isPalindrome(inputString) + " palindrome");
        }
    }

    public static boolean isPalindrome(String str) {
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

}
