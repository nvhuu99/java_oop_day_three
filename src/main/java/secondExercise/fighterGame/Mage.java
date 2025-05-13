package secondExercise.fighterGame;

public class Mage extends Hero {
    public static int MAGE_BASE_DAMAGE = 2500;

    public Mage(String name) {
        super(name);
    }

    @Override
    public int getBaseDamage() {
        return MAGE_BASE_DAMAGE;
    }
}
