package com.spacetric.gameexample.moveable.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.spacetric.gameexample.abstraction.SpaceElement;

import java.util.Random;

public class SpaceObject extends SpaceElement {

    private static final int MIN_WIDTH = 70;
    private static final int MAX_WIDTH = 200;
    private static final int MIN_SPEED_WIDTH = 3;
    private static final int MAX_SPEED = 10;
    private static final Random intRand = new Random();

    public SpaceObject(String pathToImage) {
        super(intRand.nextInt(MAX_SPEED + 1 - MIN_SPEED_WIDTH) + MIN_SPEED_WIDTH, pathToImage, intRand.nextInt(MAX_WIDTH + 1 - MIN_WIDTH) + MIN_WIDTH, intRand.nextInt(Gdx.graphics.getWidth() - MAX_WIDTH), Gdx.graphics.getHeight());
    }

    @Override
    public void move(Batch batch) {
        y -= speed;
        super.move(batch);
        if (y < -image.getHeight()) {
            speed = intRand.nextInt(MAX_SPEED + 1 - MIN_SPEED_WIDTH) + MIN_SPEED_WIDTH;
            y = Gdx.graphics.getHeight();
            x = intRand.nextInt(Gdx.graphics.getWidth() - image.getWidth());
            Gdx.app.log("METEOR_LOG", x + " " + y);
        }
    }

    @Override
    public void dispose() {
        image.dispose();
    }
}
