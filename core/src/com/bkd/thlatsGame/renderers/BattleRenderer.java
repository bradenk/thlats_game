package com.bkd.thlatsGame.renderers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.bkd.thlatsGame.AssetLoader;
import com.bkd.thlatsGame.Assets;
import com.bkd.thlatsGame.Input.BKInputProcessor;
import com.bkd.thlatsGame.Input.InputHolder;
import com.bkd.thlatsGame.Input.ZoomControl;
import com.bkd.thlatsGame.THLGame;
import com.bkd.thlatsGame.UI.UIPlatform;
import com.bkd.thlatsGame.worlds.BattleWorld;
import com.bkd.thlatsGame.worlds.MainMenuWorld;

import java.util.ArrayList;

/**
 * Created by Braden on 17/08/2015.
 */
public class BattleRenderer implements screenRenderer {
    private BattleWorld world;
    private SpriteBatch batch;
    private Texture bgTxr;
    private Sprite bg;
    private BKInputProcessor.TouchPoint[] touches;
    private ZoomControl zc;
    private OrthographicCamera cam;

    public BattleRenderer(BattleWorld world, OrthographicCamera cam) {
        this.cam = cam;
        this.world = world;
        zc = new ZoomControl();
        bgTxr = new Texture(Gdx.files.internal("data/img/chasmBg.png"));
        bg = new Sprite(bgTxr);
        cam.setToOrtho(true, 1920, 1080);
        batch = new SpriteBatch();
        batch.setProjectionMatrix(cam.combined);
    }

    @Override
    public void render() {
        batch.setProjectionMatrix(cam.combined);
        touches = THLGame.touches;
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        bg.draw(batch);
        batch.end();


    }
    public void dispose(){

    }
}
