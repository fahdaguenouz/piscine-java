public class Monster extends Character {

    public Monster(String name, int maxHealth) {
        super(name, maxHealth);
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
