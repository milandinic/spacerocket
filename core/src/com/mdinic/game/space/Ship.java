package com.mdinic.game.space;

import com.badlogic.gdx.math.Vector2;

public class Ship extends GfxItem {

    Vector2 endPos = new Vector2();

    public Ship(GameMap map, float x, float y) {
        super(map, x, y);

        bounds.width = 4f;
        bounds.height = 2f;
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);

        bounds.x += 0.1;
        pos.x = bounds.x;

    }

    @Override
    public int getColor() {
        return 0xff0000;
    }
}
