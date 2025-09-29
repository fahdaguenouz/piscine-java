public class Sorcerer extends Character implements Healer {
    private final int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity) {
        super(name, maxHealth);
        this.healCapacity = healCapacity;
    }

    @Override
    public int getHealCapacity() {
        return healCapacity;
    }

    @Override
    public void heal(Character target) {
        target.receiveHealing(healCapacity);
    }

    @Override
    public void attack(Character target) {
        heal(this);           // heal itself
        target.takeDamage(10); // deal 10 damage
    }

    @Override
    public void takeDamage(int damage) {
        reduceHealth(damage); // take full damage
    }



    @Override
    public String toString() {
        if (getCurrentHealth() == 0) {
            return getName() + " is a dead sorcerer. So bad, it could heal " + healCapacity + " HP.";
        }
        return getName() + " is a sorcerer with " + getCurrentHealth() + " HP. It can heal " + healCapacity + " HP.";
    }
}
