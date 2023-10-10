package interviewtasks;

import java.util.HashMap;
import java.util.Map;

import static interviewtasks.lib.paramhelper.intArrayFromStringArray;

/**
 * leetcode.com 13. Roman to Integer
 * Constraints:
 * <p>
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */

public class roman2integer {

    static class Solution {
        Map<Character, Integer> map = new HashMap();

        public Solution() {
            map.put('M', 1000);
            map.put('D', 500);
            map.put('C', 100);
            map.put('L', 50);
            map.put('X', 10);
            map.put('V', 5);
            map.put('I', 1);

        }

        public int romanToInt(String s) {
            char prev = 'A';
            int retVal = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                if ((prev == 'V' || prev == 'X') && s.charAt(i) == 'I') {
                    retVal--;
                    prev=s.charAt(i);
                    continue;
                }
                if ((prev == 'M' || prev == 'D') && s.charAt(i) == 'C') {
                    retVal-=100;
                    prev=s.charAt(i);
                    continue;
                }

                if ((prev == 'C' || prev == 'L') && s.charAt(i) == 'X') {
                    retVal-=10;
                    prev=s.charAt(i);
                    continue;
                }

                retVal += map.get(s.charAt(i));
                prev=s.charAt(i);



            }
            return retVal;


        }
    }


    static class Solution2 {
        Map<Character, Integer> map = new HashMap();

        public Solution2() {
            map.put('M', 1000);
            map.put('D', 500);
            map.put('C', 100);
            map.put('L', 50);
            map.put('X', 10);
            map.put('V', 5);
            map.put('I', 1);

        }

        public int romanToInt(String s) {

            int retVal = 0;
               s = s.replace("IV", "IIII")
                    .replace("IX", "VIIII")
                    .replace("XL", "XXXX")
                    .replace("XC", "LXXXX")
                    .replace("CD", "CCCC")
                    .replace("CM", "DCCCC");
            for (int i = s.length() - 1; i >= 0; i--) {
              retVal+=map.get(s.charAt(i));
            }
            return retVal;


        }
    }

    public static void main(String[] args) {
        String helpMessage = "a strings is expected as a parameter e.g. \"MMMXLV\" ";
        if (args.length != 1) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return;

        }


        System.out.println(new Solution().romanToInt(args[0]));
        System.out.println(new Solution2().romanToInt(args[0]));
    }

}
