public class Excalibur {
    private String name;

    private static Excalibur INSTANCE;

    private Excalibur(String name) {
        this.name = name;
    }

    public static Excalibur getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Excalibur("Sword");
        }
        return INSTANCE;
    }

    public String getName() {
        return name;
    }
}
