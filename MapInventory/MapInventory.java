import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapInventory {
   public static int getProductPrice(Map<String, Integer> inventory, String productId) {
        if (inventory == null || productId == null || !inventory.containsKey(productId)) {
            return -1;
        }
        return inventory.get(productId);
    }
    public static List<String> getProductIdsByPrice(Map<String, Integer> inventory, int price) {
       List<String> items= new ArrayList<>();
        if (inventory == null) {
            return items;
        }

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            if (entry.getValue() == price) {
                items.add(entry.getKey());
            }
        }

        return items;
    }
}