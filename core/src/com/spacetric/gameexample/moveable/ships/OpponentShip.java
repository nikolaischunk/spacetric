package com.spacetric.gameexample.moveable.ships;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.spacetric.gameexample.abstraction.SpaceElement;

public class OpponentShip extends SpaceElement {

    public OpponentShip(String pathToFile, int speed, int width, int height, int x, int y) {
        super(speed, pathToFile, width, height, x, y);
    }

    @Override
    public void move(Batch batch) {
        y -= speed;
        super.move(batch);
    }

}

