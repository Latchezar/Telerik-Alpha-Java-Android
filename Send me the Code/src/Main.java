import java.util.Scanner;

public class Main {

    public static int[] stringArrToIntArr(String[] text) {
        int[] nums;
        if (text[0].equals("-")) {
            nums = new int[text.length - 1];
            for (int i = 1; i < text.length; i++) {
                nums[i-1] = Integer.parseInt(text[i]);
            }
        } else {
            nums = new int[text.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(text[i]);
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] numbers = stringArrToIntArr(in.nextLine().split(""));
        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            if ((i + numbers.length) % 2 == 0) {
                result += (Math.pow(numbers[i], 2) * (numbers.length-i));
            } else {
                result += (numbers[i] * Math.pow(numbers.length-i, 2));
            }
        }
        int length = result % 10;
        if (length == 0) {
            System.out.println(result);
            System.out.println("Big Vik wins again!");
        } else {
            int S = 64 + (result % 26);
            String message = "";

             do {
                S += 1;
                if (S > 90) {
                    S -= 26;
                }
                message += Character.toString((char) S);
            } while (message.length() < length);
            System.out.println(result);
            System.out.println(message);
        }
    }
}