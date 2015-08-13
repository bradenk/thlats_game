package com.bkd.thlatsGame.Input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.bkd.thlatsGame.u.U;

/**
 * Created by Braden on 13/08/2015.
 */
public class ZoomControl {
    public static float zoom;
    private final float MAXZOOM = 4;
    private final float MINZOOM = 1;
    private boolean isZooming = false;
    private float initDist = 0;
    private float curDist = 0;
    private float initZoom = 1;
    private float lastZoom = 1;
    private Vector3 Sp1,Sp2;
    Vector3 p1, p2;
    BKInputProcessor.TouchPoint[] touches;

    public void update(OrthographicCamera cam) {
        touches = InputHolder.touches;
        if (touches[0].isDown() && touches[1].isDown()) {
            p1 = touches[0].pos;
            p2 = touches[1].pos;
            p1 = cam.unproject(p1);
            p2 = cam.unproject(p2);
            curDist = p1.dst(p2);
            if (isZooming) {
                curDist = p1.dst(p2);
                zoom =  U.clamp((lastZoom * (curDist/initDist) * 0.5f) , MINZOOM, MAXZOOM);
            } else {
                Sp1 = new Vector3(p1);
                Sp2 = new Vector3(p2);
                initDist = Sp1.dst(Sp2);
                isZooming = true;
            }
        } else {
            if (isZooming) {
                lastZoom = zoom;
            }
            isZooming = false;
        }
    }
    public float getZoom(){
        return U.clamp(zoom , MINZOOM, MAXZOOM);
    }
    public String zoomDebug(){
        if (isZooming) {
            return "currently zoom: " + zoom;
        } else {
            return "Not zooming";
        }
    }
}
