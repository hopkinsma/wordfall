package com.prefect.wordhelpers;

import com.badlogic.gdx.InputProcessor;
import com.prefect.gameworld.GameWorld;
import com.prefect.gameworld.Player;
import com.prefect.gameworld.FallingLetter;
import com.badlogic.gdx.Input.Keys;

public class InputHandler implements InputProcessor {

	
	public InputHandler() {
	}

	@Override
	public boolean keyDown(int keycode) {
		System.out.println("Keypress:" + keycode);
		//GameWorld.startScreen = false;
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {	
		//do one thing if the touch is on the start screen
		if (GameWorld.startScreen) {
			if (GameWorld.startButton.containsPoint(screenX, screenY)) {
				GameWorld.thePlayer = new Player("Player 1");
				GameWorld.startScreen = false;
				GameWorld.levScreen = true;
				System.out.println("startButton clicked!");
			}
		}
		else if (GameWorld.levScreen) {
			GameWorld.levScreen = false;
			GameWorld.playScreen = true;
			String letString = AssetLoader.wordDict.getRandWord();
		    GameWorld.gameLetters = new FallingLetter[letString.length()];
			System.out.println("Starting level. Word is: " + letString);
			for (int i = 0; i < letString.length(); i++) {
		        int xLoc = (5 + (6 - letString.length()) + i) * 30 + 10;
		        GameWorld.gameLetters[i] = new FallingLetter(letString.charAt(i), xLoc, 1);
		    }
		}
		//and do another on the play screen
		else if (GameWorld.playScreen) {
			if (GameWorld.startButton.containsPoint(screenX, screenY)) {
				GameWorld.playScreen = false;
				GameWorld.startScreen = true;
				System.out.println("Returning to start screen");
			}
		}
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}
