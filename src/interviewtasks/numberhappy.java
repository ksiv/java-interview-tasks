package interviewtasks;

import java.util.HashSet;
import java.util.Set;

import static interviewtasks.paramchecker.isStringIntegerValue;

public class numberhappy {

    /**
     * leetcode.com 202. Happy Number
     * Write an algorithm to determine if a number n is happy.
     * <p>
     * A happy number is a number defined by the following process:
     * <p>
     * Starting with any positive integer, replace the number by the sum of the squares of its digits.
     * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
     * Those numbers for which this process ends in 1 are happy.
     * Return true if n is a happy number, and false if not.
     */

    // This solution is based on the assumption that such numbers are cyclic.
    // this version is based on encounter map.
    public static boolean isHappy(int n) {
        // Already  seen elements
        Set<Integer> encounters = new HashSet<>();

        // While N is not 1 .
        while (n != 1) {
            // On first insert of same value map.add returns true (the first encounter)
            if (!encounters.add(n)) return false;
            // Compute the sum of the squares
            int tmp = 0;
            while (n != 0) {

                tmp += Math.pow(n % 10, 2);
                n /= 10;
            }

            n = tmp;
        }

        return true;
    }

    public static void main(String[] args) {
        String helpMessage = "one input parameter of type Int with value more than \"0\" is expected";
        if (args.length != 1) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return;
        } else {
            int num = Integer.parseInt(args[0]);
            System.out.println(isHappy(num));
        }
    }
}
