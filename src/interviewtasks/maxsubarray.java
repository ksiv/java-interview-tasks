package interviewtasks;

/**
 * leetcode.com
 * 121. Best Time to Buy and Sell Stock
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class maxsubarray {
    // Slow
    public static int maxProfit(int[] prices) {
        int maxVal = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            for (int k = i - 1; k >= 0; k--) {
                if (prices[i] - prices[k] > maxVal) maxVal = prices[i] - prices[k];
            }

        }
        return maxVal;
    }

    // faster
    public static int maxProfit2(int[] prices) {
        int maxVal = 0;
        int min = prices[0];
        int max = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                max = prices[i];
            }
            if (prices[i] > max) {
                max = prices[i];
                if (max - min > maxVal) maxVal = max - min;
            }

        }
        return maxVal;
    }

    public static void main(String[] args) {
        String helpMessage = "Comma separated array \"1,3,1,4,2,3\" is expected as input";
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
            System.out.println(maxProfit2(intArray));

        }

    }
}
