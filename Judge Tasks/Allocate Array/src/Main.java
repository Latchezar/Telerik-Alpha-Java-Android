import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    int N = input.nextInt();
	    int[] nums = new int[N];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i*5;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
