import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int count = 0;
    public static int girls;
    public static String[] skirts;
    public static int shirts;
    public static ArrayList<String> variations = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int K = in.nextInt();
        shirts = K;
        in.nextLine();
        String[] L = in.nextLine().split("");
        Arrays.sort(L);
        skirts = L.clone();

        int N = in.nextInt();
        girls = N;
        goneWild(0, 0, "");
        System.out.println(count);
        for (String text :
                variations) {
            System.out.println(text);
        }
    }
    public static ArrayList<String> usedSkirts = new ArrayList<>();

    public static void goneWild(int skirt, int shirt, String expression) {
        if (expression.length() == (girls * 2)) {
            variations.add(expression);
            count++;
            return;
        }

        for (int i = skirt; i < skirts.length; i++) {
            boolean checkSkirt = false;
            for (String usedSkirt :
                    usedSkirts) {
                if (usedSkirt.equals(skirts[i])) {
                    checkSkirt = true;
                    break;
                }
            }

            if (!checkSkirt) {
                usedSkirts.add(skirts[i]);
                for (int j = shirt; j < shirts - 1; j++) {
                    String nextShirt = Integer.toString(j);

                    goneWild(skirt + 1, shirt + 1, expression + nextShirt + skirts[i]);
                }
            }
        }




//        for (int i = shirt; i < shirts; i++) {
//            String nextShirt = Integer.toString(i);
//            for (int j = skirt; j < skirts.length; j++) {
//
//                goneWild(skirt + 1, shirt + 1, expression + nextShirt + skirts[j]);
//
//
//            }
//        }
        return;
    }
}
