package com.bkd.thlatsGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * Created by braden on 8/8/2015.
 */
public class Assets {
    public static TextureAtlas menuSprites;
    public static TextureAtlas shipAnimSprites;



    public static void load() {
        menuSprites = new TextureAtlas(Gdx.files.internal("data/spriteSheets/menuSprites.atlas"));
        shipAnimSprites = new TextureAtlas(Gdx.files.internal("data/spriteSheets/ship_anim.atlas"));
    }
}
