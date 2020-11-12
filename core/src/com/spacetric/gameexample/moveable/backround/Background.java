package com.spacetric.gameexample.moveable.backround;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;

public class Background extends Rectangle {

    Texture sky;
    Texture sky2;
    int ysky;
    int ysky2;

    /**
     * Constructs a new rectangle with all values set to zero
     */
    public Background(Texture sky) {
        this.sky = sky;
        this.ysky = 0;

        this.ysky2 = sky.getHeight();
    }

    public void render(Batch batch) {

        ysky = --ysky;
        ysky2 = -- ysky2;
        float topBg1 = ysky + sky.getHeight();
        float topBg2 = ysky2 + getHeight();
        if(topBg1 < 0){
            ysky = (int)topBg2;
        }
        if (topBg2 < 0){
            ysky2 = (int)topBg1;
        }
        batch.draw(sky, x, ysky, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(sky, x, ysky2, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }
}
