package com.spacetric.gameexample.moveable.objects;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.spacetric.gameexample.abstraction.SpaceElement;

public class Laser extends SpaceElement {

    public Laser(String pathToLaser, int x, int y) {
        super(10, pathToLaser, 150, 75, x, y);
    }

    public Laser(float x, float y) {
        super();
        this.image = createImage("Shots/Shot1/shot1_4.png",150,75);
        speed = 10;
        width = 150;
        height = 75;
        this.x = x;
        this.y = y;
    }

    @Override
    public void move(Batch batch) {
        y += speed;
        batch.draw(image, x, y);
    }

    @Override
    public void dispose() {
        image.dispose();
    }
}
