import java.util.ArrayList;
import java.util.List;

public class ListSearchIndex {

    public static Integer findFirstIndex(List<Integer> list, Integer value) {
        if (list == null) return null;
        int index = list.indexOf(value);
        return index != -1 ? index : null;
    }

    public static Integer findLastIndex(List<Integer> list, Integer value) {
        if (list == null) return null;
        int index = list.lastIndexOf(value);
        return index != -1 ? index : null;
    }

    public static List<Integer> findAllIndexes(List<Integer> list, Integer value) {
        List<Integer> indexes = new ArrayList<>();
        if (list == null) return indexes;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(value)) {
                indexes.add(i);
            }
        }
        return indexes;
    }
}