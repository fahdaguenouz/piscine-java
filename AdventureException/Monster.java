public class Monster extends Character {

    public Monster(String name, int maxHealth, Weapon weapon) {
        super(name, maxHealth, weapon);
    }

    @Override
    public void attack(Character target) {
        int damage = getWeapon() != null ? getWeapon().getDamage() : 7;
        target.takeDamage(damage);
    }

    @Override
    public void takeDamage(int damage) {
        int actualDamage = (int) Math.floor(damage * 0.8);
        reduceHealth(actualDamage);
    }

    @Override
    public String toString() {
        String base = getCurrentHealth() > 0
                ? getName() + " is a monster with " + getCurrentHealth() + " HP"
                : getName() + " is a monster and is dead";
        if (getWeapon() != null) {
            base += ". He has the weapon " + getWeapon().toString();
        }
        return base;
    }
}
