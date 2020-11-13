package com.spacetric.gameexample;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.spacetric.gameexample.abstraction.SpaceElement;
import com.spacetric.gameexample.moveable.backround.Background;
import com.spacetric.gameexample.moveable.objects.Laser;
import com.spacetric.gameexample.moveable.objects.SpaceObject;
import com.spacetric.gameexample.moveable.ships.OpponentShip;
import com.spacetric.gameexample.moveable.ships.OwnShip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class Game extends ApplicationAdapter {
    private List<Laser> lasers = new ArrayList<>();
    SpriteBatch batch;
    List<SpaceObject> asteroids;
    List<OpponentShip> enemies;
    OwnShip myShip;
    Background bg;

    @Override
    public void create() {
        batch = new SpriteBatch();
        initializeAsteroids();
        initializeEnemies();
        myShip = new OwnShip("Ships/playerShip.png", 0, Gdx.graphics.getWidth() / 2 + 75, Gdx.graphics.getHeight() / 8, "Shots/Shot1/shot1_4.png");
        bg = new Background(new Texture("Sky/SkyLong.png"), new Texture("Sky/SkyShort.png"));
    }

    @Override
    public void render() {
        moveToTouchPosition();
        batch.begin();
        bg.render(batch);
        checkCollisionLaserAndEnemy();
        checkCollisionWithAsteroids();
        for (Iterator<Laser> iterator = lasers.iterator(); iterator.hasNext(); ) {
            Laser l = iterator.next();
            if (l.getX() > Gdx.graphics.getWidth()) {
                l.getTexture().dispose();
                iterator.remove();
            } else {
                l.move(batch);
            }
        }
        for (SpaceObject asteroid : asteroids) {
            asteroid.move(batch);
        }
        for (OpponentShip ops : enemies) {
            ops.move(batch);
        }
        myShip.move(batch);
        batch.end();
    }

    private void checkCollisionLaserAndEnemy() {
        for (Iterator<Laser> laserIterator = lasers.iterator(); laserIterator.hasNext();) {
            Laser l = laserIterator.next();
            for (Iterator<OpponentShip> opsIterator = enemies.iterator(); opsIterator.hasNext();) {
                OpponentShip ops = opsIterator.next();
                if (ops.overlaps(l)) {
                    ops.dispose();
                    opsIterator.remove();
                    l.dispose();
                    laserIterator.remove();
                    // Spawn new OPS
                    createNewEnemy();
                    // break because laser can only destroy 1 ship
                    break;
                }
            }

        }
    }

    private void checkCollisionWithAsteroids() {
        for (SpaceElement asteroid : asteroids) {
            if(asteroid.overlaps(myShip)) {
                Gdx.app.log("GAME_INFO", "You hit an asteroid and lost the game.");
                System.exit(-1);
            }
        }
    }

    private void createNewEnemy() {
        enemies.add(new OpponentShip("Ships/opShip1.png"));
    }

    private void initializeAsteroids() {
        asteroids = new ArrayList<>();
        for(int i = 1; i < 6; i++) {
            asteroids.add(new SpaceObject("Astroids/Astroid1_" + i + ".png"));
        }
        Gdx.app.log("INITIALIZER", "ASTEROIDS: " + asteroids.size() + "");

    }

    private void initializeEnemies() {
        enemies = new ArrayList<>();
        for(int i = 1; i < 6; i++) {
            enemies.add(new OpponentShip("Ships/opShip1.png"));
        }
        Gdx.app.log("INITIALIZER", "OPS: " + asteroids.size() + "");
    }


    private void moveToTouchPosition() {
        if (Gdx.input.isTouched()) {
            float sizeWidth = myShip.getWidth() / 2; //Calculates the Middle of the Ship
            int sizeWidthInt = (int) sizeWidth; // Cast to Int
            myShip.setX(Gdx.input.getX() - sizeWidthInt);
            Optional<Laser> laserOptional = myShip.shoot();
            if (laserOptional.isPresent()) {
                lasers.add(laserOptional.get());
            }
        }
    }

    @Override
    public void dispose() {
        myShip.getTexture().dispose();
        myShip.getLaser().getTexture().dispose();
        bg.getSky().dispose();
        bg.getSky2().dispose();
        batch.dispose();
    }

}
