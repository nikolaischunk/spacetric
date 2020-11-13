package com.spacetric.gameexample.moveable.backround;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;

import java.util.Objects;

public class Background extends Rectangle {

    private transient Texture sky1;
    private transient Texture sky2;
    private float yCoordinateSky1;
    private float yCoordinateSky2;
    private float speed;

    /**
     * Constructs a new rectangle with all values set to zero
     */
    public Background(Texture sky1, Texture sky2) {
        this.sky1 = sky1;
        this.sky2 = sky2;
        this.yCoordinateSky1 = 0;
        this.yCoordinateSky2 = sky1.getHeight();
        this.speed = 250;
    }

    public void render(Batch batch) {
        yCoordinateSky1 = yCoordinateSky1 - (speed * Gdx.graphics.getDeltaTime());
        yCoordinateSky2 = yCoordinateSky2 - (speed * Gdx.graphics.getDeltaTime());

        float width = Gdx.graphics.getWidth();
        float height = (width / sky1.getWidth()) * sky1.getHeight();
        float topBg1 = yCoordinateSky1 + height;
        float topBg2 = yCoordinateSky2 + height;

        //if sky1 leaves screen, reset position y back to height of screen
        if (topBg1 < 0) {
            yCoordinateSky1 = Gdx.graphics.getHeight();
        }
        //if sky2 leaves screen, reset position y back to height of screen
        if (topBg2 < 0) {
            yCoordinateSky2 = Gdx.graphics.getHeight();
        }

        batch.draw(sky1, x, yCoordinateSky1, width, height);
        batch.draw(sky1, x, yCoordinateSky2, width, height);
    }

    public Texture getSky() {
        return sky1;
    }

    public Texture getSky2() {
        return sky2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Background that = (Background) o;
        return Float.compare(that.yCoordinateSky1, yCoordinateSky1) == 0 &&
                Float.compare(that.yCoordinateSky2, yCoordinateSky2) == 0 &&
                Float.compare(that.speed, speed) == 0 &&
                Objects.equals(sky1, that.sky1) &&
                Objects.equals(sky2, that.sky2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sky1, sky2, yCoordinateSky1, yCoordinateSky2, speed);
    }
}
