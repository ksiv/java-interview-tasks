package interviewtasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * \interviewtasks> java -classpath ".."  interviewtasks.anagram "asds", "ssda"
 * <p>
 * According to wikipedia "An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once"
 * And "A word is a basic element of language that carries an objective or practical meaning"
 * Test tasks on interview in most cases exclude "carries an objective or practical meaning" part.
 * So "test" and "ttse" would be an anagram :-) As for this task the idea to show the approach
 * and meaningless words in latin alphabet would do.
 * INFO: https://en.wikipedia.org/wiki/Anagram
 * TAGS: #strings
 */

public class stringanagram {


    public static void main(String[] args) {
        String helpMessage = "two strings is expected as an input";
        if (args.length != 2) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return;
        } else {
            String firstString;
            String secondString;
            firstString = args[0];
            secondString = args[1];
            System.out.println(firstString + "_AND_" + secondString);
            System.out.println(isAnagramViaArraySorting(firstString, secondString));
            System.out.println(isAnagramViaSymbolCounters(firstString, secondString));
            System.out.println(isAnagramViaIntArraySymbolCounters(firstString, secondString));

        }
    }

    // Compare sorted arrays
    // Simple but could demand much RAM for big strings
    // Sorting also CPU intensive task
    private static boolean isAnagramViaArraySorting(String firstString, String secondString) {

        // Diff length strings can not be anagram
        if (firstString.length() != secondString.length()) {
            return false;
        }
        // Strings to arrays
        char[] firstChars = firstString.toCharArray();
        char[] secondChars = secondString.toCharArray();
        // Sort arrays
        Arrays.sort(firstChars);
        Arrays.sort(secondChars);
        System.out.println(Arrays.toString(firstChars));
        System.out.println(Arrays.toString(secondChars));
        // Compare arrays
        if (Arrays.equals(firstChars, secondChars)) {
            return true;
        }
        return false;

    }

    // Char frequency counters
    // encounters in the first string and Lower for second one
    // For an anagram the index must be empty by the end
    private static boolean isAnagramViaSymbolCounters(String firstString, String secondString) {

        // Diff length strings can not be anagram
        if (firstString.length() != secondString.length()) {
            return false;
        }
        // Map for counters. if you know the size of your auxiliary you could define  new HashMap<>(26)
        Map<Character, Integer> symbolFrequency = new HashMap<>();
        char tmpChar;
        // Traverse the first string and rise counters for each symbol
        for (int i = firstString.length() - 1; i >= 0; i--) {
            tmpChar = firstString.charAt(i);
            symbolFrequency.put(tmpChar, symbolFrequency.getOrDefault(tmpChar, 0) + 1);
        }
        // Traverse the second string decreasing counters
        for (int i = secondString.length() - 1; i >= 0; i--) {
            tmpChar = secondString.charAt(i);

            // If the symbol in the map reducing counter otherwise exit(false)
            if (!symbolFrequency.containsKey(tmpChar)) {
                return false;
            } else {
                symbolFrequency.put(tmpChar, symbolFrequency.get(tmpChar) - 1);
            }
            // Removing element if same amount of this symbol has been found in both string
            if (symbolFrequency.get(tmpChar) == 0) {
                symbolFrequency.remove(tmpChar);
            }
        }
        // check if Map is empty

        return symbolFrequency.isEmpty();

    }

    public static boolean isAnagramViaIntArraySymbolCounters(String s, String t) {
        // Diff length strings can not be anagram
        if (s.length() != t.length()) {
            return false;
        }
        int[] map = new int[128];
        char tChar, sChar;
        // Traverse the first string and rise counters for each symbol
        // Traverse the second string decreasing counters
        for (int i = s.length() - 1; i >= 0; i--) {
            sChar = s.charAt(i);
            tChar = t.charAt(i);
            map[sChar]++;
            map[tChar]--;

        }

        for (int val : map) {
            if (val != 0) return false;
        }
        // check if Map is empty

        return true;


    }

}


