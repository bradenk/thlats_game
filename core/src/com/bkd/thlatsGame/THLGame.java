package com.bkd.thlatsGame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.bkd.thlatsGame.Input.BKInputProcessor;
import com.bkd.thlatsGame.screens.MainMenuScreen;

public class THLGame extends Game {
	BKInputProcessor ip = new BKInputProcessor();

	@Override
	public void create() {
		Gdx.app.log("THLGame", "Started");
		setScreen(new MainMenuScreen());
		Gdx.input.setInputProcessor(ip);

	}
}
