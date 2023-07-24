package interviewtasks;

import java.util.HashMap;
import java.util.Map;


/**
 * This task is to find out if every number frequency is unique.
 *
 * TAGS: #frequency
 */

public class uniquefrequencies {

    public static void main(String[] args) {

        String helpMessage = "string like \"1,2,34,7,7,7\" expected as input";
        if (args.length != 1) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return;
        } else {
            String[] stringArray = args[0].split(",");
            int[] intArray = new int[stringArray.length];
            for (int i = 0; i < stringArray.length; i++) {
                intArray[i] = Integer.parseInt(stringArray[i]);
            }
            System.out.println("return "+isFrequencyUnique(intArray));
            }


        }




    public static boolean isFrequencyUnique(int[] arr) {
        // in this example we traverse input array once and resulted frequency array in worst case once

        Map<Integer,Integer> frequencyMap = new HashMap<>();
        Map<Integer,Integer> duplcateCheck = new HashMap<>();
        for (Integer i : arr){
            frequencyMap.put(i, frequencyMap.getOrDefault(i, 0)+1);
        }
        for (Map.Entry<Integer, Integer> set : frequencyMap.entrySet()){
            if (null!=duplcateCheck.put(set.getValue(),set.getKey())){
                return false;
            }
        }
        return true;
    }
}

