package interviewtasks;

import java.util.Arrays;

/**
 * leetcode 238. Product of Array Except Self
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 *
 */
public class numberproductofarrayexceptself {
    static class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] left = new int[nums.length];
            int leftProduct=1,rightProduct=1;
            int[] right = new int[nums.length];
            int[] answer = new int[nums.length];
            for (int i=0;i<nums.length-1;i++){
                leftProduct*=nums[i];
                rightProduct*=nums[nums.length-1-i];
                left[i]=leftProduct;
                right[nums.length-1-i]=rightProduct;
            }
            for (int i=0;i<nums.length;i++){
                if (i==0) {
                    answer[i]=right[i+1];
                    continue;
                }
                if (i==nums.length-1){
                    answer[i]=left[i-1];
                    continue;
                }

                answer[i]=left[i-1]*right[i+1];
            }
            return answer;
        }
    }
    static class Solution2 {
        public int[] productExceptSelf(int[] nums) {
            int leftProduct=1,rightProduct=1;

            int[] answer = new int[nums.length];

            for (int i=0;i<nums.length;i++){
                answer[i]=leftProduct;
                leftProduct*=nums[i];

            }
            for (int i=nums.length-1;i>=0;i--){

                answer[i]*=rightProduct;
                rightProduct*=nums[i];

            }
            return answer;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[]{1,2,3,4})));
        System.out.println(Arrays.toString(new Solution2().productExceptSelf(new int[]{1,2,3,4})));
    }
}
