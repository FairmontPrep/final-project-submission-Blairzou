import java.util.*;

public class Pathfinding {

    // Static input map – change this to test different paths!
    static int[][] A = {
        {0,0,0,0,0,0,0,0,0,0,1},
        {0,0,0,0,0,0,0,0,0,0,1},
        {0,0,0,0,0,0,0,0,0,0,1},
        {0,0,0,0,0,0,0,0,0,0,1},
        {0,0,0,0,0,0,0,0,0,0,1},
        {0,0,0,0,0,0,0,0,0,0,1},
        {1,1,1,1,1,1,1,1,1,1,1}
    };

    static boolean[][] visited;
    static ArrayList<String> path = new ArrayList<>();

    public static void main(String[] args) {
        visited = new boolean[A.length][A[0].length];
        boolean found = false;

        // Find the starting point (a 1 on any wall)
        outer:
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (isEdge(i, j) && A[i][j] == 1) {
                    dfs(i, j);
                    found = true;
                    break outer;
                }
            }
        }

        if (found) {
            System.out.println("Answer List: " + path);
            printPath(path);
        } else {
            System.out.println("No path found.");
        }
    }

    public static void dfs(int row, int col) {
        if (row < 0 || row >= A.length || col < 0 || col >= A[0].length) return;
        if (A[row][col] != 1 || visited[row][col]) return;

        visited[row][col] = true;
        path.add("A[" + row + "][" + col + "]");

        // explore neighbors in order: right, down, left, up
        dfs(row, col + 1);
        dfs(row + 1, col);
        dfs(row, col - 1);
        dfs(row - 1, col);
    }

    public static boolean isEdge(int i, int j) {
        return i == 0 || j == 0 || i == A.length - 1 || j == A[0].length - 1;
    }

    public static void printPath(ArrayList<String> path) {
        String[][] output = new String[A.length][A[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                output[i][j] = " ";
            }
        }

        for (String coord : path) {
            int row = Integer.parseInt(coord.substring(coord.indexOf('[') + 1, coord.indexOf(']')));
            int col = Integer.parseInt(coord.substring(coord.lastIndexOf('[') + 1, coord.lastIndexOf(']')));
            output[row][col] = "1";
        }

        for (int i = 0; i < output.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < output[0].length; j++) {
                System.out.print(output[i][j] + " ");
            }
            System.out.println("]");
        }
    }
}
