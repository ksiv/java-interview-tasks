package interviewtasks;

import java.util.Arrays;

public class numberaddonedecimal
{
    // BrutForce
    static class Solution {
        public static int[] plusOne(int[] digits) {


            return plusOne(digits,digits.length-1);

        }
        public static int[] plusOne(int[] digits, int ind){
            // negative index =adding significant figure
            // means all the rest digits are zeroes
            if (ind<0){
                int[] digits2 = new int[digits.length+1];
                digits2[0]=1;
                return digits2;

            }
            // digit by given index is not 9, add one and exit
            if (digits[ind]!=9){
                digits[ind]=digits[ind]+1;
            // 9 replace with 0 run recursive call for higher index
            }else{
                digits[ind]=0;
                digits= plusOne(digits,ind-1);
            }
            return digits;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().plusOne(new int[]{9,9,9})));
    }
}
