package com.bkd.thlatsGame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.bkd.thlatsGame.screens.MainMenuScreen;

public class THLGame extends Game {

	@Override
	public void create() {
		Gdx.app.log("THLGame","Started");
		setScreen(new MainMenuScreen());
	}
}
