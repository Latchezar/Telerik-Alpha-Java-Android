import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextInt();
        }
        int largest = 1;
        int current = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                current++;
                if (largest < current) {
                    largest = current;
                }
            } else {
                current = 1;
            }
        }
        System.out.println(largest);
    }
}
