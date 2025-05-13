package homework.plantVsZombie.object;

public class Zombie extends GameObject implements Mover {
    private static int BASE_HEALTH = 100;

    public Zombie(String name, int x, int y) {
        health = BASE_HEALTH;
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public void move() {
        if (isAlive() && x > 0) {
            x = x - 1;
            System.out.println(name + " move. New position (" + x + ", " + y + ")");
        }
    }

    @Override
    public void update() {
        if (!isAlive()) {
            System.out.println(name + " is dead.");
        }
    }
}
