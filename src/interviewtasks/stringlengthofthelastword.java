package interviewtasks;

/**
 * leetcode 58. Length of Last Word
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 * <p>
 * A word is a maximal substring consisting of non-space characters only.
 * Constraints:
 * <p>
 * 1 <= s.length <= 104
 * s consists of only English letters and spaces ' '.
 * There will be at least one word in s.
 */

public class stringlengthofthelastword {
    static class Solution {
        public int lengthOfLastWord(String s) {
            return (s.strip().length() - (s.strip().lastIndexOf(" ") + 1));
        }
    }

    public static void main(String[] args) {
        String helpMessage = "one strings is expected as a parameter e.g. \"hello world\"";

        if (args.length != 1) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);

        } else {
            System.out.println(new Solution().lengthOfLastWord(args[0]));

        }
    }

}
