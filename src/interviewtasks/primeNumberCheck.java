package interviewtasks;
/**
 * This is an example of solution of determining if a number is "prime" one.
 * A prime number is a natural number greater than 1 that is not a product of two smaller natural numbers.
 * A natural number greater than 1 that is not prime is called a composite number.
 *
 * @author ksiv
 */


import static interviewtasks.paramChecker.isStringLongValue;

public class primeNumberCheck {
    static long numberToCheck = 0;

    public static void main(String[] args) {
        String helpMessage = "one input parameter of type \"long\" with value more than \"0\" is expected";

        if (args.length != 1) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return;
        } else if (!isStringLongValue(args[0])) {
            System.out.println("argument is not a Long number");
            System.out.println(helpMessage);
            return;
        } else {
            numberToCheck = Long.parseLong(args[0]);

            primeNumberCheck(numberToCheck);

        }
    }

    // ~O(sqrt(N))/2 maybe :-)
    private static void primeNumberCheck(long numberToCheck) {
        String output = "";
        if (numberToCheck == 1) {
            System.out.println("1 is not a prime");
        } else if (numberToCheck > 2 && (numberToCheck % 2) == 0) {
            // Even number check
            System.out.println("not a prime( factor 2)");
        } else {
            // No extra check for xx0 and xx5 divisibility by 5 for 5 would be the second check in the loop

            int i = 1;
            // This will loop odd numbers from 3 to int(sqrt(x))
            // Some smart guy has found it out that there is no need to check
            // any values bigger than sqrt of a number
            // There are room for perfection like excluding divisors which are products of 3 and 5
            // but it requires an in-depth research of the costs of such checks
            long numberToCheckSquareRoot = (long) Math.sqrt(numberToCheck);
            while (i <= numberToCheckSquareRoot) {
                i += 2; // Removes all even divisors
                // Check if i divides numberToCheck without leaving a remainder
                if (numberToCheck % i == 0) {
                    // This means that n has a factor in between 3 and sqrt(n)
                    // So it is not a prime number
                    output = "not a prime, factor found: " + i;
                    break;
                }
            }
            if (output == "") {
                output = numberToCheck + " is a prime";
            }
            System.out.println(output);

        }

    }


}
