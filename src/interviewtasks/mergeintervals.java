package interviewtasks;

import java.util.ArrayList;
import java.util.Arrays;

public class mergeintervals {

    /**
     * leetcode 56. Merge Intervals
     * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
     * <p>
     * Example 1:
     * <p>
     * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
     */
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        ArrayList<int[]> al = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        System.out.println(Arrays.deepToString(intervals));
        int[] arrayCandidate;
        for (int i = 0; i < intervals.length; i++) {
            arrayCandidate = intervals[i];

            while (i + 1 < intervals.length && intervals[i + 1][0] <= arrayCandidate[1] && arrayCandidate[0] <= intervals[i + 1][0]) {
                arrayCandidate[0] = Math.min(arrayCandidate[0], intervals[i + 1][0]);
                arrayCandidate[1] = Math.max(arrayCandidate[1], intervals[i + 1][1]);
                i++;
                if (intervals.length == i) {
                    i--;
                    continue;
                }

            }
            al.add(arrayCandidate);
        }

        return al.toArray(int[][]::new);
    }

    public static void main(String[] args) {
        String helpMessage = "Comma separated non-decreasing two-member arrays \"2,2\" \"3,5\" are expected as input";
        if (args.length < 1) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return;
        } else {
            ArrayList<int[]> al = new ArrayList();
            for (int i = 0; i < args.length; i++) {
                String[] stringArray = args[i].split(",");
                int[] intArray = new int[stringArray.length];
                for (int k = 0; k < stringArray.length; k++) {
                    intArray[k] = Integer.parseInt(stringArray[k]);
                }
                al.add(intArray);
            }

            System.out.println(Arrays.deepToString(merge(al.toArray(int[][]::new))));
        }

    }
}