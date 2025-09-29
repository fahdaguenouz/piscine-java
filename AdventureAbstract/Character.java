import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    private final int maxHealth;
    private int currentHealth;

    private final String name;

    private static List<Character> allCharacters = new ArrayList<>();

    public Character(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        allCharacters.add(this);
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

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public String getName() {
        return name;
    }

    public abstract void attack(Character target);

    public abstract void takeDamage(int damage);

    @Override
    public String toString() {
        if (currentHealth == 0) {
            return name + " : KO";
        }
        return name + " : " + currentHealth + "/" + maxHealth;
    }

    public void receiveHealing(int amount) {
        if (currentHealth == 0)
            return; 
        currentHealth += amount;
        if (currentHealth > maxHealth)
            currentHealth = maxHealth;
    }

    public static String printStatus() {
        StringBuilder sb = new StringBuilder();
        if (allCharacters.isEmpty()) {
            sb.append("------------------------------------------\n");
            sb.append("Nobody's fighting right now !\n");
            sb.append("------------------------------------------\n");
        } else {
            sb.append("------------------------------------------\n");
            sb.append("Characters currently fighting :\n");
            for (Character c : allCharacters) {
                sb.append(" - ").append(c.toString()).append("\n");
            }
            sb.append("------------------------------------------\n");
        }
        return sb.toString();
    }

    public static Character fight(Character c1, Character c2) {
        while (c1.currentHealth > 0 && c2.currentHealth > 0) {
            c1.attack(c2);
            if (c2.currentHealth == 0)
                return c1;

            c2.attack(c1);
            if (c1.currentHealth == 0)
                return c2;
        }
        return null;
    }

    public void reduceHealth(int damage) {
        currentHealth -= damage;
        if (currentHealth < 0)
            currentHealth = 0;
    }

}
