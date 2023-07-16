package interviewtasks;

import java.util.Arrays;

/**
 * Binary search in sorted array
 * ORIGIN: geeksforgeeks.org
 * TAGS: #binaryseach
 */

public class binarysearch {


    public static void main(String[] args) {
        String helpMessage = "Comma separated sorted array \"1,2,3,4,6,7\" and number to search \"6\" are expected as input";
        if (args.length != 2) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return;
        } else {
            String[] stringArray = args[0].split(",");
            int[] intArray = new int[stringArray.length];
            for (int i = 0; i < stringArray.length; i++) {
                intArray[i] = Integer.parseInt(stringArray[i]);
            }
            int k = Integer.parseInt(args[1]);
            System.out.println(Arrays.toString(intArray));
            System.out.println("Index in array (-1 for absence): " + binarySearchWrapper(intArray, k));
        }
    }


    static int binarySearchWrapper(int arr[], int k) {
        int low = 0;
        int high = arr.length - 1;
        if (arr[low] == k) {
            return low;
        }
        if (arr[high] == k) {
            return high;
        }
        return binarySearchWorker(arr, low, high, k);
    }

    static int binarySearchWorker(int arr[], int low, int high, int k) {
        if ((high - low) <= 1) {
            return -1;
        }
        int middle = high - ((high - low) / 2);
        if (arr[middle] == k) {
            return middle;
        }
        if (arr[middle] > k) {
            high = middle;
        } else {
            low = middle;
        }
        return binarySearchWorker(arr, low, high, k);
    }
}

