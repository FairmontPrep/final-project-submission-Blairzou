import java.util.ArrayList;
import java.util.Arrays;

public class MapProvider {
    public static ArrayList<ArrayList<Integer>> getMap() {
        ArrayList<ArrayList<Integer>> map = new ArrayList<>();

        map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 1, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 1, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(1, 1, 0, 1, 1, 1, 1, 0)));
        map.add(new ArrayList<>(Arrays.asList(9, 0, 0, 3, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(8, 0, 0, 1, 1, 1, 1, 1)));
        map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 1, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(1, 0, 0, 1, 2, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 1, 1, 1, 1, 0)));

        return map;
    }
}




