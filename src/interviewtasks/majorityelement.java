package interviewtasks;

import java.util.Arrays;
import java.util.HashMap;

public class majorityelement {
    /**
     * leetcode.com
     * 169 Majority Element
     * Given an array nums of size n, return the majority element.
     *
     * The majority element is the element that appears more than [n / 2] times.
     * One may assume that the majority element always exists in the array.
     * @param nums
     * @return
     */

    //   For n/2 is the best approach is to sort array and take the middle element.
    public static int getViaSort(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];

    }
    // Generic solution which works without "more than [n / 2] times" limitation
    // One may assume that the majority element always exists in the array.
    public static  int getFrequencyMap(int[] nums) {
        HashMap<Integer, Integer> encounterMap = new HashMap();
        int maxVal = 0;
        int majorityVal=0;
        int tmpVal;
        for (int i=0; i<nums.length;i++){
            tmpVal = encounterMap.getOrDefault(nums[i], 0) + 1;
            encounterMap.put(nums[i], tmpVal);
            if (tmpVal>maxVal){
                maxVal=tmpVal;
                majorityVal=nums[i];
            }
        }

        return majorityVal;
    }
    public static void main(String[] args) {
        String helpMessage = "Comma separated array \"2,2,1,1,1,2,2\" is expected as input";
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
            System.out.println("getFrequencyMap "+getFrequencyMap(intArray));
            System.out.println("getViaSort "+getViaSort(intArray));
        }
    }
}
