package interviewtasks.lib;


public class paramhelper {
    public static boolean isStringIntegerValue(String str){
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    public static boolean isStringLongValue(String str){
        try {
            Long.parseLong(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    public static int[] intArrayFromStringArray(String[] stringArray){
        int [] arr = new int [stringArray.length];
        for (int i=0;i<stringArray.length;i++) {
            arr[i] = Integer.parseInt(stringArray[i]);
        }
        return arr;
    }
}
