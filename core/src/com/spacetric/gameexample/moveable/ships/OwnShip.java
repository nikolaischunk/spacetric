package com.spacetric.gameexample.moveable.ships;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.spacetric.gameexample.abstraction.SpaceElement;
import com.spacetric.gameexample.moveable.objects.Laser;

public class OwnShip extends SpaceElement {

    private Laser leftLaser;
    private Laser rightLaser;
    private static final int width = 150;
    private static final int height = 150;

    public OwnShip(String pathToFile, int speed, int x, int y, String pathToLaserImg) {
        super(speed, pathToFile, width, height, x, y);
        leftLaser = new Laser(pathToLaserImg, x,y);
        rightLaser = new Laser(pathToLaserImg, x + width % 10, y);
    }

    @Override
    public void move(Batch batch) {
        super.move(batch);
        leftLaser.move(batch);
        rightLaser.move(batch);
    }

    public void shoot(Texture laser, Batch batch) {
        batch.draw(laser, x, y);

    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }
}
