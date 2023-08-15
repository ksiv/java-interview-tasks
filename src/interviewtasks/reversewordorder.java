package interviewtasks;

/**
 * Given an input string s, reverse the order of the words.
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 * Return a string of the words in reverse order concatenated by a single space.
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 * TAGS: #strings
 */


public class reversewordorder {
    public static String reverse(String s) {
        String[] strArr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i=strArr.length-1;i>=0;i--){
            String tmp =strArr[i].trim();
            if(tmp.length()==0) continue;
            sb.append(tmp);
            if (i>0) sb.append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String helpMessage = "a strings is expected as an input";
        if (args.length != 1) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return;
        } else {
            System.out.println("-"+args[0]+"-");
            System.out.println("-"+reverse(args[0]).trim()+"-");

        }

    }
}
