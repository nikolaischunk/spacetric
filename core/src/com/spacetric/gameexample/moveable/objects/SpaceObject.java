package com.spacetric.gameexample.moveable.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.spacetric.gameexample.abstraction.SpaceElement;

import java.util.Random;

public class SpaceObject extends SpaceElement {

    private static final int minWidth = 70;
    private static final int maxWidth = 200;
    private static final int minSpeed = 3;
    private static final int maxSpeed = 10;
    private static final Random intRand = new Random();

    public SpaceObject(String pathToImage) {
        super(intRand.nextInt(maxSpeed + 1 - minSpeed) + minSpeed, pathToImage, intRand.nextInt(maxWidth + 1 - minWidth) + minWidth, intRand.nextInt(Gdx.graphics.getWidth() - maxWidth), Gdx.graphics.getHeight());
    }

    @Override
    public void move(Batch batch) {
        y -= speed;
        super.move(batch);
        if (y < -image.getHeight()) {
            speed = intRand.nextInt(maxSpeed + 1 - minSpeed) + minSpeed;
            y = Gdx.graphics.getHeight();
            x = intRand.nextInt(Gdx.graphics.getWidth() - image.getWidth());
            Gdx.app.log("METEOR_LOG", x + " " + y);
        }
    }
}
