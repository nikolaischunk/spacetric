package com.spacetric.gameexample.abstraction;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;

import java.util.Objects;


public abstract class SpaceElement extends Rectangle {

    protected int speed;
    protected transient Texture image;

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
        setWidth(widthAndHeight);
        setHeight(widthAndHeight);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SpaceElement that = (SpaceElement) o;
        return speed == that.speed &&
                image.equals(that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), speed, image);
    }

    public boolean overlapsAsteroid(Rectangle r) {
        return x < r.x + r.width*0.9 && x + width*0.9 > r.x && y < r.y + r.height*0.9 && y + height*0.9 > r.y;
    }

    public boolean overlapsOpponentShip(Rectangle r) {
        return x < r.x + r.width*0.7 && x + width*0.7 > r.x && y < r.y + r.height*0.7 && y + height*0.7 > r.y;
    }

}
