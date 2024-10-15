package Enemy;

import Enemy.Enemy;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * @author      nazifa, firoz, nazifa.firoz@city.ac.uk
 */


public class EnemyControl implements StepListener {

    private Enemy enemy;
    private float left;
    private float right;
    private float walkingSpeed;

    /**
     * Constructs an EnemyControl with the specified enemy, left boundary, right boundary, and walking speed.
     * @param enemy The Enemy instance representing the enemy character.
     * @param left The left boundary position.
     * @param right The right boundary position.
     * @param walkingSpeed The walking speed of the enemy.
     */
    public EnemyControl(Enemy enemy, float left, float right, float walkingSpeed) {
        this.enemy = enemy;
        this.left = left;
        this.right = right;
        this.walkingSpeed = walkingSpeed;
    }

    /**
     * Reverses the enemy's walking direction if it reaches its left or right boundary.
     * @param stepEvent The StepEvent object representing the pre-step event.
     */
    @Override
    public void preStep(StepEvent stepEvent) {
        Vec2 pos = enemy.getPosition();
        if (pos.x <= left || pos.x >= right) {
            walkingSpeed = -walkingSpeed;
            enemy.startWalking(walkingSpeed);
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {
    }
}

