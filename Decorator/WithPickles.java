public class WithPickles extends RacletteDecorator {

    public WithPickles(Raclette raclette) {
        super(raclette);
    }

    @Override
    public int getCalories() {
        return raclette.getCalories() + 50;
    }

    @Override
    public String getIngredients() {
        return raclette.getIngredients() + ", cornichons";
    }

    @Override
    public String toString() {
        return getIngredients() + " pour " + getCalories() + " calories";
    }
}
