package interviewtasks;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Given an array of integers nums and an integer target, return indices of pairs of numbers such that they add up to target.
 * TAGS: #search #arrays #binary-search #numbers
 */
public class findsummandsinarray {

    public static ArrayList<int[]> getPairsOfSummands(int[] nums, int sum) {
        // 1. filter out any elements that a bigger that a "sum".
        // 2. Sort the array for binary search
        int[] shortArr = Arrays.stream(nums).filter(x -> x < sum).sorted().toArray();
        ArrayList<int[]> returnArray = new ArrayList<>();
        int secondSummand;
        for (int i = 0; i < shortArr.length; i++) {
            // calc a possible addend and search it in the array from current position
            secondSummand = sum - shortArr[i];
            int summandCandidatePos = Arrays.binarySearch(shortArr, i, shortArr.length, secondSummand);
            // take
            if (summandCandidatePos > 0 && summandCandidatePos != i) {
                returnArray.add(new int[]{shortArr[i], shortArr[summandCandidatePos]});
            }
        }


        return returnArray;
    }

    /**
     * leetcode.com 167. Two Sum II - Input Array Is Sorted
     * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 < numbers.length
     * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
     * The tests are generated such that there is exactly one solution. You may not use the same element twice.
     * <p>
     * Your solution must use only constant extra space.
     *
     * @param numbers an array of sorted nums
     * @param target  a sum
     */

    // two pointers binary search
    public static int[] twoSum(int[] numbers, int target) {

        Arrays.sort(numbers);
        int secondSummand;
        int[] retVal = new int[2];
        int size = numbers.length;
        for (int i = 0; i < size; i++) {
            // calc a possible addend for search pointer
            secondSummand = target - numbers[i];
            // and search it in the array using built-in binary search
            // there is still a place to improovement (numbers, HERE,size, secondSummand)
            // but I do not have time now, maybe you have? :-)
            int summandCandidatePos = Arrays.binarySearch(numbers, 0,size, secondSummand);

            // custom binary search to move search pointer
            // based on the logic of Arrays.binarySearch return value
            if (summandCandidatePos < 0 ){
                if (-summandCandidatePos>=size){
                    i=i+((size-i)/2)-1;
                }else if (-summandCandidatePos==i+1){
                    i=i/2;
                }
            }


            // value found
            if (summandCandidatePos >= 0) {
                // second summand found
                if (summandCandidatePos != i) {
                    retVal[0] = i + 1;
                    retVal[1] = summandCandidatePos + 1;
                    break;
                }
                // pointer to the first summand means summands are equal checking previous one
                if (summandCandidatePos<0 && numbers[summandCandidatePos - 1] == secondSummand ) {
                    retVal[0] = i + 1;
                    retVal[1] = summandCandidatePos;
                    break;
                }
                // or next one
                if ((summandCandidatePos + 1)<numbers.length && numbers[summandCandidatePos + 1] == secondSummand) {
                    retVal[0] = i + 1;
                    retVal[1] = summandCandidatePos + 2;
                    break;
                }

            }
        }

        Arrays.sort(retVal);
        return retVal;



    }

    public int[] findSummandsInArrayTwoPointers(int[] numbers, int target) {
        int retVal[]=new int[2];
        int i=0;
        int j=numbers.length-1;
        while(i!=j){
            if(numbers[i]+numbers[j]==target){
                retVal[0]=i+1;
                retVal[1]=j+1;
                break;

            }
            else if(numbers[i]+numbers[j]>target){
                j--;
            }
            else{
                i++;
            }
        }
        return retVal;
    }
    public static void main(String[] args) {
        String helpMessage = "Comma separated array of summand candidates \"1,4,3,9,6,7\" and a sum to search \"9\" are expected as input";
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
            int sum = Integer.parseInt(args[1]);
            System.out.println("Input: " + Arrays.toString(intArray) + ", possible sum:" + sum);
            ArrayList<int[]> returnArray = getPairsOfSummands(intArray, sum);
            System.out.println("Output: " + Arrays.deepToString(returnArray.toArray()));
            System.out.println(Arrays.toString(twoSum(intArray,sum)));
        }

    }
}
