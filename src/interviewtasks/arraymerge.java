package interviewtasks;

import java.util.Arrays;

import static interviewtasks.paramchecker.stringArrayToIntArray;

public class arraymerge {
    /**
     * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
     * num1 has a large enough buffer at the end to hold num2.
     * Two integers m and n, representing the number of elements in nums1 and nums2 respectively.
     * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
     * TAGS: #arrays
     */

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, nums1.length-n, n);
        Arrays.sort(nums1);
        return nums1;
    }
    public static int[] merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - n-1;
        int j = n - 1;
        int k = m-1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        return nums1;
    }

    public static void main(String[] args) {
        String helpMessage = "string like \"1,2,3,0,0,0\" ,\"2,5,6\" expected as input.";
        if (args.length != 2) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return;
        } else {
            // arg handling
            String[] stringArray = args[0].split(",");
            int [] arr = stringArrayToIntArray(stringArray);
            String[] stringArray2 = args[1].split(",");
            int [] arr2 = stringArrayToIntArray(stringArray2);
            int[] arrCopy = arr.clone();
            int[] arr2Copy = arr2.clone();
            System.out.println(Arrays.toString(merge(arr,arr.length,arr2,arr2.length)));
            System.out.println(Arrays.toString(merge2(arrCopy,arrCopy.length,arr2Copy,arr2Copy.length)));


        }
    }
}
