package secondExercise.fighter;

public class Archer extends Hero {
    public static int ARCHER_BASE_DAMAGE = 1000;

    public Archer(String name) {
        super(name);
    }

    @Override
    public int getBaseDamage() {
        return ARCHER_BASE_DAMAGE;
    }
}
