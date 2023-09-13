package interviewtasks;

import static interviewtasks.paramchecker.isStringIntegerValue;

/**
 *  Java program to calculate so-called "Fibonachi" sequence
 *  this one uses a cycle so is iterative.
 *  "Fibonachi/Fibonacci" sequence is a sequence where every following member is a sum of two previous members
 *  typically it has two first members as 1 and another 1 where first calculated member would be 2
 *  and the next one would be 3 following by 5 and so on.
 *  INFO: https://en.wikipedia.org/wiki/Fibonacci_sequence
 *  TAGS: #sequence
 */

public class numberfibonacci {
    static int sequenceLength;

    public static void main(String[] args) {
        String helpMessage="one input parameter of type Int with value more than \"2\" is expected";
        if (args.length != 1) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return ;
        }
        else if (!isStringIntegerValue(args[0])){
            System.out.println("argument is not a number");
            System.out.println(helpMessage);
            return ;
        }else if (Integer.parseInt(args[0])<2){
            System.out.println("argument less than 2, we know the first two members of so called Fibonachi sequence");
            System.out.println(helpMessage);
        }else{
            sequenceLength = Integer.parseInt(args[0]);
            printNlengthFibonachi(sequenceLength);
        }
    }



    private static void printNlengthFibonachi(int n){
        StringBuilder outputString = new StringBuilder();
        int fibA =1;
        int fibB =1;
        int fibC;
        int i;
        outputString.append('-');
        outputString.append(fibA);
        outputString.append('-');
        outputString.append(fibB);
        outputString.append('-');
        for (i=2; i<n; i++){
            fibC = fibA+fibB;
            outputString.append(fibC);
            outputString.append('-');
            fibA=fibB;
            fibB=fibC;
        }
        System.out.println("Fibonacci sequence of "+ sequenceLength+ " members:" + outputString); ;
    }
}