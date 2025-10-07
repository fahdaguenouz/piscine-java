public class ExerciseRunner {

    public static void main(String[] args)  {

        System.out.println(DriverFactory.getDriver("Car").createTransport().getDistance());
        System.out.println(DriverFactory.getDriver("Plane").createTransport().getDistance());
    }
}