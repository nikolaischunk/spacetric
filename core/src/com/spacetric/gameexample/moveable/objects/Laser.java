package com.spacetric.gameexample.moveable.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.spacetric.gameexample.abstraction.SpaceElement;

public class Laser extends SpaceElement {

    public Laser(String pathToLaser, int x, int y) {
        super(10, pathToLaser, 150, 75, x, y);
    }

    public Laser(Texture laserTexture, float x, float y) {
        super();
        this.image = createImage("Shots/Shot1/shot1_4.png",150,75);
        speed = 10;
        this.width = 150;
        this.height = 75;
        this.x = x;
        this.y = y;
    }

    protected Texture createImage(String pathToFile, int width, int height) {
        Texture img;
        Pixmap pixMap200 = new Pixmap(Gdx.files.internal(pathToFile));
        Pixmap pixMap100 = new Pixmap(width, height, pixMap200.getFormat());

        pixMap100.drawPixmap(pixMap200,
                0, 0, pixMap200.getWidth(), pixMap200.getHeight(),
                0, 0, pixMap100.getWidth(), pixMap100.getHeight()
        );

        img = new Texture(pixMap100);
        pixMap200.dispose();
        pixMap100.dispose();

        return img;
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
