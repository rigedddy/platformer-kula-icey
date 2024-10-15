package Platforms;

import Level.GameLevel;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

/**
 * @author      nazifa, firoz, nazifa.firoz@city.ac.uk
 */

public class PlatformManager2 {

    private GameLevel world;

    /**
     * Constructs a PlatformManager object for the specified game world.
     * Initializes the creation of platforms for the game level.
     * @param world The game level for which the platforms are being managed.
     */
    public PlatformManager2(GameLevel world) {
        this.world = world;
        createPlatforms();
        createMovingPlatform();
    }

    /**
     *  Creating all the platforms for the world in order.
     */
    private void createPlatforms() {
        // making the ground
        Shape g = new BoxShape(30, 10f);
        StaticBody ground = new StaticBody(world, g);
        ground.setPosition(new Vec2(-11f, -17));
        new AttachedImage(ground, new BodyImage("data/fireground.png", 30f), 1f, 0f, new Vec2(0, -5f));
        //ground.addImage(new BodyImage("data/lavaground.png", 30f));
        //ground.setClipped(true);

        //1
        Shape platformShape1 = new BoxShape(7, 3f);
        StaticBody platform1 = new StaticBody(world, platformShape1);
        platform1.setPosition(new Vec2(12, -4f));
        new AttachedImage(platform1, new BodyImage("data/fireblock.png", 15f), 1f, 0f, new Vec2(0, -1f));
        platform1.setClipped(true);

        //2
        Shape platformShape2 = new BoxShape(7, 6f);
        StaticBody platform2 = new StaticBody(world, platformShape2);
        platform2.setPosition(new Vec2(26, -3f));
        new AttachedImage(platform2, new BodyImage("data/fireblock.png", 15f), 1f, 0f, new Vec2(0, -1f));
        platform2.setClipped(true);

        //3
        Shape platformShape3 = new BoxShape(7, 9f);
        StaticBody platform3 = new StaticBody(world, platformShape3);
        platform3.setPosition(new Vec2(40, -2f));
        new AttachedImage(platform3, new BodyImage("data/fireblock.png", 30f), 1f, 0f, new Vec2(0, -1f));
        platform3.setClipped(true);

        //4
        Shape platformShape4 = new BoxShape(7, 12f);
        StaticBody platform4 = new StaticBody(world, platformShape4);
        platform4.setPosition(new Vec2(54, -1f));
        new AttachedImage(platform4, new BodyImage("data/fireblock.png", 35f), 1f, 0f, new Vec2(0, -1f));
        platform4.setClipped(true);

        //5
        Shape platformShape5 = new BoxShape(20, 4f);
        StaticBody platform5 = new StaticBody(world, platformShape5);
        platform5.setPosition(new Vec2(80, 7f));
        new AttachedImage(platform5, new BodyImage("data/fireground.png", 20f), 1f, 0f, new Vec2(0, -1f));
        platform5.setClipped(true);

        //6
        Shape platformShape6 = new BoxShape(25, 8f);
        StaticBody platform6 = new StaticBody(world, platformShape6);
        platform6.setPosition(new Vec2(124, -20f));
        new AttachedImage(platform6, new BodyImage("data/fireground.png", 30f), 1f, 0f, new Vec2(0, -1f));
        platform6.setClipped(true);

        //7
        Shape platformShape7 = new BoxShape(10, 8f);
        StaticBody platform7 = new StaticBody(world, platformShape7);
        platform7.setPosition(new Vec2(175, -20f));
        new AttachedImage(platform7, new BodyImage("data/fireblock.png", 20f), 1f, 0f, new Vec2(0, -1f));
        platform7.setClipped(true);

        //8
        Shape platformShape8 = new BoxShape(10, 8f);
        StaticBody platform8 = new StaticBody(world, platformShape8);
        platform8.setPosition(new Vec2(210, -20f));
        new AttachedImage(platform8, new BodyImage("data/fireblock.png", 20f), 1f, 0f, new Vec2(0, -1f));
        platform8.setClipped(true);

        Spikes s5 = new Spikes(world,15, 10,6,155,-22,"data/firespikes3.png");
        //s5.setClipped(true);

        Spikes s6 = new Spikes(world,15, 10,6,195,-22,"data/firespikes3.png");
        //s8.setClipped(true);

        //9
        Shape platformShape9 = new BoxShape(10, 8f);
        StaticBody platform9 = new StaticBody(world, platformShape9);
        platform9.setPosition(new Vec2(288, -18f));
        new AttachedImage(platform9, new BodyImage("data/fireblock.png", 20f), 1f, 0f, new Vec2(0, -1f));
        platform9.setClipped(true);

        Spikes s7 = new Spikes(world,28, 30,6,249,-24,"data/firespikes3.png");
        //s6.setClipped(true);

        //10
        Shape platformShape10 = new BoxShape(20, 8f);
        StaticBody platform10 = new StaticBody(world, platformShape10);
        platform10.setPosition(new Vec2(317, -23f));
        new AttachedImage(platform10, new BodyImage("data/fireground.png", 30f), 1f, 0f, new Vec2(0, -1f));
        platform10.setClipped(true);

        Spikes s8 = new Spikes(world,28, 30,6,366,-26,"data/firespikes3.png");
        //s7.setClipped(true);

        //11
        Shape platformShape11 = new BoxShape(10, 1f);
        StaticBody platform11 = new StaticBody(world, platformShape11);
        platform11.setPosition(new Vec2(315, -4.5f));
        new AttachedImage(platform11, new BodyImage("data/fireblock.png", 20f), 1f, 0f, new Vec2(0, -1f));
        platform11.setClipped(true);

        //12
        Shape platformShape12 = new BoxShape(30, 2f);
        StaticBody platform12 = new StaticBody(world, platformShape12);
        platform12.setPosition(new Vec2(355, -3.5f));
        new AttachedImage(platform12, new BodyImage("data/fireground.png", 35f), 1f, 0f, new Vec2(0, -1f));
        platform12.setClipped(true);

        //13
        Shape platformShape13 = new BoxShape(30, 2f);
        StaticBody platform13 = new StaticBody(world, platformShape13);
        platform13.setPosition(new Vec2(415, -3.5f));
        new AttachedImage(platform13, new BodyImage("data/fireground.png", 35f), 1f, 0f, new Vec2(0, -1f));
        platform13.setClipped(true);

        // making a border
        Shape borderShape = new BoxShape(20f, 30f);
        StaticBody border = new StaticBody(world, borderShape);
        border.setPosition(new Vec2(-40, 5));
        //border.addImage(new BodyImage("data/trees.png", 39f));
        new AttachedImage(border, new BodyImage("data/volcano.png", 25f), 1f, 0f, new Vec2(5, 0f));

        // making a second border
        Shape borderShape2 = new BoxShape(20f, 10f);
        StaticBody border2 = new StaticBody(world, borderShape2);
        border2.setPosition(new Vec2(409, 11));
        //border.addImage(new BodyImage("data/trees.png", 39f));
        new AttachedImage(border2, new BodyImage("data/volcano.png", 25f), 1f, 0f, new Vec2(-15, 0f));


    }

    /**
     *  Creating moving platforms for the world.
     */
    private void createMovingPlatform() {

        // 1
        Shape platformShape = new BoxShape(5, 1f);
        MovingPlatform movingPlatform = new MovingPlatform(world, platformShape, 225, 273, 0.15f, 225, -7);
        world.addStepListener(movingPlatform);
        new AttachedImage(movingPlatform, new BodyImage("data/fireblock.png", 10f), 1f, 0f, new Vec2(0, -1f));
        movingPlatform.setClipped(true);
    }

}