package interviewtasks;

import java.util.Arrays;
import static interviewtasks.lib.paramhelper.intArrayFromStringArray;

/**
 * leetcode.com
 * 189. Rotate Array
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 */


public class rotatearray {
    // Loop solution
    public static int[] rotateLoop(int[] nums, int k) {
        if (k > nums.length) {
            k = k % nums.length;
        }
        k = nums.length - k;
        int[] rotatedNums = new int[nums.length];
        int j = 0;

        for (int i = k; i < nums.length; i++) {
            rotatedNums[j] = nums[i];
            j++;
        }
        for (int i = 0; i < k; i++) {
            rotatedNums[j] = nums[i];
            j++;
        }
        return rotatedNums;

    }

    // Array Copy solution
    public static int[] rotateArrayCopy(int[] nums, int k) {

        if (k > nums.length) {
            k = k % nums.length;
        }
        int[] rotatedNums = new int[nums.length];

        System.arraycopy(nums, nums.length - k, rotatedNums, 0, k);
        System.arraycopy(nums, 0, rotatedNums, k, nums.length - k);
        return rotatedNums;
    }

    public static void main(String[] args) {
        String helpMessage = "Comma separated array \"1,2,3,4,6,7\" and time to rotate \"3\" are expected as input";
        if (args.length != 2) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
        } else {
            String[] stringArray = args[0].split(",");
            int[] intArray;
            intArray = intArrayFromStringArray(stringArray);

            int k = Integer.parseInt(args[1]);
            System.out.println(Arrays.toString(intArray));
            System.out.println("rotateLoop     : " + Arrays.toString(rotateLoop(intArray, k)));
            System.out.println("rotateArrayCopy: " + Arrays.toString(rotateArrayCopy(intArray, k)));
        }
    }
}
