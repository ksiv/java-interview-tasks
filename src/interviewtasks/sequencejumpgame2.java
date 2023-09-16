package interviewtasks;

import static interviewtasks.lib.paramhelper.intArrayFromStringArray;

/**
 * leetcode 45. Jump Game II
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 * <p>
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 * <p>
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 */
public class sequencejumpgame2 {
    static class Solution {
        public int jump(int[] nums) {
            if (nums.length == 1) return 0;
            int steps = 0;
            int i = 0;
            while (i < nums.length) {
                steps++;
                int max = 0;
                int maxPos = 0;
                if (i + nums[i] >= nums.length - 1) return steps;
                for (int k = 0; k <= nums[i]; k++) {
                    if (nums[i + k] + k >= max) {
                        max = nums[i + k] + k;
                        maxPos = i + k;
                    }
                }
                i = maxPos;


            }
            return 1;
        }

    }

    public static void main(String[] args) {
        String helpMessage = "Comma separated array \"1,2,3,0,1,2,4\" is expected as input";
        if (args.length != 1) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
        } else {
            String[] stringArray = args[0].split(",");
            int[] intArray = intArrayFromStringArray(stringArray);
            System.out.println("SolutionBackward: " + new sequencejumpgame2.Solution().jump(intArray));


        }

    }
}
