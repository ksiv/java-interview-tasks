package interviewtasks;

import java.util.*;
import java.util.Comparator;

/**
 * This is a sub-set of Longest Incremented Subsequence (LIS)
 * Known as "Nested Envelopes" where given: a set of different envelopes with different height and width
 * objective: to fit max amount of envelopes one inside another (envelopes can not be rotated).
 * Here both members of a pair should increase or decrease relative to previous pair in a sequence
 * example: {{1,4},{2, 5}, {4, 1}, {5, 2},  {6, 3}}
 * lis: [[4, 1], [5, 2], [6, 3]]
 * TAGS: #nested-envelopes #sequence #lis
 */


public class lis_pairs {

    public static int getLISlength(int[][] pairs) {
        // Sort by first element in ascending order and second element in descending order
        Arrays.sort(pairs, new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                if (pair1[0] == pair2[0]) {
                    return pair2[1] - pair1[1];  // Sort second elements in descending order
                } else {
                    return pair1[0] - pair2[0];  // Sort first elements in ascending order
                }
            }
        });

        int[] dp = new int[pairs.length];
        int size = 0;

        // Iterate over sorted pairs

        for (int[] pair : pairs) {
            int position = Arrays.binarySearch(dp, 0, size, pair[1]);
            // if the key is not found "binarySearch" returns negative position candidate -1
            // change to positive add 1 back
            if (position < 0) {
                position = -(position + 1);
            }
            // write or replace pair at index "position"
            // it's important to understand the _replace_ part that's why only length of the sequence
            // can be retrieved not the sequence itself.
            dp[position] = pair[1];
            // update size if needed
            if (position == size) {
                size++;
            }
        }
        return size;
    }

    public static List<int[]> getMaxPairSequence(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int n = pairs.length;

        // There is a different option without value table (dp_val) with
        // runtime calculation using subset of pairs table pairs[i][1] table
        // where "i" index is stored in dp_pos.
        // but I think this approach is more clear for a start with additional explicit table for values
        // it also gives us option of usage of native binarySearch method

        int[] dp_pos = new int[n];  // pair numbers
        int[] dp_val = new int[n];  // corresponding value
        int[] parent = new int[n];  // parent pair for sequence reconstruction
        int size = 0;

        for (int i = 0; i < n; ++i) {
            int[] pair = pairs[i];
            int pos = Arrays.binarySearch(dp_val, 0, size, pair[1]);
            if (pos < 0) {
                pos = -(pos + 1);
            }

            dp_pos[pos] = i;
            dp_val[pos] = pair[1];
            parent[i] = pos > 0 ? dp_pos[pos - 1] : -1;

            if (pos == size) {
                ++size;
            }
        }

        List<int[]> sequence = new ArrayList<>();
        // For each pair get pair, get prev index from parent table
        for (int i = dp_pos[size - 1]; i >= 0; i = parent[i]) {
            sequence.add(0, pairs[i]);
        }
        return sequence;
    }


    public static void main(String[] args) {
        String helpMessage = "a strings is expected as a parameter e.g. \"1-2,1-1,3-4,1-2,5-6\", beware long input";
        if (args.length != 1) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);

        }
        String[] pairsStr = args[0].split(",");
        int[][] pairsInt = new int[pairsStr.length][2];

        for (int i = 0; i < pairsStr.length; i++) {
            String[] pair = pairsStr[i].split("-");
            pairsInt[i][0] = Integer.parseInt(pair[0]);
            pairsInt[i][1] = Integer.parseInt(pair[1]);
        }
        

        System.out.println("Number of pairs: "+ getLISlength(pairsInt));
        System.out.println(Arrays.deepToString(getMaxPairSequence(pairsInt).toArray()));
    }
}
