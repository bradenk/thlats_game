package com.bkd.thlatsGame.Input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector3;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Braden on 11/08/2015.
 */
public class BKInputProcessor implements InputProcessor  {
    private static final int MAXTOUCHPOINTS = 5;
    private TouchPoint t;
    public boolean isInit = false;



    public BKInputProcessor(){
        for (int i = 0; i < MAXTOUCHPOINTS; i++) {
            InputHolder.touches[i] = new TouchPoint(0,0);
        }
        isInit = true;
    }

    public TouchPoint[] getTouches(){
        return InputHolder.touches;
    }


    public class TouchPoint {
        public Vector3 pos = new Vector3();
        private int id;
        private boolean down = false;
        private boolean justPressed = false;
        private boolean dragging = false;

        public TouchPoint(int x, int y) {
            pos.set(x,y,0);
        }
        public void setPos(int x, int y) { pos.set(x,y,0); }
        public int getX() { return (int)pos.x; }
        public int getY() { return (int)pos.y; }
        public float getYf() { return pos.y; };
        public float getXf() { return pos.x; }
        public boolean isDown(){ return down; }
        public boolean isJustPressed() { return justPressed; }
        public boolean isDragging() { return dragging; }

        public void setDown(boolean isDown) { down = isDown; }
        public void setDrag(boolean isDragging) { dragging = isDragging; }
        public void setJustPressed(boolean isJustPressed) { justPressed = isJustPressed; }

        public String info(){
            return new String("x: " + pos.x + " y: " + pos.y + " T: " + isDown() + " I: " + isJustPressed() + " D: " + isDragging() );
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
     if (pointer < MAXTOUCHPOINTS) {
         InputHolder.touches[pointer].setPos(screenX, screenY);
         if (InputHolder.touches[pointer].isDown()) {
             InputHolder.touches[pointer].setJustPressed(false);
         } else {
             InputHolder.touches[pointer].setJustPressed(true);
         }
         InputHolder.touches[pointer].setDown(true);
     }
     return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (pointer < MAXTOUCHPOINTS) {
            InputHolder.touches[pointer].setPos(screenX, screenY);
            InputHolder.touches[pointer].setDown(false);
            InputHolder.touches[pointer].setDrag(false);
            InputHolder.touches[pointer].setJustPressed(false);
        }
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer)  {
        if (pointer < MAXTOUCHPOINTS) {
            InputHolder.touches[pointer].setPos(screenX, screenY);
            InputHolder.touches[pointer].setDrag(true);
            InputHolder.touches[pointer].setJustPressed(false);
        }
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
