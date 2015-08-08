package com.bkd.thlatsGame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.bkd.thlatsGame.AssetLoader;
import com.bkd.thlatsGame.renderers.MainMenuRenderer;
import com.bkd.thlatsGame.worlds.MainMenuWorld;

/**
 * Created by Braden on 5/08/2015.
 */
public class MainMenuScreen implements Screen {
    private MainMenuRenderer renderer;
    private MainMenuWorld world;


    public MainMenuScreen() {
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 480;
        float gameHeight = screenHeight / (screenWidth / gameWidth);
        int midPointY = (int) (gameHeight / 2);
        AssetLoader.load();
        world = new MainMenuWorld(midPointY);
        renderer = new MainMenuRenderer(world);

    }

    @Override
    public void show() {
        Gdx.app.log("StarMap", "show called");
    }

    @Override
    public void render(float delta) {
        world.update(delta);
        renderer.render();
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("StarMap", "resizing");

    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "pause called");
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "resume called");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen", "hide called");
    }

    @Override
    public void dispose() {

    }
}
