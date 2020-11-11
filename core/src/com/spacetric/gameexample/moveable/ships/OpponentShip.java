package com.spacetric.gameexample.moveable.ships;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.spacetric.gameexample.abstraction.SpaceElement;

public class OpponentShip extends SpaceElement {

    public OpponentShip(String pathToFile, int speed, int width, int height, int x, int y) {
        super(speed, pathToFile, width, height, x, y);
    }

    @Override
    public void moveDown(Batch batch) {
        super.moveDown(batch);
        if (y < 1) {
            System.out.println("LOST");
        }
    }

}

