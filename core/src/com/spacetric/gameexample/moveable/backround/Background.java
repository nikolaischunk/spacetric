package com.spacetric.gameexample.moveable.backround;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;

public class Background extends Rectangle {

    Texture sky1;
    Texture sky2;
    float yCoordinateSky1;
    float yCoordinateSky2;
    float secondBackgroundY;
    float speed;

    /**
     * Constructs a new rectangle with all values set to zero
     */
    public Background(Texture sky1, Texture sky2) {
        this.sky1 = sky1;
        this.sky2 = sky2;
        this.yCoordinateSky1 = 0;
        this.yCoordinateSky2 = sky1.getHeight();
        this.speed = 250;
        this.secondBackgroundY = Gdx.graphics.getHeight();
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

}
