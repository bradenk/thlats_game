package com.bkd.thlatsGame.worlds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.bkd.thlatsGame.AssetLoader;
import com.bkd.thlatsGame.Assets;
import com.bkd.thlatsGame.Input.BKInputProcessor;
import com.bkd.thlatsGame.MainMenu;
import com.bkd.thlatsGame.UI.UIMainMenu;
import com.bkd.thlatsGame.UI.UIPlatform;
import com.bkd.thlatsGame.u.Rect;

import java.util.Map;

/**
 * Created by Braden on 5/08/2015.
 */
public class MainMenuWorld implements World {
    public UIPlatform[] platforms;
    private Map<Integer,BKInputProcessor.TouchPoint> touches;


    public MainMenuWorld(int midPointY) {
        platforms = new UIPlatform[]{
                new UIPlatform(1028,644, Assets.menuSprites ,"settings", UIPlatform.buttonID.setting),
                new UIPlatform(546,208, Assets.menuSprites , "start", UIPlatform.buttonID.start),
                new UIPlatform(638,428, Assets.menuSprites , "resume" , UIPlatform.buttonID.resume),
                new UIPlatform(638,642, Assets.menuSprites , "quit" , UIPlatform.buttonID.quit)
        };
        platforms[0].setHitZone(100,40,100,100);
        platforms[1].setHitZone(200,50,400,80);
        platforms[2].setHitZone(120,50,380,80);
        platforms[3].setHitZone(120,50, 200,80);
        platforms[1].addAnim(Assets.shipAnimSprites, "flag", 1 / 6f, -8, 88);
        platforms[3].addAnim(Assets.shipAnimSprites, "prop", 1 / 24f, -91, 30);
        platforms[3].addAnim(Assets.shipAnimSprites,"flag",1/ 6f,40,190);
        platforms[3].addAnim(Assets.shipAnimSprites,"anchor",1/6f,270,150);
    }
    public void update(float delta) {
        touches = BKInputProcessor.getTouches();
        if (touches != null) {
            int size = touches.size();
            for (int i = 0; i < size; i++) {
                if (touches.containsKey(i)){
                    BKInputProcessor.TouchPoint t = touches.get(i);
                    if (t.inst) {
                        for (int j = 0; j < platforms.length; j++) {
                            UIPlatform p = platforms[j];
                            if (p.isHit(t.pos)) {
                                Gdx.app.log("",""+ p.id);
                            }
                        }
                    }

                }
            }
        }

        for (int i = 0; i < platforms.length; i++) {
            platforms[i].update(delta);
        }
    }
    public UIPlatform[] getPlatforms(){
        return platforms;
    }
}
