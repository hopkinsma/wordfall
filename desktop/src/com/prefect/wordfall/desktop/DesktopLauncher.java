package com.prefect.wordfall.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.prefect.wordfall.WordFallGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//window size of desktop app is set here
		config.height = 800;
		config.width = 550;
		new LwjglApplication(new WordFallGame(), config);
	}
}
