import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
    int N = input.nextInt();
    int result = BiggestPrime(N);
    System.out.println(result);
    }

    public static int BiggestPrime(int num) {
        int result = 0;
        for (int i = num; i > 1; i--) {
            if (IsPrime(i)) {
                result = i;
                break;
            }
        }
        return result;
    }

    public static boolean IsPrime(int num) {
        int status = 0;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                status = 1;
                break;
            }
        }
        if (status == 0) {
            return true;
        } else {
            return false;
        }
    }
}
