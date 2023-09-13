package interviewtasks;

import java.util.Locale;

/**
 * leetcode 190. Reverse Bits
 * Reverse bits of a given 32 bits unsigned integer.
 * <p>
 * Note:
 * <p>
 * Note that in some languages, such as Java, there is no unsigned integer type. In this case, both input and output will be given as a signed integer type. They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents the signed integer -1073741825.
 * // you need treat n as an unsigned value
 */
public class binarybitreverse {
    public static class Solution {
        public static int reverseBits(int n) {

            int backwadInt = 0;
            int original = n;
            int lastBit;

            for (int i = 0; i <= 31; i++) {
                lastBit = (original >> i) & 1;
                backwadInt = backwadInt | (lastBit << (31 - i));

            }

            return backwadInt;
        }
    }

    public static class Solution2 {
        // you need treat n as an unsigned value
        public static int reverseBits(int n) {
            String s = new StringBuilder(Integer.toBinaryString(n)).toString();
            s = ("00000000000000000000000000000000" + s).substring(s.length());
            s = new StringBuilder(s).reverse().toString();
            return (int) Long.parseUnsignedLong(s, 2);
        }
    }

    public static void main(String[] args) {
        String helpMessage = "int string is expected as input e.g. \"12345\" ";
        if (args.length != 1) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);

        } else {
            Integer i = Integer.parseInt(args[0].toLowerCase(Locale.ROOT));

            System.out.println(new Solution().reverseBits(i));
            System.out.println(new Solution2().reverseBits(i));
        }
    }
}
