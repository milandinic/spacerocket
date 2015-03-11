package com.mdinic.game.space;

import com.badlogic.gdx.math.Vector2;

public class Ship extends CollidableGfxItem {

    Vector2 endPos = new Vector2();

    CollidableGfxItemState oldState = CollidableGfxItemState.NORMAL;

    public Ship(GameMap map, float x, float y) {
        super(map, x, y);

        bounds.width = 4f;
        bounds.height = 2f;

        resetMovement();
    }

    private void resetMovement() {
        v = 10f;
        directionX = DirectionX.FORWARD;
        directionY = DirectionY.NEUTRAL;
    }

    @Override
    public void update(float deltaTime) {
        oldState = collistionState;
        super.update(deltaTime);

        for (CollidableGfxItem item : map.collidableItems) {

        }

        if (oldState == CollidableGfxItemState.COLLISION && collistionState == CollidableGfxItemState.NORMAL
                && stateTime == 0) {

            resetMovement();
        }
    }

    @Override
    public int getColor() {
        return 0xff0000;
    }
}
