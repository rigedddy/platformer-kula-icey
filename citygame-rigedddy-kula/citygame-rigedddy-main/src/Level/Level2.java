package Level;

import Coin.CoinHandler;
import Coin.Coin;
import Enemy.Enemy;
import Enemy.EnemyControl;
import Kula.KulaControl;
import Kula.KulaPlayer;
import Platforms.PlatformManager;
import Platforms.PlatformManager2;
import Platforms.Portal;
import Platforms.Spikes;
import Ragnite.Ragnite;
import city.cs.engine.*;
import game.Game;
import org.jbox2d.common.Vec2;
import java.util.Random;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

/**
 * @author      nazifa, firoz, nazifa.firoz@city.ac.uk
 */

public class Level2 extends GameLevel {
    private KulaPlayer kula;
    private Game game;
    private CoinHandler coinHandler;
    private PlatformManager2 platformManager;
    private SoundClip gameMusic;
    private Enemy enemy1;
    private Enemy enemy2;
    private Enemy enemy3;
    private Enemy enemy4;
    private Timer coinSpawnTimer;
    private Timer coinSpawnTimer2;
    private Timer coinSpawnTimer3;

    /**
     * Constructs Level2 with the specified Game instance.
     * @param game The Game instance associated with this level.
     */
    public Level2(Game game) {
        super(game);
        this.game = game;

        try {
            gameMusic = new SoundClip("sounds/leveltwo.wav");
            gameMusic.loop();
            gameMusic.setVolume(0.5);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        // get all the platforms into the game
        platformManager = new PlatformManager2(this);

        // create kula
        kula = new KulaPlayer(this);

        createEnemies();

        Portal portal1 =  new Portal(this,22f,5f,5f,375,6f,"data/portalTwo.png");

        coinHandler = new CoinHandler(this, kula);
        coinSpawnTimer = new Timer(3000, e -> coinHandler.spawnCoin(4));
        coinSpawnTimer.start();
        coinSpawnTimer2 = new Timer(6000, e -> coinHandler.spawnCoin(5));
        coinSpawnTimer2.start();
        coinSpawnTimer3 = new Timer(11000, e -> coinHandler.spawnCoin(6));
        coinSpawnTimer3.start();


    }

    /**
     * Checks if the level is complete.
     * @return True if the level is complete, false otherwise.
     */
    @Override
    public boolean isComplete() {
        return kula.getCoinsCount() >= 10;
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

        // Create enemy 1
        Shape enemyShape = new BoxShape(2, 2f);
        enemy1 = new Enemy(this, enemyShape, 61f, 97f, 13);
        EnemyControl enemyControl1 = new EnemyControl(enemy1, 61f, 97f, 5);
        new AttachedImage(enemy1, new BodyImage("data/enemy_fire4.gif", 8f), 1f, 0f, new Vec2(0, 1f));
        addStepListener(enemyControl1);

        // Create enemy 2
        Shape enemyShape2 = new BoxShape(2, 2f);
        enemy2 = new Enemy(this, enemyShape2, 166f, 183, -9);
        EnemyControl enemyControl2 = new EnemyControl(enemy2, 166f, 183, 4);
        new AttachedImage(enemy2, new BodyImage("data/enemy_fire2.gif", 6f), 1f, 0f, new Vec2(0, 0.5f));
        addStepListener(enemyControl2);

        // Create enemy 3
        Shape enemyShape3 = new BoxShape(2, 2f);
        enemy3 = new Enemy(this, enemyShape3, 302f, 323, -12f);
        EnemyControl enemyControl3 = new EnemyControl(enemy3, 302f, 323, 7);
        new AttachedImage(enemy3, new BodyImage("data/enemy_fire2.gif", 6f), 1f, 0f, new Vec2(0, 0.5f));
        addStepListener(enemyControl3);

        // Create enemy 4
        Shape enemyShape4 = new BoxShape(2, 2f);
        enemy4 = new Enemy(this, enemyShape4, 338f, 363, 1.5f);
        EnemyControl enemyControl4 = new EnemyControl(enemy4, 338f, 363, 7);
        new AttachedImage(enemy4, new BodyImage("data/enemy_fire4.gif", 8f), 1f, 0f, new Vec2(0, 1f));
        addStepListener(enemyControl4);


    }


    @Override
    public void createRagnite() {}

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
        enemy1.destroy();
        enemy2.destroy();
        enemy3.destroy();
        enemy4.destroy();
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
        return null;
    }
}