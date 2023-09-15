package interviewtasks;

import interviewtasks.lib.linkedlist.*;

import java.util.Arrays;
import java.util.PriorityQueue;

import static interviewtasks.lib.linkedlist.linkedListFromIntArray;
import static interviewtasks.lib.paramhelper.intArrayFromStringArray;

public class listmergenlists {
    /**
     * leetcode 23. Merge k Sorted Lists
     * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
     *
     * Merge all the linked-lists into one sorted linked-list and return it.
     *
     *  !!! this solution uses solution from two other tasks
     */
    static class SolutionCyclicMerge{
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode retVal=null;
            for(ListNode l : lists){
                if(retVal==null){
                    retVal=l;
                    continue;
                }
                retVal=new listmergetwosortedlists.Solution().mergeTwoLists(retVal,l);
            }
            return retVal;
        }
    }
    static class SolutionMerge {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode head=null,tail=null;
            for(ListNode l : lists){
                if(l==null) continue;
                if(head==null){
                    head=l;
                    tail =getTail(head);
                    continue;
                }
                tail.next=l;
                tail=getTail(l);
            }
            return new listsort.MergeSort().sortList(head);
        }
        public  ListNode getTail(ListNode head){
            if(head.next==null) return head;
            ListNode  node=head;
            while (node.next!=null){
                node=node.next;
            }
            return node;
        }

    }
    static class SolutionPriorityQueue {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
            for (ListNode l : lists) {
                if (l != null) {
                    pq.offer(l);
                }
            }

            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;

            while (!pq.isEmpty()) {
                ListNode minNode = pq.poll();
                tail.next = minNode;
                tail = minNode;

                if (minNode.next != null) {
                    pq.offer(minNode.next);
                }
            }

            return dummy.next;
        }

    }
    public static void main(String[] args) {
        String helpMessage = "two sorted array like \"1,2,3\"  \"1,4,5,6\" are expected as input";
        if (args.length != 2) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);

        } else {
            // arg handling
            String[] stringArray = args[0].split(",");
            int[] arrInt = intArrayFromStringArray(stringArray);
            String[] stringArray2 = args[1].split(",");
            int[] arrInt2 = intArrayFromStringArray(stringArray2);

            ListNode head1 = linkedListFromIntArray(arrInt);

            ListNode head2 = linkedListFromIntArray(arrInt2);


            System.out.println(head1);

            System.out.println(head2);
            ListNode[] lists = new ListNode[]{head1,head2};
            head1 = linkedListFromIntArray(arrInt);
            head2 = linkedListFromIntArray(arrInt2);
            lists = new ListNode[]{head1,head2};

            System.out.println("SolutionMerge: "+new SolutionMerge().mergeKLists(lists));
            head1 = linkedListFromIntArray(arrInt);
            head2 = linkedListFromIntArray(arrInt2);
            lists = new ListNode[]{head1,head2};
            System.out.println("SolutionPQu  : "+new SolutionPriorityQueue().mergeKLists(lists));
            head1 = linkedListFromIntArray(arrInt);
            head2 = linkedListFromIntArray(arrInt2);
            lists = new ListNode[]{head1,head2};
            System.out.println("Cyclic Merge : "+new SolutionCyclicMerge().mergeKLists(lists));

        }
    }
}

