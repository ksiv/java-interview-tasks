package interviewtasks;

import static interviewtasks.lib.linkedlist.*;

/**
 * leetcode 21. Merge Two Sorted Lists
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 *
 */
public class mergetwosortedlists {
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
            int[] arrInt = new int[stringArray.length];
            for (int i = 0; i < stringArray.length; i++) {

                arrInt[i] = Integer.parseInt(stringArray[i]);

            }
            String[] stringArray2 = args[1].split(",");
            int[] arrInt2 = new int[stringArray2.length];
            for (int i = 0; i < stringArray2.length; i++) {

                arrInt2[i] = Integer.parseInt(stringArray2[i]);

            }

            ListNode head1 = new ListNode(arrInt[0]);

            ListNode node = head1;
            for (int i = 1; i < arrInt.length; i++) {
                node = addNext(node, arrInt[i]);
            }


            ListNode head2 = new ListNode(arrInt2[0]);
            node = head2;
            for (int i = 1; i < arrInt2.length; i++) {
                node = addNext(node, arrInt2[i]);
            }


            System.out.println(head1);

            System.out.println(head2);


            System.out.println(new Solution().mergeTwoLists(head1, head2));
        }
    }
}
