package Enemy;

import Collision.KulaEnemyCollision;
import Kula.KulaPlayer;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;

/**
 * @author      nazifa, firoz, nazifa.firoz@city.ac.uk
 */

public class Enemy extends Walker {

    private static float walkingSpeed = 3f; // slower than kula
    private final float startPosY;
    private float startPosX;
    private float endPosX;
    private Timer timer;

    /**
     * Constructs an Enemy with the specified world, shape, start position, and end position.
     * @param world The World instance representing the game world.
     * @param shape The shape of the enemy.
     * @param startPosX The starting x-coordinate of the enemy.
     * @param endPosX The ending x-coordinate of the enemy.
     * @param startPosY The y-coordinate of the enemy.
     */
    public Enemy(World world, Shape shape, float startPosX, float endPosX, float startPosY) {
        super(world, shape);
        //addImage(new BodyImage("data/enemy_1.gif", 5));
        this.startPosX = startPosX;
        this.endPosX = endPosX;
        this.startPosY = startPosY;
        setPosition(new Vec2(startPosX, startPosY));


    }

}