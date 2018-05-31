import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    int N = in.nextInt();
	    int[] nums = new int[N];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums);
        int num = nums[0];
        int count = 1;
        int current = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                current++;
                if (count < current) {
                    count = current;
                    num = nums[i];
                }
            } else {
                current = 1;
            }
        }
        System.out.println(num + " (" + count + " times)");
    }
}