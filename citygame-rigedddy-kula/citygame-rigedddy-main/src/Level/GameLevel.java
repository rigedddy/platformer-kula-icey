package Level;
import Kula.KulaPlayer;
import Ragnite.Ragnite;
import city.cs.engine.*;
import game.Game;

/**
 * @author      nazifa, firoz, nazifa.firoz@city.ac.uk
 */

public abstract class GameLevel extends World{ ;
    protected Game game;

    /**
     * Constructs a GameLevel with the specified Game instance.
     * @param game The Game instance associated with this level.
     */
    public GameLevel(Game game) {
        this.game = game;
    }

    /**
     * Retrieves the KulaPlayer associated with this level.
     * @return The KulaPlayer object.
     */
    public abstract KulaPlayer getKulaPlayer();

    /**
     * Checks if the level is complete.
     * @return the values needed for the level to be complete
     */
    public abstract boolean isComplete();

    /**
     * Proceeds to the next level.
     */
    public abstract void goToNextLevel();

    /**
     * Creates enemies in the level.
     */
    public abstract void createEnemies();

    /**
     * Creates Ragnite in the level.
     */
    public abstract void createRagnite();

    /**
     * Destroys all enemies in the level.
     */
    public abstract void destroyEnemies();

    /**
     * Stops the music associated with the level.
     */
    public abstract void stopMusic();

    public abstract Ragnite getRagnite();

}