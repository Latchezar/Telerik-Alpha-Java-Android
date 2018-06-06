import java.util.Scanner;

public class Main {
    public static void printMatrix (int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == matrix[i].length - 1) {
                    System.out.print(matrix[i][j]);
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    int N = in.nextInt();
	    int[][] matrix = new int[N][N];
	    matrix = horsePath(matrix, 0,0,1);
        printMatrix(matrix);
    }

    public static int[][] horsePath(int[][] board, int row, int col, int index) {
        if(index == board.length*board.length) {
            board[row][col] = index;
            return board;
        }

        board[row][col] = index;

        index++;
        if (row - 2 >= 0 && col - 1 >= 0 && board[row-2][col-1] == 0) {
            row-=2;
            col--;
        }
        else if (row - 2 >= 0 && col + 1 <= board.length -1 && board[row-2][col+1] == 0) {
            row-=2;
            col++;
        }
        else if (row - 1 >= 0 && col - 2 >= 0 && board[row-1][col-2] == 0) {

            row--;
            col-=2;
        }
        else if (row - 1 >= 0 && col + 2 <= board.length - 1 && board[row-1][col+2] == 0) {
            row--;
            col+=2;
        }
        else if (row + 1 <= board.length - 1 && col - 2 >=0 && board[row+1][col-2] == 0) {
            row++;
            col-=2;
        }
        else if (row + 1 <= board.length - 1 && col + 2 <= board.length - 1 && board[row+1][col+2] == 0) {
            row++;
            col+=2;
        }
        else if (row + 2 <= board.length - 1 && col - 1 >= 0 && board[row+2][col-1] == 0) {
            row+=2;
            col--;
        }
        else if (row + 2 <= board.length - 1 && col + 1 <= board.length - 1 && board[row+2][col+1] == 0) {
            row +=2;
            col++;
        } else {
            for (int j = 0; j < board.length; j++) {
                int mask = 0;
                for (int k = 0; k < board.length; k++) {
                    if (board[j][k] == 0) {
                        row = j;
                        col = k;
                        mask = k;
                        break;

                    }
                }
                if (row == j && col == mask) {
                    break;
                }
            }
        }
        return horsePath(board, row, col, index);
    }
}
