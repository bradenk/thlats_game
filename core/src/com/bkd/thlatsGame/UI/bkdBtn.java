package com.bkd.thlatsGame.UI;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.bkd.thlatsGame.AssetLoader;
import com.bkd.thlatsGame.Assets;
import com.bkd.thlatsGame.u.Rect;

/**
 * Created by Braden on 6/08/2015.
 */
public class bkdBtn extends Rect {
    private String function;
    private AtlasRegion region;
    private String spriteName;
    private Sprite sprite;

    public bkdBtn(int x, int y, String function, String spriteName ){
        this.left = x;
        this.right = y;
        this.top = top;
        this.bottom = bottom;
        this.function = function;
        sprite = AssetLoader.getSprite(Assets.menuSprites, spriteName);
    }
    public void setSpritePosition(int oX, int oY) {
        sprite.setPosition((int)(left + oX),(int)(right + oY) );
    }
    public Sprite getSprite(){
        return sprite;
    }
}
