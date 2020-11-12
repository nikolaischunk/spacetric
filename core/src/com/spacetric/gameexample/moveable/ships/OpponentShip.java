package com.spacetric.gameexample.moveable.ships;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.spacetric.gameexample.abstraction.SpaceElement;

import java.util.Random;

public class OpponentShip extends SpaceElement {

    private Texture t;
    private static final int minWidth = 70;
    private static final int maxWidth = 150;
    private static final int minSpeed = 2;
    private static final int maxSpeed = 5;
    private static final Random intRand = new Random();

    public OpponentShip(String pathToFile, int speed, int width, int height, int x, int y) {
        super(speed, pathToFile, width, height, x, y);
    }

    public OpponentShip(String pathToFile) {
        super(
                intRand.nextInt(maxSpeed + 1 - minSpeed) + minSpeed,
                pathToFile,
                intRand.nextInt(maxWidth + 1 - minWidth) + minWidth,
                intRand.nextInt(Gdx.graphics.getWidth() - maxWidth),
                Gdx.graphics.getHeight()
        );
    }

    @Override
    public void move(Batch batch) {
        y -= speed;
        super.move(batch);
        if (y < -image.getHeight()) {
            Gdx.app.log("LOST", "You lost the game");
        }
    }

}

