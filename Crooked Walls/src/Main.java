import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = in.readLine().split(" ");
        long[] nums = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }

        long[] differences = new long[nums.length-1];
        for (int i = 1; i < nums.length; i++) {
            long difference = getDifference(nums[i - 1], nums[i]);
            if (difference % 2 != 0) {
                differences[i-1] = difference;
            } else if (difference % 2 == 0) {
                differences[i-1] = difference;
                i++;
            }
        }

        BigInteger finalResult = BigInteger.ZERO;
        for (int i = 0; i < differences.length; i++) {
            if (differences[i] % 2 == 0 && differences[i] != 0) {
                String mask = Long.toString(differences[i]);
                finalResult = finalResult.add(new BigInteger(mask));
            }
        }
        System.out.println(finalResult);
    }

    public static long getDifference(long a, long b) {
        long result;
        if (a > 0 && b > 0) {
            if (a < b) {
                long mask = a;
                a = b;
                b = mask;
            }
            result = a - b;
        } else if (a < 0 && b > 0) {
            result = Math.abs(a) + b;
        } else if (a > 0 && b < 0) {
            result = Math.abs(b) + a;
        } else {
            a = Math.abs(a);
            b = Math.abs(b);
            if (a < b) {
                long mask = a;
                a = b;
                b = mask;
            }
            result = a - b;
        }
        return result;
    }
}
