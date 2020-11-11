package com.spacetric.gameexample.abstraction;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;


public abstract class SpaceElement {

    protected int speed;
    protected Texture image;
    protected int x;
    protected int y;

    protected SpaceElement(int speed, String pathToFile, int width, int height, int x, int y) {
        this.speed = speed;
        this.image = createImage(pathToFile, width, height);
        this.x = x;
        this.y = y;
    }

    protected void moveDown(Batch batch) {
        y -= speed;
        render(batch);
    }

    public void render(Batch batch) {
        batch.draw(image, x, y);
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

}
