package Platforms;

import Level.GameLevel;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

/**
 * @author      nazifa, firoz, nazifa.firoz@city.ac.uk
 */

public class MovingPlatform extends StaticBody implements StepListener {

    private float speed;
    private float startX;
    private float endX;
    private boolean movingRight;

    /**
     * Constructs a MovingPlatform with the specified parameters.
     * @param world The GameLevel instance associated with this platform.
     * @param shape The shape of the platform.
     * @param startX The starting x-coordinate of the platform's movement range.
     * @param endX The ending x-coordinate of the platform's movement range.
     * @param speed The speed at which the platform moves.
     * @param xPos The initial x-position of the platform.
     * @param yPos The initial y-position of the platform.
     */
    public MovingPlatform(GameLevel world, Shape shape, float startX, float endX, float speed, float xPos, float yPos) {
        super(world, shape);
        this.startX = startX;
        this.endX = endX;
        this.speed = speed;
        this.movingRight = true;
        this.setPosition(new Vec2(xPos, yPos));
    }

    /**
     * Updates the platform's position before each step in the simulation.
     * @param stepEvent Information about the step event.
     */
    @Override
    public void preStep(StepEvent stepEvent) {
        // Calculate the new position of the platform
        float newX = this.getPosition().x + (movingRight ? speed : -speed);

        // Check if the platform has reached the end of its range
        if (newX > endX || newX < startX) {
            // Reverse the direction
            movingRight = !movingRight;
        }

        // Set the new position of the platform
        this.setPosition(new Vec2(newX, this.getPosition().y));
    }


    @Override
    public void postStep(StepEvent stepEvent) {}
}