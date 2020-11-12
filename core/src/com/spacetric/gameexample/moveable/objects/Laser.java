package com.spacetric.gameexample.moveable.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Laser {

    private Texture laserTexture;
    private int x;
    private int y;

    public Laser(String pathToLaser, int x, int y) {
        this.laserTexture = createImage(pathToLaser, 300, 300);
        this.x = x;
        this.y = y;
    }

    public Laser (Texture laserTexture, int x, int y) {
        this.laserTexture = laserTexture;
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
        batch.draw(laserTexture, x, ++y);
    }


    public Texture getLaserTexture() {
        return laserTexture;
    }

    public void setLaser(Texture laser) {
        this.laserTexture = laser;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
