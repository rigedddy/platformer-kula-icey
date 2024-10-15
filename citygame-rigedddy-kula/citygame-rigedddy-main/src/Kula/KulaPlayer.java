package Kula;

import Collision.KulaEnemyCollision;
import Level.GameLevel;
import Level.Level3;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import Enemy.Enemy;
import Ragnite.Ragnite;
import city.cs.engine.SoundClip;

/**
 * @author      nazifa, firoz, nazifa.firoz@city.ac.uk
 */


public class KulaPlayer extends Walker {
    private static final float walking_speed = 15f;
    private static final float jumping_speed = 16f;
    private boolean isWalking;
    private GameLevel world;
    private DynamicBody attackBody;
    private boolean isFacingRight;
    private int health;
    private int coins = 0;
    public static final int MAX_HEALTH = 100;  // Set maximum health
    private SoundClip attackSound;
    private SoundClip jumpSound;
    private Level3 level3;

    /**
     * Constructs a KulaPlayer instance with the specified GameLevel world.
     * Initializes Kula's attributes and adds collision listeners.
     * @param world The GameLevel world in which Kula exists.
     */
    public KulaPlayer(GameLevel world) {
        super(world, new BoxShape(1, 2.5f));
        this.world = world;
        addImage(new BodyImage("data/kula_standing.gif", 5.55f));
        setPosition(new Vec2(-17, 0f));
        isWalking = false;
        isFacingRight = false;
        setGravityScale(1.9f);
        SolidFixture fixture = new SolidFixture(this, new BoxShape(1,2.5f));
        fixture.setFriction(0);


        // KulaEnemyCollision listener
        KulaEnemyCollision collisionListener = new KulaEnemyCollision(world);
        this.addCollisionListener(collisionListener);

        // health bar
        health = MAX_HEALTH;

        if (world instanceof Level3) {
            this.level3 = (Level3) world;
        }

        try {
            attackSound = new SoundClip("sounds/iceattack.wav");
            jumpSound = new SoundClip("sounds/jumpsound.wav");
        } catch (Exception e) {
            System.err.println("Error loading sound files: " + e);
        }

    }


    // Methods for controlling Kula's movement and actions
    public void walkLeft() {
        startWalking(-walking_speed);
        removeAllImages();
        addImage(new BodyImage("data/kula_walk_left.gif", 5.5f));
        isWalking = true;
        isFacingRight = false;
    }

    public void walkRight() {
        startWalking(walking_speed);
        removeAllImages();
        addImage(new BodyImage("data/kula_walk_right.gif", 5.5f));
        isWalking = true;
        isFacingRight = true;
    }


    public void stopWalking() {
        super.stopWalking();
        this.startWalking(0); // stops motion after key release
        removeAllImages();
        if(isFacingRight) {
            addImage(new BodyImage("data/kula_standing_right.gif", 5.5f));
        } else{
            addImage(new BodyImage("data/kula_standing.gif", 5.5f));
        }
        isWalking = false;
    }

    public void jump() {
        if (jumpSound != null) {
            jumpSound.play();
        }
        jump(jumping_speed);
        removeAllImages();
        addImage(new BodyImage("data/kula_jumper.gif",8.5f));
    }

    public void stopJump(){
        removeAllImages();
        if(isFacingRight) {
            addImage(new BodyImage("data/kula_standing_right.gif", 5.5f));
        } else{
            addImage(new BodyImage("data/kula_standing.gif", 5.5f));
        }
    }

    public void jump2() {
        if (jumpSound != null) {
            jumpSound.play();
        }
        jump(jumping_speed);
        removeAllImages();
        addImage(new BodyImage("data/kula_jumper2.gif", 8.5f));
    }


