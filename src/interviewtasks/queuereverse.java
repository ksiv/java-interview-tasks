package interviewtasks;


import java.util.LinkedList;
import java.util.Queue;

/**
 * according to https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Queue.html
 * "Queues typically, but do not necessarily, order elements in a FIFO" (c)
 * this will work only for FIFO type queues.
 *
 * TAGS: #queue, #recursion
 */
public class queuereverse {

    public static void main(String[] args) {
        String helpMessage = "string like \"7,2,3,4,1,1\" expected as input.";
        if (args.length != 1) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
        } else {
            // arg handling
            String[] stringArray = args[0].split(",");
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < stringArray.length - 1; i++) {

                q.add(Integer.parseInt(stringArray[i]));

            }


            System.out.println("before: " + q);
            new queuereverse().rev(q);
            System.out.println("after : " + q);

        }
    }

    // recursion storage in call-stack
    public Queue<Integer> rev(Queue<Integer> q) {


        if (null == q.peek()) {
            return q;
        }
        int tmpvar = q.poll();

        rev(q);

        q.offer(tmpvar);
        return q;
    }
}
