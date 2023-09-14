package interviewtasks;

import static interviewtasks.lib.paramhelper.*;
/**
 *  leetcode 53. Maximum Subarray
 *  Given an integer array nums, find the subarray with the largest sum, and return its sum.
 *
 */
public class kadanemaxsubbaray {
    static class Solution {
        public static int maxSubArray(int[] nums) {
            // Kadane's implementation
            /**
             * Say array is: 1,2,3,-7,1,2,4
             *               ↓ ↓ ↓  ↓ ↓ ↓ ↓
             * maxAtIndex    1 3 6 -1 1 3 7
             *               ↓ ↓ ↓  ↓ ↓ ↓ ↓
             * max           1 3 6  6 6 6 7
             */

            int maxSum = nums[0];
            int maxAtIndex = nums[0];
            for (int i = 1; i < nums.length; i++) {
                maxAtIndex = Math.max(nums[i], nums[i] + maxAtIndex);
                maxSum = Math.max(maxSum, maxAtIndex);

            }
            return maxSum;
        }
    }
    public static void main(String[] args) {
        String helpMessage = "Comma separated array \"1,2,3,-7,1,2,4\" is expected as input";
        if (args.length != 1) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
        } else {
            String[] stringArray = args[0].split(",");
            int[] intArray = intArrayFromStringArray(stringArray);
            System.out.println(new Solution().maxSubArray(intArray));

        }

    }
}
