package Platforms;

import Level.GameLevel;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

/**
 * @author      nazifa, firoz, nazifa.firoz@city.ac.uk
 */

public class Spikes extends StaticBody {

    private GameLevel world;

    /**
     * Constructs a spikes object with the specified properties.
     * @param world The game level in which the spikes exist.
     * @param imageHeight The height of the spikes image.
     * @param width The width of the spikes.
     * @param height The height of the spikes.
     * @param xPos The x-coordinate position of the spikes.
     * @param yPos The y-coordinate position of the spikes.
     * @param imagePath The file path of the spikes image.
     */
    public Spikes(GameLevel world, float imageHeight, float width, float height, float xPos, float yPos, String imagePath) {
        super(world, new BoxShape(width, height));
        this.world = world;
        this.setPosition(new Vec2(xPos, yPos));
        BodyImage img = new BodyImage(imagePath, imageHeight);
        this.addImage(img);
    }
}
