import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    static HashSet<String> brackets = new HashSet<>();
    public static HashSet<String> generateExpression (String expression, int n) {
        if (expression.length() == n) {
            brackets.add(expression);


            return brackets;
        }

        HashSet<String> currentBrackets = generateExpression(expression+"()", n);
        brackets.addAll(currentBrackets);

        currentBrackets = generateExpression("()" + expression, n);
        brackets.addAll(currentBrackets);


        currentBrackets = generateExpression("(" + expression + ")", n);
        brackets.addAll(currentBrackets);

        return brackets;

    }

    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    int N = in.nextInt();
        generateExpression("", N);
        for (String text :
                brackets) {
            System.out.println(text);
        }
    }
}
