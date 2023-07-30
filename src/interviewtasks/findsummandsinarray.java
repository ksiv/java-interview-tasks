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
            System.out.println("Input: "+Arrays.toString(intArray)+", possible sum:"+sum);
            ArrayList<int[]> returnArray = getPairsOfSummands(intArray, sum);
            System.out.println("Output: "+Arrays.deepToString(returnArray.toArray()));
        }

    }
}
