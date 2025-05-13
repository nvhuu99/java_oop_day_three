package homework.plantVsZombie.object.action;

import java.util.Date;

public class GameObjectAction {
    public Action action;
    public Date timestamp;
    public int damage;
    public int x;
    public int y;

    public static GameObjectAction NewAttackAction(int damage) {
        GameObjectAction action = new GameObjectAction();
        action.action = Action.ATTACK;
        action.timestamp = new Date();
        action.damage = damage;
        return action;
    }

    public static GameObjectAction NewMoveAction(int x, int y) {
        GameObjectAction action = new GameObjectAction();
        action.action = Action.MOVE;
        action.timestamp = new Date();
        action.x = x;
        action.y = y;
        return action;
    }
}
