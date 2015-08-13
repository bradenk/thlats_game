package com.bkd.thlatsGame.Input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.bkd.thlatsGame.u.U;

/**
 * Created by Braden on 13/08/2015.
 */
public class ZoomControl {
    public static float zoom;
    private final float MAXZOOM = 4;
    private final float MINZOOM = 1;
    private boolean isZooming = false;
    private float lastDist = 0;
    private float curDist = 0;
    Vector2 p1, p2;
    BKInputProcessor.TouchPoint[] touches;

    public void update() {
        touches = InputHolder.touches;
        if (touches[0].isDown() && touches[1].isDown()) {
            p1 = touches[0].pos;
            p2 = touches[1].pos;
            curDist = p1.dst(p2);
            if (isZooming) {
                float scale = curDist / lastDist;
                zoom =  U.clamp(zoom * scale, MINZOOM, MAXZOOM);
            } else {
                lastDist = curDist;
                isZooming = true;
            }
        } else {
            isZooming = false;
        }
    }
    public float getZoom(){
        return zoom;
    }
    public String zoomDebug(){
        if (isZooming) {
            return "currently zoom: " + zoom;
        } else {
            return "Not zooming";
        }
    }
}
