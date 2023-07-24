package interviewtasks;



import java.util.*;

/**
 * Given an input stream A of n characters consisting only of lower case alphabets.
 * While reading characters from the stream, you have to tell which character has appeared only once in the stream upto that point.
 * If there are many characters that have appeared only once, you have to tell which one of them was the first one to appear.
 * If there is no such character then append '#' to the answer.
 * TAGS: #strings
 *
 */
public class firstnonrepeatingsymbol {

    public static void main(String[] args) {
        String helpMessage = "one strings is expected as a parameter e.g. \"abcdddfeqwertttty\"";
        String str = "";
        if (args.length != 1) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return;

        } else {
            str = args[0].toLowerCase(Locale.ROOT);
            System.out.println("String >>" + str + "<<");
        }
        Long start;
        Long stop;
        start = System.nanoTime();
        System.out.println(new Solution1().firstNonRepeating(str));
        stop = System.nanoTime();
        System.out.println("Solution 1 time taken "+(stop - start));
        start = System.nanoTime();
        System.out.println(new Solution2().firstNonRepeating(str));
        stop = System.nanoTime();
        System.out.println("Solution 2 time taken "+(stop - start));
        start = System.nanoTime();
        System.out.println(new Solution3().firstNonRepeating(str));
        stop = System.nanoTime();
        System.out.println("Solution 3 time taken "+(stop - start));
    }
}
    class Solution1
    {
        public String firstNonRepeating(String A) {
            StringBuilder sb = new StringBuilder();
            Queue<Character> queue = new LinkedList<Character>();
            Map<Character, Integer> countMap = new HashMap<>();

            for (int i = 0; i < A.length(); i++) {
                Character chr = A.charAt(i);
                int count = countMap.getOrDefault(chr, 0) + 1;
                countMap.put(chr, count);

                if (count == 1) {
                    queue.add(chr);
                }

                if (count == 2) {
                    queue.remove(chr);
                }

                if (!queue.isEmpty()) {
                    sb.append(queue.peek());
                } else {
                    sb.append("#");
                }
            }
            return sb.toString();
        }
    }
    class Solution2 {
        public String firstNonRepeating(String A) {
            StringBuilder sb = new StringBuilder();
            Queue<Character> queue = new LinkedList<>();
            Map<Character, Integer> countMap = new HashMap<>();

            for (int i = 0; i < A.length(); i++) {
                Character chr = A.charAt(i);
                int count = countMap.getOrDefault(chr, 0) + 1;
                countMap.put(chr, count);

                if (count == 1) {
                    queue.add(chr);
                }

                if (count == 2) {
                    while (!queue.isEmpty() && countMap.get(queue.peek()) > 1) {
                        queue.poll();
                    }
                }

                if (!queue.isEmpty()) {
                    sb.append(queue.peek());
                } else {
                    sb.append('#');
                }
            }
            return sb.toString();
        }
    }

    class Solution3 {
        class Node {
            char ch;
            int count;
            Node prev, next;

            Node(char ch, int count) {
                this.ch = ch;
                this.count = count;
            }
        }

        public String firstNonRepeating(String A) {
            // encounter frequency map
            HashMap<Character, Node> map = new HashMap<>();
            // doubly linked list head and tail. usefull load nodes will be inbetween
            Node head = new Node('\0', 0);
            Node tail = new Node('\0', 0);
            head.next = tail;
            tail.prev = head;

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < A.length(); i++) {
                char c = A.charAt(i);
                // the first encounter
                if (!map.containsKey(c)) {
                    Node node = new Node(c, 1);
                    map.put(c, node);
                    addToEnd(node, tail);
                    // the second encounter - remove from the queue
                } else {
                    Node node = map.get(c);
                    node.count++;
                    if (node.count == 2) removeFromList(node);
                }
                // if a one-time encountered element awaits in the queue, otherwise '#'
                if (head.next != tail) {
                    sb.append(head.next.ch);
                } else {
                    sb.append('#');
                }
            }
            return sb.toString();
        }

        private void addToEnd(Node node, Node tail) {
            Node prev = tail.prev;
            prev.next = node;
            node.prev = prev;
            node.next = tail;
            tail.prev = node;
        }

        private void removeFromList(Node node) {
            // link prev and next nodes together removing intemediate node
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }
    }

