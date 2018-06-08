import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int startRow;
    static int startCol;
    static int endRow;
    static int endCol;
    static boolean[][] beenThere;
    static String[][] maze;
    static ArrayList<ArrayList<Integer>> coordinates = new ArrayList<>();


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        startRow = in.nextInt();
        startCol = in.nextInt();
        endRow = in.nextInt();
        endCol = in.nextInt();
        maze = new String[N][M];
        in.nextLine();
        for (int i = 0; i < maze.length; i++) {
            maze[i] = in.nextLine().split("");
        }
        beenThere = new boolean[N][M];
        coordinates.add(route(startRow, startCol));

    }

    public static ArrayList<Integer> route(int currentRow, int currentCol) {
        ArrayList<Integer> current = new ArrayList<>();
            current.add(currentRow);
            current.add(currentCol);
        beenThere[currentRow][currentCol] = true;
        if (currentRow == endRow && currentCol == endCol) {

            return current;
        }


        if (currentRow == endRow) {
            if (currentCol < endCol && !beenThere[currentRow][currentCol++]) {
                return route(currentRow, currentCol++);
            } else if (currentCol > endCol && !beenThere[currentRow][currentCol--]){
                return route(currentRow, currentCol--);
            }

        } else if (currentRow < endRow) {
            if (!beenThere[currentRow++][currentCol]) {
                return route(currentRow++, currentCol);
            }
        } else if (currentRow > endRow) {
            if (!beenThere[currentRow--][currentCol]) {
                return route(currentRow--, currentCol);
            }
        } else {
            if (currentRow > 0 && !beenThere[currentRow-1][currentCol]) {
                return route(currentRow--, currentCol);
            } else if (currentCol < maze[0].length - 1 && !beenThere[currentRow][currentCol++]) {
                return route(currentRow, currentCol++);
            } else if (currentRow < maze.length - 1 && !beenThere[currentRow++][currentCol]) {
                return route(currentRow++, currentCol);
            } else if (currentCol > 0 && !beenThere[currentRow][currentCol--]) {
                return route(currentRow, currentCol--);
            }
        }
        current = new ArrayList<>();
        return current;
    }
}
