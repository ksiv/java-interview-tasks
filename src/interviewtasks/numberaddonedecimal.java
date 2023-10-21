package interviewtasks;

import java.util.Arrays;

import static interviewtasks.lib.paramhelper.intArrayFromStringArray;

/**
 * leetcode 66 plus one
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 *
 * Increment the large integer by one and return the resulting array of digits.
 *
 *
 */
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
        String helpMessage = "Comma separated array \"1,2,3\" is expected as input";
        if (args.length != 1) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
        } else {
            String[] stringArray = args[0].split(",");
            int[] intArray = intArrayFromStringArray(stringArray);
            System.out.println(Arrays.toString(Solution.plusOne(intArray)));
        }
    }
}
