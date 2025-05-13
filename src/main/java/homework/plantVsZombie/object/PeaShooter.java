package homework.plantVsZombie.object;

public class PeaShooter extends GameObject implements Shooter{
    public static int BASE_DAMAGE = 20;
    public static int BASE_HEALTH = 100;

    private int damagePoint;

    public PeaShooter(String name, int x, int y) {
        damagePoint = BASE_DAMAGE;
        health = BASE_HEALTH;
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public void shoot(GameObject target) {
        if (isAlive() && target.isAlive()) {
            if (target.getX() - x <= 5) {
                target.takeDamage(this.damagePoint);
                System.out.println(name + " shoot " + target.getName() + " with " + damagePoint + " damage");
            }
        }
    }

    @Override
    public void update() {
        if (!isAlive()) {
            System.out.println(name + " is dead.");
        }
    }
}
