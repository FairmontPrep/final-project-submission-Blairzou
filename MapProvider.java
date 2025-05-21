import java.util.ArrayList;
import java.util.Arrays;


public class MapProvider {
    public static ArrayList<ArrayList<Object>> getMap() {
        ArrayList<ArrayList<Object>> map = new ArrayList<>();
        map.add(new ArrayList<>(Arrays.asList(0, 1, 1, 0, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(0, 0, 1, 1, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(0, 1, 0, 1, 0, 0, 1, 0)));
        map.add(new ArrayList<>(Arrays.asList(9, 1, 0, 1, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(8, 1, 0, 1, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(0, 1, 0, 1, 0, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(1, 1, 0, 1, 2, 0, 0, 0)));
        map.add(new ArrayList<>(Arrays.asList(0, 0, 0, 1, 1, 1, 1, 1)));
        return map;
    }
}



