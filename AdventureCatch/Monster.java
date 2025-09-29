public class Monster extends Character {

    public Monster(String name, int maxHealth, Weapon weapon) {
        super(name, maxHealth, weapon);
    }

    @Override
    public void attack(Character target) throws DeadCharacterException {
        if (getCurrentHealth() == 0) {
            throw new DeadCharacterException(this); 
        }
        int damage = getWeapon() != null ? getWeapon().getDamage() : 7;
        target.takeDamage(damage);
    }

    @Override
    public void takeDamage(int damage) throws DeadCharacterException {
        int actualDamage = (int) Math.floor(damage * 0.8);
        reduceHealth(actualDamage);
    }

    @Override
    public String toString() {
        if (getCurrentHealth() > 0)
            return getName() + " is a monster with " + getCurrentHealth() + " HP";
        return getName() + " is a monster and is dead";
    }
}