    public void attack() {
        if (attackSound != null) {
            attackSound.setVolume(0.5);
            attackSound.play();
        }
        removeAllImages();
        //BoxShape attackBody= new BoxShape(1f,3f);
        //addImage(new BodyImage("data/kula_swirl.gif", 7f));
        if(isFacingRight) {
            new AttachedImage(this, new BodyImage("data/kula_blast.gif", 5.5f), 1f, 0f, new Vec2(4, 0));
        } else{
            new AttachedImage(this, new BodyImage("data/kula_blast2.gif", 5.5f), 1f, 0f, new Vec2(-4, 0));
        }

        // check if any enemies are nearby
        checkForEnemies();
        checkForRagnite();
    }

    public void animation(){
        removeAllImages();
        if(isWalking){
            if(isFacingRight){
                addImage(new BodyImage("data/kula_walk_right.gif", 5.5f));
            } else{
                addImage(new BodyImage("data/kula_walk_left.gif", 5.5f));
            }
        } else{
            if(isFacingRight){
                addImage(new BodyImage("data/kula_standing_right.gif", 5.5f));
            } else{
                addImage(new BodyImage("data/kula_standing.gif", 5.5f));
            }
        }
    }

    // Method for checking and handling collisions
    // used for attack, only the enemy closest will destroy
    private void checkForEnemies() {
        // Get the GameWorld instance
        GameLevel gameWorld = (GameLevel) getWorld();

        // Iterate over all bodies in the world
        for (Body body : gameWorld.getDynamicBodies()) {
            // Check if the body is an instance of Enemy
            if (body instanceof Enemy) {
                // Check if the enemy is within a certain range
                Vec2 playerPos = this.getPosition();
                Vec2 enemyPos = body.getPosition();
                float distance = playerPos.sub(enemyPos).length();

                if (distance < 6f) {
                    createAfterImage((Enemy) body);
                    body.destroy();

                }
            }
        }
    }

    private void checkForRagnite() {
        // Get the GameWorld instance
        GameLevel gameWorld = (GameLevel) getWorld();

        // Iterate over all bodies in the world
        for (Body body : gameWorld.getDynamicBodies()) {
            // Check if the body is an instance of Ragnite
            if (body instanceof Ragnite) {
                // Check if Ragnite is within a certain range
                Vec2 playerPos = this.getPosition();
                Vec2 ragnitePos = body.getPosition();
                float distance = playerPos.sub(ragnitePos).length();

                if (distance < 6f) {
                    ((Ragnite) body).receiveDamage(10); // Example: Decrease Ragnite's health by 10
                }
            }
        }
    }


    // this doesn't work.
    private void createAfterImage(Enemy enemy) {
        Vec2 enemyPos = enemy.getPosition();
        AttachedImage afterImage = new AttachedImage(enemy, new BodyImage("data/poof.gif", 2f), 1f, 0f, enemyPos);

    }

    /**
     * Gets whether Kula is facing right.
     * @return True if Kula is facing right, false otherwise.
     */
    public boolean isFacingRight() {
        return isFacingRight;
    }


    /**
     * Gets Kula's current health.
     * @return The current health of Kula.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Decreases Kula's health by the specified amount.
     * If health drops to zero, restarts the game.
     * @param amount The amount by which to decrease Kula's health.
     */
    public void decreaseHealth(int amount) {
        health -= amount;
        if (health < 0) {
            health = 0; // ensure health doesn't go negative
        }
        if (health == 0 ){
            restartGame();
        }
    }


    /**
     * Restarting the game when kula reaches health zero.
     */
    private void restartGame() {
        // get the GameWorld instance
        GameLevel gameWorld = (GameLevel) getWorld();

        // reset KulaPlayer's position
        setPosition(new Vec2(-17, -6f));

        // reset health
        health = MAX_HEALTH;

        // reset coins
        coins = 0;

        // destroy and recreate enemies
        gameWorld.destroyEnemies();
        gameWorld.createEnemies();
        //gameWorld.createRagnite();

    }

    /**
     * Increments Kula's coin count.
     */
    public void incrementCoins(){
        this.coins ++;
    }

    /**
     * Gets the current count of coins collected by Kula.
     * @return The count of coins collected by Kula.
     */
    public int getCoinsCount(){
        return coins;
    }


}