package com.bkd.thlatsGame.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.bkd.thlatsGame.AssetLoader;
import com.bkd.thlatsGame.Assets;
import com.bkd.thlatsGame.u.Rect;

/**
 * Created by Braden on 6/08/2015.
 */
public class UIMainMenu extends Rect {

    private int x, y;
    private int w = 780, h = 751;

    private bkdBtn[] buttons;
    private Sprite sprite;
    private double sinY = 0;
    private double sinX = 0;

    public UIMainMenu(int x, int y) {
        this.left = x;
        this.right = x + w;
        this.top = y;
        this.bottom = y + h;
        sprite = AssetLoader.getSprite(Assets.menuSprites,"menuFrame");
        sprite.setPosition((int)x , (int)y);
        buttons = new bkdBtn[]{
                new bkdBtn(240,56,"start","startBtn"),
                new bkdBtn(271,273,"resume","resumeBtn"),
                new bkdBtn(600,482,"quit","quitBtn"),
                new bkdBtn(564,460,"settings","settingsBtn")
        };
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setSpritePosition(left,top);
        }
    }
    public void update(){
        double offY = Math.sin(sinY) * 3;
        double offX = Math.sin(sinX) * 2 ;
        sinY += .03 ;
        sinX += .016 ;
        sprite.setPosition((int) (left + offX), (int) (top + offY));
    }
    public Sprite getSprite() {
        return sprite;
    }
    public Sprite getBtnSprite(int index){
        return buttons[index].getSprite();
    }
}
