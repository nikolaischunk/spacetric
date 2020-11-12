package com.spacetric.gameexample.moveable.backround;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;

public class Background extends Rectangle {

    Texture sky;
    float secondBackgroundY;

    /**
     * Constructs a new rectangle with all values set to zero
     */
    public Background(Texture sky) {
        this.sky = sky;
        this.secondBackgroundY = Gdx.graphics.getHeight();
    }

    public void render(Batch batch) {

        batch.draw(sky, x, y, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        y = --y;
        float topBg1 = y + sky.getHeight();
        if (topBg1 < 0) {
            //Draw Second Background
            batch.draw(sky, x, secondBackgroundY, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            Gdx.app.log("BACKGROUND", topBg1 + "");
        }
    }
}
