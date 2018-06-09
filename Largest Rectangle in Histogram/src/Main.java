import java.util.Scanner;

public class Main {

    public static int[] getArray(String[] text) {
        int[] nums = new int[text.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(text[i]);
        }
        return nums;
    }

    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    int[] numbers = getArray(in.nextLine().split(" "));
        int result = getLargestArea(numbers);
        System.out.println(result);
    }
    public static int current = 0;
    public static int biggest = 0;

    public static int getLargestArea(int[] nums) {
        int indexOfMin = 0;
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                indexOfMin = i;
                min = nums[i];
            }
        }
        //bottom
        if (nums.length <= 2) {
            return nums.length*nums[indexOfMin];
        }

        int[] before = new int[indexOfMin];
        for (int i = 0; i < before.length; i++) {
            before[i] = nums[i];
        }
        int[] after = new int[nums.length - 1 - indexOfMin];
        for (int i = 0; i < after.length; i++) {
            after[i] = nums[i+indexOfMin+1];
        }
        if (indexOfMin == 0) {
            return getLargestArea(after);
        }
        if (indexOfMin == nums.length-1) {
            return getLargestArea(before);
        }
        if (getLargestArea(before) > getLargestArea(after)) {
            return  getLargestArea(before);
        }
        return getLargestArea(after);

    }
}
