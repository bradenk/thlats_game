package com.bkd.thlatsGame.renderers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.bkd.thlatsGame.AssetLoader;
import com.bkd.thlatsGame.Assets;
import com.bkd.thlatsGame.Graphics.Anim;
import com.bkd.thlatsGame.Input.BKInputProcessor;
import com.bkd.thlatsGame.UI.UIPlatform;
import com.bkd.thlatsGame.worlds.MainMenuWorld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Braden on 5/08/2015.
 */
public class MainMenuRenderer implements screenRenderer {
    private MainMenuWorld world;
    private OrthographicCamera cam;
    private SpriteBatch batch;
    private Texture bgTxr;
    private Sprite bg;
    private Sprite title;
    private UIPlatform[] platforms;
    private ShapeRenderer shpR;

    public MainMenuRenderer(MainMenuWorld world) {
        this.world = world;
        bgTxr = new Texture(Gdx.files.internal("data/img/chasmBg.png"));
        bg = new Sprite(bgTxr);
        title = AssetLoader.getSprite(Assets.menuSprites,"title");
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 1920, 1080);
        title.scale(2);
        title.setPosition(cam.viewportWidth / 2 - title.getWidth() / 2, 120);
        batch = new SpriteBatch();
        batch.setProjectionMatrix(cam.combined);
        shpR = new ShapeRenderer();
        shpR.setProjectionMatrix(cam.combined);

    }
    public void render(){

            platforms = world.getPlatforms();
            Gdx.gl.glClearColor(0, 0, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            batch.begin();
            bg.draw(batch);
            for (int i = 0; i < platforms.length; i++) {
                UIPlatform p = platforms[i];
                p.getSprite().draw(batch);
                if (p.hasAnim()) {
                    ArrayList<Anim> anim = p.getAnim();
                    for (Anim a : anim) {
                        a.getSprite().draw(batch);
                    }
                }
                batch.end();
                shpR.begin(ShapeRenderer.ShapeType.Filled);
                shpR.setColor(Color.CYAN);
                shpR.rect(p.getHitZone().left, p.getHitZone().top, p.getHitZone().width(), p.getHitZone().height());
                shpR.end();
                batch.begin();
            }
            title.draw(batch);
            batch.end();
        }
}
