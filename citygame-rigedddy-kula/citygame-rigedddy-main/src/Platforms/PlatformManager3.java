package Platforms;

import Level.GameLevel;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

/**
 * @author      nazifa, firoz, nazifa.firoz@city.ac.uk
 */

public class PlatformManager3 {

    private GameLevel world;

    /**
     * Constructs a PlatformManager object for the specified game world.
     * Initializes the creation of platforms for the game level.
     * @param world The game level for which the platforms are being managed.
     */
    public PlatformManager3(GameLevel world) {
        this.world = world;
        createPlatforms();
        //createMovingPlatform();
    }

    /**
     *  Creating all the platforms for the world in order.
     */
    private void createPlatforms() {

        // wall 1
        Shape wallShape = new BoxShape(10, 20f);
        StaticBody wall = new StaticBody(world, wallShape);
        wall.setPosition(new Vec2(-27f, 10));
        new AttachedImage(wall, new BodyImage("data/ruinsground.png", 20f), 1f, 0f, new Vec2(-27, -10f));
        //ground.addImage(new BodyImage("data/lavaground.png", 30f));
        //ground.setClipped(true);

        // ground wall
        Shape g = new BoxShape(30, 10f);
        StaticBody ground = new StaticBody(world, g);
        ground.setPosition(new Vec2(-11f, -17));
        new AttachedImage(ground, new BodyImage("data/ruinsground.png", 30f), 1f, 0f, new Vec2(-22, -5f));
        //ground.addImage(new BodyImage("data/lavaground.png", 30f));
        //ground.setClipped(true);

        // ground
        Shape platformShape1 = new BoxShape(90, 10f);
        StaticBody platform1 = new StaticBody(world, platformShape1);
        platform1.setPosition(new Vec2(57, -37f));
        new AttachedImage(platform1, new BodyImage("data/ruinsground.png", 37f), 1f, 0f, new Vec2(0, -1f));
        platform1.setClipped(true);

        // wall two
        Shape platformShape2 = new BoxShape(30, 10f);
        StaticBody platform2 = new StaticBody(world, platformShape2);
        platform2.setPosition(new Vec2(145, -17f));
        new AttachedImage(platform2, new BodyImage("data/ruinsground.png", 30f), 1f, 0f, new Vec2(0, -1f));
        platform2.setClipped(true);

        // x = 21 , 96
        // y = -24


    }


}
