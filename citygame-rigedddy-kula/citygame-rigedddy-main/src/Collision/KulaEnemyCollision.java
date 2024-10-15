package Collision;

import Level.GameLevel;
import Level.Level3;
import Platforms.Portal;
import Platforms.Spikes;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import Enemy.Enemy;
import Kula.KulaPlayer;
import Ragnite.Ragnite;
import city.cs.engine.SoundClip;

/**
 * @author      nazifa, firoz, nazifa.firoz@city.ac.uk
 */


public class KulaEnemyCollision implements CollisionListener {
    private GameLevel level;
    private SoundClip hurtSound;
    //private Level3 level2;
    private boolean portalActivated = false; // Flag to track portal activation

    /**
     * Constructs a KulaEnemyCollision handler with the specified game level.
     * @param level The GameLevel instance representing the game world.
     */
    public KulaEnemyCollision(GameLevel level){
        this.level = level;

        try {
            hurtSound = new SoundClip("sounds/kulahurt.wav");
        } catch (Exception e) {
            System.err.println("Error loading sound files: " + e);
        }

    }

    /**
     * Handles collision events between the player character (Kula) and other objects.
     * @param collisionEvent The CollisionEvent object representing the collision event.
     */
    @Override
    public void collide(CollisionEvent collisionEvent) {
        // Collision with enemy
        if (collisionEvent.getOtherBody() instanceof Enemy) {
            System.out.println("Ouch! Kula collided with an enemy!");
            KulaPlayer kula = (KulaPlayer) collisionEvent.getReportingBody();
            kula.decreaseHealth(10); // Decrease health by 10
            playHurtSound();
        }
        // Collision with ragnite
        if (collisionEvent.getOtherBody() instanceof Ragnite) {
            System.out.println("Kula collided with Ragnite!");
            KulaPlayer kula = (KulaPlayer) collisionEvent.getReportingBody();
            kula.decreaseHealth(10); // Decrease health by 10
            playHurtSound();
        }
        // Collision with spikes
        if (collisionEvent.getOtherBody() instanceof Spikes) {
            System.out.println("Ouch! Kula collided with a spike!");
            KulaPlayer kula = (KulaPlayer) collisionEvent.getReportingBody();
            kula.decreaseHealth(100);
        }
        // Collision with portal
        if (collisionEvent.getOtherBody() instanceof Portal && !portalActivated) {
            System.out.println("Portal contact!");
            KulaPlayer kula = (KulaPlayer) collisionEvent.getReportingBody();
            if(level.isComplete()){
                level.goToNextLevel();
                portalActivated = true; // Set the portal activation flag
            }
        }

    }

    /**
     * Plays the hurt sound effect.
     */
    private void playHurtSound() {
        if (hurtSound != null) {
            hurtSound.play();
        }
    }

}
