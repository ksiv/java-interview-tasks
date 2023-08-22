package interviewtasks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * leetcode.com 217. Contains Duplicate
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 *
 */

public class duplicatesinarray {
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return true;
        }
        return false;
    }

    public static boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        return set.size() != nums.length;
    }

    public static boolean containsDuplicate3(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) return true;
        }
        return false;
    }

    public static boolean containsDuplicate4(int[] nums) {


        return nums.length != Arrays.stream(nums).distinct().toArray().length;
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
            System.out.println(containsDuplicate(intArray));
            System.out.println(containsDuplicate2(intArray));
            System.out.println(containsDuplicate3(intArray));
            System.out.println(containsDuplicate4(intArray));
        }
    }
}
