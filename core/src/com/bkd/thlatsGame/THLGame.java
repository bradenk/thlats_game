package com.bkd.thlatsGame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.bkd.thlatsGame.Input.BKInputProcessor;
import com.bkd.thlatsGame.screens.BattleScreen;
import com.bkd.thlatsGame.screens.MainMenuScreen;

public class THLGame extends Game {
	BKInputProcessor ip = new BKInputProcessor();
	public static BKInputProcessor.TouchPoint[] touches;
	public static enum screens {
		MainMenu,
		Battle
	}

	@Override
	public void create() {
		Gdx.app.log("THLGame", "Started");
		setScreen(new MainMenuScreen(this));
		Gdx.input.setInputProcessor(ip);

	}
	public void switchScreens(screens s) {
		switch (s) {
			case Battle:
				setScreen(new BattleScreen(this));
				break;
		}
	}
}
