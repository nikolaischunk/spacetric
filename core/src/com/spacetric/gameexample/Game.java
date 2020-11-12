package com.spacetric.gameexample;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.spacetric.gameexample.moveable.objects.Laser;
import com.spacetric.gameexample.moveable.objects.SpaceObject;
import com.spacetric.gameexample.moveable.ships.OpponentShip;
import com.spacetric.gameexample.moveable.ships.OwnShip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Game extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
    List<SpaceObject> asteroids;
    OpponentShip opponentShip;
    OwnShip myShip;
    private final List<Laser> lasers = new ArrayList<>();


    @Override
    public void create() {
        batch = new SpriteBatch();
        initializeAsteroids();
        opponentShip = new OpponentShip("Ships/opShip1.png", 6, 200, 200, 40, Gdx.graphics.getHeight());
        myShip = new OwnShip("Ships/playerShip.png", 0, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 8, "Shots/Shot1/shot1_4.png");
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (Gdx.input.isTouched()) {
            float sizeWidth = myShip.getWidth() / 2; //Calculates the Middle of the Ship
            int sizeWidthInt = (int) sizeWidth; // Cast to Int
            myShip.setX(Gdx.input.getX() - sizeWidthInt);
            Optional<Laser> laserOptional = myShip.shoot();
            if (laserOptional.isPresent()) {
                lasers.add(laserOptional.get());
            }
        }
        batch.begin();
        for (Laser l : lasers) {
            l.move(batch);
        }
        for (SpaceObject asteroid : asteroids) {
            asteroid.move(batch);
        }
        myShip.move(batch);
        opponentShip.move(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }

    private void initializeAsteroids() {
        asteroids = Arrays.asList(
                new SpaceObject("Astroids/Astroid1_1.png"),
                new SpaceObject("Astroids/Astroid1_2.png"),
                new SpaceObject("Astroids/Astroid1_3.png"),
                new SpaceObject("Astroids/Astroid1_4.png"),
                new SpaceObject("Astroids/Astroid1_5.png")
        );
    }
}
