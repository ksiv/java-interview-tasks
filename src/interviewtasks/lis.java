package interviewtasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static interviewtasks.lib.paramhelper.*;

public class lis {
    /**
     * This is a sub-set of Longest Incremented Subsequence (LIS)
     * example: 1,3,6,2,9,5
     * lis: 1,3,6,9 of length 4
     * TAGS: #nested-envelopes #sequence #lis
     */


    public static int getLISlength(int[] intArr) {
        // Sort by first element in ascending order and second element in descending order


        int[] dp = new int[intArr.length];
        int size = 0;

        // Iterate over sorted pairs

        for (int i : intArr) {
            int position = Arrays.binarySearch(dp, 0, size, i);
            // if the key is not found "binarySearch" returns negative position candidate -1
            // change to positive add 1 back
            if (position < 0) {
                position = -(position + 1);
            }
            // write or replace value at index "position"
            // it's important to understand the _replace_ part that's why only length of the sequence
            // can be retrieved not the sequence itself.
            dp[position] = i;
            // update size if needed
            if (position == size) {
                size++;
            }
        }
        return size;
    }

    public static List<Integer> getMaxSequence(int[] intArr) {
        int n = intArr.length;

        int[] dp_pos = new int[n];  // position
        int[] dp_val = new int[n];  // value
        int[] parent = new int[n];  // parent for sequence reconstruction
        int size = 0;

        for (int i = 0; i < n; ++i) {

            int pos = Arrays.binarySearch(dp_val, 0, size, intArr[i]);
            if (pos < 0) {
                pos = -(pos + 1);
            }

            dp_pos[pos] = i;
            dp_val[pos] = intArr[i];
            parent[i] = pos > 0 ? dp_pos[pos - 1] : -1;

            if (pos == size) {
                ++size;
            }
        }

        List<Integer> sequence = new ArrayList<>();
        // For each number get number, get prev index from parent table
        for (int i = dp_pos[size - 1]; i >= 0; i = parent[i]) {
            sequence.add(0, intArr[i]);
        }
        return sequence;
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


        System.out.println("lis length: " + getLISlength(intArr));
        System.out.println(Arrays.deepToString(getMaxSequence(intArr).toArray()));
    }
}


