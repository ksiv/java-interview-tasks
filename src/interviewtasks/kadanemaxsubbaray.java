package interviewtasks;

/**
 *  leetcode 53. Maximum Subarray
 *  Given an integer array nums, find the subarray with the largest sum, and return its sum.
 *
 */
public class kadanemaxsubbaray {
    static class Solution {
        public static int maxSubArray(int[] nums) {
            // Kadane's implementation
            int maxSum = nums[0];
            int maxAtIndex = nums[0];
            for (int i = 1; i < nums.length; i++) {
                maxAtIndex = Math.max(nums[i], nums[i] + maxAtIndex);
                maxSum = Math.max(maxSum, maxAtIndex);
                System.out.println(i+"_"+maxAtIndex+"_"+maxSum);
            }
            return maxSum;
        }
    }
    public static void main(String[] args) {
        String helpMessage = "Comma separated array \"1,3,1,4,2,3\" is expected as input";
        if (args.length != 1) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return;
        } else {
            String[] stringArray = args[0].split(",");
            int[] intArray = new int[stringArray.length];
            for (int i = 0; i < stringArray.length; i++) {
                intArray[i] = Integer.parseInt(stringArray[i]);
            }
            System.out.println(new Solution().maxSubArray(intArray));

        }

    }
}
