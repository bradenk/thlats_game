package com.bkd.thlatsGame.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.bkd.thlatsGame.AssetLoader;
import com.bkd.thlatsGame.MainMenu;
import com.bkd.thlatsGame.u.Rect;


/**
 * Created by Braden on 7/08/2015.
 */
public class UIPlatform  {
    private Rect hitZone;
    private Sprite sprite;
    public int x, y, width, height;
    public String name;
    private float sinX, sinY;
    private double xRan, yRan;
    private int frames;
    private int curframe = 0;
    private String spriteName;
    private TextureAtlas txrA;
    private Array<TextureAtlas.AtlasRegion> regions;
    private Animation animation;
    private float animationStateTime = 0;

    public UIPlatform(int x, int y, String spriteName, String name) {
        this.x = x;
        this.y = y;
        this.spriteName = spriteName;
        Gdx.app.log("Sprite", spriteName);
        sinX = (float) Math.random() * 0.1f;
        sinY = (float) Math.random() * 0.1f;
        xRan = Math.random() * 0.05;
        yRan = Math.random() * 0.05;
        this.name = name;
        Gdx.app.log("MainMenu:","loaded " +name);
        txrA = new TextureAtlas(Gdx.files.internal("data/spriteSheets/menuSprites.atlas"));
        regions = txrA.findRegions(spriteName);
        animation = new Animation(0.15f, regions ) ;
        sprite = new Sprite(txrA.findRegion(spriteName));
        Gdx.app.log("Sprite", "texture loaded");

        width = (int) sprite.getWidth();
        height = (int) sprite.getHeight();



    }
    public void setHitZone(Rect r) {
        hitZone = new Rect(x + r.left, y+r.top, x + r.left + r.width(),  y + r.top + r.height());
    }
    public void update(float delta) {
        TextureRegion frame;
        frame = animation.getKeyFrame(animationStateTime += delta, true);
        double offY = Math.sin(sinY) * 3;
        double offX = Math.sin(sinX) * 2;
        sinY += .03 + yRan ;
        sinX += .016 + xRan;
        hitZone.move((int) (offX), (int) (offY));
        sprite.setRegion(frame);
        sprite.setPosition((int) (x + offX), (int) (y + offY));
        sprite.flip(false,true);
    }
    public Sprite getSprite(){
        return sprite;
    }
    public Rect getHitZone(){
        return hitZone;
    }
}
