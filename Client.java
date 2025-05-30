import java.util.ArrayList;


public class Client {


    static ArrayList<ArrayList<Object>> A = MapProvider.getMap();


    public static void main(String[] args) {
        findPathAndPrint(A);
    }


    public static void findPathAndPrint(ArrayList<ArrayList<Object>> map) {
        ArrayList<String> path = new ArrayList<>();
        boolean[][] visited = new boolean[map.size()][map.get(0).size()];


        int[] start = findStart(map);
        if (start == null) {
            System.out.println("No starting point found.");
            return;
        }


        dfs(map, visited, start[0], start[1], path);


        System.out.println("Path coordinates:");
        System.out.println(path);


        System.out.println("\nPath visualized:");
        printPath(map, path);
    }


    public static int[] findStart(ArrayList<ArrayList<Object>> map) {
        int rows = map.size();
        int cols = map.get(0).size();


        for (int col = 0; col < cols; col++) {
            if (getValue(map, 0, col) == 1 && hasNeighbor(map, 0, col)) return new int[]{0, col};
            if (getValue(map, rows - 1, col) == 1 && hasNeighbor(map, rows - 1, col)) return new int[]{rows - 1, col};
        }
        for (int row = 0; row < rows; row++) {
            if (getValue(map, row, 0) == 1 && hasNeighbor(map, row, 0)) return new int[]{row, 0};
            if (getValue(map, row, cols - 1) == 1 && hasNeighbor(map, row, cols - 1)) return new int[]{row, cols - 1};
        }
        return null;
    }


    public static boolean hasNeighbor(ArrayList<ArrayList<Object>> map, int row, int col) {
        int rows = map.size();
        int cols = map.get(0).size();
        if (row > 0 && getValue(map, row - 1, col) == 1) return true;
        if (row < rows - 1 && getValue(map, row + 1, col) == 1) return true;
        if (col > 0 && getValue(map, row, col - 1) == 1) return true;
        if (col < cols - 1 && getValue(map, row, col + 1) == 1) return true;
        return false;
    }


    public static int getValue(ArrayList<ArrayList<Object>> map, int row, int col) {
        try {
            Object value = map.get(row).get(col);
            if (value instanceof Integer) {
                return (Integer) value;
            } else {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }


    public static void dfs(ArrayList<ArrayList<Object>> map, boolean[][] visited, int row, int col, ArrayList<String> path) {
        if (row < 0 || col < 0 || row >= map.size() || col >= map.get(0).size()) return;
        if (getValue(map, row, col) != 1 || visited[row][col]) return;


        visited[row][col] = true;
        path.add("A[" + row + "][" + col + "]");


        if (row > 0 && getValue(map, row - 1, col) == 1 && !visited[row - 1][col]) dfs(map, visited, row - 1, col, path);
        if (row < map.size() - 1 && getValue(map, row + 1, col) == 1 && !visited[row + 1][col]) dfs(map, visited, row + 1, col, path);
        if (col > 0 && getValue(map, row, col - 1) == 1 && !visited[row][col - 1]) dfs(map, visited, row, col - 1, path);
        if (col < map.get(0).size() - 1 && getValue(map, row, col + 1) == 1 && !visited[row][col + 1]) dfs(map, visited, row, col + 1, path);
    }


    public static void printPath(ArrayList<ArrayList<Object>> map, ArrayList<String> path) {
        String[][] display = new String[map.size()][map.get(0).size()];


        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(0).size(); j++) {
                display[i][j] = " ";
            }
        }


        for (String pos : path) {
            int row = Integer.parseInt(pos.substring(pos.indexOf('[') + 1, pos.indexOf(']')));
            int col = Integer.parseInt(pos.substring(pos.lastIndexOf('[') + 1, pos.lastIndexOf(']')));
            display[row][col] = "1";
        }


        for (String[] row : display) {
            for (String cell : row) {
                System.out.print("[ " + cell + " ]");
            }
            System.out.println();
        }
    }
}

 
