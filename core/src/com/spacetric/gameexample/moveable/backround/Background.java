package com.spacetric.gameexample.moveable.backround;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;

public class Background extends Rectangle {

    Texture sky;
    Texture sky2;
    float ysky;
    float ysky2;
    float secondBackgroundY;
    float speed;

    /**
     * Constructs a new rectangle with all values set to zero
     */
    public Background(Texture sky, Texture sky2) {
        this.sky = sky;
        this.sky2 = sky2;
        this.ysky = 0;
        this.ysky2 = sky.getHeight();

        this.speed = 250;


        this.secondBackgroundY = Gdx.graphics.getHeight();

    }

    public void render(Batch batch) {

        ysky = ysky - (speed * Gdx.graphics.getDeltaTime());
        ysky2 = ysky2 - (speed * Gdx.graphics.getDeltaTime());

        float width = Gdx.graphics.getWidth();
        float height = (width / sky.getWidth()) * sky.getHeight();

        float topBg1 = ysky + height;
        float topBg2 = ysky2 + height;
        //Wenn erster BG aus dem Bild, position x wieder auf höhe screen setzten.

        if (topBg1 < 0) {
            ysky = Gdx.graphics.getHeight();
        }
        if (topBg2 < 0) {
            ysky2 = Gdx.graphics.getHeight();
        }

        batch.draw(sky, x, ysky, width, height);
        batch.draw(sky, x, ysky2, width, height);
    }

}
