public class Templar extends Character implements Healer, Tank {
    private final int healCapacity;
    private final int shield;

    public Templar(String name, int maxHealth, int healCapacity, int shield, Weapon weapon) {
        super(name, maxHealth, weapon);
        this.healCapacity = healCapacity;
        this.shield = shield;
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
    public int getShield() {
        return shield;
    }

    @Override
    public void attack(Character target) {
        heal(this);
        int damage = getWeapon() != null ? getWeapon().getDamage() : 6;
        target.takeDamage(damage);
    }

    @Override
    public void takeDamage(int damage) {
        int actualDamage = damage - shield;
        if (actualDamage < 0) actualDamage = 0;
        reduceHealth(actualDamage);
    }

    @Override
    public String toString() {
        String base = getCurrentHealth() == 0
                ? getName() + " has been beaten, even with its " + shield + " shield. So bad, it could heal " + healCapacity + " HP."
                : getName() + " is a strong Templar with " + getCurrentHealth() + " HP. It can heal " + healCapacity + " HP and has a shield of " + shield + ".";
        if (getWeapon() != null) {
            base += " He has the weapon " + getWeapon().toString();
        }
        return base;
    }
}
