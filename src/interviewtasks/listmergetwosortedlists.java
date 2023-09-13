package interviewtasks;

import static interviewtasks.lib.linkedlist.*;
import static interviewtasks.paramchecker.*;

/**
 * leetcode 21. Merge Two Sorted Lists
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 *
 */
public class listmergetwosortedlists {
    static class Solution {
        // Two pointers
        static public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null && list2 == null) return list1;
            if (list1 != null && list2 == null) return list1;
            if (list1 == null && list2 != null) return list2;

            ListNode head;
            if (list1.val < list2.val) {
                head = list1;
                list1 = list1.next;
            } else {
                head = list2;
                list2 = list2.next;
            }
            ListNode tail = head;

            while (list1 != null && list2 != null) {
                //  list1.val<list2.val
                if (list1.val < list2.val) {
                    tail.next = list1;
                    list1 = list1.next;
                    tail = tail.next;
                    continue;
                }
                //  list1.val>list2.val
                if (list1.val > list2.val) {
                    tail.next = list2;
                    list2 = list2.next;
                    tail = tail.next;
                    continue;

                }
                    //  list1.val==list2.val
                    tail.next = list2;
                    list2 = list2.next;
                    tail = tail.next;
                    tail.next = list1;
                    list1 = list1.next;
                    tail = tail.next;




            }

            // list2 ended attaching the rest of list1
            if (list1 != null) {
                tail.next = list1;

            }
            // list1 ended attaching the rest of list2
            if (list2 != null ) {
                tail.next = list2;

            }
            return head;

        }
    }

    public static void main(String[] args) {
        String helpMessage = "two sorted array like \"1,2,3\"  \"1,4,5,6\" are expected as input";
        if (args.length != 2) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return;
        } else {
            // arg handling
            String[] stringArray = args[0].split(",");
            int[] arrInt = stringArrayToIntArray(stringArray);
            String[] stringArray2 = args[1].split(",");
            int[] arrInt2 = stringArrayToIntArray(stringArray2);

            ListNode head1 = linkedListFromIntArray(arrInt);

            ListNode head2 = linkedListFromIntArray(arrInt2);


            System.out.println(head1);

            System.out.println(head2);

            System.out.println(new Solution().mergeTwoLists(head1, head2));
        }
    }
}
