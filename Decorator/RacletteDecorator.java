public abstract class RacletteDecorator implements Raclette {
    protected Raclette raclette;

    public RacletteDecorator(Raclette raclette) {
        this.raclette = raclette;
    }

    @Override
    public int getCalories() {
        return raclette.getCalories();
    }

    @Override
    public String getIngredients() {
        return raclette.getIngredients();
    }

    @Override
    public String toString() {
        return getIngredients() + " pour " + getCalories() + " calories";
    }
}
