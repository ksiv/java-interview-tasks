package interviewtasks;

import java.util.Arrays;
import static interviewtasks.lib.linkedlist.*;
import static interviewtasks.lib.paramhelper.intArrayFromStringArray;

public class listreverselinkedlist {
    /**
     * leetcode 92. Reverse Linked List II
     * Given array of int e.g.[1,2,3,4,5,6]
     * interval start pos end pos 2 and 4
     * return result should be [1,4,3,2,5]
     */

    static class Solution {
        public static ListNode reverseBetween(ListNode head, int left, int right) {
            if (head.next == null) {
                return head;
            }
            ListNode leftNode = head;
            ListNode leftNodeCandidate = null;
            ListNode beforeLeftNode = null;
            ListNode rightNode;
            ListNode afterRightNode = null;
            int i = 1;
            while (i < left) {
                beforeLeftNode = leftNode;
                leftNode = leftNode.next;
                i++;
            }
            rightNode = leftNode;
            while (i < right) {
                rightNode = rightNode.next;
                i++;

            }

            if (rightNode.next != null) {
                afterRightNode = rightNode.next;
            }
            while (left < right) {
                System.out.println("- " + head);
                leftNodeCandidate = leftNode.next;
                if (beforeLeftNode != null) {
                    beforeLeftNode.next = leftNode.next;
                }

                if (afterRightNode != null) {
                    leftNode.next = afterRightNode;
                } else {
                    leftNode.next = null;
                    System.out.println("- " + head);
                }
                rightNode.next = leftNode;
                if (leftNode.equals(head)) {
                    head = rightNode;
                }
                afterRightNode = leftNode;
                if (!leftNodeCandidate.equals(rightNode)) {
                    leftNode = leftNodeCandidate;
                }
                left++;
            }
            return head;
        }
    }



    public static void main(String[] args) {
        String helpMessage = "array like \"7,2,3,4,1,1\" and \"2\", \"4\" expected as input.";
        if (args.length != 3) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return;
        } else {
            // arg handling
            String[] stringArray = args[0].split(",");
            int[] arr = intArrayFromStringArray(stringArray);
            System.out.println("before: " + Arrays.toString(arr));
            ListNode head = linkedListFromIntArray(arr);

            ListNode result = new Solution().reverseBetween(head, Integer.parseInt(args[1]), Integer.parseInt(args[2]));
            System.out.println(result);

        }

    }
}
