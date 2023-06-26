package interviewtasks;

import static interviewtasks.paramChecker.isStringIntegerValue;

/**
 *  Java program to calculate so-called "Fibonachi" sequence
 *  this one uses a cycle so is iterative.
 *  "Fibonachi/Fibonacci" sequence is a sequence where every following member is a sum of two previous members
 *  typically it has two first members as 1 and another 1 where first calculated member would be 2
 *  and the next one would be 3 following by 5 and so on.
 *  @author ksiv
 */

public class fibonacci {
    static int sequenceLength;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("wrong argument count");
            System.out.println("one input parameter of type Int with value more than \"2\" is expected");
            return ;
        }
        else if (!isStringIntegerValue(args[0])){
            System.out.println("argument is not a number");
            System.out.println("one input parameter of type Int with value more than \"2\" is expected");
            return ;
        }else if (Integer.parseInt(args[0])<2){
            System.out.println("argument less than 2, we know the first two members of so called Fibonachi sequence");
            System.out.println("one input parameter of type Int with value more than \"2\" is expected");
        }else{
            sequenceLength = Integer.parseInt(args[0]);
            printNlengthFibonachi(sequenceLength);
        }
    }



    private static void printNlengthFibonachi(int n){
        String outputString ="";
        int fibA =1;
        int fibB =1;
        int fibC;
        int i;
        outputString += "-"+fibA+"-";
        outputString += fibB+"-";
        for (i=2; i<n; i++){
            fibC = fibA+fibB;
            outputString += fibC+"-";
            fibA=fibB;
            fibB=fibC;
        }
        System.out.println("Fibonacci sequence of "+ sequenceLength+ " members:" + outputString); ;
    }
}