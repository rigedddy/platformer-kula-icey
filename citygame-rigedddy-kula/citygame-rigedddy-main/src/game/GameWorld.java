//package game;
//
//import Coin.CoinHandler;
//import Enemy.Enemy;
//import Enemy.EnemyControl;
//import Kula.KulaPlayer;
//import Platforms.PlatformManager;
//import Platforms.Spikes;
//import city.cs.engine.*;
//import city.cs.engine.Shape;
//import org.jbox2d.common.Vec2;
//import javax.swing.*;
//import java.util.ArrayList;
//

/**
 * @author      nazifa, firoz, nazifa.firoz@city.ac.uk
 */

//public class GameWorld extends World {
//
//    private KulaPlayer kula;
//    private Timer coinSpawnTimer;
//    private Timer coinSpawnTimer2;
//    private Timer coinSpawnTimer3;
//    private CoinHandler coinHandler;
//    private PlatformManager platformManager;
//    private Spikes spikes;
//    private Enemy enemy1;
//    private Enemy enemy2;
//    private Enemy enemy3;
//    public GameWorld() {
//        super();
//
//        // get all the platforms into the game
//        platformManager = new PlatformManager(this);
//
//        // create kula
//        //kula = new KulaPlayer(this);
//
//        // making a border
//        Shape borderShape = new BoxShape(20f, 30f);
//        StaticBody border = new StaticBody(this, borderShape);
//        border.setPosition(new Vec2(-40, 0));
//        //border.addImage(new BodyImage("data/trees.png", 39f));
//        new AttachedImage(border, new BodyImage("data/newtrees.png", 20f), 1f, 0f, new Vec2(7, 0f));
//
//        // making a second border
//        Shape borderShape2 = new BoxShape(20f, 30f);
//        StaticBody border2 = new StaticBody(this, borderShape2);
//        border2.setPosition(new Vec2(370, 3));
//        new AttachedImage(border2, new BodyImage("data/newtrees.png", 20f), 1f, 0f, new Vec2(-7, 5));
//
//        // enemies in world
//        createEnemies();
//
//        // portal
//        Shape portalShape = new BoxShape(5f,5f);
//        StaticBody portal = new StaticBody(this, portalShape);
//        portal.setPosition(new Vec2(340,4.5f));
//        portal.addImage(new BodyImage("data/portalone.png", 22f));
//
//        // timer for coin
//        coinHandler = new CoinHandler(this, kula);
//        coinSpawnTimer = new Timer(5000, e -> coinHandler.spawnCoin());
//        coinSpawnTimer.start();
//        coinSpawnTimer2 = new Timer(9000, e -> coinHandler.spawnCoin2());
//        coinSpawnTimer2.start();
//        coinSpawnTimer3 = new Timer(10000, e -> coinHandler.spawnCoin3());
//        coinSpawnTimer3.start();
//
//        Spikes s1 = new Spikes(this,18, 9,7,75,-12);
//        Spikes s2 = new Spikes(this,18, 12,7,109f,-12);
//        Spikes s3 = new Spikes(this,40, 12,7,150,-12);
//        Spikes s4 = new Spikes(this,40, 12,7,170,-12);
//        Spikes s5 = new Spikes(this,35, 12,7,183,-12);
//        //s3.setClipped(true);
//    }
//
//    public void createEnemies() {
//        // Create enemy 1
//        Shape enemyShape = new BoxShape(2, 2f);
//        enemy1 = new Enemy(this, enemyShape, 13.3f, 26.7f, 5);
//        EnemyControl enemyControl1 = new EnemyControl(enemy1, 13.3f, 26.7f, 3);
//        new AttachedImage(enemy1, new BodyImage("data/enemy_1.gif", 6f), 1f, 0f, new Vec2(0, 0.5f));
//        addStepListener(enemyControl1);
//
//        // Create enemy 2
//        Shape enemyShape2 = new BoxShape(2, 2f);
//        enemy2 = new Enemy(this, enemyShape2, 81f, 99, 7);
//        EnemyControl enemyControl2 = new EnemyControl(enemy2, 81f, 99, 3);
//        enemy2.addImage(new BodyImage("data/enemy_2.gif", 5));
//        addStepListener(enemyControl2);
//
//        // Create enemy 3
//        Shape enemyShape3 = new BoxShape(2, 2f);
//        enemy3 = new Enemy(this, enemyShape3, 220f, 249, -7.9f);
//        EnemyControl enemyControl3 = new EnemyControl(enemy3, 220f, 249, 7);
//        new AttachedImage(enemy3, new BodyImage("data/enemy_1.gif", 6f), 1f, 0f, new Vec2(0, 0.5f));
//        addStepListener(enemyControl3);
//
//    }
//
//    public void destroyEnemies() {
//        // Destroy existing enemy instances
//        enemy1.destroy();
//        enemy2.destroy();
//        enemy3.destroy();
//    }
//
//
//    public void addCollisionListener(CoinHandler coinHandler) {
//    }
//
//    public KulaPlayer getKulaPlayer() {
//        return kula;
//    }
//
//
//    public CoinHandler getCoinHandler() {
//        return coinHandler;
//    }
//
//}


//// Create a new Timer for updating the game
//            gameTimer = new Timer(1000 / 60, new ActionListener() {
//@Override
//public void actionPerformed(ActionEvent e) {
//        // Print the coordinates of KulaPlayer
//        Vec2 kulaPosition = currentLevel.getKulaPlayer().getPosition();
//        float x = kulaPosition.x;
//        float y = kulaPosition.y;
//        //System.out.println("KulaPlayer coordinates: x = " + x + ", y = " + y);
//        view.repaint();
//        }
//        });
//        gameTimer.start();

//// create a new Timer for updating the current level
//            gameTimer = new Timer(1000 / 60, new ActionListener() {
//@Override
//public void actionPerformed(ActionEvent e) {
//        // Print the coordinates of KulaPlayer
//        Vec2 kulaPosition = currentLevel.getKulaPlayer().getPosition();
//        float x = kulaPosition.x;
//        float y = kulaPosition.y;
//        //System.out.println("KulaPlayer coordinates: x = " + x + ", y = " + y);
//        view.repaint();
//        }
//        });
//        gameTimer.start();
