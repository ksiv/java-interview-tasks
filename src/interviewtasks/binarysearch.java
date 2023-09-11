package interviewtasks;

import java.util.Arrays;

/**
 * Binary search in sorted array
 * INFO: https://en.wikipedia.org/wiki/Binary_search_algorithm
 * TAGS: #search
 *
 * leetcode: 35. Search Insert Position
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 */

public class binarysearch {



    static class SolutionNative{
        static public int searchInsert(int[] nums, int target) {
            int bsRes=Arrays.binarySearch(nums,target);
            return bsRes>=0 ? bsRes : Math.abs(bsRes)-1;
        }
    }
    static class Solution {
        static int binarySearchWrapper(int arr[], int k) {
            int low = 0;
            int high = arr.length - 1;
            if (arr[low] == k) {
                return low;
            }
            if (arr[high] == k) {
                return high;
            }
            return binarySearchWorker(arr, low, high, k);
        }

        static int binarySearchWorker(int arr[], int low, int high, int k) {
            if ((high - low) <= 1) {
                return high;
            }
            int middle = high - ((high - low) / 2);
            if (arr[middle] == k) {
                return middle;
            }
            if (arr[middle] > k) {
                high = middle;
            } else {
                low = middle;
            }
            return binarySearchWorker(arr, low, high, k);
        }
    }

    public static void main(String[] args) {
        String helpMessage = "Comma separated sorted array \"1,2,3,4,6,7\" and number to search \"6\" are expected as input";
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
            System.out.println(Arrays.toString(intArray));
            System.out.println("Custom: " + Solution.binarySearchWrapper(intArray, k));
            System.out.println("Native: " + SolutionNative.searchInsert(intArray, k));
        }
    }

}

