package interviewtasks;

/**
 * leetcode.com 6. Zigzag Conversion
 *
 * The string "hlloewdolr" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * H   E   L
 * L O W O R
 * L   D
 * And then read line by line: "helloworld"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 */



public class zigzag {
    public static String doit(String s, int numRows) {
        if (numRows<=1) return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i=0;i<numRows;i++){
            rows[i]= new StringBuilder();
        }
        boolean direction = true;
        int stepsBeforeSwap = numRows - 1;
        int step = 0;
        int row = 0;
        for (int i = 0; i < s.length(); i++) {
            rows[row].append(s.charAt(i));
            step++;
            if (direction) {
                row++;
            } else {
                row--;
            }
            if (step == stepsBeforeSwap) {
                direction = !direction;
                step=0;
            }
        }
        StringBuilder retVal= new StringBuilder();
        for (int i=0;i<numRows;i++){
            retVal.append(rows[i]);
        }
        return retVal.toString();
    }


    public static void main(String[] args) {
        String helpMessage = "String \"hlloewdolr\" and num rows \"3\" are expected as input";
        if (args.length != 2) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return;
        } else {
            String s = args[0];
            int k = Integer.parseInt(args[1]);
            System.out.println(doit(s,k));
        }
    }
}
