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
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector3;
import com.bkd.thlatsGame.AssetLoader;
import com.bkd.thlatsGame.Assets;
import com.bkd.thlatsGame.Graphics.Anim;
import com.bkd.thlatsGame.Input.BKInputProcessor;
import com.bkd.thlatsGame.Input.ZoomControl;
import com.bkd.thlatsGame.THLGame;
import com.bkd.thlatsGame.UI.UIPlatform;
import com.bkd.thlatsGame.screens.MainMenuScreen;
import com.bkd.thlatsGame.u.Rect;
import com.bkd.thlatsGame.worlds.MainMenuWorld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Braden on 5/08/2015.
 */
public class MainMenuRenderer implements screenRenderer {
    private MainMenuWorld world;
    private SpriteBatch batch;
    private Texture bgTxr;
    private Sprite bg;
    private Sprite title;
    private UIPlatform[] platforms;
    private BitmapFont f;
    private BKInputProcessor.TouchPoint[] touches;
    private ArrayList<BKInputProcessor.TouchPoint> tArray;
    private ZoomControl zc;
    private Vector3 screenCenter;
    private Vector3 camC;
    private ShapeRenderer shp;
    private OrthographicCamera cam;
    private Color[] colours = new Color[]{
        Color.BLUE,
        Color.GREEN,
        Color.YELLOW,
        Color.ORANGE,
        Color.RED
    };

    public MainMenuRenderer(MainMenuWorld world, OrthographicCamera cam) {
        this.cam = cam;
        this.world = world;
        zc = new ZoomControl();
        bgTxr = new Texture(Gdx.files.internal("data/img/chasmBg.png"));
        bg = new Sprite(bgTxr);
        title = AssetLoader.getSprite(Assets.menuSprites,"title");

        cam.setToOrtho(true, 1920, 1080);
        camC = cam.position;
        title.scale(2);
        title.setPosition(cam.viewportWidth / 2 - title.getWidth() / 2, 120);
        batch = new SpriteBatch();
        batch.setProjectionMatrix(cam.combined);
        f = new BitmapFont(true);
        shp = new ShapeRenderer();
        shp.setProjectionMatrix(cam.combined);
    }
    public void limitCam(){
        if (cam.position.x > 1920) cam.position.x  = 1920;
        else if (cam.position.x < 0) cam.position.x  = 0;
        if (cam.position.y > 1080) cam.position.x  = 1080;
        else if (cam.position.y < 0) cam.position.x  = 0;
    }
    public void render(){
            zc.update(cam);
            if (zc.isZooming()) {
                cam.zoom = zc.getZoom();
                cam.translate(zc.getCenter());
                limitCam();
                cam.update();
            }
          //  Gdx.app.log("Cam zoom", ""+cam.zoom);
            batch.setProjectionMatrix(cam.combined);
            shp.setProjectionMatrix(cam.combined);
            touches = THLGame.touches;
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
            }
            if (touches[0].isJustPressed()) {
                for (int j = 0; j < platforms.length; j++) {
                    if ( platforms[j].isHit(touches[0].posR)) {
                        Gdx.app.log("Renderer",platforms[j].id + " has been pressed");
                    }
                }
            }
            f.draw(batch, zc.zoomDebug(), 20, 300);
            title.draw(batch);

            batch.end();
            shp.begin(ShapeRenderer.ShapeType.Filled);
            for (int i = 0; i < platforms.length; i++ ) {
                shp.setColor(.2f,.3f,.4f,.5f);
                shp.rect(platforms[i].getHitZone().left,platforms[i].getHitZone().top, platforms[i].getHitZone().width(), platforms[i].getHitZone().height());
            }
            for (int i = 0; i < touches.length; i++ ) {
                Vector3 t = touches[i].posR;
                if (touches[i].isDown()) {
                    shp.setColor(colours[i]);
                } else {
                    shp.setColor(Color.WHITE);
                }
                shp.circle(t.x, t.y, 8);
            }
            shp.end();
        }
}
