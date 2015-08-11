package com.bkd.thlatsGame.Input;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Braden on 11/08/2015.
 */
public class BKInputProcessor implements InputProcessor {

    public static Map<Integer,TouchPoint> tDown = new HashMap<Integer,TouchPoint>();
    public static Map<Integer,TouchPoint> tUp = new HashMap<Integer,TouchPoint>();


    public static Map<Integer,TouchPoint> getTouches(){
        if (tDown.isEmpty()) {
            return null;
        } else {
            return tDown;
        }
    }

    public class TouchPoint {
        public Vector2 pos = new Vector2();
        public int id;
        public boolean isDown;
        public boolean inst;

        public TouchPoint(int x, int y) {
            pos.set(x,y);
            isDown = true;
            inst = false;
        }
        public void move(int x, int y) {
            pos.set(x,y);
        }
        public void down(){
            if (!isDown) {
                inst = true;
            } else {
                inst = false;
            }
            isDown = true;

        }
        public void up(){
            inst = false;
            isDown = false;
        }
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (tDown.containsKey(pointer)) {
            tDown.get(pointer).move(screenX, screenY);
        } else if (tUp.containsKey(pointer)){
            TouchPoint t = tUp.get(pointer);
            tUp.remove(pointer);
            tDown.put(pointer,t);
        } else {
            TouchPoint t = new TouchPoint(screenX,screenY);
            t.down();
            tDown.put(pointer, t);
        }

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        if (tUp.containsKey(pointer)) {
            tUp.get(pointer).move(screenX, screenY);
            tUp.get(pointer).down();
        } else if (tDown.containsKey(pointer)){
            TouchPoint t = tDown.get(pointer);
            tDown.remove(pointer);
            tUp.put(pointer,t);
        } else {
            TouchPoint t = new TouchPoint(screenX,screenY);
            t.down();
            tUp.put(pointer, t);
        }
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer)  {

        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
