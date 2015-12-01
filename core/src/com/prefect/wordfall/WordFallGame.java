package com.prefect.wordfall;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.prefect.wordhelpers.AssetLoader;
import com.prefect.screens.GameScreen;

public class WordFallGame extends Game {
	
	/*
	DezNutz
	*/
	
	
	@Override
	public void create() {
		Gdx.app.log("WordFall", "created");
		AssetLoader.load();
		setScreen(new GameScreen());
	}

	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}
}
