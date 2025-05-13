package secondExercise.fighter;

public abstract class Hero implements Fighter {
    public static int HERO_BASE_HEALTH_POINT = 50000;
    public static int HERO_BASE_DAMAGE = 1000;

    private int healthPoint;
    private String name;
    public String getName() { return name; }

    public Hero(String name) {
        name = name;
        healthPoint = HERO_BASE_HEALTH_POINT;
    }

    public int getBaseDamage() { return HERO_BASE_DAMAGE; }

    public int attack() {
        if (died()) {
            return 0;
        }
        return (int)Math.round(Math.random() * getBaseDamage());
    }

    public void receivedDamage(int damagePoint) {
        healthPoint -= damagePoint;
    }

    public boolean died() {
        return healthPoint <= 0;
    }
}
