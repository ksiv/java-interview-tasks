package interviewtasks;

import java.util.Arrays;


/**
 * Implementation of FIFO queue in an array
 * TAGS: #array #ring-buffer
 */

public class queueinarray {
    int popPointer, pushPointer;
    int arr[] = new int[10];
    int arrCap;
    int qSize;

    public static void main(String[] args) {
        String helpMessage = "string like \"<1,<2,<3,<4,>,>\" expected as input. where \"<\" is push followed by value";
        if (args.length != 1) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return;
        } else {
            queueinarray aq = new queueinarray();
            // arg handling
            String[] stringArray = args[0].split(",");
            boolean isPush;
            int value;
            for (String str : stringArray) {
                // true - push; false - pop
                isPush = str.charAt(0) == '<';
                if ((isPush)) {
                    value = Integer.parseInt(str.substring(1));
                    aq.push(value);
                } else {
                    aq.pop();
                }
                System.out.println(Arrays.toString(aq.arr));


            }

        }


    }

    queueinarray() {
        arrCap = arr.length;
        popPointer = 0;
        pushPointer = 0;
        qSize = 0;
    }

    // Function to push an element x in a queue.
    public void push(int x) {
        if (qSize < arrCap) {
            arr[pushPointer] = x;
            qSize++;
            movePushPointer();
        } else {
            System.out.println("Overflow");
        }
    }

    // Function to pop an element from queue and return that element.
    public int pop() {
        if (qSize > 0) {
            int tempVal = arr[popPointer];
            arr[popPointer] = 0;
            qSize--;
            movePopPointer();
            return tempVal;
        } else {
            System.out.println("Queue is empty");
            return -1;
        }
    }

    private void movePushPointer() {
        if (pushPointer < arrCap - 1) {
            pushPointer++;
        } else {
            pushPointer = 0;
        }
    }

    private void movePopPointer() {
        if (popPointer < arrCap - 1) {
            popPointer++;
        } else {
            popPointer = 0;
        }
    }
}
