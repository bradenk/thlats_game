package com.bkd.thlatsGame.ships;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.bkd.thlatsGame.Guns.Gun;
import com.bkd.thlatsGame.Guns.GunMount;
import com.bkd.thlatsGame.Rooms.Room;
import com.bkd.thlatsGame.Rooms.RoomPos;
import com.bkd.thlatsGame.crew.Crew;
import com.bkd.thlatsGame.screens.BattleScreen;
import com.bkd.thlatsGame.worlds.BattleWorld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Braden on 17/08/2015.
 */
public class Ship {
    private boolean isPlayer;
    private int health;
    private int dir;
    private int dist;
    private float speed;
    private int[] floor;
    private HashMap<GunMount,Gun> guns;
    private HashSet<Crew> crewSet;
    private HashMap<RoomPos,Room> rooms;
    private Sprite shipBG;
    private Sprite shipFG;
    private int rockY;
    private int altitude;


    public Ship(boolean isPlayer){
        if (isPlayer) dir = -1;
        else dir = 1;
    }
    public void update(float delta) {
        dist = (int) (speed * delta);
        rockY = (int) Math.sin(delta);
    }
    public void addRoom(RoomPos pos, Room room) {
        if (rooms.containsKey(pos)) {
            rooms.remove(pos);
        }
        rooms.put(pos,room);
    }
    public void damage(int hp) {
        health -= hp;
        if (health <= 0) die();
    }
    public int getHealth(){
        return health;
    }
    public int getY() {
        return rockY + altitude + BattleScreen.horizon;
    }
    public int distX() {
        return dist;
    }
    private void die(){

    }
}
