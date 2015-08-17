package com.bkd.thlatsGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;


import java.util.HashMap;

/**
 * Created by Braden on 6/08/2015.
 */
public class AssetLoader {


    public static Sprite getSprite(TextureAtlas atlas, String regionName){
        Gdx.app.log("Sprite region" ,regionName);
        AtlasRegion region = atlas.findRegion(regionName);
        Sprite s = new Sprite(region);
        s.flip(false, true);
        return s;
    }
    public static Animation loadAnimation(TextureAtlas ta, String name, float speed) {
        Array<AtlasRegion> regions = ta.findRegions(name);
        return new Animation(speed,regions);
    }
}
