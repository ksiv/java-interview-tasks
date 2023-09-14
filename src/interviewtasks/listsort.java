package interviewtasks;

import java.util.*;
import static interviewtasks.lib.linkedlist.*;
import static interviewtasks.lib.paramhelper.*;
/**
 * leetcode 148. Sort List
 * Given the head of a linked list, return the list after sorting it in ascending order.
 */
public class listsort {


    // Solution for uniq values using TreeMap sorting
    class BuiltInTreeMapSort {
        // Sorting using TreeMap
        // Maybe slower but is not a fake
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null){
                return head;

            }

            HashMap<Integer, ListNode> map = new HashMap<>();
            // Singlelinked list to Map
            while (head != null) {
                map.put(head.val, head);
                head = head.next;
            }
            // Sort using placing into TreeMap
            TreeMap<Integer, ListNode> tmap = new TreeMap<>(map);
            // Head is first element of TreeMap
            head = tmap.firstEntry().getValue();

            // Set next for every previous element
            ListNode prev = null;

            for (Map.Entry<Integer, ListNode>
                    entry : tmap.entrySet()) {

                if (prev != null) {
                    prev.next = entry.getValue();
                    prev = entry.getValue();

                } else {
                    prev = entry.getValue();
                }
            }
            // last.next to null
            ListNode last = tmap.lastEntry().getValue();
            last.next = null;
            return head;
        }


    }

    public static class MergeSort {

        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            // step 1. cut the list to two halves using two-pointers
            ListNode leftListEnd = null;
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                leftListEnd = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

            leftListEnd.next = null;

            // step 2. sort each half
            ListNode leftList = sortList(head);
            ListNode rightList = sortList(slow);

            // step 3. merge left and right halves
            return merge(leftList, rightList);
        }

        ListNode merge(ListNode right, ListNode left) {
            ListNode l = new ListNode(0), p = l;

            while (right != null && left != null) {
                if (right.val < left.val) {
                    p.next = right;
                    right = right.next;
                } else {
                    p.next = left;
                    left = left.next;
                }
                p = p.next;
            }

            if (right != null)
                p.next = right;

            if (left != null)
                p.next = left;

            return l.next;
        }

    }

    static class BubbleSort {
        // bubble (will take long time)
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null){
                return head;
            }
            boolean swapDone = true;
            while (swapDone) {
                swapDone = false;
                ListNode prevNode = null;
                ListNode node = head;
                ListNode nextNode;
                while (node.next != null) {
                    //swapDone=false;
                    if (node.val > node.next.val) {
                        // if head swap
                        if (node.equals(head)) {
                            head = node.next;
                        }
                        // if previous exist  prev to next
                        if (prevNode != null) {
                            prevNode.next = node.next;
                        }

                        nextNode = node.next;
                        // this to next but one
                        node.next = node.next.next;
                        // next node.next to this node
                        nextNode.next = node;

                        //next node now prevNode
                        prevNode = nextNode;
                        swapDone = true;

                    } else {
                        prevNode = node;
                        node = node.next;
                    }
                }
            }
            return head;
        }
    }

    // Support duplicates
    static class CountSort {
        public static class NodeInfo {
            public int value;
            ListNode node;

            // added type safety as compare to Object[][]
            NodeInfo(int value, ListNode node) {
                this.value = value;
                this.node = node;

            }

        }

        void countSort(ArrayList<NodeInfo> arr) {
            int arrSize = arr.size();
            NodeInfo[] output = new NodeInfo[arrSize];

            // Create a frequency map for all numbers from min to max
            // number and initialize counters  as 0
            Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
            int min = 0;
            int max = 0;
            for (NodeInfo nodeInfo : arr) {
                max = Math.max(max, nodeInfo.value);
                min = Math.min(min, nodeInfo.value);
            }
            for (int i = min; i <= max; ++i) {
                frequencyMap.put(i, 0);

            }


            // store encounter count of each int
            for (int i = 0; i < arrSize; i++) {
                frequencyMap.put(arr.get(i).value, frequencyMap.get(arr.get(i).value) + 1);

            }

            // Change frequency map so that it now contains
            // actual position of this Int in output array

            for (int i = min + 1; i <= max; i++) {

                frequencyMap.put(i, frequencyMap.get(i) + frequencyMap.get(i - 1));

            }

            // Build the output array (bottom-up)
            for (int i = arrSize - 1; i >= 0; i--) {

                output[frequencyMap.get(arr.get(i).value) - 1] = arr.get(i);
                frequencyMap.put(arr.get(i).value, frequencyMap.get(arr.get(i).value) - 1);

            }

            // Copy the output array to arr, so that arr now
            // contains sorted characters
            arr.clear();
            Collections.addAll(arr, output);

        }

        // Sorting driver
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null){
                return head;

            }
            // Put nodes to array
            ArrayList<NodeInfo> al = new ArrayList<>();
            ListNode node = head;
            while (true) {
                al.add(new NodeInfo(node.val, node));
                if (node.next == null) break;
                node = node.next;

            }
            int counter = al.size();
            // Sort the array
            countSort(al);
            // Fix link for every prev node
            ListNode prev = null;

            for (NodeInfo nodeInfo : al) {
                if (prev != null) {
                    prev.next = nodeInfo.node;
                    prev = nodeInfo.node;

                } else {
                    prev = nodeInfo.node;
                }
            }
            // Fix last.next to null
            al.get(al.size() - 1).node.next = null;
            // First node is the new 'head'
            head = al.get(0).node;

            return head;

        }
    }

    // Support duplicates
    static class BuiltInArrasSort {

        // Object[][] Sorting
        public ListNode sortList(ListNode head) {
            if (head == null) {
                return head;
            }
            // Count nodes
            int counter = 1;
            ListNode node = head;
            while (node.next != null) {
                counter++;
                node = node.next;
            }
            // Put nodes to array
            Object[][] objects = new Object[counter][2];
            node = head;
            for (int i = 0; i < counter; i++) {
                objects[i][0] = node.val;
                objects[i][1] = node;
                node = node.next;
            }
            // Sort the array
            Arrays.sort(objects, Comparator.comparingInt(o -> (int) o[0]));

            // Fix link for every prev node
            ListNode prev = null;

            for (int i = 0; i < counter; i++) {
                if (prev != null) {
                    prev.next = (ListNode) objects[i][1];
                    prev = (ListNode) objects[i][1];

                } else {
                    prev = (ListNode) objects[i][1];
                }
            }
            // Fix last.next to null
            ListNode last = (ListNode) objects[counter - 1][1];
            last.next = null;
            // First node is the new 'head'
            head = (ListNode) objects[0][1];

            return head;

        }
    }

    public static ListNode addNext(ListNode node, int val) {
        node.next = new ListNode(val);
        return node.next;
    }


    public static void main(String[] args) {
        String helpMessage = "unsorted array like \"7,2,3,4,1,1\" is expected as input";
        if (args.length != 1) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return;
        } else {
            // arg handling
            String[] stringArray = args[0].split(",");
            int[] arrInt = intArrayFromStringArray(stringArray);


            ListNode head = linkedListFromIntArray(arrInt);
            System.out.println("Buble " + new BubbleSort().sortList(head));

            head = linkedListFromIntArray(arrInt);
            System.out.println("BUilt-in" + new BuiltInArrasSort().sortList(head));

            head = linkedListFromIntArray(arrInt);
            System.out.println("Merge" + new MergeSort().sortList(head));

            head = linkedListFromIntArray(arrInt);
            System.out.println("Count" + new CountSort().sortList(head));
        }
    }
}
