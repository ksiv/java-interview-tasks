package interviewtasks;


import java.util.ArrayList;
import java.util.Arrays;

import static interviewtasks.paramchecker.isStringIntegerValue;

public class countbits {

    /** leetcode 338. Counting Bits
     * Given an integer n,
     * return an array ans of length n + 1 such that for each i (0 <= i <= n),
     * ans[i] is the number of 1's in the binary representation of i.
     * <p>
     * Example 1:
     * <p>
     * Input: n = 2
     * Output: [0,1,1]
     * Explanation:
     * 0 --> 00
     * 1 --> 01 (+1)
     * 2 --> 10 (+1)
     * TAGS: #hamming-weight #population-count
     */

    // Brut force 1
    static class Solution1 {

        public static int[] countBits(int n) {

            int[] ia = new int[n + 1];
            Boolean[] ba = new Boolean[22];
            Arrays.fill(ba, Boolean.FALSE);

            int ones = 0;

            for (int i = 0; i <= n; i++) {
                if (i != 0) {
                    ones = (!ba[0]) ? ones + 1 : ones - 1;
                    ba[0] = !ba[0];
                }
                int baIndex = 1;
                for (int k = 2; k <= 65536; k *= 2) {
                    if (i != 0 && i % k == 0) {
                        ones = (!ba[baIndex]) ? ones + 1 : ones - 1;
                        ba[baIndex] = !ba[baIndex];

                    }
                    baIndex++;

                }


                ia[i] = ones;
            }
            return ia;
        }

    }

    // Brut force 2
    static class Solution2 {

        public static int[] countBits(int n) {

            int[] ia = new int[n + 1];
            int ones = 0;
            int cnt;
            for (int i = 0; i <= n; i++) {
                cnt = 0;

                for (char c : Integer.toBinaryString(i).toCharArray()) {
                    cnt += Integer.parseInt(String.valueOf(c));
                }

                ia[i] = cnt;
            }
            return ia;
        }

    }

    // Bitwise
    static class Solution3 {

        public static int[] countBits(int n) {

            int[] ia = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                /*
                Here is used information that division by 2 is bitwise shift.
                Let's call 1 -set and 0-clear
                e.g. 1) 1.0.0.0. b is decimal 8 shift >> right once gives us 1.0.0.
                     + (1.0.0.0. & 0.0.0.1.) which is 0. total 1 set bit
                     2) 1.0.0.1. b is decimal 9 shift >> right gives us 1.0.0.
                     + (1.0.0.1.&0.0.0.1.) which is 1. total 2 set bit


                AND operation with 1 - which gives us the last bit.

                 */
                ia[i] = ia[i >> 1] + (i & 1);
            }
            return ia;

        }

    }
    // my version without bit shift. counting set bits
    static class Solution4 {
        public static int[] countBits(int n) {
            int[] ia = new int[n + 1];
            Boolean[] ba = new Boolean[22];
            Arrays.fill(ba, Boolean.FALSE);

            for (int i = 0; i <= n; i++) {
                ia[i]= (int) Arrays.stream(ba).filter(val->val.booleanValue()==true).count();
                plusOne(ba,0);
            }
            return ia;
        }
        public static void plusOne(Boolean[] ba, int ind){
            if (ba[ind]==false){
                ba[ind]=true;
            }else{
                ba[ind]=false;
                plusOne(ba,ind+1);
            }
        }

    }


    // faster version without bit shift, counting set bits inside adding function
    static class Solution5 {

        public static int[] countBits(int n) {

            int[] ia = new int[n + 1];
            Boolean[] ba = new Boolean[22];
            Arrays.fill(ba, Boolean.FALSE);
            int setBits = 0;

            for (int i = 0; i <= n; i++) {
                if (i==0) continue;
                 setBits=plusOne(ba,0,setBits);
                ia[i]=setBits;
             }
            return ia;
        }
        public static int plusOne(Boolean[] ba, int ind,int setBits){
            if (ba[ind]==false){
                ba[ind]=true;
                setBits++;
            }else{
                ba[ind]=false;
                setBits--;
                setBits = plusOne(ba,ind+1,setBits);
            }
            return setBits;
        }

    }
  public static void main(String[] args) {
        String helpMessage = "one input parameter of type Int with value less than 10001  \"146\" is expected";
        if (args.length != 1) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return;
        } else if (!isStringIntegerValue(args[0])) {
            System.out.println("argument is not a number");
            System.out.println(helpMessage);
            return;
        } else {
            System.out.println(Arrays.toString(new Solution1().countBits(Integer.parseInt(args[0]))));
            System.out.println(Arrays.toString(new Solution2().countBits(Integer.parseInt(args[0]))));
            System.out.println(Arrays.toString(new Solution3().countBits(Integer.parseInt(args[0]))));
            System.out.println(Arrays.toString(new Solution4().countBits(Integer.parseInt(args[0]))));
            System.out.println(Arrays.toString(new Solution5().countBits(Integer.parseInt(args[0]))));
        }
    }
}
