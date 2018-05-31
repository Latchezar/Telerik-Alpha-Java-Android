import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    int N = in.nextInt();
	    int[] nums = new int[N];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextInt();
        }
        int largest = 0;
        for (int i = 0; i < nums.length-1; i++) {
            int current = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                current += nums[j];
                if (current > largest) {
                    largest = current;
                }
            }
        }
        System.out.println(largest);
    }
}
