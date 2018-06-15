import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] arr = in.nextLine().split(" ");
        int[] nums = new int[arr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        int target = in.nextInt();
        int[] result = new int[0];
        for (int i = 0; i < nums.length - 1; i++) {
            result = twoSumSolution(nums, target, i, i+ 1);
            if (result != null) {
                break;
            }
        }
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }


    public static int[] twoSumSolution(int[] nums, int target, int one, int two) {
        if (nums[one] + nums[two] == target) {
            int[] mask = {one, two};
            return mask;
        }

            for (int j = two; j < nums.length - 1; j++) {
                    return twoSumSolution(nums, target, one, j + 1);

            }

        return null;
    }

}
