package com.mdinic.game.space;

import com.badlogic.gdx.Game;

public class SpaceRocket extends Game {

    // private HighScoreService highScoreService;
    // private SettingsService settingsService;
    // private GeneralService generalService;
    Sounds sounds;
    MapRenderer renderer;

    public SpaceRocket() {
        super();
    }

    @Override
    public void create() {
        sounds = new Sounds();
        renderer = new MapRenderer();
        setScreen(new GameScreen(this, new GameMap(0, sounds), renderer));
        // setScreen(new IntroScreen(this, sounds, renderer));
    }

    @Override
    public void dispose() {
        super.dispose();
        // sounds.dispose();
        // renderer.dispose();

        // sounds = null;
        // renderer = null;
    }

}
