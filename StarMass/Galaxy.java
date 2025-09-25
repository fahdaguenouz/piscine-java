import java.util.*;


public class Galaxy  {
    private List<CelestialObject>  celestialObjects;
    public Galaxy(){
        celestialObjects=new ArrayList<>();
    }
 public List<CelestialObject> getCelestialObjects() {
        return celestialObjects;
    }

    public void addCelestialObject(CelestialObject obj) {
        celestialObjects.add(obj);
    }
     public Map<String, Integer> computeMassRepartition() {
        Map<String, Integer> massMap = new HashMap<>();
        massMap.put("Star", 0);
        massMap.put("Planet", 0);
        massMap.put("Other", 0);

        for (CelestialObject obj : celestialObjects) {
            if (obj instanceof Star) {
                massMap.put("Star", massMap.get("Star") + obj.getMass());
            } else if (obj instanceof Planet) {
                massMap.put("Planet", massMap.get("Planet") + obj.getMass());
            } else {
                massMap.put("Other", massMap.get("Other") + obj.getMass());
            }
        }
        return massMap;
    }
}
