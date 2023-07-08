package interviewtasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Different implementation of substring search
 * There is no best algorithm out there as every approach better suits some type of input data than the other
 * in this example only few algorithms provided
 * Some methods count overlapping encounters and other do not.
 */

public class subString {
    static String stringToSeachIn; // Codename haystack
    static String subString; // Codename needle :-)
    static int subStringLength;
    static int stringToSearchInLength;

    public static void main(String[] args) {
        String helpMessage = "two strings is expected as an input: a string to search in and a substring to be searched";
        if (args.length != 2) {
            System.out.println("wrong argument count\n" + helpMessage);
        }
        stringToSeachIn = args[0];
        subString = args[1];
        subStringLength = subString.length();
        stringToSearchInLength = stringToSeachIn.length();

        if (subStringLength > stringToSearchInLength) {
            System.out.println("Substring longer than a string\n" + helpMessage);
        } else if (stringToSearchInLength == 0 || subStringLength == 0) {
            System.out.println("Empty string\n" + helpMessage);
        } else {
            System.out.println(stringToSeachIn + "_AND_" + subString);
            Long start;
            Long stop;

            start = System.nanoTime();
            subStringMatchForEveryCharInString();
            stop = System.nanoTime();
            System.out.println("subStringMatchForEveryCharInString time taken " + (stop - start));

            start = System.nanoTime();
            charByChar();
            stop = System.nanoTime();
            System.out.println("charByChar time taken " + (stop - start));

            start = System.nanoTime();
            viaRegexp();
            stop = System.nanoTime();
            System.out.println("viaRegexp time taken " + (stop - start));

            start = System.nanoTime();
            javaRegionMatches();
            stop = System.nanoTime();
            System.out.println("javaRegionMatches time taken " + (stop - start));

            start = System.nanoTime();
            KMP();
            stop = System.nanoTime();
            System.out.println("KMP time taken " + (stop - start));


        }

    }


    // Memory heavy  "Window" approach.
    // finds overlap
    private static void subStringMatchForEveryCharInString() {
        String window = "";
        ArrayList<Integer> occurrenceArr = new ArrayList<Integer>();

        for (int i = 0; i <= stringToSearchInLength - subStringLength; i++) {


            window = stringToSeachIn.substring(i, i + subStringLength);
            if (window.equals(subString)) {
                occurrenceArr.add(i);
            }
        }
        System.out.println("Encounters indexes:" + occurrenceArr.toString() + "");

    }

    // Char by char
    // finds overlap
    private static void charByChar() {
        ArrayList<Integer> occurrenceArr = new ArrayList<Integer>();

        int k = 0, i = 0, j = 0;

        // for every index "i" in string to be searched
        for (i = 0; i <= (stringToSearchInLength - subStringLength); i++) {
            // try match subString char by char
            for (j = 0; j < subStringLength; j++) {
                if (stringToSeachIn.charAt(i + j) != subString.charAt(j))
                    break;
            }
            // if all char in subString matched - record position
            if (j == subStringLength) {
                k++;
                occurrenceArr.add(i);
            }
        }

        System.out.println("Encounters indexes:" + occurrenceArr.toString() + "");
    }

    // does not find overlap
    private static void viaRegexp() {
        ArrayList<Integer> occurrenceArr = new ArrayList<Integer>();
        String REGEX = subString;
        Pattern.compile(REGEX)
                .matcher(stringToSeachIn).results()
                .forEach(matchResult -> occurrenceArr.add(matchResult.start()));
        System.out.println("viaRegexp Encounters indexes:" + occurrenceArr.toString() + "");

    }

    // One of Java build in method
    // finds overlap
    public static void javaRegionMatches() {
        final boolean ignoreCase = false;


        ArrayList<Integer> occurrenceArr = new ArrayList<Integer>();

        for (int i = 0; i < stringToSearchInLength - subStringLength + 1; i++) {
            if (stringToSeachIn.regionMatches(ignoreCase, i, subString, 0, subStringLength)) {
                occurrenceArr.add(i);
            }
        }
        System.out.println("javaRegionMatches Encounters indexes:" + occurrenceArr.toString() + "");

    }



     // KMP algorithm of pattern matching.
     // does not find overlap
    public static void KMP() {
        ArrayList<Integer> occurrenceArr = new ArrayList<Integer>();
        char[] charArrayToSearchIn = stringToSeachIn.toCharArray();
        char[] charArrayToSearch = subString.toCharArray();

        // Prepare LPS (List of prefixes and suffixes)
        // we are looking for a word beginning in the word itself
        int[] lps = new int[subStringLength];
        int j = 0;
        int i;
        for (i = 1; i < subStringLength; ) {
            // For every position "i" in a word look for the word beginning
            if (charArrayToSearch[i] == charArrayToSearch[j]) {
                // word beginning found, write down how many consequential letters by this position
                lps[i] = j + 1;
                j++;
                i++;
            } else {
                if (j != 0) {
                    // Letter not found move to previous letter
                    j = lps[j - 1];
                } else {
                    // No letters found, at this position search can go from 1-st letter again
                    lps[i] = 0;
                    i++;
                }
            }
        }
        System.out.println("LPS (ind)"+Arrays.toString(subString.toCharArray()));
        System.out.println("LPS (val)" + Arrays.toString(lps));


        i = 0;
        j = 0;
        while (i < (stringToSearchInLength)) {
            System.out.println(i+"-"+stringToSeachIn.charAt(i)+"-"+j+"-"+subString.charAt(j));
            if (charArrayToSearchIn[i] == charArrayToSearch[j]) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    // check every position where the word could begin
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
            if (j == subStringLength) {
                occurrenceArr.add(i-j);
                j=0;
            }
        }

        System.out.println("KMP Encounters indexes:" + occurrenceArr.toString() + "");
    }

}
