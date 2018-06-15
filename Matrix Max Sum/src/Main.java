import java.util.Scanner;

public class Main {

    public static int determineEndCol(int input) {
        return Math.abs(input) - 1;
    }

    public static int determineEndRow(int input, int len) {
        if (input > 0) {
            return 0;
        }
        return len-1;
    }

    public static int determineStartCol(int input, int len) {
        if (input > 0) {
            return 0;
        }
        return len-1;
    }

    public static int determineStartRow(int input) {
        return Math.abs(input) - 1;
    }

    public static int[][] matrix;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        matrix = new int[N][];
        in.nextLine();
        for (int i = 0; i < matrix.length; i++) {
            String[] text = in.nextLine().split(" ");
            matrix[i] = new int[text.length];
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Integer.parseInt(text[j]);
            }
        }
        String[] mask = in.nextLine().split(" ");
        int[] pairs = new int[mask.length];
        for (int i = 0; i < pairs.length; i++) {
            pairs[i] = Integer.parseInt(mask[i]);
        }
        long biggest = Long.MIN_VALUE;

        for (int i = 0; i < pairs.length; i+=2) {
//            int row = determineStartRow(pairs[i]);
//            int col = determineStartCol(pairs[i+1], matrix[0].length);
//            int endRow = determineEndRow(pairs[i], matrix.length);
//            int endCol = determineEndCol(pairs[i+1]);
           // long current = getSum(row, col, endRow, endCol);
            long current = 0;
//            do {
//                current += matrix[row][col];
//                if (col != endCol) {
//                    if (col < endCol) {
//                        ++col;
//                    } else if (col > endCol) {
//                        --col;
//                    }
//                }else {
//                    if (row < endRow) {
//                        ++row;
//                    } else if (row > endRow) {
//                        --row;
//                    }
//                }
//            }while (row != endRow || col != endCol);
//            current += matrix[row][col];
//            if (current > biggest) {
//                biggest = current;
//            }
//        }
        System.out.println(biggest);
    }

//    public static long getSum(int row, int col, int endR, int endC) {
//        if (row == endR && col == endC) {
//            return matrix[row][col];
//        }
//
//        if (col < endC) {
//            return matrix[row][col] + getSum(row, col + 1, endR, endC);
//        } else if (col > endC) {
//            return matrix[row][col] + getSum(row, col - 1, endR, endC);
//        }
//        if (row < endR) {
//            return matrix[row][col] + getSum(row + 1, col, endR, endC);
//        }
//        return matrix[row][col] + getSum(row - 1, col, endR, endC);
//    }
}