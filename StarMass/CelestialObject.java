import java.util.Objects;

public class CelestialObject {
  private  double x;
  private  double y;
  private  double z;
  private  String name;
  private int mass;
    public static final  double KM_IN_ONE_AU=150000000;
  public CelestialObject() {
    this.x = 0.0;
    this.y = 0.0;
    this.z = 0.0;
    this.mass=0;
    this.name = "Soleil";
  }
  public CelestialObject(String name, double x, double y, double z,int mass) {
    this.name = name;
    this.x = x;
    this.y = y;
    this.z = z;
    this.mass=mass;
  }
    public int getMass() { return mass; }
    public void setMass(int mass) { this.mass = mass; }
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
    @Override
    public  String toString(){
        return String.format("%s is positioned at (%.3f, %.3f, %.3f)", name, x, y, z);
    }
    @Override
     public boolean equals(Object obj) {
        if (this == obj) return true; 
        if (obj == null || getClass() != obj.getClass()) return false;

        CelestialObject other = (CelestialObject) obj;
        return Double.compare(other.x, x) == 0 &&
               Double.compare(other.y, y) == 0 &&
               Double.compare(other.z, z) == 0 &&
               Objects.equals(name, other.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, name);
    }
}
