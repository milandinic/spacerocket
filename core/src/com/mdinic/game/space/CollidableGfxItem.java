package com.mdinic.game.space;

import com.badlogic.gdx.math.Vector2;

public class CollidableGfxItem extends GfxItem {

    enum CollidableGfxItemState {
        NORMAL, COLLISION
    }

    enum DirectionX {
        FORWARD, NEUTRAL, BACKWORD;
        static DirectionX invert(DirectionX dir) {
            switch (dir) {
            case BACKWORD:
                return FORWARD;
            case FORWARD:
                return BACKWORD;
            default:
                return NEUTRAL;
            }
        }
    };

    enum DirectionY {
        UP, NEUTRAL, DOWN;

        static DirectionY invert(DirectionY dir) {
            switch (dir) {
            case UP:
                return DOWN;
            case DOWN:
                return UP;
            default:
                return NEUTRAL;
            }

        }
    };

    // edge points
    Vector2 topLeft;
    Vector2 topRight;
    Vector2 bottomLeft;
    Vector2 bottomRight;
    // direction
    DirectionX directionX = DirectionX.NEUTRAL;
    DirectionY directionY = DirectionY.NEUTRAL;

    /**
     * mass of the item.
     */
    int m = 1;

    /**
     * speed of the item.
     */
    float v = 10f;

    CollidableGfxItemState collistionState = CollidableGfxItemState.NORMAL;

    public CollidableGfxItem(GameMap map, float x, float y) {
        super(map, x, y);

        topLeft = new Vector2(x, y);
        topRight = new Vector2(x, y);
        bottomLeft = new Vector2(x, y);
        bottomRight = new Vector2(x, y);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);

        switch (directionX) {
        case BACKWORD:
            bounds.x -= v / 100;
            break;
        case FORWARD:
            bounds.x += v / 100;
            break;
        default:
            break;
        }

        switch (directionY) {
        case UP:
            bounds.y += v / 100;
            break;
        case DOWN:
            bounds.y -= v / 100;
            break;
        default:
            break;
        }

        topLeft.set(bounds.x, bounds.y + bounds.height);
        topRight.set(bounds.x + bounds.width, bounds.y + bounds.height);

        bottomLeft.set(bounds.x, bounds.y);
        bottomRight.set(bounds.x + bounds.width, bounds.y);

        for (CollidableGfxItem item : map.collidableItems) {

            if (bounds.overlaps(item.bounds)) {
                if (this != item) {

                    // iteraction, do something
                    v = v * m - item.m * m + item.m;
                    item.v = item.m * m * m + item.m;

                    item.directionX = DirectionX.invert(item.directionX);
                    item.directionY = DirectionY.invert(item.directionY);

                    // v1=vm1-m2m1+m2
                    // v2=v2m1m1+m2

                    collistionState = CollidableGfxItemState.COLLISION;
                    item.collistionState = CollidableGfxItemState.COLLISION;
                    stateTime = 0;
                }
            }
        }

        if (stateTime > 2 && collistionState == CollidableGfxItemState.COLLISION) {
            collistionState = CollidableGfxItemState.NORMAL;
            stateTime = 0;
        }
        pos.x = bounds.x;
        pos.y = bounds.y;
    }
}
