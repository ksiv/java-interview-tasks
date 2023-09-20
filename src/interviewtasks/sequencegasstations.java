package interviewtasks;

import static interviewtasks.lib.paramhelper.intArrayFromStringArray;

public class sequencegasstations {
    static class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int max = 0;
            int maxPos = 0;
            int tmp = 0;
            for (int i = gas.length - 1; i >= 0; i--) {
                gas[i] = gas[i] - cost[i];
                tmp += gas[i];
                if (tmp > max) {
                    maxPos = i;
                    max = tmp;
                }

            }


            if (tmp >= 0) {
                return maxPos;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        String helpMessage = "two arrays 1. costs to next hop and credits like \"1,2,3,4,5\" ,\"3,4,5,1,2\" expected as input.";
        if (args.length != 2) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);

        } else {
            // arg handling
            String[] stringArray = args[0].split(",");
            int[] arr = intArrayFromStringArray(stringArray);
            String[] stringArray2 = args[1].split(",");
            int[] arr2 = intArrayFromStringArray(stringArray2);
            System.out.println(new Solution().canCompleteCircuit(arr, arr2));
        }
    }
}
