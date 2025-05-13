package homework.plantVsZombie.object;

public abstract class GameObject {
    protected int health;
    protected int x;
    protected int y;

    public abstract void update();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void takeDamage(int amount) {
        if (health > 0) {
            health -= amount;
        }

    }

    public void kill() {
        health = 0;
    }

    public boolean isAlive() {
        return health > 0;
    }
}
