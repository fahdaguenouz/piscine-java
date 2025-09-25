
public class CelestialObject {
  public double x;
  public double y;
  public double z;
  public String name;

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
}
