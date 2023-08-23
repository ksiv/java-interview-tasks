package interviewtasks;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * leetcode.com 383. Ransom Note
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 * Each letter in magazine can only be used once in ransomNote.
 * TAGS: #frequency-map
 */
public class stringcontainsallchars {
    // frequency map
    public static boolean canConstruct(String charSet, String shouldContain) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < shouldContain.length(); i++) {
            map.put(shouldContain.charAt(i), map.getOrDefault(shouldContain.charAt(i), 0) + 1);
        }

        for (int i = 0; i < charSet.length(); i++) {
            if (map.containsKey(charSet.charAt(i)) && map.get(charSet.charAt(i)) > 0) {
                map.put(charSet.charAt(i), map.get(charSet.charAt(i)) - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String helpMessage = "two strings are expected as input e.g. \"abc\" \"akhbkc\", beware long input";
        if (args.length != 2) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);

        } else {
            String str1 = args[0].toLowerCase(Locale.ROOT);
            String str2 = args[1].toLowerCase(Locale.ROOT);

            System.out.println(canConstruct(str1, str2));
        }
    }
}
