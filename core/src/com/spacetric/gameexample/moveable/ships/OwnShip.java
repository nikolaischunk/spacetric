package com.spacetric.gameexample.moveable.ships;

import com.badlogic.gdx.graphics.Texture;
import com.spacetric.gameexample.abstraction.SpaceElement;

public class OwnShip extends SpaceElement {

    private Texture laser;

    protected OwnShip(String pathToFile, int speed, int width, int height, int x, int y, String pathToLaserImg) {
        super(speed, pathToFile, width, height, x, y);

    }
}
