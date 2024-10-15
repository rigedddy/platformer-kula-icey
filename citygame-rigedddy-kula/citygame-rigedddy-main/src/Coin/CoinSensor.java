package Coin;

import Kula.KulaPlayer;
import city.cs.engine.*;
import Coin.Coin;

/**
 * @author      nazifa, firoz, nazifa.firoz@city.ac.uk
 */


public class CoinSensor extends Sensor implements SensorListener {
    private final KulaPlayer kula;
    private final Coin coin;

    /**
     * Constructs a CoinSensor with the specified coin, shape, and player.
     * @param coin The Coin instance representing the coin.
     * @param shape The shape of the sensor.
     * @param kula The KulaPlayer instance representing the player.
     */
    public CoinSensor(Coin coin,Shape shape, KulaPlayer kula) {
        super(coin, shape);
        this.kula = kula;
        this.coin = coin;
        this.addSensorListener(this);
    }

    /**
     * Destroys the coin upon contact with the player and increments the player's coin count.
     * @param sensorEvent The event object representing the beginning of contact.
     */
    @Override
    public void beginContact(SensorEvent sensorEvent) {
        if (sensorEvent.getContactBody() instanceof KulaPlayer kula) {
            coin.destroy();
            kula.incrementCoins();
        }
    }

    @Override
    public void endContact(SensorEvent sensorEvent) {

    }

}

