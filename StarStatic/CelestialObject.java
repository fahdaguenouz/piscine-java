
public class CelestialObject {
  public double x;
  public double y;
  public double z;
  public String name;
    public static final  double KM_IN_ONE_AU=150000000;
  public CelestialObject() {
    this.x = 0.0;
    this.y = 0.0;
    this.z = 0.0;
    this.name = "Soleil";
  }
  public CelestialObject(String name, double x, double y, double z) {
    this.name = name;
    this.x = x;
    this.y = y;
    this.z = z;
  }
   public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
     public static double getDistanceBetween(CelestialObject a, CelestialObject b) {
        double dx = a.x - b.x;
        double dy = a.y - b.y;
        double dz = a.z - b.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public static double getDistanceBetweenInKm(CelestialObject a, CelestialObject b) {
        return getDistanceBetween(a, b) * KM_IN_ONE_AU;
    }
}
