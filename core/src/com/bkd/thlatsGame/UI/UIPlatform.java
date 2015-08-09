package com.bkd.thlatsGame.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.bkd.thlatsGame.AssetLoader;
import com.bkd.thlatsGame.Graphics.Anim;
import com.bkd.thlatsGame.u.Rect;

import java.util.ArrayList;


/**
 * Created by Braden on 7/08/2015.
 */
public class UIPlatform  {
    private Rect hitZone;
    private Sprite sprite;
    public int x, y, width, height;
    public buttonID id;
    private float sinX, sinY;
    private double xRan, yRan;
    private String spriteName;
    private TextureAtlas ta;
    private ArrayList<Anim> anim;
    private Boolean hasAnim = false;
    public static enum buttonID  {
        setting,start ,resume,quit
    }
    public UIPlatform(int x, int y, TextureAtlas ta, String spriteName, buttonID id) {
        this.x = x;
        this.y = y;
        this.spriteName = spriteName;
        this.ta = ta;
        this.id = id;
        Gdx.app.log("Sprite", spriteName);
        sinX = (float) Math.random() * 0.1f;
        sinY = (float) Math.random() * 0.1f;
        xRan = Math.random() * 0.05;
        yRan = Math.random() * 0.05;

        sprite = AssetLoader.getSprite(ta,spriteName);
        Gdx.app.log("Sprite", "texture loaded");

        width = (int) sprite.getWidth();
        height = (int) sprite.getHeight();



    }
    public void setHitZone(Rect r) {
        hitZone = new Rect(x + r.left, y+r.top, x + r.left + r.width(),  y + r.top + r.height());
    }
    public void update(float delta) {

        double offY = Math.sin(sinY) * 3;
        double offX = Math.sin(sinX) * 2;
        sinY += .03 + yRan ;
        sinX += .016 + xRan;
        hitZone.move((int) (offX), (int) (offY));
        sprite.setPosition((int) (x + offX), (int) (y + offY));
        if (hasAnim) {
            for (Anim a : anim) {
                a.update(delta);
                a.move(offX, offY);
            }
        }
    }
    public void addAnim(TextureAtlas ta, String regions, float speed, int rx, int ry) {
        if (!hasAnim) {
            anim = new ArrayList<Anim>() ;
        }
        hasAnim = true;
        Anim a = new Anim(ta,regions,speed);
        a.setPosition(x+rx,y+ry);
        anim.add(a);
    }
    public Sprite getSprite(){
        return sprite;
    }
    public Rect getHitZone(){
        return hitZone;
    }
    public boolean hasAnim(){
        return hasAnim;
    }
    public ArrayList<Anim> getAnim() {
        return anim;
    }
}
