package Coin;

import Kula.KulaControl;
import Level.GameLevel;
import city.cs.engine.*;
import Kula.KulaPlayer;
import org.jbox2d.common.Vec2;

/**
 * @author      nazifa, firoz, nazifa.firoz@city.ac.uk
 */

public class CoinHandler {

    private KulaPlayer kula;
    private GameLevel world;
    private int coinCount; // Added coin count variable

    /**
     * Initialises the coin count to zero.
     * @param world The GameLevel instance representing the game world.
     * @param kula The KulaPlayer instance representing the player.
     */
    public CoinHandler(GameLevel world, KulaPlayer kula) {
        this.world = world;
        this.kula = kula;
        this.coinCount = 0; // Initialize coin count
    }

    /**
     * Spawns a coin at a random position based on the current stage of the game level.
     * @param stage The current stage of the game level.
     */
    public void spawnCoin(int stage) {
        double x = 0;
        double y = 0;
        if (stage == 1) {
            x = Math.random() * 150 - 15;
            y = Math.random() * 5 - (-10);
        }
        else if(stage == 2) {
            x = Math.random() * 50 - (-140);
            y = (Math.random() * 5 - (-17));
        }
        else if (stage == 3) {
            x = Math.random() * 120 - (-210);
            y =  Math.random() * 5 - (-2);
        }
        else if (stage == 4){
            x = Math.random() * 48 - (-50);
            y = Math.random() * 3 - (-17);
        }
        else if (stage == 5){
            x = Math.random() * 120 - (-100);
            y = Math.random() * 5 - (7);
        }
        else if (stage == 6){
            x = Math.random() * 36 - (-299);
            y = Math.random() * 1.5f - (10);
        }
        else if (stage == 7){
            x = Math.random() * 70 - (-25);
            y = Math.random() * 1.5f - (22);
        }
        Coin coin = new Coin(world, new CircleShape(1));
        coin.setPosition(new Vec2((float) x, (float) y));
    }
}