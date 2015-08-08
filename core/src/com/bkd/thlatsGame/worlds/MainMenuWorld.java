package com.bkd.thlatsGame.worlds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.bkd.thlatsGame.AssetLoader;
import com.bkd.thlatsGame.MainMenu;
import com.bkd.thlatsGame.UI.UIMainMenu;
import com.bkd.thlatsGame.UI.UIPlatform;
import com.bkd.thlatsGame.u.Rect;

/**
 * Created by Braden on 5/08/2015.
 */
public class MainMenuWorld implements World {
    public UIPlatform[] platforms;

    public MainMenuWorld(int midPointY) {
        platforms = new UIPlatform[]{
                new UIPlatform(1018,644, "settings" ,"settings"),
                new UIPlatform(546,208, "start" ,"start"),
                new UIPlatform(638,428,"resume" ,"resumme"),
                new UIPlatform(548,642, "quit" ,"quit")
        };
        platforms[0].setHitZone(new Rect(0,0,30,30));
        platforms[1].setHitZone(new Rect(0,0,30,30));
        platforms[2].setHitZone(new Rect(0,0,30,30));
        platforms[3].setHitZone(new Rect(0,0,30,30));
    }
    public void update(float delta) {
        for (int i = 0; i < platforms.length; i++) {
            platforms[i].update(delta);
        }
    }
    public UIPlatform[] getPlatforms(){
        return platforms;
    }
}
