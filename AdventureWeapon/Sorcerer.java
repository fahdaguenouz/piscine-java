public class Sorcerer extends Character implements Healer {
    private final int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity, Weapon weapon) {
        super(name, maxHealth, weapon);
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
        heal(this); // self-heal
        int damage = getWeapon() != null ? getWeapon().getDamage() : 10;
        target.takeDamage(damage);
    }

    @Override
    public void takeDamage(int damage) {
        reduceHealth(damage);
    }

    @Override
    public String toString() {
        String base = getCurrentHealth() == 0
                ? getName() + " is a dead sorcerer. So bad, it could heal " + healCapacity + " HP."
                : getName() + " is a sorcerer with " + getCurrentHealth() + " HP. It can heal " + healCapacity + " HP.";
        if (getWeapon() != null) {
            base += " He has the weapon " + getWeapon().toString();
        }
        return base;
    }
}
