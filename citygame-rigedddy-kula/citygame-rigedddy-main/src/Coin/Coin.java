package Coin;

import Kula.KulaPlayer;
import city.cs.engine.*;
import city.cs.engine.Shape;

/**
 * @author      nazifa, firoz, nazifa.firoz@city.ac.uk
 */

public class Coin extends StaticBody {
    private Fixture fixture;
    private KulaPlayer kula;
    private Sensor sensor;
    private Coin coin;

    /**
     * Constructs a Coin object with the specified world and shape.
     * @param world The world in which the coin exists.
     * @param shape The shape of the coin.
     */
    public Coin(World world, Shape shape) {
        super(world);
        addImage(new BodyImage("data/coin.png", 2f));
        fixture = new GhostlyFixture(this, shape);
        sensor = new CoinSensor(this, shape, kula);
    }


}
