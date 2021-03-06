package com.prefect.wordhelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.prefect.gameworld.GameWorld;
import com.prefect.gameworld.Player;
import com.prefect.gameworld.FallingLetter;
import com.badlogic.gdx.Input.Keys;
import com.prefect.wordhelpers.Helpers;

public class InputHandler implements InputProcessor {

	
	private static Helpers helpMe = new Helpers();
	
	public InputHandler() {
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		
		switch (keycode) {
			
			case Keys.ENTER:
				if (AssetLoader.wordDict.listContains(GameWorld.word)) {
					GameWorld.thePlayer.scored(25 * GameWorld.word.length());
					if (GameWorld.word.length() == GameWorld.gameLetters.length) {
						
						GameWorld.thePlayer.giveLife(5);
					}
					for (int i = 0; i < GameWorld.gameLetters.length; i++) {
						
						if (GameWorld.gameLetters[i].checkSelected()) {
						
							GameWorld.gameLetters[i].kill();
					    }
					}
				} else {
					
					for (int i = 0; i < GameWorld.gameLetters.length; i++) {
						GameWorld.gameLetters[i].deselect();
					}
				}
				GameWorld.word = "";
				break;
				
			case Keys.BACKSPACE:
				for (int i = 0; i < GameWorld.gameLetters.length; i++) {
		            GameWorld.gameLetters[i].deselect();
				}
				GameWorld.word = "";
				break;
				
			default:
				for (int i = 0; i < GameWorld.gameLetters.length; i++) {
				    if ((Character.toString(GameWorld.gameLetters[i].value()).equalsIgnoreCase(Keys.toString(keycode))) && (GameWorld.gameLetters[i].fallStatus()) && (!GameWorld.gameLetters[i].checkSelected())) {
				    	GameWorld.gameLetters[i].select();
				    	Character add = GameWorld.gameLetters[i].value();
				    	GameWorld.word = GameWorld.word.concat(add.toString());
				    	break;
				    }
				}
				break;
				}
		
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {	
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		
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
		        //int xLoc = (5 + (6 - letString.length()) + i) * 30 + 10;
				float xLoc = (Gdx.graphics.getWidth() / 2) - ((letString.length() * helpMe.xPixelAdjuster(142))/2) + (i*helpMe.xPixelAdjuster(142));
				GameWorld.gameLetters[i] = new FallingLetter(letString.charAt(i), xLoc, 1, helpMe.xPixelAdjuster(75));
		    }
		}
		//and do another on the play screen
		else if (GameWorld.playScreen) {
			if (GameWorld.enterButton.containsPoint(screenX, screenY)) {
				System.out.println("Enter clicked.");
				if (AssetLoader.wordDict.listContains(GameWorld.word)) {
				    GameWorld.thePlayer.scored(25 * GameWorld.word.length());
				    if (GameWorld.word.length() == GameWorld.gameLetters.length) {
				        GameWorld.thePlayer.giveLife(5);
				    }
				    for (int i = 0; i < GameWorld.gameLetters.length; i++) {
				        if (GameWorld.gameLetters[i].checkSelected()) {
					    GameWorld.gameLetters[i].kill();
				        }
				    }
				} else {
					for (int i = 0; i < GameWorld.gameLetters.length; i++) {
					    GameWorld.gameLetters[i].deselect();
				    }
				}
				GameWorld.word = "";
			} else if (GameWorld.clearButton.containsPoint(screenX, screenY)) {
				//Clear button clicked
				System.out.println("Clear clicked");
				for (int i = 0; i < GameWorld.gameLetters.length; i++) {
		            GameWorld.gameLetters[i].deselect();
				}
				GameWorld.word = "";
			} else { //no button clicked, check letters
				boolean clickCheck = false;
				for (int i = 0; i < GameWorld.gameLetters.length; i++) {
					if (GameWorld.gameLetters[i].checkClick(screenX, screenY)) {
							System.out.println("fallStatus: " + GameWorld.gameLetters[i].fallStatus());
						if (GameWorld.gameLetters[i].fallStatus()) {
					    		System.out.println("check select: " + !GameWorld.gameLetters[i].checkSelected());
							if (!GameWorld.gameLetters[i].checkSelected()) {
								GameWorld.gameLetters[i].select();
								GameWorld.word = GameWorld.word.concat(Character.toString(GameWorld.gameLetters[i].value()));
					            	//GameWorld.gameLetters[i].kill();
								clickCheck = true;
							}
							else {
								//the letter is already selected. deselect letter maybe?
							}
						}
					}
				}
				if (!clickCheck) {
					/*if (AssetLoader.wordDict.listContains(GameWorld.word)) {
						GameWorld.thePlayer.scored(25 * GameWorld.word.length());
						if (GameWorld.word.length() == GameWorld.gameLetters.length) {
							GameWorld.thePlayer.giveLife(5);
						}
						for (int i = 0; i < GameWorld.gameLetters.length; i++) {
							if (GameWorld.gameLetters[i].checkSelected()) {
								GameWorld.gameLetters[i].kill();
							}
						}
						GameWorld.word = "";
					}*/
				}
			}
		//aaaaan on the end screen
		} else if (GameWorld.endScreen) {
			GameWorld.endScreen = false;
			GameWorld.startScreen = true;
		}
	
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
