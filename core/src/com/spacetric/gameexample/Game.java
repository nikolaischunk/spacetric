package com.spacetric.gameexample;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.spacetric.gameexample.moveable.objects.SpaceObject;
import com.spacetric.gameexample.moveable.ships.OpponentShip;
import com.spacetric.gameexample.moveable.ships.OwnShip;

public class Game extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
    SpaceObject meteor;
    OpponentShip opponentShip;
    OwnShip myShip;

    @Override
    public void create() {
        batch = new SpriteBatch();
        meteor = new SpaceObject("Astroids/Astroid1_1.png", 2, 200, 200, 20, Gdx.graphics.getHeight());
        opponentShip = new OpponentShip("Ships/opShip1.png", 6, 200, 200, 40, Gdx.graphics.getHeight());
        myShip = new OwnShip("Ships/playerShip.png", 0, 150, 150, Gdx.graphics.getWidth()/3, Gdx.graphics.getHeight()/8, "Shots/Shot1/shot1_1.png");
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        meteor.move(batch);
        myShip.move(batch);
        opponentShip.move(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
