package interviewtasks;

import java.util.Arrays;
import static interviewtasks.lib.paramhelper.intArrayFromStringArray;

/**
 * leetcode.com 1266. Minimum Time Visiting All Points
 * On a 2D plane, there are n points with integer coordinates points[i] = [xi, yi]. Return the minimum time in seconds to visit all the points in the order given by points.
 *
 * You can move according to these rules:
 *
 * In 1 second, you can either:
 * move vertically by one unit,
 * move horizontally by one unit, or
 * move diagonally sqrt(2) units (in other words, move one unit vertically then one unit horizontally in 1 second).
 * You have to visit the points in the same order as they appear in the array.
 * You are allowed to pass through points that appear later in the order, but these do not count as visits.
 */
public class minimumtimevisitingallpoints {
    // Brute Force
    static class Solution {
        public int minTimeToVisitAllPoints(int[][] points) {
            int[] prevPoint = points[0];
            int diagonal =0;
            int steps=0;
            for (int i = 1; i < points.length; i++) {

                while (!Arrays.equals(prevPoint,points[i])) {
                    if (prevPoint[0] < points[i][0]) {
                        prevPoint[0]++;
                        diagonal++;
                        steps++;
                    }
                    if (prevPoint[0] > points[i][0]) {
                        prevPoint[0]--;
                        diagonal++;
                        steps++;
                    }

                    if (prevPoint[1] < points[i][1]) {
                        prevPoint[1]++;
                        diagonal++;
                        steps++;
                    }
                    if (prevPoint[1] > points[i][1]) {
                        prevPoint[1]--;
                        diagonal++;
                        steps++;
                    }
                    if (diagonal>1){
                        steps--;
                    }
                    diagonal=0;

                }
            }
            return steps;
        }
    }
    // Faster version does not make unnecessary steps.
    static class Solution2 {
        public int minTimeToVisitAllPoints(int[][] points) {

            int steps=0;
            for (int i = 0; i < points.length-1; i++) {
                steps += Math.max(Math.abs(points[i][0]-points[i+1][0]),
                        Math.abs(points[i+1][1]-points[i][1]));
            }
            return steps;
        }
    }
    public static void main(String[] args) {
        String helpMessage = "Comma separated coord arrays \"1,1\" \"3,4\" are expected as input";
        if (args.length != 2) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
        } else {

            int[][] intArr2D = new int[args.length][];
            for (int i = 0; i < args.length; i++) {
                String[] sa = args[i].split(",");
                intArr2D[i] = intArrayFromStringArray(sa);
            }
            System.out.println(new Solution().minTimeToVisitAllPoints(intArr2D));

            for (int i = 0; i < args.length; i++) {
                String[] sa = args[i].split(",");
                intArr2D[i] = intArrayFromStringArray(sa);
            }
            System.out.println(new Solution2().minTimeToVisitAllPoints(intArr2D));
        }
    }
}
