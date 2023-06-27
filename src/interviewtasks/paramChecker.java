package interviewtasks;


public class paramChecker {
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
}
