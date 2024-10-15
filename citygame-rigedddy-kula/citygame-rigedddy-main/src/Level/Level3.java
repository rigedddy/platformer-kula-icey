package Level;

import Coin.CoinHandler;
import Enemy.Enemy;
import Enemy.EnemyControl;
import Platforms.Portal;
import Ragnite.Ragnite;
import Ragnite.RagniteControl;
import Kula.KulaPlayer;
import Platforms.PlatformManager3;
import city.cs.engine.*;
import game.Game;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.util.List;

/**
 * @author      nazifa, firoz, nazifa.firoz@city.ac.uk
 */

public class Level3 extends GameLevel {
    private KulaPlayer kula;
    private PlatformManager3 platformManager;
    private SoundClip gameMusic;
    private Timer enemySpawnTimer;
    private int enemySpawnCount = 0;
    private int totalEnemies = 6;
    private Enemy enemy;
    private List<Enemy> enemies;
    private Ragnite ragnite; // Declare ragnite here
    private RagniteControl ragniteControl;
    private CoinHandler coinHandler;
    private javax.swing.Timer coinSpawnTimer;
    private Timer ragniteRespawnTimer; // Timer for respawning Ragnite
    private boolean ragniteDestroyed = false; // Flag to track Ragnite's status
    private SoundClip letsgoSound;

    /**
     * Constructs Level3 with the specified Game instance.
     * @param game The Game instance associated with this level.
     */
    public Level3(Game game) {
        super(game);
        this.game = game;
        enemies = new ArrayList<>();

        try {
            gameMusic = new SoundClip("sounds/levelthree.wav");
            gameMusic.loop();
            gameMusic.setVolume(0.5);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        try {
            letsgoSound = new SoundClip("sounds/letsgoragnite.wav");
        } catch (Exception e) {
            System.err.println("Error loading sound files: " + e);
        }

        platformManager = new PlatformManager3(this);

        // create kula
        kula = new KulaPlayer(this);


        // Create a timer to spawn enemies one by one
        enemySpawnTimer = new Timer();
        enemySpawnTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (enemySpawnCount < totalEnemies) {
                    createEnemies();
                    enemySpawnCount++;
                } else {
                    enemySpawnTimer.cancel();
                }
            }
        }, 0, 9000);

        // Schedule the spawning of Ragnite after a short delay
        Timer ragniteSpawnTimer = new Timer();
        ragniteSpawnTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                createRagnite();
                ragniteSpawnTimer.cancel();
            }
        }, 54500);


        coinHandler = new CoinHandler(this, kula);
        coinSpawnTimer = new javax.swing.Timer(4000, e -> coinHandler.spawnCoin(7));
        coinSpawnTimer.start();

        ragniteRespawnTimer = new Timer();

    }


    /**
     * Checks if the level is complete.
     * @return True if the level is complete, false otherwise.
     */
    @Override
    public boolean isComplete() {
        return ragnite != null && ragnite.isDestroyed(true) && kula.getCoinsCount() >= 10;
        //return kula.getCoinsCount() >= 0;
    }

    /**
     * Proceeds to the next level.
     */
    @Override
    public void goToNextLevel() {
        game.goToNextLevel();
    }

    /**
     * Creates enemies in the level.
     */
    @Override
    public void createEnemies() {
        float startPosX = 24f;
        float endPosX = 96f;
        float startPosY = -24;

        Shape enemyShape = new BoxShape(2, 2f); // Define the shape of the enemy
        enemy = new Enemy(this, enemyShape, startPosX, endPosX, startPosY);
        EnemyControl enemyControl = new EnemyControl(enemy, startPosX, endPosX, 9); // Adjust walking speed as needed
        new AttachedImage(enemy, new BodyImage("data/trying.gif", 6f), 1f, 0f, new Vec2(0, 0.5f));
        addStepListener(enemyControl);

        enemies.add(enemy);

    }

    /**
     * Creates Ragnite in the level.
     */
    @Override
    public void createRagnite() {
        ragnite = new Ragnite(Level3.this, 24f, 96, -24);
        ragniteControl = new RagniteControl(ragnite, 24f, 96, 11);
        if (letsgoSound != null) {
            letsgoSound.setVolume(2);
            letsgoSound.play();
        }
        new AttachedImage(ragnite, new BodyImage("data/ragnite_walking1.gif", 6f), 1f, 0f, new Vec2(0, 0.7f));
        Level3.this.addStepListener(ragniteControl);
    }

    /**
     * Retrieves the KulaPlayer associated with this level.
     * @return The KulaPlayer object.
     */
    @Override
    public KulaPlayer getKulaPlayer() {
        return kula;
    }

    /**
     * Destroys all enemies in the level.
     */
    @Override
    public void destroyEnemies() {
        for (Enemy enemy : enemies) {
            enemy.destroy();
        }

        enemies.clear();
    }

    /**
     * Stops the music associated with the level.
     */
    @Override
    public void stopMusic() {
        gameMusic.stop();
    }

    @Override
    public Ragnite getRagnite() {
        return ragnite;
    }
}