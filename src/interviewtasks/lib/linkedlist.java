package interviewtasks.lib;

public class linkedlist {
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }

    }
    public static ListNode addNext(ListNode node, int val) {
        node.next = new ListNode(val);
        return node.next;
    }
}
