import java.util.Scanner;

public class Main {

    public static int[] splitToDigits(String[] text) {
        int[] nums = new int[text.length];
        for (int i = 0; i < text.length; i++) {
            nums[i] = Integer.parseInt(text[i]);
        }
        return nums;
    }
    public static int[] counts = new int[10];

    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    int[] digits = splitToDigits(in.nextLine().split(""));
	    for (int x:
                counts) {
	        x = 0;
        }
        numerology(digits);

        for (int num :
                counts) {
            System.out.print(num + " ");
        }
	    //int equation = (a + b) * (a ^ b) % 10;
    }

    public static int calculate (int a, int b) {
        return (a + b) * (a ^ b) % 10;
    }

    public static void numerology(int[] digits) {
        if (digits.length == 1) {
            counts[digits[0]]++;
            return;
        }

        for (int i = 0; i < digits.length - 1; i++) {
            int[] mask = new int[digits.length-1];
            for (int j = 0; j < i; j++) {
                mask[j] = digits[j];
            }
            mask[i] = calculate(digits[i], digits[i+1]);
            for (int j = i + 2; j < digits.length ; j++) {
                mask[j - 1] = digits[j];
            }
            numerology(mask);
        }
    }
}
