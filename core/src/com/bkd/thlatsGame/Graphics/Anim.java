package com.bkd.thlatsGame.Graphics;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.bkd.thlatsGame.AssetLoader;

/**
 * Created by braden on 8/8/2015.
 */
public class Anim {
    private Animation anim;
    private TextureRegion frame;
    private Sprite sprite;
    private int x, y;
    private float animationStateTime = 0;

    public Anim(TextureAtlas ta, String regions, float speed) {
        anim = AssetLoader.loadAnimation(ta,regions,speed);
        sprite = new Sprite(ta.findRegion(regions));
    }
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
        sprite.setPosition( x, y);
    }
    public void move(int dx, int dy) {
        sprite.setPosition( (x + dx), (y + dy));
    }
    public void move(double dx, double dy) {
        sprite.setPosition((int) (x + dx), (int) (y + dy));
    }
    public void update(float delta) {
        frame = anim.getKeyFrame(animationStateTime += delta, true);
        sprite.setRegion(frame);
        sprite.flip(false, true);
    }
    public Sprite getSprite(){
        return sprite;
    }
}
