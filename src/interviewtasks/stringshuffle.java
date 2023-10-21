package interviewtasks;

import static interviewtasks.lib.paramhelper.intArrayFromStringArray;

/**
 * leetcode 1528. Shuffle String
 * You are given a string s and an integer array indices of the same length. The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.
 *
 * Return the shuffled string.
 */

public class stringshuffle {
    static class Solution {
        public String restoreString(String s, int[] indices) {
            StringBuilder resStr = new StringBuilder();
            resStr.setLength(indices.length);
            for (int i=0;i<indices.length;i++){

                resStr.setCharAt(indices[i],s.charAt(i));
            }
            return resStr.toString();
        }
    }


    public static void main(String[] args) {
        String helpMessage = "A word and a comma separated int array of same length \"stte\" \"2,3,0,1\" are expected as input";
        if (args.length != 2) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
        } else {
            String s = args[0];
            String[] stringArray = args[1].split(",");
            int[] intArray = intArrayFromStringArray(stringArray);
            System.out.println(new Solution().restoreString(s,intArray));
        }
    }
}
