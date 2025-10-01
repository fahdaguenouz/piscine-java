import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WeddingComplex {
    public static Map<String, String> createBestCouple(Map<String, List<String>> first, Map<String, List<String>> second) {
        // your code here
        Map<String, String> matches = new HashMap<>();

        Set<String> freeMen = new HashSet<>(first.keySet());

        Map<String, String> womenPartners = new HashMap<>();

        while (!freeMen.isEmpty()) {
            String man = freeMen.iterator().next();

            List<String> women = first.get(man);

            for (String woman : women) {
                if (!womenPartners.containsKey(woman)) {
                    womenPartners.put(woman, man);
                    matches.put(man, woman);
                    freeMen.remove(man);  
                    break;
                } else {
                    String currentPartner = womenPartners.get(woman);
                    List<String> womanPreferences = second.get(woman);

                    if (womanPreferences.indexOf(man) < womanPreferences.indexOf(currentPartner)) {
                        womenPartners.put(woman, man);
                        matches.put(man, woman);
                        freeMen.remove(man);
                        freeMen.add(currentPartner); 
                        break;
                    }
                }
            }
        }

        return matches;
    }
}