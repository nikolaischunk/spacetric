package com.spacetric.gameexample.moveable.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.spacetric.gameexample.abstraction.SpaceElement;

public class Laser extends SpaceElement {

    private static final int width = 150;
    private static final int height = 75;

    public Laser(String pathToLaser, int x, int y) {
        super(10, pathToLaser, 150, 75, x, y);
    }

    public Laser(float x, float y) {
        super();
        this.image = createImage("Shots/Shot1/shot1_4.png",width,height);
        speed = 10;
        super.width = width;
        super.height = height;
        this.x = x;
        this.y = y;
    }

    public void move(Batch batch) {
        y += speed;
        batch.draw(image, x, y);
    }

    public void setLaser(Texture laser) {
        this.image = laser;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void dispose() {
        image.dispose();
    }
}
