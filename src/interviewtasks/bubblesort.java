package interviewtasks;

import java.util.Arrays;


/**
 *
 * Implementation of "bubble sort" algorithm
 * TAGS: #sort
 * INFO: https://en.wikipedia.org/wiki/Bubble_sort
 */
public class bubblesort {


    public static void main(String[] args) {
        String helpMessage = "string like \"7,2,3,4,1,1\" expected as input.";
        if (args.length != 1) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return;
        } else {
            // arg handling
            String[] stringArray = args[0].split(",");
            int [] arr = new int [stringArray.length];
            for (int i=0;i<stringArray.length-1;i++) {

                arr[i] = Integer.parseInt(stringArray[i]);

            }

            System.out.println("before: "+Arrays.toString(arr));
            bubbleSort(arr);
            System.out.println("after : "+Arrays.toString(arr));

        }
    }
    public static void bubbleSort(int arr[])
    {
        Boolean swapDone=true;
        int k;
        while (swapDone){
            swapDone=false;
            for(int i=0;i<arr.length-1;i++){
                k=i+1;
                if (arr[i]>arr[k]){
                    int tmpVar = arr[i];
                    arr[i]=arr[k];
                    arr[k]=tmpVar;
                    swapDone=true;
                }
            }
        }
    }
}
