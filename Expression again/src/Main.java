import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static int N;
    public static ArrayList<Integer> usedPlus = new ArrayList<>();
    public static ArrayList<Integer> usedMinus = new ArrayList<>();
    public static ArrayList<Integer> usedMulti = new ArrayList<>();


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] arr = in.nextLine().split("");
        int[] nums = new int[arr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        N = in.nextInt();
        String mask = "";
        int input = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            input *= 10;
            input += nums[i];
            int[] numsNew = new int[nums.length - 1 - i];
            int index = 0;
            for (int j = i + 1; j < nums.length; j++) {
                numsNew[index] = nums[j];
                index++;
            }
            result += calculate(numsNew, input);
            if (input == 0) {
                break;
            }
        }
        System.out.println(result);
    }

    public static int calculate(int[] digits, int currentSum) {
        if  (digits.length == 0) {
            if (currentSum == N) {
                return 1;
            }
            return 0;
        }
        int count = 0;
        int number = 0;
        for (int i = 0; i < digits.length; i++) {
            number *= 10;
            number += digits[i];

            int[] numbers = new int[digits.length - 1];
            for (int j = i + 1; j < digits.length; j++) {
                numbers[j - 1] = digits[j];
            }
            if (number > 9) {
                boolean test = true;
                if (usedPlus.size() > 0) {
                    test = true;
                    for (int j = 0; j < usedPlus.size(); j++) {
                        if (number == usedPlus.get(i)){
                            test = false;
                            break;
                        }
                    }
                    if (test) {
                        usedPlus.add(number);
                        count += calculate(numbers, currentSum + number);
                    }
                } else {
                    usedPlus.add(number);
                }
                if (usedMulti.size() > 0) {
                    test = true;
                    for (int j = 0; j < usedMulti.size(); j++) {
                        if (number == usedMulti.get(i)){
                            test = false;
                            break;
                        }
                    }
                    if (test) {
                        usedMulti.add(number);
                        count += calculate(numbers, currentSum + number);
                    }
                } else {
                    usedMulti.add(number);
                }
                if (usedMinus.size() > 0) {
                    test = true;
                    for (int j = 0; j < usedMinus.size(); j++) {
                        if (number == usedMinus.get(i)){
                            test = false;
                            break;
                        }
                    }
                    if (test) {
                        usedMinus.add(number);
                        count += calculate(numbers, currentSum + number);
                    }
                } else {
                    usedMinus.add(number);
                }
            }
            count += calculate(numbers, currentSum + number);
            count += calculate(numbers, currentSum * number);
            count += calculate(numbers, currentSum - number);

            if (number == 0) {
                break;
            }
        }


        return count;
    }
}
