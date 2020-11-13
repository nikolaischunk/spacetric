package com.spacetric.gameexample.abstraction;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;


public abstract class SpaceElement extends Rectangle {

    protected int speed;
    protected Texture image;

    protected SpaceElement(int speed, String pathToFile, int width, int height, int x, int y) {
        this.speed = speed;
        this.width = width;
        this.height = height;
        this.image = createImage(pathToFile, width, height);
        this.x = x;
        this.y = y;
    }

    protected SpaceElement(int speed, String pathToFile, int widthAndHeight, int x, int y) {
        this.speed = speed;
        this.image = createImage(pathToFile, widthAndHeight, widthAndHeight);
        this.x = x;
        this.y = y;
    }

    protected SpaceElement() {}

    protected void move(Batch batch) {
        render(batch);
    }

    protected void render(Batch batch) {
        batch.draw(image, x, y);
    }

    protected Texture createImage(String pathToFile, int width, int height) {
        Texture img;
        // Create pixMap with given image
        Pixmap pixMap200 = new Pixmap(Gdx.files.internal(pathToFile));
        // create pixMap with format of old pixMap
        Pixmap pixMap100 = new Pixmap(width, height, pixMap200.getFormat());
        // draw pixMap200 into pixMap100
        pixMap100.drawPixmap(pixMap200,
                0, 0, pixMap200.getWidth(), pixMap200.getHeight(),
                0, 0, pixMap100.getWidth(), pixMap100.getHeight()
        );
        // Create new texture with pixMap
        img = new Texture(pixMap100);
        pixMap200.dispose();
        pixMap100.dispose();
        return img;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Texture getTexture() {
        return image;
    }

    public abstract void dispose();
}
