package com.bkd.thlatsGame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.bkd.thlatsGame.Assets;
import com.bkd.thlatsGame.Input.BKInputProcessor;
import com.bkd.thlatsGame.Input.InputHolder;
import com.bkd.thlatsGame.THLGame;
import com.bkd.thlatsGame.renderers.BattleRenderer;
import com.bkd.thlatsGame.worlds.BattleWorld;

/**
 * Created by Braden on 17/08/2015.
 */
public class BattleScreen implements Screen {
    private BattleRenderer renderer;
    private BattleWorld world;
    private BKInputProcessor ip;
    public static BKInputProcessor.TouchPoint[] touches;
    private OrthographicCamera cam;
    private THLGame game;
    public static int horizon;
    public static int centerLine;


    public BattleScreen(THLGame game){
        this.game = game;
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 480;
        float gameHeight = screenHeight / (screenWidth / gameWidth);
        int midPointY = (int) (gameHeight / 2);
        world = new BattleWorld();
        cam = new OrthographicCamera();
        renderer = new BattleRenderer(world,cam);
        ip = new BKInputProcessor();
        ip.setCam(cam);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        touches = InputHolder.touches;
        world.update(delta);
        renderer.render();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        world.dispose();
        renderer.dispose();
    }

}
