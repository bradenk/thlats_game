package com.bkd.thlatsGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


import java.util.HashMap;

/**
 * Created by Braden on 6/08/2015.
 */
public class AssetLoader {
    public static TextureAtlas menuSprites;

    public static void load() {
        Gdx.app.log("assetLoader","loading Assets");
        menuSprites = new TextureAtlas(Gdx.files.internal("data/spriteSheets/menuSprites.atlas"));
    }
    public static Sprite getSprite(TextureAtlas atlas, String regionName){
        Gdx.app.log("assetLoader","starting");
        AtlasRegion region = atlas.findRegion(regionName);
        region.flip(false,true);
        return new Sprite(region);
    }
}
