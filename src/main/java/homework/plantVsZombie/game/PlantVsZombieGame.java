package homework.plantVsZombie.game;

import homework.plantVsZombie.object.*;

import java.util.ArrayList;
import java.util.Random;

public class PlantVsZombieGame {
    private GameObject[][] gameMap;
    private ArrayList<GameObject> objects;

    private int w = 10;
    private int h = 10;

    public PlantVsZombieGame() {
        gameMap = new GameObject[w][h];
        objects = new ArrayList<>();

        Random rand = new Random();
        gameMap[w - 1][0] = new Zombie("Zombie#1", w - 1, 0);
        gameMap[0][0] = new PeaShooter("Plant#1", 0, 0);
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; ++j) {
                if (gameMap[i][j] != null) {
                    objects.add(gameMap[i][j]);
                }
            }
        }
    }

    public void start() {
        while (true) {
            for (GameObject obj: objects) {
                if (obj instanceof Shooter) {
                    handleShooterAction(obj);
                } else if (obj instanceof Mover) {
                    handleMoverAction(obj);
                }
            }

            boolean plantAlive = false;
            boolean zombieAlive = false;
            for (GameObject obj: objects) {
                obj.update();
                if (obj.isAlive()) {
                    if (obj instanceof PeaShooter) {
                        plantAlive = true;
                    } else {
                        zombieAlive = true;
                    }
                }
            }

            if (!plantAlive || !zombieAlive) {
                System.out.println("Game finished");
                return;
            }
        }
    }

    private void handleShooterAction(GameObject shooter) {
        for (int x = shooter.getX() + 1; x < w; ++x) {
            if (gameMap[x][shooter.getY()] != null && gameMap[x][shooter.getY()].isAlive()) {
                ((Shooter)shooter).shoot(gameMap[x][shooter.getY()]);
            }
        }
    }

    private void handleMoverAction(GameObject mover) {
        // Move
        ((Mover) mover).move();
        // Zombie will kill plants immediately by moving right to left
        if (mover instanceof Zombie) {
            for (int y = mover.getY() - 1; y >= 0; --y) {
                if (gameMap[mover.getX()][y] != null) {
                    gameMap[mover.getX()][y].kill();
                }
            }
        }
    }
}
