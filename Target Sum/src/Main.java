import java.util.Scanner;

public class Main {

    public static int[] splitString(String[] text) {
        int[] nums = new int[text.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(text[i]);
        }
        return nums;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] numbers = splitString(in.nextLine().split(" "));
        int targetSum = in.nextInt();
        int result = solve(0, numbers, 0, targetSum);
        System.out.println(result);
    }

    public static int solve(int index, int[] nums, int current, int target) {
        if (index == nums.length) {
            if (current == target) {
                return 1;
            }
            return 0;
        }

        int count = 0;
        count += solve(index + 1, nums, current+nums[index], target);
        count += solve(index + 1, nums, current-nums[index], target);
        return count;
    }
}
