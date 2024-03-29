package com.mdinic.game.space;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class OnscreenControlRenderer {
    GameMap map;
    SpriteBatch batch;

    TextureRegion left;
    TextureRegion right;
    TextureRegion jump;
    TextureRegion fire;

    TextureRegion soundOn;
    TextureRegion soundOff;

    SpaceRocketScreen screen;

    int soundSize = 64;
    int soundX = 480 - soundSize;
    int soundY = 320 - soundSize - 20;

    public OnscreenControlRenderer(GameMap map, SpaceRocketScreen screen) {
        this.map = map;
        this.screen = screen;
        // loadAssets();
    }

    private void loadAssets() {
        Texture texture = new Texture(Gdx.files.internal("data/controls.png"));
        TextureRegion[] buttons = TextureRegion.split(texture, 64, 64)[0];
        left = buttons[0];
        right = buttons[1];
        jump = buttons[2];

        soundOn = buttons[3];
        soundOff = buttons[4];
        fire = buttons[5];

        batch = new SpriteBatch();
        batch.getProjectionMatrix().setToOrtho2D(0, 0, 480, 320);
    }

    public void render() {
        if (Gdx.app.getType() != ApplicationType.Android && Gdx.app.getType() != ApplicationType.iOS)
            return;

        batch.begin();

        // if (screen.getGame().getSettingsService().isSoundEnabled()) {
        // batch.draw(soundOn, soundX, soundY);
        // } else {
        // batch.draw(soundOff, soundX, soundY);
        // }

        batch.draw(left, 0, 0);
        batch.draw(right, 70, 0);
        batch.draw(jump, 480 - 64, 0);

        // if (map.giana.power.hasGun())
        // batch.draw(fire, 480 - 64, 64);

        batch.end();

        processKeys();
    }

    private void processKeys() {

        float x0 = (Gdx.input.getX(0) / (float) Gdx.graphics.getWidth()) * 480;
        float x1 = (Gdx.input.getX(1) / (float) Gdx.graphics.getWidth()) * 480;
        float y0 = 320 - (Gdx.input.getY(0) / (float) Gdx.graphics.getHeight()) * 320;

        boolean soundButton = false;
        if (Gdx.input.justTouched()) {
            if (x0 > soundX && x0 < soundX + soundSize || x1 > soundX && x1 < soundX + soundSize) {
                if (y0 > soundY && y0 < soundY + soundSize) {
                    soundButton = true;
                }
            }
        }

        // if (soundButton) {
        // boolean enabled =
        // screen.getGame().getSettingsService().isSoundEnabled();
        // screen.getGame().getSettingsService().enableSound(!enabled);
        // map.sounds.setMute(enabled);
        // Music music = map.sounds.getCurrentMusic();
        // if (music != null) {
        // music.setVolume(screen.getGame().getSettingsService().isSoundEnabled()
        // ? 1 : 0);
        // }
        // }

    }

    public void dispose() {
        // batch.dispose();
    }
}
