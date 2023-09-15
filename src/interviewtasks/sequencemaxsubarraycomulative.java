package interviewtasks;

import java.util.Arrays;

import static interviewtasks.lib.paramhelper.*;

/**
 * leetcode 122. Best Time to Buy and Sell Stock II
 * ou are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * On each day, you may decide to buy and/or sell the stock.
 * You can only hold at most one share of the stock at any time.
 * However, you can buy it then immediately sell it on the same day.
 * Find and return the maximum profit you can achieve.
 */
public class sequencemaxsubarraycomulative {
    static class Solution {
        public static int maxProfit2(int[] prices) {

            int totalMax = 0;
            int intervalEnd = 0;
            int intervalStart = prices[0];

            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < intervalEnd) {
                    // new interval, add sum to total
                    totalMax += intervalEnd - intervalStart;
                    intervalStart = prices[i];
                    intervalEnd = prices[i];
                }
                if (prices[i] >= intervalEnd) {
                    // interval end border update to new high
                    intervalEnd = prices[i];
                    if (i == prices.length - 1) {
                        // end of input. add sum to total
                        totalMax += intervalEnd - intervalStart;

                    }
                }

            }
            return totalMax;
        }

    }

    public static void main(String[] args) {
        String helpMessage = "Comma separated array \"1,3,1,4,2,3\" is expected as input";
        if (args.length != 1) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return;
        } else {
            String[] stringArray = args[0].split(",");
            int[] intArray = intArrayFromStringArray(stringArray);
            System.out.println(new Solution().maxProfit2(intArray));
            //  System.out.println(maxSubArray(intArray));

        }

    }
}
