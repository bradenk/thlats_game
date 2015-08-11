package com.bkd.thlatsGame.Input;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Braden on 11/08/2015.
 */
public class BKInputProcessor implements InputProcessor {

    public static Map<Integer,TouchPoint> touches = new HashMap<Integer,TouchPoint>();

    public static Map<Integer,TouchPoint> getTouches(){
        if (touches.isEmpty()) {
            return null;
        } else {
            return touches;
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
        if (touches.containsKey(pointer)) {
            touches.get(pointer).move(screenX, screenY);
            touches.get(pointer).down();
        } else {
            touches.put(pointer,new TouchPoint(screenX, screenY));
            touches.get(pointer).down();
        }
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (touches.containsKey(pointer)) {
            touches.get(pointer).move(screenX, screenY);
            touches.get(pointer).up();
        } else {
            touches.put(pointer,new TouchPoint(screenX, screenY));
            touches.get(pointer).up();
        }
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
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
