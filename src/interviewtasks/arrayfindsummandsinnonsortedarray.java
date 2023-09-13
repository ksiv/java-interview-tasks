package interviewtasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * leetcode.com 1. Two Sum
 * <p>
 * Very interesting solution for unsorted input array. (by vishaal351)
 * It calculates the second summand for current index, puts it in the hashMap as a key.
 * And checks if map contains a valid summand for current "index"
 * If map contains the second summand key current index and index extracted by key are returned.
 * I initially though to make a reverse map but this solution looks much more elegant.
 * Input: Int[], int - array to search in and target sum
 * Return: summands position
 * TAGS: #non-ordered-array
 */
public class arrayfindsummandsinnonsortedarray {
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < n; i++) {

            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        String helpMessage = "Comma separated array \"2,7,11,15\" and an Int \"9\" are expected as input";
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

            System.out.println(Arrays.toString(twoSum(intArray, sum)));
        }
    }
}
