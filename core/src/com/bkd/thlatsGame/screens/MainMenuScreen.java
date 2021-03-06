package com.bkd.thlatsGame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.bkd.thlatsGame.AssetLoader;
import com.bkd.thlatsGame.Assets;
import com.bkd.thlatsGame.Input.BKInputProcessor;
import com.bkd.thlatsGame.Input.InputHolder;
import com.bkd.thlatsGame.THLGame;
import com.bkd.thlatsGame.renderers.MainMenuRenderer;
import com.bkd.thlatsGame.worlds.MainMenuWorld;

/**
 * Created by Braden on 5/08/2015.
 */
public class MainMenuScreen implements Screen {
    private MainMenuRenderer renderer;
    private MainMenuWorld world;
    private BKInputProcessor ip;
    private OrthographicCamera cam;
    private THLGame game;



    public MainMenuScreen(THLGame game) {
        this.game = game;
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 480;
        float gameHeight = screenHeight / (screenWidth / gameWidth);
        int midPointY = (int) (gameHeight / 2);
        Assets.load();
        world = new MainMenuWorld(midPointY);
        cam = new OrthographicCamera();
        renderer = new MainMenuRenderer(world,cam);
        ip = new BKInputProcessor();
        ip.setCam(cam);

    }

    @Override
    public void show() {
        Gdx.app.log("StarMap", "show called");
    }

    @Override
    public void render(float delta) {
        if (world.switchScreen) {
            game.switchScreens(world.nextScreen);
        }
        THLGame.touches = InputHolder.touches;
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
