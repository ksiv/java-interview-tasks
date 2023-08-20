package interviewtasks;

/**
 * leetcode.com 392. Is Subsequence
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * A subsequence of a string is a new string that is formed from the original string by deleting some
 * (can be none) of the characters without disturbing the relative positions of the remaining characters.
 * (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *
 */
public class iscommonsubsequence {
    public static boolean isSubsequence(String s, String t) {

        if (s.length()==0) return true; // I do not understand this test case
        int j=0;
        for (int i=0;i<t.length();i++){
            if(t.charAt(i)==s.charAt(j)){
                j++;
                if(s.length()==j) return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        String helpMessage = "two strings is expected as an input: a string to search in and a possible subsequence to be searched";
        if (args.length != 2) {
            System.out.println("wrong argument count\n" + helpMessage);
            return;
        }
        String stringToSeachIn = args[0];
        String subString = args[1];
        int subStringLength = subString.length();
        int stringToSearchInLength = stringToSeachIn.length();

        if (subStringLength > stringToSearchInLength) {
            System.out.println("Substring longer than a string\n" + helpMessage);
        } else if (stringToSearchInLength == 0 || subStringLength == 0) {
            System.out.println("Empty string\n" + helpMessage);
        } else {
            System.out.println(isSubsequence(subString, stringToSeachIn));
        }
    }

}
