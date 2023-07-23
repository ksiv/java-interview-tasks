package interviewtasks;

import java.util.Locale;


public class lcs {

    public static void main(String[] args) {
        String helpMessage = "two strings are expected as input e.g. \"ameyame\" \"ametdxr\", beware long input";
        if (args.length != 2) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);

        } else {
            String str1 = args[0].toLowerCase(Locale.ROOT);
            String str2 = args[1].toLowerCase(Locale.ROOT);
            int s1length = str1.length();
            int s2length = str2.length();
            System.out.println(str1 + "-" + str2);
            System.out.println("Length of LCS(recursion) is " + lcs1(str1, str2, s1length, s2length));
            System.out.println("Length of LCS(memoization) is " + lcs2(str1, str2, s1length, s2length));
        }
    }


    // Memoization solution
    public static int lcs2(String s1, String s2, int s1l, int s2l) {

        int height = s1.length();
        int width = s2.length();
        int[][] table = new int[height + 1][width + 1];

        for (int h = 0; h < height; h++) {

            for (int w = 0; w < width; w++) {

                if (w == 0 || h == 0) {
                    // 1. check -write accesible boundaries for check 2
                    // first column and firs rows are zeroes.
                    table[h][w] = 0;
                } else if (s1.charAt(h - 1) == s2.charAt(w - 1)) {
                    // 2. check write 1+ number from diagonal left-top
                    table[h][w] = table[h - 1][w - 1] + 1;
                } else {
                    // 3. check. no match take max value from left OR top.
                    table[h][w] = Math.max(table[h - 1][w], table[h][w - 1]);
                }

            }

        }

        return table[height - 1][width - 1];
    }

    // Recursive approach
    // it uses same matrix approach but without storing any data
    public static int lcs1(String s1, String s2, int s1pointer, int s2pointer) {
        // Base condition
        if (s1pointer == 0 || s2pointer == 0)
            return 0;

        // If characters match
        if (s1.charAt(s1pointer - 1) == s2.charAt(s2pointer - 1))
            return 1 + lcs1(s1, s2, s1pointer - 1, s2pointer - 1);
        else
            // If characters don't match
            return Math.max(lcs1(s1, s2, s1pointer, s2pointer - 1), lcs1(s1, s2, s1pointer - 1, s2pointer));
    }

}
