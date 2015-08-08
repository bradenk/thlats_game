package com.bkd.thlatsGame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.bkd.thlatsGame.THLGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "10,000 Leagues above the Sea";
		config.width = 1920;
		config.height = 1080;
		new LwjglApplication(new THLGame(), config);
	}
}
