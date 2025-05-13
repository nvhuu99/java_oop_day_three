package secondExercise.fighter;

public class Knight extends Hero {
    public static int KNIGHT_BASE_DAMAGE = 5000;

    public Knight(String name) {
        super(name);
    }

    @Override
    public int getBaseDamage() { return KNIGHT_BASE_DAMAGE; }
}
