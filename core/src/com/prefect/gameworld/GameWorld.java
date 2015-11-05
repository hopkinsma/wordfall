package com.prefect.gameworld;

import com.prefect.wordhelpers.AssetLoader;

public class GameWorld {
	
	public static FallingLetter gameLetters[];
	public static Player thePlayer;
	public static GameButton startButton;
	public static boolean startScreen, levScreen, playScreen, endScreen;
	
	public GameWorld(int midPointY){
		thePlayer = new Player("Player 1");
		startButton = new GameButton(270, 190, 100, 100);
		startScreen = true;
		playScreen = false;
		endScreen = false;
		levScreen = false;
	}

	public void update(float delta) {
		if (startScreen || endScreen) {
			
		} else if (playScreen) {
			/*Loop through all the falling letters and move them down, if they hit floor make
		     * player take damage. If players life is gone, game is over. check higscores. */
		    int count = 0;
		    for (int x = 0; x < gameLetters.length; x++) {
				//System.out.println("Count is " + x + " of " + gameLetters.length);
				//System.out.println("Letter is " + gameLetters[x].value());
		    	if (gameLetters[x].fallStatus()) {
			    	count += 1;
			    	gameLetters[x].update();
			    	if (gameLetters[x].hitFloor()) {
			    		thePlayer.damaged(10);
			    		if (thePlayer.getLife() <= 0) { //player is dead, check top scores and change screen
			    			playScreen = false;
			    			endScreen = true;
			    			System.out.println("You died, Sucka.");
			    		}
			    		if (gameLetters[x].checkSelected()) {
			    			for (int i = 0; i < gameLetters.length; i++) {
			    				gameLetters[i].deselect();
			    			}
			    			//word = "";
			    		}
			    		gameLetters[x].kill();
			    	}
				}
		    }
		    if (count == 0) { //no letters left on screen, check to see if level is over and get a new word.
				thePlayer.incWords();
				if (thePlayer.getWords() == 8) {
				    thePlayer.levelUp();
				    playScreen = false;
				    levScreen = true;
				}
				else {
				    String letString = AssetLoader.wordDict.getRandWord();
			        gameLetters = new FallingLetter[letString.length()];
			        System.out.println("New word: " + letString);
			        //give them random x locations
			        for (int i = 0; i < letString.length(); i++) {
			            int xLoc = (5 + (6 - letString.length()) + i) * 30 + 10;
			            gameLetters[i] = new FallingLetter(letString.charAt(i), xLoc, 1);
			        }
				}
		    }
		}
	}
	
}
