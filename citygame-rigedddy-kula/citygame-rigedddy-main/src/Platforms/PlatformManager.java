package Platforms;

import Level.GameLevel;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

/**
 * @author      nazifa, firoz, nazifa.firoz@city.ac.uk
 */

public class PlatformManager {

    private GameLevel world;

    /**
     * Constructs a PlatformManager object for the specified game world.
     * Initialises the creation of platforms for the game level.
     * @param world The game level for which the platforms are being managed.
     */
    public PlatformManager(GameLevel world) {
        this.world = world;
        createPlatforms();
    }

    /**
     *  Creating all the platforms for the world in order.
     */
    private void createPlatforms() {
        // making the ground
        Shape shape = new BoxShape(65, 10f);
        StaticBody ground = new StaticBody(world, shape);
        ground.setPosition(new Vec2(5f, -17));
        //ground.setFillColor(Color.GRAY);
        new AttachedImage(ground, new BodyImage("data/ground.png", 22f), 1f, 0f, new Vec2(15, -1f));
        //ground.setFillColor(Color.GRAY);

        // fixing pictures
        Shape shape2 = new BoxShape(65, 10f);
        StaticBody ground2 = new StaticBody(world, shape);
        ground2.setPosition(new Vec2(-20f, -17));
        new AttachedImage(ground2, new BodyImage("data/ground.png", 22f), 1f, 0f, new Vec2(12, -1f));

        //1
        Shape platformShape1 = new BoxShape(3, 0.5f);
        StaticBody platform1 = new StaticBody(world, platformShape1);
        platform1.setPosition(new Vec2(2, -2f));
        //platform1.setClipped(true);
        new AttachedImage(platform1, new BodyImage("data/snow.png", 1.3f), 1f, 0f, new Vec2(0, 0));

        //2
        Shape platformShape2 = new BoxShape(7f, 1.3f);
        StaticBody platform2 = new StaticBody(world, platformShape2);
        platform2.setPosition(new Vec2(20, 3.5f));
        new AttachedImage(platform2, new BodyImage("data/snow.png", 2.5f), 1f, 0f, new Vec2(0, 0));

        //3
        Shape platformShape3 = new BoxShape(5f, 0.5f);
        StaticBody platform3 = new StaticBody(world, platformShape3);
        platform3.setPosition(new Vec2(39, -2f));
        new AttachedImage(platform3, new BodyImage("data/snow.png", 1.8f), 1f, 0f, new Vec2(0, -0.3f));

        //4
        Shape platformShape4 = new BoxShape(10f, 7f);
        StaticBody platform4 = new StaticBody(world, platformShape4);
        platform4.setPosition(new Vec2(60, -3f));
        new AttachedImage(platform4, new BodyImage("data/block.png", 17f), 1f, 0f, new Vec2(0, -1.3f));

        //5
        Shape platformShape5 = new BoxShape(10f, 17f);
        StaticBody platform5 = new StaticBody(world, platformShape5);
        platform5.setPosition(new Vec2(90, -13f));
        new AttachedImage(platform5, new BodyImage("data/block.png", 20f), 1f, 0f, new Vec2(0, 6.9f));
        platform5.setClipped(true);

        //6
        Shape platformShape6 = new BoxShape(10f, 17f);
        StaticBody platform6 = new StaticBody(world, platformShape6);
        platform6.setPosition(new Vec2(127, -13f));
        new AttachedImage(platform6, new BodyImage("data/block.png", 20f), 1f, 0f, new Vec2(0, 6.7f));

        // 1 over spikes
        Shape platformShape7 = new BoxShape(5f, 0.5f);
        StaticBody platform7 = new StaticBody(world, platformShape7);
        platform7.setPosition(new Vec2(151, 9f));
        new AttachedImage(platform7, new BodyImage("data/snow.png", 1.8f), 1f, 0f, new Vec2(0, -0.3f));

        // 2 over spikes
        Shape platformShape8 = new BoxShape(5f, 0.5f);
        StaticBody platform8 = new StaticBody(world, platformShape8);
        platform8.setPosition(new Vec2(167, 13f));
        new AttachedImage(platform8, new BodyImage("data/snow.png", 1.8f), 1f, 0f, new Vec2(0, -0.3f));

        // 3 over spikes
        Shape platformShape9 = new BoxShape(5f, 0.5f);
        StaticBody platform9 = new StaticBody(world, platformShape9);
        platform9.setPosition(new Vec2(183, 17f));
        new AttachedImage(platform9, new BodyImage("data/snow.png", 1.8f), 1f, 0f, new Vec2(0, -0.3f));

        //10
        Shape platformShape10 = new BoxShape(10f, 17f);
        StaticBody platform10 = new StaticBody(world, platformShape10);
        platform10.setPosition(new Vec2(205, -12f));
        new AttachedImage(platform10, new BodyImage("data/block.png", 20f), 1f, 0f, new Vec2(0, 6.7f));

        //12
        Shape platformShape12 = new BoxShape(10f, 10f);
        StaticBody platform12 = new StaticBody(world, platformShape12);
        platform12.setPosition(new Vec2(265, -14f));
        new AttachedImage(platform12, new BodyImage("data/block.png", 20f), 1f, 0f, new Vec2(0, 0f));

        //11
        Shape platformShape11 = new BoxShape(20f, 10f);
        StaticBody platform11 = new StaticBody(world, platformShape11);
        platform11.setPosition(new Vec2(234, -20f));
        new AttachedImage(platform11, new BodyImage("data/ground.png", 15f), 1f, 0f, new Vec2(-12.5f, 2.4f));


        //13
        Shape platformShape13 = new BoxShape(10f, 10f);
        StaticBody platform13 = new StaticBody(world, platformShape13);
        platform13.setPosition(new Vec2(287, -9f));
        new AttachedImage(platform13, new BodyImage("data/block.png", 20f), 1f, 0f, new Vec2(0, 0f));

        //14
        Shape platformShape14 = new BoxShape(40f, 20f);
        StaticBody platform14 = new StaticBody(world, platformShape14);
        platform14.setPosition(new Vec2(338, -19f));
        new AttachedImage(platform14, new BodyImage("data/ground.png", 20f), 1f, 0f, new Vec2(-4, 10f));

        // making a border
        Shape borderShape = new BoxShape(20f, 30f);
        StaticBody border = new StaticBody(world, borderShape);
        border.setPosition(new Vec2(-40, 0));
        //border.addImage(new BodyImage("data/trees.png", 39f));
        new AttachedImage(border, new BodyImage("data/newtrees.png", 20f), 1f, 0f, new Vec2(7, 0f));

        // making a second border
        Shape borderShape2 = new BoxShape(20f, 30f);
        StaticBody border2 = new StaticBody(world, borderShape2);
        border2.setPosition(new Vec2(370, 3));
        new AttachedImage(border2, new BodyImage("data/newtrees.png", 20f), 1f, 0f, new Vec2(-7, 5));

    }
}

