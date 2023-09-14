package interviewtasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static interviewtasks.lib.paramhelper.*;


public class intervalinsert {

    /**
     * leetcode 57. Insert Interval
     * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by start i.
     * You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
     * <p>
     * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
     * <p>
     * Return intervals after the insertion.
     */
    static class Solution {
        public static int[][] insert(int[][] intervals, int[] newInterval) {
            int[][] result;
            // 1. empty intervals add return
            if (intervals.length == 0) {
                return new int[][]{{newInterval[0],newInterval[1]}};
            }
            Boolean isStartMerge =false;
            Boolean isEndMerge=false;
            // 2. The last element add and return
            if (newInterval[0] > intervals[intervals.length - 1][1]) {
                return insert(intervals,newInterval,intervals.length);
            }
            // 3. The first element add and return
            if (newInterval[1] < intervals[0][0]) {
                return insert(intervals,newInterval,0);
            }
            // 4. Looking for insert pos/merge range
            int startPos = binarySearch(intervals, newInterval[0]);
            int endPos = binarySearch(intervals, newInterval[1]);
            // check interval start
            if (intervals[startPos][0] <= newInterval[0] && intervals[startPos][1] >= newInterval[0]) {
                intervals[startPos][0] = Math.min(intervals[startPos][0], newInterval[0]);
                isStartMerge = true;

            }
            // check interval end if not outside
            if (endPos<intervals.length && intervals[endPos][0] <= newInterval[1] && intervals[endPos][1] >= newInterval[1]) {
                intervals[endPos][1] = Math.max(intervals[endPos][1], newInterval[1]);
                isEndMerge = true;
            }
            // 5. Insert ( no overlap)
            if(!isStartMerge && !isEndMerge && startPos==endPos){
                return insert(intervals,newInterval,startPos);
            }
            // 6. Overlapping detected, merge
            //
            if(!isEndMerge){
                endPos--;

            }
            newInterval[0]=Math.min(newInterval[0],intervals[startPos][0]);
            newInterval[1]=Math.max(newInterval[1],intervals[endPos][1]);


            result = new int[intervals.length -(endPos-startPos)][];


            System.arraycopy(intervals, 0, result, 0, startPos);
            result[startPos] = newInterval;
            System.arraycopy(intervals, endPos+1, result, startPos + 1, result.length - (startPos+1));


            return result;
        }
        public static int[][] insert(int[][] intervals, int[] newInterval, int pos){
            int[][] result = new int[intervals.length + 1][];
            System.arraycopy(intervals, 0, result, 0, pos);
            result[pos] = newInterval;
            System.arraycopy(intervals, pos, result, pos + 1, intervals.length - pos);
            return result;

        }

        public static int binarySearch(int[][] intervals, int target) {
            int left = 0;
            int right = intervals.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (intervals[mid][1] < target) {
                    left = mid + 1;
                } else if (intervals[mid][0] > target) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            }
            return left;
        }


    }

    static class Solution2 {
        public int[][] insert(int[][] intervals, int[] newInterval) {

            List<int[]> result = new ArrayList<>();

            // Iterate through all intervals
            for (int[] interval : intervals) {

                // if newInterval fits before interval insert newInterval & update slot as new interval
                if (newInterval[1] < interval[0]) {

                    result.add(newInterval);
                    newInterval = interval;
                }

                // if slot is lesser than new Interval insert slot
                else if (interval[1] < newInterval[0]) {

                    result.add(interval);
                }

                // if above conditions fail its an overlap since possibility of new interval existing in left & right of slot is checked
                // update lowest of start & highest of end & not insert
                else {

                    newInterval[0] = Math.min(newInterval[0], interval[0]);
                    newInterval[1] = Math.max(newInterval[1], interval[1]);
                }

            }

            // insert the last newInterval
            System.out.println("last");
            result.add(newInterval);

            // convert to int[][] array
            return result.toArray(new int[result.size()][]);
        }
    }



    public static void main(String[] args) {
        String helpMessage = "Comma separated non-decreasing two-member arrays \"2,2\" \"4,8\" \"3,5\" are expected as input. last array is the member to add";
        if (args.length < 1) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return;
        } else {
            int[][] intArrays = new int[args.length-1][];
            for (int i = 0; i < args.length-1; i++) {
                String[] stringArray = args[i].split(",");
                int[] intArray = new int[]{Integer.parseInt(stringArray[0]),Integer.parseInt(stringArray[1])};
                intArrays[i]=intArray;
            }
            String[] stringArray = args[args.length-1].split(",");
            int[] intArrayNew = intArrayFromStringArray(stringArray);
            System.out.println(Arrays.deepToString(intArrays));
            System.out.println("Solution1" + Arrays.deepToString(new Solution().insert(intArrays, intArrayNew)));
            System.out.println("Solution2" + Arrays.deepToString(new Solution2().insert(intArrays, intArrayNew)));
        }

      }


}
