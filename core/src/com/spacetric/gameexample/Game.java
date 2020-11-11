package com.spacetric.gameexample;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.spacetric.gameexample.moveable.objects.SpaceObject;

public class Game extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
    SpaceObject meteor;

    @Override
    public void create() {
        batch = new SpriteBatch();
        meteor = new SpaceObject("Astroids/Astroid1_1.png", 2, 200, 200, 20, Gdx.graphics.getHeight());

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        meteor.moveDown(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
