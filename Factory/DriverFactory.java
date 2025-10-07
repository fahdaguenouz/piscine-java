public class DriverFactory {
    public static Driver getDriver(String type) {
        if (type.equalsIgnoreCase("Car")) {
            return new CarDriver();
        } else if (type.equalsIgnoreCase("Plane")) {
            return new PlaneDriver();
        }
        return null;
    }
}
