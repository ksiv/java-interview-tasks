package interviewtasks;

import java.util.Arrays;

import static interviewtasks.lib.paramhelper.intArrayFromStringArray;

public class candy {
    static class Solution {

        public int candy(int[] ratings) {
            int[] candies = new int[ratings.length];
            // Auxiliary sapce O(N)
            // minimal one candy
            Arrays.fill(candies, 1);
            //System.out.println(Arrays.toString(candies));
            for (int i = 1; i < ratings.length; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                }
            }
            //System.out.println(Arrays.toString(candies));
            for (int i = ratings.length - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    candies[i] = Math.max(candies[i], candies[i + 1] + 1);
                }
            }
            //System.out.println(Arrays.toString(candies));
            int totalCandies = 0;
            for (int candy : candies) {
                totalCandies += candy;
            }

            return totalCandies;
        }
    }


    public static void main(String[] args) {
        String helpMessage = "a strings is expected as a parameter e.g. \"1,3,2,5,4\" ";
        if (args.length != 1) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return;

        }
        String[] strings = args[0].split(",");
        int[] intArr = intArrayFromStringArray(strings);



        System.out.println(new Solution().candy(intArr));
    }
}
