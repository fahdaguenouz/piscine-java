public class WithColdMeats extends RacletteDecorator {

    public WithColdMeats(Raclette raclette) {
        super(raclette);
    }

    @Override
    public int getCalories() {
        return raclette.getCalories() + 350;
    }

    @Override
    public String getIngredients() {
        return raclette.getIngredients() + ", charcuterie";
    }

    @Override
    public String toString() {
        return getIngredients() + " pour " + getCalories() + " calories";
    }
}
