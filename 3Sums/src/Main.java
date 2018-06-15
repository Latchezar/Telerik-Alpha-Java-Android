import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static ArrayList<int[]> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] arr = in.nextLine().split(" ");
        int[] nums = new int[arr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                calcSums(nums, i, j, j);
            }
        }
        for (int[] number:
             result) {
            for (int digit :
                    number) {
                    System.out.print(digit + " ");
            }
            System.out.println();

        }
    }


    public static void calcSums (int[] numbers, int a, int b, int c) {
        if (numbers[a] + numbers[b] + numbers[c] == 0 && b < c) {
            int[] mask = {numbers[a], numbers[b], numbers[c]};
            Arrays.sort(mask);
            boolean check = false;
            for (int[] nums :
                    result) {
                if (Arrays.equals(nums, mask)) {
                    check = true;
                }
            }
            if (!check) {
                result.add(mask);
            }
            return;
        }
        if  (c < numbers.length - 1) {
            calcSums(numbers, a, b, c + 1);
        }
        return;
    }
}
