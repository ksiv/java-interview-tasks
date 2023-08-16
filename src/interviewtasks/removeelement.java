package interviewtasks;

import java.util.Arrays;

/**
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
 * Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
 * Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 * TAGS: #arrays
 */
public class removeelement {

    // option 1 sort array find "val" using binary search,
    // find all equal values around it and remove those.
    public static int[] removeElement(int[] nums, int val) {
        int k = 0;
        Arrays.sort(nums);
        // since we ca not remove the element in array and the requirements is to do in-place.
        // we replace value with some out of scope value so it would be sorted away to the end
        int imposibleValue = 101;
        int index = Arrays.binarySearch(nums, val);
        int start = index;
        int end = index;
        if (index >= 0) {
            while (start > 0 && nums[start - 1] == val) {
                start--;
            }
            while (end < nums.length - 1 && nums[end + 1] == val) {
                end++;
            }
            for (int i = start; i <= end; i++) {

                nums[i] = imposibleValue;
                k++;

            }
        }
        Arrays.sort(nums);
        int[] retVal = new int[nums.length - k];
        System.arraycopy(nums, 0, retVal, 0, nums.length - k);
        return retVal;

    }

    public static int[] removeElement2(int[] nums, int val) {
        int k = 0;
        // since we ca not remove the element in array and the requirements is to do in-place.
        // we replace value with some out of scope value so it would be sorted away to the end
        int imposibleValue = 101;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                nums[i] = imposibleValue;
                k++;
            }
        }
        Arrays.sort(nums);

        int[] retVal = new int[nums.length - k];
        System.arraycopy(nums, 0, retVal, 0, nums.length - k);
        return retVal;
    }

    public static int[] removeElement3(int[] nums, int val) {
        int i = 0; // pointer where to put next non "val" number
        int j = 0; // pointer searches for next non "val" number
        int k = 0; // counter of non "val" numbers
        int imposibleValue = 101;
        while (j < nums.length) {
            if (val == (nums[j])) {
                j++;
                nums[i] = imposibleValue;
            } else {
                nums[i] = nums[j];
                i++;
                j++;
                k++;
            }

        }
        int[] retVal = new int[k];
        System.arraycopy(nums, 0, retVal, 0, k);
        return retVal;
    }

    public static void main(String[] args) {
        String helpMessage = "Comma separated array \"1,2,3,4,6,7\" and val to remove \"3\" are expected as input";
        if (args.length != 2) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return;
        } else {
            String[] stringArray = args[0].split(",");
            int[] intArray = new int[stringArray.length];
            for (int i = 0; i < stringArray.length; i++) {
                intArray[i] = Integer.parseInt(stringArray[i]);
            }
            int k = Integer.parseInt(args[1]);
            int[] copy1 = intArray.clone();
            int[] copy2 = intArray.clone();
            System.out.println(Arrays.toString(intArray));
        System.out.println(Arrays.toString(removeElement(intArray, k)));
        System.out.println(Arrays.toString(removeElement2(copy1, k)));
        System.out.println(Arrays.toString(removeElement3(copy2, k)));

        }
    }
}
