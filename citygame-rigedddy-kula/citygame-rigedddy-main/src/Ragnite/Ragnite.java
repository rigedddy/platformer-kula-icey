package Ragnite;

import Level.GameLevel;
import Platforms.Portal;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * @author      nazifa, firoz, nazifa.firoz@city.ac.uk
 */

public class Ragnite extends Walker {
    private static final int MAX_HEALTH = 120;
    private int health;
    private boolean isDestroyed = false; // Track Ragnite's destruction status
    private SoundClip hurtSound;
    private GameLevel gameLevel;

    /**
     * Constructs a Ragnite object with the specified properties.
     * @param world The world in which the Ragnite exists.
     * @param startPosX The starting x-coordinate position of the Ragnite.
     * @param endPosX The ending x-coordinate position of the Ragnite.
     * @param startPosY The y-coordinate position of the Ragnite.
     */
    public Ragnite(GameLevel world, float startPosX, float endPosX, float startPosY) {
        super(world, new BoxShape(1, 2));
        setPosition(new Vec2(startPosX, startPosY));
        health = MAX_HEALTH;
        gameLevel = world;

        RagniteControl ragniteControl = new RagniteControl(this, startPosX, endPosX, 5f);
        world.addStepListener(ragniteControl);

        try {
            hurtSound = new SoundClip("sounds/ragnitehurt.wav");
        } catch (Exception e) {
            System.err.println("Error loading sound files: " + e);
        }

    }

    /**
     * Damages the Ragnite object by the specified amount.
     * @param damage The amount of damage to be inflicted on the Ragnite.
     */
    public void receiveDamage(int damage) {
        health -= damage;
        if (hurtSound != null) {
            hurtSound.setVolume(2);
            hurtSound.play();
        }
        if (health <= 0) {
            destroy();
            isDestroyed = true;
            Portal portal1 =  new Portal(gameLevel,22f,5f,6f,110,-17f,"data/portalThree.png");

        }
    }

    /**
     * Checks if the Ragnite object is destroyed.
     * @param checkDestroyed Flag to indicate whether to check for destruction.
     * @return True if the Ragnite is destroyed, otherwise false.
     */
    public boolean isDestroyed(boolean checkDestroyed) {
        if (checkDestroyed) {
            return isDestroyed;
        } else {
            return !isDestroyed;
        }
    }

    public int getHealth(){
        return health;
    }

}