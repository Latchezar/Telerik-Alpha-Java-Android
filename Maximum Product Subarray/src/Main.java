import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] arrNums = in.nextLine().split(" ");
        int[] numbers = new int[arrNums.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(arrNums[i]);
        }

        for (int i = 0; i < numbers.length; i++) {
            calculate(numbers, numbers[i], i);
        }
        System.out.println(product);
    }

    public static int product = Integer.MIN_VALUE;

    public static void calculate(int[] digits, int currentProduct, int index) {
        if (currentProduct > product) {
            product = currentProduct;
        }

        if (index < digits.length - 1) {
            calculate(digits, currentProduct * digits[index + 1], index + 1);
        }
        return;
    }
}
