package Level;

import Coin.CoinHandler;
import Enemy.Enemy;
import Enemy.EnemyControl;
import Kula.KulaControl;
import Kula.KulaPlayer;
import Platforms.PlatformManager;
import Platforms.Portal;
import Platforms.Spikes;
import Ragnite.Ragnite;
import city.cs.engine.*;
import game.Game;;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

/**
 * @author      nazifa, firoz, nazifa.firoz@city.ac.uk
 */

public class Level1 extends GameLevel{
    private KulaPlayer kula;
    private Timer coinSpawnTimer;
    private Timer coinSpawnTimer2;
    private Timer coinSpawnTimer3;
    private CoinHandler coinHandler;
    private PlatformManager platformManager;
    private Spikes spikes;
    private Enemy enemy1;
    private Enemy enemy2;
    private Enemy enemy3;
    private SoundClip gameMusic;
    Game game;

    /**
     * Constructs Level1 with the specified Game instance.
     * @param game The Game instance associated with this level.
     */
    public Level1(Game game) {
        super(game);
        this.game = game;

        try {
            gameMusic = new SoundClip("sounds/levelone.wav");
            gameMusic.loop();
            gameMusic.setVolume(0.5);
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }

        // get all the platforms into the game
        platformManager = new PlatformManager(this);

        // create kula
        kula = new KulaPlayer(this);

        // enemies in world
        createEnemies();

        // portal
        Portal portal1 =  new Portal(this,22f,5f,5f,340,4.5f,"data/portalOne.png");

        // timer for coin
        coinHandler = new CoinHandler(this, kula);
        coinSpawnTimer = new Timer(5000, e -> coinHandler.spawnCoin(1));
        coinSpawnTimer.start();
        coinSpawnTimer2 = new Timer(6000, e -> coinHandler.spawnCoin(2));
        coinSpawnTimer2.start();
        coinSpawnTimer3 = new Timer(10000, e -> coinHandler.spawnCoin(3));
        coinSpawnTimer3.start();

        // spikes
        Spikes s1 = new Spikes(this,18, 9,7,75,-12,"data/spikes.png");
        Spikes s2 = new Spikes(this,18, 12,7,109f,-12,"data/spikes.png");
        Spikes s3 = new Spikes(this,40, 12,7,150,-12,"data/spikes.png");
        Spikes s4 = new Spikes(this,40, 12,7,170,-12,"data/spikes.png");
        Spikes s5 = new Spikes(this,35, 12,7,183,-12,"data/spikes.png");
        //s3.setClipped(true);

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
     * Creates enemies in the level.
     */
    public void createEnemies() {
        // Create enemy 1
        Shape enemyShape = new BoxShape(2, 2f);
        enemy1 = new Enemy(this, enemyShape, 13.3f, 26.7f, 5) {
        };
        EnemyControl enemyControl1 = new EnemyControl(enemy1, 13.3f, 26.7f, 3);
        new AttachedImage(enemy1, new BodyImage("data/enemy_1.gif", 6f), 1f, 0f, new Vec2(0, 0.5f));
        addStepListener(enemyControl1);

        // Create enemy 2
        Shape enemyShape2 = new BoxShape(2, 2f);
        enemy2 = new Enemy(this, enemyShape2, 81f, 99, 7);
        EnemyControl enemyControl2 = new EnemyControl(enemy2, 81f, 99, 3);
        enemy2.addImage(new BodyImage("data/enemy_2.gif", 5));
        addStepListener(enemyControl2);

        // Create enemy 3
        Shape enemyShape3 = new BoxShape(2, 2f);
        enemy3 = new Enemy(this, enemyShape3, 220f, 249, -7.9f);
        EnemyControl enemyControl3 = new EnemyControl(enemy3, 220f, 249, 7);
        new AttachedImage(enemy3, new BodyImage("data/enemy_1.gif", 6f), 1f, 0f, new Vec2(0, 0.5f));
        addStepListener(enemyControl3);

    }

    @Override
    public void createRagnite() {}

    /**
     * Destroys all enemies in the level.
     */
    public void destroyEnemies() {
        // Destroy existing enemy instances
        enemy1.destroy();
        enemy2.destroy();
        enemy3.destroy();
    }

    /**
     * Checks if the level is complete.
     * @return True if the level is complete, false otherwise.
     */
    @Override
    public boolean isComplete() {
        return this.getKulaPlayer().getCoinsCount() >= 10;
    }

    /**
     * Proceeds to the next level.
     */
    @Override
    public void goToNextLevel() {
        game.goToNextLevel();
    }

    /**
     * Stops the music associated with the level.
     */
    @Override
    public void stopMusic(){
        gameMusic.stop();
    }

    @Override
    public Ragnite getRagnite() {
        return null;
    }
}