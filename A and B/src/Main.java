import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<String> variations = new ArrayList<>();
    public static String a;
    public static String b;

    public static String generateExpression(String expression, int n, String[] elements) {
        if (expression.length() == n) {
            variations.add(expression);
            return expression.substring(0, expression.length()-2);
        }
        for (int i = 0; i < elements.length; i++) {
            generateExpression(expression + elements[i], n, elements);
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        String[] arrAB = in.nextLine().split(" ");
        a = arrAB[0];
        b = arrAB[1];
        if (Integer.parseInt(a) > Integer.parseInt(b)) {
            arrAB[0] = b;
            arrAB[1] = a;
        }
        if (N == 1) {
            variations.add(arrAB[0]);
            variations.add(arrAB[1]);
        } else {
            generateExpression("", N, arrAB);
        }
        for (String text :
                variations) {
            System.out.println(text);
        }
    }
}
