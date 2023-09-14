package interviewtasks;

import java.util.*;

/**
 * Given strings A and B, find the length of the longest repeating subsequence such that it can be found in
 * each of those strings where sequence is a set of character spread around the word but following each other
 * in certain order.
 * <p>
 * Example: words "xaxabx" and "axbaxx" longest subsequence is "xxx"
 * <p>
 * TAGS: #LCS #memoization #DP #sequence
 */
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
            System.out.println(str1 + " - " + str2);

            long start;
            long stop;

            start = System.nanoTime();
            System.out.println("Length of LCS(memoization) is " + lcsMemoization(str1, str2));
            stop = System.nanoTime();
            System.out.println("LCS(memoization)time taken " + (stop - start));
            start = System.nanoTime();
            System.out.println("Length of LCS(my) is " + my_lcs(str1, str2));
            stop = System.nanoTime();
            System.out.println("LCS(my)time taken " + (stop - start));
        }
    }


    // Memoization solution
    public static int lcsMemoization(String s1, String s2) {

        int height = s1.length();
        int width = s2.length();
        int[][] table = new int[height + 1][width + 1];

        for (int h = 0; h <= height; h++) {

            for (int w = 0; w <= width; w++) {

                if (w == 0 || h == 0) {
                    // 1. check -write accesible boundaries for check 2
                    // first column and firs rows are zeroes.
                    table[h][w] = 0;
                } else if (s1.charAt(h - 1) == s2.charAt(w - 1)) {
                    // 2. check. Match, write 1+ number from diagonal left-top
                    table[h][w] = table[h - 1][w - 1] + 1;
                } else {
                    // 3. check. No match take max value from left OR top.
                    table[h][w] = Math.max(table[h - 1][w], table[h][w - 1]);
                }

            }

        }
        System.out.println(getLcs(table, s1, s2, s1.length(), s2.length()));
        return table[height][width];

    }

    private static String getLcs(int[][] table, String s1, String s2, int height, int width) {

        StringBuilder lcs = new StringBuilder();

        int i = height, j = width;
        while (i > 0 && j > 0) {
            // match found
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.append(s1.charAt(i - 1));
                i--;
                j--;
                //else move left or up the table where bigger number is
            } else if (table[i - 1][j] > table[i][j - 1]) {
                i--;
            } else {
                j--;
            }

        }
        return lcs.reverse().toString();
    }

    // Recursive approach
    // it uses same matrix approach but without storing any data
    // Only as an example, it's not called as it has serious issues handling some 20 symbols strings
    // On some sites it's called "Naive". I personally see nothing naive about it.

    public static int lcsRecursive(String s1, String s2, int s1pointer, int s2pointer) {
        // filling with zeroes first column and row.
        if (s1pointer == 0 || s2pointer == 0)
            return 0;
        if (s1.charAt(s1pointer - 1) == s2.charAt(s2pointer - 1))
            return 1 + lcsRecursive(s1, s2, s1pointer - 1, s2pointer - 1);
        else
            return Math.max(lcsRecursive(s1, s2, s1pointer, s2pointer - 1), lcsRecursive(s1, s2, s1pointer - 1, s2pointer));
    }

    /* my implementation via lcs
     * 1. map all symbol positions
     * 2. build pairs
     * a1-b -c3
     * ↓  ↘  ↓
     * a1-a2-c3
     *
     * 3. Run LCS for resulted pairs {a1,a1},{a1,a2},{c3,c3}
     *
     *
     * @ksiv
     */
    public static int my_lcs(String s1, String s2) {
        int retVal = 0;
        Map<Character, ArrayList<Integer>> positionMap1 = new HashMap<>();
        Map<Character, ArrayList<Integer>> positionMap2 = new HashMap<>();

        mapString(s1, positionMap1);
        mapString(s2, positionMap2);

        // removing unpaired keys
        // this can be done or not depending on expected amount of unpaired keys
        positionMap1.keySet().retainAll(positionMap2.keySet());
        // this is not necessary for computation, but maybe it's needed if you in an RAM tight environment
        // positionMap2.keySet().retainAll(positionMap1.keySet());
        // if your PL allows temporal DS can be replaced with Stacks

        List<int[]> pairs = new ArrayList<>();
        for (Map.Entry<Character, ArrayList<Integer>> entry : positionMap1.entrySet()) {
            Character key = entry.getKey();
            ArrayList<Integer> value = entry.getValue();
            ArrayList<Integer> value2 = positionMap2.get(key);
            for (int i : value) {
                for (int j : value2) {
                    pairs.add(new int[]{i, j});
                }
            }
        }
        int[][] pairsArr = pairs.toArray(new int[0][]);
        //
        StringBuilder sb = new StringBuilder();
        for (int[] intArr : lis_pairs.getMaxPairSequence(pairsArr)) {
            sb.append(s1.charAt(intArr[0]));
        }
        System.out.println(sb.toString());
        //
        return lis_pairs.getLISlength(pairsArr);

    }

    public static void mapString(String s, Map<Character, ArrayList<Integer>> pos) {
        Character tmpChar;
        int i = 0;
        int sl = s.length();
        ArrayList<Integer> tmpArrList;
        while (i < sl) {

            tmpChar = s.charAt(i);
            tmpArrList = pos.getOrDefault(tmpChar, new ArrayList<Integer>());
            tmpArrList.add(i);
            pos.put(tmpChar, tmpArrList);

            i++;
        }

    }

}



