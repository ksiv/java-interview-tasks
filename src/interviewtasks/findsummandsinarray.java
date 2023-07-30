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

    public static void main(String[] args) {
        ArrayList<int[]> returnArray = getPairsOfSummands(new int[]{1, 5, 3, 7, 9, 10, 11, 12, 49, 51}, 100);
        System.out.println(Arrays.deepToString(returnArray.toArray()));
    }
}
