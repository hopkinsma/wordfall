package com.prefect.wordfall;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.prefect.wordhelpers.AssetLoader;
import com.prefect.screens.GameScreen;

public class WordFallGame extends Game {
	
	/*
	DezNutz
	*/
	GameScreen gameScreen;
	
	@Override
	public void create() {
		Gdx.app.log("WordFall", "created");
		AssetLoader.load();
		gameScreen = new GameScreen();
		setScreen(gameScreen);
	}

	@Override
	public void dispose() {
		System.out.println("Dispose called.");
		super.dispose();
		gameScreen.dispose();
		AssetLoader.dispose();
	}
}
