package interviewtasks;

import static interviewtasks.lib.paramhelper.intArrayFromStringArray;

/**
 * leetcode 55. Jump Game
 * You are given an integer array nums.
 * You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.
 * <p>
 * Return true if you can reach the last index, or false otherwise.
 */
public class sequencejumpgame {
    static class SolutionForward {
        public boolean canJump(int[] nums) {
            if (nums.length == 1) return true;
            int maxReach = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i > maxReach) {
                    return false;
                }
                maxReach = Math.max(maxReach, i + nums[i]);
            }
            return true;
        }
    }

    static class SolutionBackward {
        public static boolean canJump(int[] nums) {
            if (nums.length == 1) return true;
            // backward solution
            int step = 1;
            for (int i = nums.length - 2; i >= 0; i--) {
                if (nums[i] >= step) {
                    step = 1;
                } else {
                    step++;
                }
                if (i == 0 && step == 1) {
                    return true;
                }
            }
            return false;
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
            System.out.println("SolutionBackward: " + new SolutionBackward().canJump(intArray));
            System.out.println("SolutionForward : " + new SolutionForward().canJump(intArray));

        }

    }
}
