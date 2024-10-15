package Platforms;

import Level.GameLevel;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * @author      nazifa, firoz, nazifa.firoz@city.ac.uk
 */

public class Portal extends StaticBody {
    private GameLevel world;

    /**
     * Constructs a portal object with the specified properties.
     * @param world The game level in which the portal exists.
     * @param imageHeight The height of the portal image.
     * @param width The width of the portal.
     * @param height The height of the portal.
     * @param xPos The x-coordinate position of the portal.
     * @param yPos The y-coordinate position of the portal.
     * @param imagePath The file path of the portal image.
     */
    public Portal(GameLevel world, float imageHeight, float width, float height, float xPos, float yPos, String imagePath) {
        super(world, new BoxShape(width, height));
        this.world = world;
        this.setPosition(new Vec2(xPos, yPos));
        BodyImage img = new BodyImage(imagePath, imageHeight);
        this.addImage(img);
    }
}
