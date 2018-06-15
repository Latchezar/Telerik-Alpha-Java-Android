import org.omg.PortableInterceptor.INACTIVE;

import java.util.Scanner;

public class Main {

    public static int K;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(" ");
        int N = Integer.parseInt(input[0]);
        String directions[] = input[1].split("");
        K = Integer.parseInt(input[2]);
        for (int i = 0; i < ; i++) {
            getPassword(directions, );

        }
        System.out.println(result);
    }

    public static String result = new String();

    public static String getPassword(String[] steps, String password) {
        if (steps.length == 0) {
            --K;
            if (K == 0) {
                result = password;
            }
            int end = password.length() - 1;
            return password.substring(0, end);
        }

        if(steps[0].equals("=")) {
            for (int i = 0; i < 10; i++) {
                String[] after = new String[steps.length-1];
                for (int j = 1; j < steps.length; j++) {
                    after[j-1] = steps[j];
                }
                password = getPassword(after, password + Integer.toString(i));
                if (K == 0) {
                    break;
                }

            }
        } else if (steps[0].equals(">")){
            for (int i = 1; i < 10; i++) {
                String[] after = new String[steps.length-1];
                for (int j = 1; j < steps.length; j++) {
                    after[j-1] = steps[j];
                }
                password = getPassword(after, password + Integer.toString(i));
                if (K == 0) {
                    break;
                }
            }
        } else if (steps[0].equals("<")) {
            for (int i = 10; i > 0; i--) {
                String[] after = new String[steps.length-1];
                for (int j = 1; j < steps.length; j++) {
                    after[j-1] = steps[j];
                }
                password = getPassword(after, password + Integer.toString(i%10));
                if (K == 0) {
                    break;
                }
            }
        }
        return password;
    }
}
