package com.spacetric.gameexample.moveable.ships;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.spacetric.gameexample.abstraction.SpaceElement;
import com.spacetric.gameexample.moveable.objects.Laser;

import java.util.Objects;
import java.util.Optional;

public class OwnShip extends SpaceElement {

    private final Laser laser;
    private int laserIterationDelay = 9;


    public OwnShip(String pathToFile, int speed, int x, int y, String pathToLaserImg) {
        super(speed, pathToFile, 150, 150, x, y);
        laser = new Laser(pathToLaserImg, x + (150), y);
        // Set width and height from rectangle
        setWidth(150);
        setHeight(150);
    }

    @Override
    public void move(Batch batch) {
        super.move(batch);
    }

    public Optional<Laser> shoot() {
        laserIterationDelay++;
        // creates delay of shoots so they are not too fast
        if (laserIterationDelay == 10) {
            laserIterationDelay = 0;
            return Optional.of(new Laser(x, y + 150 - 10));
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OwnShip ownShip = (OwnShip) o;
        return laserIterationDelay == ownShip.laserIterationDelay &&
                Objects.equals(laser, ownShip.laser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), laser, laserIterationDelay);
    }
}
