package interviewtasks;


import java.util.Arrays;
import static interviewtasks.lib.paramhelper.intArrayFromStringArray;


/**
 * leetcode.com N 26
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
 * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
 * Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
 * Return modified int[]
 * TAGS: #array
 */

public class arrayremoveduplicatesinsortedarr {
    public static int[] removeDuplicates(int[] nums) {
        int i=0; // pointer where to put next increasing number
        int j=1; // pointer searches for next increasing number
        int k=1; // counter
        while(j<nums.length){
            if (nums[i]==(nums[j])){
                j++;
            }else if(nums[i]<nums[j]){
                i++;
                nums[i]=nums[j];
                j++;
                k++;
            }

        }
        int[] retVal = new int[k];
        System.arraycopy(nums,0,retVal,0,k);
        return retVal;
    }

    /**
     * leetcode.com
     * 80. Remove Duplicates from Sorted Array II
     * as previous but one duplicate for every number is allowed
     * @param nums
     * @return modified int[]
     * */
    public static int[] removeMoreThanOneDuplicates(int[] nums) {
        int i=0; // pointer where to put next increasing number
        int j=1; // pointer searches for next candidate number to insert
        int k=1; // counter of sucessfull insertions
        int last=nums[0]; // one allowed duplicate. since it's sorted list the allowed duplicate would be last value
        int outsideInputScope = 10001;
        while(j<nums.length){
            if (nums[i]==nums[j] && nums[j]!=last){
                j++;
            }else if(nums[i]>nums[j]){
                j++;
            }else if(nums[i]<nums[j]){
                i++;
                nums[i]=nums[j];
                last=nums[j];
                j++;
                k++;
            }else if (nums[i]==nums[j] && nums[j]==last){
                i++;
                nums[i]=nums[j];
                last=outsideInputScope;
                j++;
                k++;
            }

        }
        int[] retVal = new int[k];
        System.arraycopy(nums,0,retVal,0,k);
        return retVal;
    }

    public static void main(String[] args) {
        String helpMessage = "Comma separated array \"1,1,1,2,2,3\" is expected as input";
        if (args.length != 1) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return;
        } else {
            String[] stringArray = args[0].split(",");
            int[] intArray = intArrayFromStringArray(stringArray);
            int[] copy = intArray.clone();
            System.out.println(Arrays.toString(intArray));
            System.out.println("removeDuplicates "+Arrays.toString(removeDuplicates(intArray)));
            System.out.println("removeMoreThanOneDuplicates "+Arrays.toString(removeMoreThanOneDuplicates(copy)));

        }


    }
}
