import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static int[][] matrix;
    public static boolean[][] beenThere;


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //Scanner in = new Scanner(System.in);
        //get parameters for matrix
        String[] asd = in.readLine().split(" ");
        int N = Integer.parseInt(asd[0]);
        int M = Integer.parseInt(asd[1]);
        matrix = new int[N][M];
        beenThere = new boolean[N][M];
        // fill the matrix
        for (int i = 0; i < matrix.length; i++) {
            String[] strI = in.readLine().split(" ");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Integer.parseInt(strI[j]);
            }
        }

        int result = 0;
                //getLargestArea(matrix, 0, 0);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int current;
                if (beenThere[i][j]){
                    current = 0;
                } else {
                    current = 1 + getLargestArea(matrix, i, j);
                }
                if (current > result) {
                    result = current;
                }
            }
        }
        System.out.println(result);
    }


    public static int getLargestArea (int[][] nums, int row, int col) {
        if (!((row > 0 && nums[row - 1][col] == nums[row][col]) || (row < nums.length - 1 && nums[row + 1][col] == nums[row][col]) || (col > 0 && nums[row][col - 1] == nums[row][col]) || (col < nums[row].length - 1 && nums[row][col + 1] == nums[row][col]))){
            return 0;
        }
        int result = 0;
        beenThere[row][col] = true;
        if (row > 0 && !beenThere[row - 1][col]) {
            if (nums[row][col] == nums[row-1][col]) {
                result += 1 + getLargestArea(nums, row - 1, col);
            }
        }
        if (row < nums.length - 1 && !beenThere[row + 1][col]) {
            if (nums[row][col] == nums[row+1][col]) {
                result += 1 + getLargestArea(nums, row + 1, col);
            }
        }
        if (col > 0 && !beenThere[row][col - 1]) {
            if (nums[row][col]== nums[row][col-1]) {
                result += 1 + getLargestArea(nums, row, col - 1);
            }
        }
        if (col < nums[row].length - 1 && !beenThere[row][col + 1]) {
            if (nums[row][col] == nums[row][col+1]) {
                result += 1 + getLargestArea(nums, row, col + 1);
            }
        }
        return result;
    }
}
