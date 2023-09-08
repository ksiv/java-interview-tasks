package interviewtasks;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
 * Given an unsorted array A of size N that contains only positive integers, find a continuous sub-array that adds to a given number S and return the left and right index(1-based indexing) of that subarray.
 * <p>
 * In case of multiple subarrays, return the subarray indexes which come first on moving from left to right.
 * Note:- You have to return an ArrayList consisting of two elements left and right. In case no such subarray exists return an array consisting of element -1.
 */

public class subarraywithgivensum {
    static class Solution {
        //Function to find a continuous sub-array which adds up to a given number.
        static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {

            int left = 0;
            int right = 0;
            int sum = arr[left];
            ArrayList<Integer> retVal = new ArrayList<>();

            while (sum != s) {


                if (sum < s) {
                    if (arr.length == right + 1) {
                        retVal.add(-1);
                        return retVal;
                    }
                    right++;
                    sum += arr[right];
                }
                if (sum > s) {
                    sum -= arr[left];
                    left++;
                    if (left > right) {
                        if (arr.length == right + 1) {
                            retVal.add(-1);
                            return retVal;
                        }
                        right++;
                        sum += arr[right];

                    }
                }

            }
            retVal.add(left + 1);
            retVal.add(right + 1);
            return retVal;
        }
    }

    public static void main(String[] args) {
        String helpMessage = "int array like \"7,2,3,4,1,1\" and \"4\" expected as input.";
        if (args.length != 2) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return;
        } else {
            // arg handling
            String[] stringArray = args[0].split(",");
            int[] arr = new int[stringArray.length];
            for (int i = 0; i < stringArray.length; i++) {

                arr[i] = Integer.parseInt(stringArray[i]);

            }

            System.out.println("before: " + Arrays.toString(arr));

            System.out.println(new Solution().subarraySum(arr, arr.length, Integer.parseInt(args[1])));
        }
    }
}
