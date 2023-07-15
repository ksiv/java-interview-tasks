package interviewtasks;

import java.util.Stack;

/**
 *  Remove middle element of a stack "without" additional data structure
 *  the question is can we call recursive call chain a "Data Structure"
 */


public class removemiddleofstack {
    public static void main(String[] args){
        String helpMessage = "string like \"1,2,3,4,5,6,7,8,9\" expected as input";
        if (args.length != 1) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return;
        } else {
            String[] stringArray = args[0].split(",");
            Stack<Integer> stack = new Stack<Integer>();
            for (int i = 0; i < stringArray.length; i++) {
                stack.push(Integer.parseInt(stringArray[i]));
            }

            System.out.println(stack);
            deleteMidViaRecursiveCall(stack, stack.size(), 0);
            System.out.println(stack);
            deleteMidViaInheritedFromVectorMethod(stack,stack.size());
            System.out.println(stack);
        }
    }

    // LIFO breakage
    public static void deleteMidViaInheritedFromVectorMethod(Stack<Integer> s, int sizeOfStack){

        int middle = ((sizeOfStack-1)/2);
        s.removeElementAt(middle);


    }
    // Implicit data storage in recursive call
    // Poping and storing stack recursively
    public static void deleteMidViaRecursiveCall(Stack<Integer> stack, int n, int curr) {
        if (stack.isEmpty() || curr == n/2) {
            stack.pop();
            return;
        }

        int temp = stack.pop();

        deleteMidViaRecursiveCall(stack, n, curr+1);

        if (curr != n/2) {
            stack.push(temp);
        }
    }
}
