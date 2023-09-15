package interviewtasks;

import java.util.Locale;

public class binarysumbytes {
    /**
     * leetcode 67. Add Binary
     * Given two binary strings a and b, return their sum as a binary string.
     */
    // BruteForce solution
    static class Solution {
        public static String addBinary(String a, String b) {

            StringBuilder retVal = new StringBuilder();
            int carry = 0;
            int sum;
            int maxNumLength = Math.max(a.length(), b.length());
            int[][] valAndCarry = new int[][]{{0, 0}, {1, 0}, {0, 1}, {1, 1}};
            for (int i = 0; i < maxNumLength + carry; i++) {
                sum = carry;
                carry = 0;
                if (i < a.length() && a.charAt(a.length() - i - 1) == '1') {
                    sum++;

                }
                if (i < b.length() && b.charAt(b.length() - i - 1) == '1') {
                    sum++;
                }

                retVal.append(valAndCarry[sum][0]);
                carry = valAndCarry[sum][1];
                sum = 0;

            }

            return retVal.reverse().toString();
        }
    }

    public static void main(String[] args) {
        String helpMessage = "two int strings are expected as input e.g. \"1010\" \"0101\"";
        if (args.length != 2) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);

        } else {
            String str1 = args[0].toLowerCase(Locale.ROOT);
            String str2 = args[1].toLowerCase(Locale.ROOT);


            System.out.println(new Solution().addBinary(str1, str2));
        }
    }
}
