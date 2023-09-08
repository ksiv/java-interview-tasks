package interviewtasks;

import java.util.*;

public class sortlist {

    // Solution for uniq values using TreeMap sorting
    class SolutionForUniq {
        // Sorting using TreeMap
        // Maybe slower but is not a fake
        public ListNode sortList(ListNode head) {
            if(head==null){
                return head;
            }
            HashMap<Integer,ListNode> map = new HashMap<>();
            // Singlelinked list to Map
            while (head!=null){
                map.put(head.val,head);
                head=head.next;
            }
            // Sort using placing into TreeMap
            TreeMap<Integer,ListNode> tmap = new TreeMap<>(map);
            // Head is first element of TreeMap
            head = tmap.firstEntry().getValue();

            // Set next for every previous element
            ListNode prev =null;

            for (Map.Entry<Integer, ListNode>
                    entry : tmap.entrySet()){

                if(prev!=null){
                    prev.next=entry.getValue();
                    prev=entry.getValue();

                }else{
                    prev=entry.getValue();
                }
            }
            // last.next to null
            ListNode last = tmap.lastEntry().getValue();
            last.next=null;
            return head;
        }


    }
    public static class ListNode {
          int val;
          String stamp;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; this.stamp=Long.toString(System.nanoTime());}
          ListNode(int val, ListNode next) { this.val = val; this.next = next;  this.stamp=Long.toString(System.nanoTime());}

          @Override
          public String toString() {
              return "ListNode{" +
                      "val=" + val +
                      "val+1=" + stamp +
                      ", next=" + next +
                      '}';
          }

      }
    public static class SolutionMerge {

        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null)
                return head;

            // step 1. cut the list to two halves
            ListNode prev = null, slow = head, fast = head;

            while (fast != null && fast.next != null) {
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

            prev.next = null;

            // step 2. sort each half
            ListNode l1 = sortList(head);
            ListNode l2 = sortList(slow);

            // step 3. merge l1 and l2
            return merge(l1, l2);
        }

        ListNode merge(ListNode l1, ListNode l2) {
            ListNode l = new ListNode(0), p = l;

            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    p.next = l1;
                    l1 = l1.next;
                } else {
                    p.next = l2;
                    l2 = l2.next;
                }
                p = p.next;
            }

            if (l1 != null)
                p.next = l1;

            if (l2 != null)
                p.next = l2;

            return l.next;
        }

    }

    static class BubbleSort {
        // bubble (will take long time)
        public ListNode sortList(ListNode head) {
            if(head==null){
                return head;
            }
            Boolean swapDone=true;
            while (swapDone){
                swapDone=false;
                ListNode prevNode=null;
                ListNode node = head;
                ListNode nextNode;
                while(node.next!=null){
                    //swapDone=false;
                    if(node.val>node.next.val){
                        // if head swap
                        if(node.equals(head)){
                            head=node.next;
                        }
                        // if previous exist  prev to next
                        if (prevNode!=null){
                            prevNode.next=node.next;
                        }

                        nextNode = node.next;
                        // this to next but one
                        node.next=node.next.next;
                        // next node.next to this node
                        nextNode.next=node;

                        //next node now prevNode
                        prevNode=nextNode;
                        swapDone=true;

                    }else{
                        prevNode=node;
                        node=node.next;
                    }
                }
            }
            return head;
        }
    }

    // Support duplicates
    static class JavaBuildInArrasSort {
        // Object[][] Sorting
        public ListNode sortList(ListNode head) {
            if(head==null){
                return head;
            }
            // Count nodes
            int counter=1;
            ListNode node = head;
            while(node.next!=null){
                counter++;
                node=node.next;
            }
            // Put nodes to array
            Object[][] objects = new Object[counter][2];
            node = head;
            for(int i=0;i<counter;i++){
                objects[i][0]=node.val;
                objects[i][1]=node;
                node=node.next;
            }
            // Sort the array
            Arrays.sort(objects, Comparator.comparingInt(o -> (int) o[0]));

            // Fix link for every prev node
            ListNode prev =null;

            for(int i=0;i<counter;i++){
                if(prev!=null){
                    prev.next=(ListNode) objects[i][1];
                    prev= (ListNode) objects[i][1];

                }else{
                    prev= (ListNode) objects[i][1];
                }
            }
            // Fix last.next to null
            ListNode last = (ListNode) objects[counter-1][1];
            last.next=null;
            // First node is the new 'head'
            head = (ListNode) objects[0][1];

            return head;

        }
    }

    public static ListNode addNext(ListNode node , int val){
        node.next=new ListNode(val);
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
            int[] arr = new int[stringArray.length];
            for (int i = 0; i < stringArray.length; i++) {

                arr[i] = Integer.parseInt(stringArray[i]);

            }

            ListNode head = new ListNode(arr[0]);
            ListNode node = head;

            for (int i=1;i<arr.length;i++) {

                node = addNext(node, arr[i]);

            }
            System.out.println("before " + head);
            //ListNode result = new BubbleSort().sortList(head);
            //ListNode result = new JavaBuildInArrasSort().sortList(head);
            ListNode result = new SolutionMerge().sortList(head);
            System.out.println(result);
        }
    }
}
