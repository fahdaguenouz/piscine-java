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
        if (target.currentHealth == 0) return; 
        target.currentHealth += healCapacity;
        if (target.currentHealth > target.getMaxHealth()) {
            target.currentHealth = target.getMaxHealth();
        }
    }

    @Override
    public String toString() {
        if (currentHealth == 0) {
            return getName() + " is a dead sorcerer. So bad, it could heal " + healCapacity + " HP.";
        }
        return getName() + " is a sorcerer with " + currentHealth + " HP. It can heal " + healCapacity + " HP.";
    }
}
