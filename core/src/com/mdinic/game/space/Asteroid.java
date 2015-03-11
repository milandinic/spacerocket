package com.mdinic.game.space;

import java.util.Random;

public class Asteroid extends CollidableGfxItem {

    AsteroidType type;

    public Asteroid(GameMap map, float x, float y) {
        super(map, x, y);
        type = AsteroidType.values()[new Random().nextInt(AsteroidType.values().length - 1)];

        bounds.width = 2f;
        bounds.height = 2f;
        v = 0.3f;
        directionX = DirectionX.values()[new Random().nextInt(DirectionX.values().length - 1)];
        directionY = DirectionY.values()[new Random().nextInt(DirectionY.values().length - 1)];
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
