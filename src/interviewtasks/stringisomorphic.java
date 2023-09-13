package interviewtasks;

import java.util.*;
import java.util.stream.Collectors;

/**
 * leetcode.com 205. Isomorphic Strings
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
 * ASCII set is used
 */
public class stringisomorphic {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {

            if (map.containsKey(s.charAt(i))) {

                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                if (map.containsValue(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }

        }

        return true;
    }

    // int array hash implementation
    public static boolean isIsomorphic2(String s, String t) {

        // one map can be used with adding offset while addressing "t" values
        // these map store cycle "i" value for given pair, each time they met
        // index is checked for equality and updated
        int[] map1 = new int[128];
        int[] map2 = new int[128];

        if (s.length() != t.length())
            return false;


        for (int i = 0; i < s.length(); i++) {
            // in this case char is converted to int
            if (map1[s.charAt(i)] != map2[t.charAt(i)])
                return false;

            map1[s.charAt(i)] = i + 1;
            map2[t.charAt(i)] = i + 1;

        }
        return true;
    }

    public static void main(String[] args) {
        String helpMessage = "two strings are expected as input e.g. \"abcda\" \"xyztx\", beware long input";
        if (args.length != 2) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);

        } else {
            String str1 = args[0];
            String str2 = args[1];

            System.out.println(isIsomorphic(str1, str2));
            System.out.println(isIsomorphic2(str1, str2));
        }
    }
}
