package com.mdinic.game.space;

import java.util.Random;

public class Asteroid extends GfxItem {

    AsteroidType type;

    public Asteroid(GameMap map, float x, float y) {
        super(map, x, y);
        type = AsteroidType.values()[new Random().nextInt(AsteroidType.values().length - 1)];

        bounds.width = 2f;
        bounds.height = 2f;
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);

        if (new Random().nextInt(10) % 3 == 0) {
            rotation++;
        }

        if (rotation > 359) {
            rotation = 0;
        }
    }

    @Override
    public int getColor() {
        return 0xf4f8f2;
    }

}
