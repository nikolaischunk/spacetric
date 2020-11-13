package com.spacetric.gameexample.moveable.ships;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.spacetric.gameexample.abstraction.SpaceElement;

import java.util.Random;

public class OpponentShip extends SpaceElement {
    
    private static final int MIN_WIDTH = 70;
    private static final int MAX_WIDTH = 150;
    private static final int MIN_SPEED = 2;
    private static final int MAX_SPEED = 5;
    private static final Random intRand = new Random();

    public OpponentShip(String pathToFile) {
        super(
                intRand.nextInt(MAX_SPEED + 1 - MIN_SPEED) + MIN_SPEED,
                pathToFile,
                intRand.nextInt(MAX_WIDTH + 1 - MIN_WIDTH) + MIN_WIDTH,
                intRand.nextInt(Gdx.graphics.getWidth() - MAX_WIDTH),
                Gdx.graphics.getHeight()
        );
    }

    @Override
    public void move(Batch batch) {
        y -= speed;
        super.move(batch);
        if (y < -image.getHeight()) {
            // TODO Change to losing screen
            System.exit(-1);
            Gdx.app.log("LOST", "You lost the game");
        }
    }

    @Override
    public void dispose() {
        image.dispose();
    }

}

