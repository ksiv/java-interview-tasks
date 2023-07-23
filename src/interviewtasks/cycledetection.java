package interviewtasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static interviewtasks.paramChecker.isStringIntegerValue;

/**
 *  Having Single Linked List (Chain) where every element only knows it's next.
 *  Task to detect a possible cycle.
 *  Intuition behind the algorithm
 *  where distance between 0 and cycle start = "a"
 *  distance traveled inside cycle by "slow" pointer = "b"
 *  cycle length "c"
 *  slow pointer went (a+b)
 *  since speed of fastPointer is double it made (a+b)*2
 *  or (a+b)+(n*c) where "n" num of cycles fastPointer made inside.
 *  2*(a + b) = (a + b) + n*c
 *  So,  'a + b = n*c'
 * TAGS: #dual-pointer
 */
public class cycledetection {

    public static void main(String[] args) {
        int nodesToMake = 0, loopAt = 1;
        String helpMessage = "number of nodes >1 and N of loopAt Node are input params. Example \"5 1\"";
        if (args.length != 2) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);

        } else {
            if(isStringIntegerValue(args[0]) && isStringIntegerValue(args[0])){
                nodesToMake = Integer.parseInt(args[0]);
                loopAt  = Integer.parseInt(args[1]);
                if (loopAt>nodesToMake) {
                    loopAt=nodesToMake-1;
                    System.out.println("loopAt was outside the scope reset to :"+loopAt);
                }
                if (nodesToMake<2) {
                    nodesToMake=2;
                    System.out.println("nodesTomake is too low reset to :"+nodesToMake);
                }
                System.out.println("nodesTomake"+nodesToMake+",loopAt"+loopAt);
            }

        }
        // make node chain of given length "nodesTomake"
        Map<Integer, Node> nodes = new HashMap();
        Node firstNode = new Node(0);
        nodes.put(0,firstNode);
        for (int i =1; i < nodesToMake;i++){
            Node n = new Node(i);
            nodes.put(i,n);
            nodes.get(i-1).next = n;

        }
        // make cycle where cycle end is taken from input param and start at random position
        int tmp = new Random().nextInt(loopAt);
        nodes.get(loopAt).next=nodes.get(tmp);
        System.out.println("set "+loopAt+" node.next to"+tmp);
        // Detect cycle
        Node loopNode = detectLoop(firstNode);
        if (loopNode == null) {
            System.out.println("Loop not present");
        } else {
            System.out.println("Start node of Loop is found at:" + loopNode.data);
        }
    }

    // Node has only two fields useful load (data) and link to next Node.
    public static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static Node detectLoop(Node startNode) {
        Node firstPointer = startNode;
        Node secondPointer = startNode;
        // Default value of Node.next pointer is "null"
        // End of chain
        while (secondPointer != null && secondPointer.next != null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next.next;

            // Cycle found case
            // firstPointer moved to the start position
            // FastPointer speed changed to x1
            // now two pointers move to the same point by different routes
            if (firstPointer == secondPointer) {
                firstPointer = startNode;
                while (firstPointer != secondPointer) {
                    firstPointer = firstPointer.next;
                    secondPointer = secondPointer.next;
                }

                return firstPointer;
            }
        }
        return null;
    }


}

