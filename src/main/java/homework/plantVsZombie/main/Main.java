package homework.plantVsZombie.main;

import homework.plantVsZombie.game.PlantVsZombieGame;

public class Main {
    public static void main(String[] args) {
        var game = new PlantVsZombieGame();

        System.out.println("Start game");
        game.start();
    }
}
