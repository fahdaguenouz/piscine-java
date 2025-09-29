public interface Healer {
void heal(Character target) throws DeadCharacterException;
    int getHealCapacity();
}
