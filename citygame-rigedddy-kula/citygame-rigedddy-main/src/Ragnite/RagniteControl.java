package Ragnite;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * @author      nazifa, firoz, nazifa.firoz@city.ac.uk
 */

public class RagniteControl implements StepListener {

    private Ragnite ragnite;
    private float left;
    private float right;
    private float walkingSpeed;
    private boolean walkingRight = true; // Flag to track walking direction

    /**
     * Constructs a RagniteControl object with the specified parameters.
     *
     * @param ragnite The Ragnite object to control.
     * @param left The left boundary of the movement range.
     * @param right The right boundary of the movement range.
     * @param walkingSpeed The walking speed of the Ragnite.
     */
    public RagniteControl(Ragnite ragnite, float left, float right, float walkingSpeed) {
        this.ragnite = ragnite;
        this.left = left;
        this.right = right;
        this.walkingSpeed = walkingSpeed;
    }

    /**
     * Performs actions before each step in the simulation.
     * Updates the Ragnite's movement direction and image based on its position.
     * @param stepEvent Information about the step event.
     */
    @Override
    public void preStep(StepEvent stepEvent) {
        Vec2 pos = ragnite.getPosition();
        if (pos.x <= left || pos.x >= right) {
            walkingSpeed = -walkingSpeed;
            ragnite.startWalking(walkingSpeed);
            // Update image when changing direction
            if (walkingSpeed > 0) {
                ragnite.removeAllImages();
                new AttachedImage(ragnite, new BodyImage("data/ragnite_walking1.gif", 6f), 1f, 0f, new Vec2(0, 0.7f));
            } else {
                ragnite.removeAllImages();
                new AttachedImage(ragnite, new BodyImage("data/ragnite_walking2.gif", 6f), 1f, 0f, new Vec2(0, 0.7f));
            }
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {}
}
