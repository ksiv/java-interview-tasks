package interviewtasks;

import java.util.HashMap;
import java.util.Map;

public class wordpattern {
    /**
     * leetcode.com 290. Word Pattern
     * Given a pattern and a string s, find if s follows the same pattern.
     * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
     * TAGS: #isomorthic
     */
    public static boolean wordPattern(String pattern, String s) {
        String[] strArr = s.split(" ");
        if (pattern.length() != strArr.length) return false;
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {

            if (map.containsKey(pattern.charAt(i))) {

                if (!map.get(pattern.charAt(i)).equals(strArr[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(strArr[i])) {
                    return false;
                }
                map.put(pattern.charAt(i), strArr[i]);
            }

        }

        return true;
    }

    public static void main(String[] args) {
        String helpMessage = "two strings are expected as input e.g. \"abba\" \"test this this test\"";
        if (args.length != 2) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);

        } else {
            String str1 = args[0];
            String str2 = args[1];

            System.out.println(wordPattern(str1, str2));

        }
    }
}
