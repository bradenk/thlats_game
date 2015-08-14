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
    private final float MAXZOOM = 1;
    private final float MINZOOM = .25f;
    private boolean isZooming = false;
    private float initDist = 0;
    private float curDist = 0;
    private float initZoom = 1;
    private float lastZoom = 1;
    private Vector3 Sp1,Sp2;
    private Vector3 Smp = new Vector3();
    private Vector3 center = new Vector3();
    private Vector3 lastCenter = new Vector3();
    private Vector3 offset = new Vector3();
    Vector3 p1, p2;
    BKInputProcessor.TouchPoint[] touches;

    public void update(OrthographicCamera cam) {
        touches = InputHolder.touches;
        if (touches[0].isDown() && touches[1].isDown()) {
            p1 = touches[0].pos;
            p2 = touches[1].pos;
            center.set((p1.x + p2.x) / 2, (p1.y + p2.y) / 2, 0);
            Gdx.app.log("camera center", center.x + " ' " + center.y);
            curDist = p1.dst(p2);
            if (isZooming) {
                curDist = p1.dst(p2);
                zoom =  U.clamp((lastZoom / (curDist / initDist)), MINZOOM, MAXZOOM);
                offset.set(lastCenter.x - center.x, lastCenter.y - center.y, 0);
                lastCenter.set(center);
                Gdx.app.log("camera lastcenter" , lastCenter.x + " ' " +lastCenter.y);
                Gdx.app.log("camera offset" , offset.x + " ' " +offset.y);
            } else {
                lastCenter = new Vector3(center);
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
    public Vector3 getCenter() {

        return offset.scl(zoom);
    }
    public boolean isZooming() {
        return isZooming;
    }
    public String zoomDebug(){
        if (isZooming) {
            return "currently zoom: " + zoom;
        } else {
            return "Not zooming";
        }
    }
}
