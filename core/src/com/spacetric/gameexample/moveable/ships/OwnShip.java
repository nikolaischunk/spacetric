package com.spacetric.gameexample.moveable.ships;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.spacetric.gameexample.abstraction.SpaceElement;
import com.spacetric.gameexample.moveable.objects.Laser;

import java.util.Optional;

public class OwnShip extends SpaceElement {

    private final Laser laser;
    private int laserIterationDelay = 9;
    private static final int width = 150;
    private static final int height = 150;


    public OwnShip(String pathToFile, int speed, int x, int y, String pathToLaserImg) {
        super(speed, pathToFile, width, height, x, y);
        laser = new Laser(pathToLaserImg, x + (width), y);
        setWidth(width);
        setHeight(height);
    }

    @Override
    public void move(Batch batch) {
        super.move(batch);
    }

    public Optional<Laser> shoot() {
        laserIterationDelay++;
        if (laserIterationDelay == 10) {
            laserIterationDelay = 0;
            return Optional.of(new Laser(laser.getTexture(), x, y + height - 10));
        }
        return Optional.empty();
    }

    public Laser getLaser() {
        return laser;
    }

    @Override
    public void dispose() {
        image.dispose();
        laser.getTexture().dispose();
    }
}
