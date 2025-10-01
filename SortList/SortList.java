import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortList {

    public static List<Integer> sort(List<Integer> list) {
        if (list == null) return null;

        List<Integer> sorted = new ArrayList<>(list); 
        Collections.sort(sorted); 
        return sorted;
    }


    public static List<Integer> sortReverse(List<Integer> list) {
        if (list == null) return null;

        List<Integer> sorted = new ArrayList<>(list); 
        sorted.sort(Comparator.reverseOrder()); 
        return sorted;
    }
}