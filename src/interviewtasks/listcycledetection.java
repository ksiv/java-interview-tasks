package interviewtasks;

import interviewtasks.lib.linkedlist.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static interviewtasks.paramchecker.isStringIntegerValue;

/**
 *  Floyd's implementation
 *  Having Single Linked List (Chain) where every element only knows it's next.
 *  Task to detect a possible cycle where some element.next pointer points to some element that was encountered before..
 *
 *  was hard for me to grasp the idea at the beginning.
 *  for simplicity let's imagine
 *        ▼
 *  A->B->C->..
 *     ↑_____↓
 * the first pointer walked A-B and B-C before meeting point
 * second pointer going twice the speed made same distance twice
 * it went A-B,  B-C , (C-B) and B-C again.
 * that means that distance A-B = C-B
 *
 * At this point the speed of both pointers become x1
 * and first one goes from meeting point C-B
 * and second goes from the first node A -B
 * since it's same distance the point they met are the beginning of cycle, or it's end :-)
 *
 * TAGS: #dual-pointer
 * INFO: https://en.wikipedia.org/wiki/Cycle_detection
 *
 */
public class listcycledetection {

    public static void main(String[] args) {
        int nodesToMake = 0, loopAt = 1;
        String helpMessage = "number of nodes >1 and N of loopAt Node are input params. Example \"5\" \"1\"";
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
        Map<Integer, ListNode> nodes = new HashMap();
        ListNode firstListNode = new ListNode(0);
        nodes.put(0, firstListNode);
        for (int i =1; i < nodesToMake;i++){
            ListNode n = new ListNode(i);
            nodes.put(i,n);
            nodes.get(i-1).next = n;

        }
        // make cycle where cycle end is taken from input param and start at random position
        int tmp = new Random().nextInt(loopAt);
        nodes.get(loopAt).next=nodes.get(tmp);
        System.out.println("set "+loopAt+" node.next to"+tmp);
        // Detect cycle
        ListNode loopListNode = detectLoop(firstListNode);
        if (loopListNode == null) {
            System.out.println("Loop not present");
        } else {
            System.out.println("Start node of Loop is found at:" + loopListNode.val);
        }
    }


    public static ListNode detectLoop(ListNode startListNode) {
        ListNode firstPointer = startListNode;
        ListNode secondPointer = startListNode;
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
                firstPointer = startListNode;
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

