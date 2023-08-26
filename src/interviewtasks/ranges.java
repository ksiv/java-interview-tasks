package interviewtasks;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 228. Summary Ranges
 * You are given a sorted unique integer array nums.
 * A range [a,b] is the set of all integers from a to b (inclusive).
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
 * That is, each element of nums is covered by exactly one of the ranges,
 * and there is no integer x such that x is in one of the ranges but not in nums.
 * Each range [a,b] in the list should be output as:
 * "a->b" if a != b
 * "a" if a == b
 */
public class ranges {
    public static List<String> summaryRanges2(int[] nums) {
        ArrayList<String> al=new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<nums.length;i++){
            int start=nums[i];
            while(i+1<nums.length && nums[i]+1==nums[i+1])
                i++;

            if(start!=nums[i]){
                sb.setLength(0);
                sb.append(start);
                sb.append("->");
                sb.append(nums[i]);

                al.add(sb.toString());
            }
            else{
                sb.setLength(0);
                sb.append(start);
                al.add(sb.toString());
            }
        }
        return al;
    }
    public static List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<String>();
        int left = 0;
        int right = 0;
        if (nums.length == 1) {
            addRange(ranges, nums[0], nums[0]);
            return ranges;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                if (nums[i] == nums[i - 1] + 1) {
                    right = i;
                } else {

                    addRange(ranges, nums[left], nums[right]);
                    right = left = i;
                }

                if (i == nums.length - 1) {
                    addRange(ranges, nums[left], nums[right]);

                }

            }



        }
        return ranges;
    }

    public static void addRange(List<String> ranges, int start, int end) {
        StringBuilder sb = new StringBuilder();
        if (end > start) {
            sb.append(start);
            sb.append("->");
            sb.append(end);
        } else {
            sb.append(start);
        }
        ranges.add(sb.toString());
    }

    public static void main(String[] args) {
        String helpMessage = "Comma separated ascending array \"1,2,3,4,5,7,9\" is expected as input";
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

            System.out.println(summaryRanges2(intArray));
        }
    }
}
