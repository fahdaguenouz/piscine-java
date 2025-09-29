import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    private final int maxHealth;
    private int currentHealth;
    private final String name;
    private final Weapon weapon;

    private static List<Character> allCharacters = new ArrayList<>();

    public Character(String name, int maxHealth, Weapon weapon) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.weapon = weapon;
        allCharacters.add(this);
    }

    public int getMaxHealth() {
        return maxHealth;
    }
       protected void setCurrentHealth(int currentHealth) {
        if (currentHealth < 0) {
            this.currentHealth = 0;
        } else if (currentHealth > maxHealth) {
            this.currentHealth = maxHealth;
        } else {
            this.currentHealth = currentHealth;
        }
    }
    public int getCurrentHealth() {
        return currentHealth;
    }

    public String getName() {
        return name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

   public abstract void attack(Character target) throws DeadCharacterException;
    public abstract void takeDamage(int damage) throws DeadCharacterException;  
    @Override
    public String toString() {
        if (currentHealth == 0) return name + " : KO";
        return name + " : " + currentHealth + "/" + maxHealth;
    }

    protected void receiveHealing(int amount) throws DeadCharacterException {
        if (currentHealth == 0)
            throw new DeadCharacterException(this);
        currentHealth += amount;
        if (currentHealth > maxHealth)
            currentHealth = maxHealth;
    }

    protected void reduceHealth(int damage) throws DeadCharacterException {
        if (currentHealth == 0)
            throw new DeadCharacterException(this);
        currentHealth -= damage;
        if (currentHealth < 0)
            currentHealth = 0;
    }

   public static Character fight(Character c1, Character c2) {
    while (c1.getCurrentHealth() > 0 && c2.getCurrentHealth() > 0) {
        try {
            c1.attack(c2);
        } catch (DeadCharacterException ignored) {}
        if (c2.getCurrentHealth() == 0) return c1;

        try {
            c2.attack(c1);
        } catch (DeadCharacterException ignored) {}
        if (c1.getCurrentHealth() == 0) return c2;
    }
    return null;
}


    public static String printStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append("------------------------------------------\n");
        sb.append("Characters currently fighting :\n");
        for (Character c : allCharacters) {
            sb.append(" - ").append(c.toString());
            if (c.getWeapon() != null) sb.append(". He has the weapon ").append(c.getWeapon());
            sb.append("\n");
        }
        sb.append("------------------------------------------\n");
        return sb.toString();
    }
}
