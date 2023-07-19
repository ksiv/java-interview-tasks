package interviewtasks;

import java.util.Locale;

/**
 * Given string str, find the length of the longest repeating subsequence such that it can be found twice in the given string.
 * The two identified subsequences A and B can use the same ith character from string str if and only if that ith character has different indices in A and B.
 * For example, A = "xax" and B = "xax" then the index of first "x" must be different in the original string for A and B.
 * So far only one approach here, but different solution for this problem exist.
 *
 * ORIGIN: geeksforgeeks.org
 * TAGS: #LCS #Memoization #DP
 *
 */


public class lcs {
    public static void main(String[] args) {
        String helpMessage = "one strings is expected as a parameter e.g. \"ameyamedozp\"";
        String str;
        if (args.length != 1) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return;

        } else {
            str = args[0].toLowerCase(Locale.ROOT);

            System.out.println("String >>" + str + "<<");
            int result = longestRepeatingSubsequence(str);
            System.out.println("Length of LCS is " + result);
        }
    }
    // Memoization solution
    public static int longestRepeatingSubsequence(String str)
    {

        int height = str.length();
        int width = str.length();
        int[][] table = new int[height+1][width+1];

        for(int h = 0; h<height;h++){

            for (int w=0; w<width;w++){

                if (w ==0 || h ==0){
                    // 1. check -write accesible boundaries for check 2
                    // first column and firs rows are zeroes.
                    table[h][w]= 0;
                }else if(str.charAt(h-1) == str.charAt(w-1) && w!=h){
                    // 2. check write 1+ number from diagonal left-top
                    table[h][w]=table[h-1][w-1]+1;
                }else{
                    // 3. check. no match take max value from left OR top.
                    table[h][w]=Math.max(table[h-1][w],table[h][w-1]);
                }

            }

        }

        return table[height-1][width-1];
    }


}






