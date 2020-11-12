package com.spacetric.gameexample.moveable.ships;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.spacetric.gameexample.abstraction.SpaceElement;
import com.spacetric.gameexample.moveable.objects.Laser;

public class OwnShip extends SpaceElement {

    private Laser laser;

    private static final int width = 150;
    private static final int height = 150;


    public OwnShip(String pathToFile, int speed, int x, int y, String pathToLaserImg) {
        super(speed, pathToFile, width, height, x, y);
        laser = new Laser(pathToLaserImg, x,y);

    }

    @Override
    public void move(Batch batch) {
        super.move(batch);
        laser.move(batch);

    }

    public Laser shoot() {
        return new Laser(laser.getLaserTexture(), x, y);
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    public Laser getLaser() {
        return laser;
    }
}
