package com.bkd.thlatsGame.u;

/**
 * Created by Braden on 13/08/2015.
 */
public class U {
    public static float clamp(float val, float min, float max) {
        if (val > max) val = max;
        else if (val < min) val = min;
        return val;
    }
}
