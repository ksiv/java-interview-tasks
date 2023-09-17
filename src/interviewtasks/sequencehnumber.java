package interviewtasks;

import java.util.Arrays;
/**
 * leetcode 274. H-Index
 * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.
 * According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
 */

import static interviewtasks.lib.paramhelper.intArrayFromStringArray;

public class sequencehnumber {
    // Backward brute-force
    static class Solution {
        public int hIndex(int[] citations) {
            citations = Arrays.stream(citations).filter(c -> c > 0).sorted().toArray();
            if (citations.length == 0) return 0;
            if (citations.length == 1) return 1;
            int i = 0;
            while (i < citations.length && i < citations[citations.length - i - 1]) {
                i++;
            }

            return i;
        }
    }

    static class Solution2 {
        public int hIndex(int[] citations) {
            int n = citations.length;
            int[] count = new int[n + 1]; // Create an array to count the number of papers with each citation count.

            // Populate the count array.
            for (int citation : citations) {
                if (citation >= n) {
                    count[n]++;
                } else {
                    count[citation]++;
                }
            }
            System.out.println(Arrays.toString(count));
            int hIndex = 0;
            int totalPapers = 0;

            // Iterate from right to left through the count array to find the H-index.
            for (int i = n; i >= 0; i--) {
                totalPapers += count[i];
                if (totalPapers >= i) {
                    hIndex = i;
                    break;
                }
            }

            return hIndex;
        }
    }

    public static void main(String[] args) {
        String helpMessage = "Comma separated array \"1,2,3,0,1,2,4\" is expected as input";
        if (args.length != 1) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
        } else {
            String[] stringArray = args[0].split(",");
            int[] intArray = intArrayFromStringArray(stringArray);
            System.out.println("hnumber: " + new sequencehnumber.Solution().hIndex(intArray));
            System.out.println("hnumber: " + new sequencehnumber.Solution2().hIndex(intArray));


        }

    }
}
