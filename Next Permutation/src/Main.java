    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.Scanner;

    public class Main {

        public static int N;

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            N = in.nextInt();
            int[] digits = new int[N];
            for (int i = 0; i < digits.length; i++) {
                digits[i] = i + 1;
            }
            in.nextLine();
            String[] arr = in.nextLine().split(" ");
            int[] toCompare = new int[arr.length];
            for (int i = 0; i < toCompare.length; i++) {
                toCompare[i] = Integer.parseInt(arr[i]);
            }
            String input = new String();
            for (int num :
                    digits) {
                input += Integer.toString(num);
            }
            result = new ArrayList<>();
            int[] nothing = new int[0];
            permutations(nothing, digits);
            //print
            int status = 0;
            for (int[] txt :
                    result) {
                for (int num :
                        txt) {
                    if (status == 1) {
                        System.out.print(num + " ");
                    }
                }
                if (status == 1) {
                    break;
                }
                if (Arrays.equals(toCompare, txt)) {
                    status = 1;
                }
            }

        }

        static ArrayList<int[]> result;

        public static int[] permutations(int[] starting, int[] text) {
            if (text.length == 1) {
                result.add(new int[N]);
                for (int i = 0; i < starting.length; i++) {
                    result.get(result.size() - 1)[i] = starting[i];
                }
                result.get(result.size() - 1)[N - 1] = text[0];
                return text;
            }

            for (int i = 0; i < text.length; i++) {
                int[] mask = text.clone();
                int[] retext = new int[text.length - 1];
                for (int j = 0; j < i; j++) {
                    retext[j] = mask[j];

                }
                for (int j = i + 1; j < mask.length; j++) {
                    retext[j - 1] = mask[j];
                }
                int[] next = new int[starting.length + 1];
                for (int j = 0; j < next.length - 1; j++) {
                    next[j] = starting[j];
                }
                next[next.length - 1] = mask[i];
                permutations(next, retext);

            }
            return null;
        }
    }