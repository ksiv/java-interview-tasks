package interviewtasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 219. Contains Duplicate II
 * <p>
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array
 * such that nums[i] == nums[j] and abs(i - j) <= k.
 * TAGS: #non-ordered-array
 */

public class containsduplicate2 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {

            if (map.containsKey(nums[i])) {
                if (Math.abs(map.get(nums[i]) - i) <= k) return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        String helpMessage = "Comma separated array \"1,2,3,1\" and an Int \"3\" are expected as input";
        if (args.length != 2) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return;
        } else {
            int sum = Integer.parseInt(args[1]);
            String[] stringArray = args[0].split(",");
            int[] intArray = new int[stringArray.length];
            for (int i = 0; i < stringArray.length; i++) {
                intArray[i] = Integer.parseInt(stringArray[i]);
            }

            System.out.println(containsNearbyDuplicate(intArray, sum));
        }
    }
}
