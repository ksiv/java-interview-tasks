package interviewtasks;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class counsort {
    void sort(int arr[]) {
        int n = arr.length;

        int output[] = new int[n];

        // Create a frequency map for all numbers from min to max
        // number and initialize counters  as 0
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
        int min = 0;
        int max = 0;
        for (int i : arr) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        // TODO: later
        int len = Math.abs(max) + Math.abs(min) + 2;
        for (int i = min; i <= max; i++) {
            frequencyMap.put(i, 0);

        }


        // store encounter count of each int
        for (int i = 0; i < n; ++i) {
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);

        }
        System.out.println(frequencyMap);

        // Change frequency map so that it now contains
        // actual position of this Int in output array

        for (int i = min + 1; i <= max; i++) {

            frequencyMap.put(i, frequencyMap.get(i) + frequencyMap.get(i - 1));

        }

        // Build the output array (bottom-up)
        for (int i = n - 1; i >= 0; i--) {

            output[frequencyMap.get(arr[i]) - 1] = arr[i];
            frequencyMap.put(arr[i], frequencyMap.get(arr[i]) - 1);

        }
        System.out.println(frequencyMap);

        // Copy the output array to arr, so that arr now
        // contains sorted characters
        System.arraycopy(output, 0, arr, 0, arr.length);

    }


    public static void main(String args[]) {
        String helpMessage = "unsorted array like \"7,2,3,4,1,1\" is expected as input";
        if (args.length != 1) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return;
        } else {
            // arg handling
            String[] stringArray = args[0].split(",");
            int[] arrInt = new int[stringArray.length];
            for (int i = 0; i < stringArray.length; i++) {

                arrInt[i] = Integer.parseInt(stringArray[i]);

            }

            counsort sorter = new counsort();


            sorter.sort(arrInt);

            System.out.print("Sorted : " + Arrays.toString(arrInt));
        }
    }
}