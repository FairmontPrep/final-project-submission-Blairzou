import java.util.ArrayList;

public class Client {
    private static ArrayList<ArrayList<Integer>> test_array_2 = MapProvider.getMap();

    public static void main(String[] args) {
        new Client().run();
    }

    public void run() {
        ArrayList<String> path = findPath();
        printPath(path);
        printVisualMap(path);
    }

    private ArrayList<String> findPath() {
        ArrayList<int[]> starts = new ArrayList<>();
        int rows = test_array_2.size();
        int cols = test_array_2.get(0).size();

        for (int col = 0; col < cols; col++) {
            if (test_array_2.get(0).get(col) == 1) starts.add(new int[]{0, col});
            if (test_array_2.get(rows - 1).get(col) == 1) starts.add(new int[]{rows - 1, col});
        }
        for (int row = 0; row < rows; row++) {
            if (test_array_2.get(row).get(0) == 1) starts.add(new int[]{row, 0});
            if (test_array_2.get(row).get(cols - 1) == 1) starts.add(new int[]{row, cols - 1});
        }

        for (int[] start : starts) {
            ArrayList<String> path = new ArrayList<>();
            boolean[][] visited = new boolean[rows][cols];

            if (findPath(start[0], start[1], visited, path) && hasValidTurn(path)) {
                return path;
            }
        }
        return new ArrayList<>();
    }

    private boolean findPath(int row, int col, boolean[][] visited, ArrayList<String> path) {
        if (row < 0 || row >= test_array_2.size() || col < 0 || col >= test_array_2.get(0).size()) {
            return isExitPoint(row, col, path);
        }

        if (visited[row][col] || test_array_2.get(row).get(col) != 1) return false;

        visited[row][col] = true;
        path.add("A[" + row + "][" + col + "]");

        if (isExitPoint(row, col, path)) return true;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] dir : directions) {
            if (findPath(row + dir[0], col + dir[1], visited, path)) return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    private boolean isExitPoint(int row, int col, ArrayList<String> path) {
        if (path.size() < 2) return false;

        int rows = test_array_2.size();
        int cols = test_array_2.get(0).size();

        boolean onWall = (row < 0 || row >= rows || col < 0 || col >= cols);
        if (!onWall) return false;

        int firstRow = Integer.parseInt(path.get(0).split("\\[|\\]")[1]);
        boolean startedVertical = (firstRow == 0 || firstRow == rows - 1);

        return startedVertical ? (col < 0 || col >= cols) : (row < 0 || row >= rows);
    }

    private boolean hasValidTurn(ArrayList<String> path) {
        if (path.size() < 3) return false;

        String[] first = path.get(0).split("\\[|\\]");
        String[] second = path.get(1).split("\\[|\\]");
        int row1 = Integer.parseInt(first[1]);
        int row2 = Integer.parseInt(second[1]);
        boolean initialVertical = (row1 != row2);

        for (int i = 2; i < path.size(); i++) {
            int currRow = Integer.parseInt(path.get(i).split("\\[|\\]")[1]);
            int prevRow = Integer.parseInt(path.get(i - 1).split("\\[|\\]")[1]);
            boolean currentVertical = (currRow != prevRow);
            if (currentVertical != initialVertical) return true;
        }
        return false;
    }

    private void printPath(ArrayList<String> path) {
        System.out.println("Path Coordinates:");
        System.out.println(path.isEmpty() ? "No valid path" : path);
    }

    private void printVisualMap(ArrayList<String> path) {
        System.out.println("\nVisual Representation of Path:");
        if (path.isEmpty()) {
            System.out.println("No path to display");
            return;
        }

        int rows = test_array_2.size();
        int cols = test_array_2.get(0).size();
        String[][] grid = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = " ";
            }
        }

        for (String coord : path) {
            String[] parts = coord.split("\\[|\\]");
            int row = Integer.parseInt(parts[1]);
            int col = Integer.parseInt(parts[3]);
            grid[row][col] = "1";
        }

        for (String[] row : grid) {
            System.out.print("[");
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i]);
                if (i < row.length - 1) System.out.print(",");
            }
            System.out.println("]");
        }
    }
}
