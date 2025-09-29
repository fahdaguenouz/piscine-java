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
    public void heal(Character target) throws DeadCharacterException {
        target.receiveHealing(healCapacity);
    }

    @Override
    public void attack(Character target) throws DeadCharacterException {
        heal(this);
        int damage = getWeapon() != null ? getWeapon().getDamage() : 10;
        target.takeDamage(damage);
    }

    @Override
    public void takeDamage(int damage) throws DeadCharacterException {
        reduceHealth(damage);
    }

    @Override
    public String toString() {
        if (getCurrentHealth() == 0)
            return getName() + " is a dead sorcerer. So bad, it could heal " + healCapacity + " HP.";
        return getName() + " is a sorcerer with " + getCurrentHealth() + " HP. It can heal " + healCapacity + " HP.";
    }
}
