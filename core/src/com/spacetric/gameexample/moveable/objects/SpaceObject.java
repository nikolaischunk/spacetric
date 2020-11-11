package com.spacetric.gameexample.moveable.objects;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.spacetric.gameexample.abstraction.SpaceElement;

public class SpaceObject extends SpaceElement {

    public SpaceObject(String pathToImage, int speed, int width, int height, int x, int y) {
        super(speed, pathToImage, width, height, x, y);
    }

    @Override
    public void moveDown(Batch batch) {
        super.moveDown(batch);
        if (y < 0) {
            System.out.println("LOST");
        }
    }
}
