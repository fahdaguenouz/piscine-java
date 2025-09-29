public class Monster extends Character {

    public Monster(String name, int maxHealth) {
        super(name, maxHealth);
    }

    @Override
    public void attack(Character target) {
        target.takeDamage(7);
    }

    @Override
    public void takeDamage(int damage) {
        int actualDamage = (int) Math.floor(damage * 0.8);
        reduceHealth(actualDamage);  // now works
    }

    @Override
    public String toString() {
        if (getCurrentHealth() > 0) {
            return getName() + " is a monster with " + getCurrentHealth() + " HP";
        } else {
            return getName() + " is a monster and is dead";
        }
    }
}
