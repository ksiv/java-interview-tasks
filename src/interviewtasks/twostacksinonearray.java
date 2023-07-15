package interviewtasks;


import java.util.Arrays;

/**
 * implementation of two stacks in one array
 * one stack pointer goes from array start and enother one from the end
 * ORIGIN: geeksforgeeks.org
 * CMD: interviewtasks> java -classpath ".."  interviewtasks.twostacksinonearray "0<23,1<356,1<44,0<99,1>,0>"
 * TAGS: #twopoints
 */



public class twostacksinonearray {
    static int arr[];
    static int size;
    static int top1, top2;


    public static void main(String[] args) throws Exception {
        String helpMessage = "string like \"0<23,1<356,1<44,0<99,1>,0>\" expected as input. where 0 the fist stack and 1 is the second one. < is push followed by value";
        if (args.length != 1) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return;
        } else {
            //stacks settings
            size = 20;
            arr = new int[size];
            System.out.println(arr[5]);
            top1 = -1;
            top2 = size;
            // arg handling
            String[] stringArray = args[0].split(",");
            boolean isFirstStack;
            boolean isPush;
            int value;
            for (String str: stringArray ){
                System.out.println(str);
                // true - the first stack; false - the second
                isFirstStack = str.charAt(0)=='0';
                // true - push; false - pop
                isPush  = str.charAt(1) == '<';
                if ((isPush)) {
                    value = Integer.parseInt(str.substring(2)) ;
                    pushToStack(isFirstStack, value);
                } else {
                    popFromStack(isFirstStack);
                }
                System.out.println(Arrays.toString(arr));
            }


        }
    }

    static void pushToStack(Boolean isFirstStack, int value) throws Exception {
        if ((isFirstStack)) {
            push1(value);
        } else {
            push2(value);
        }

    }
    static void popFromStack(Boolean isFirstStack){
        if ((isFirstStack)) {
            pop1();
        } else {
            pop2();
        }
    }
    //Function to push an integer into the stack1.
    static void push1(int x) throws Exception {

        if (top2 == (top1 + 1)) {
            throw new Exception("Custom stack array overflow");
        }
        ++top1;
        arr[top1] = x;

    }
    static private void pushToStack(boolean stackN, int value) throws Exception {
        if (stackN){
            push1(value);
        }else{
            push2(value);
        }

    }
    //Function to push an integer into the stack2.
    static private void push2(int x) throws Exception {

        if (top2 == (top1 + 1)) {
            throw new Exception("Custom stack array overflow");
        }

        --top2;
        arr[top2] = x;
    }

    //Function to remove an element from top of the stack1.
    static int pop1() {
        if (top1 == -1) {
            return -1;
        }
        int reval = arr[top1];
        arr[top1] = 0;
        top1--;
        return reval;

    }

    //Function to remove an element from top of the stack2.
    static int pop2() {
        if (top2 == size) {
            return -1;
        }
        int retval =arr[top2];
        arr[top2]=0;
        top2++;
        return retval;
    }
}
