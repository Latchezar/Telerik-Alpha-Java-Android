import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    int N = in.nextInt();
	    int K = in.nextInt();
	    int[] nums = new int[N];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums);
        int sum = 0;
        for (int i = nums.length - 1; i > nums.length - K - 1; i--) {
            sum+= nums[i];
        }
        System.out.println(sum);
    }
}
