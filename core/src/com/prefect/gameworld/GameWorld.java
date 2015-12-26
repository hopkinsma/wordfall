package com.prefect.gameworld;

import com.badlogic.gdx.Gdx;
import com.prefect.wordhelpers.AssetLoader;
import com.prefect.wordhelpers.Helpers;

public class GameWorld {
	
	public static FallingLetter gameLetters[];
	public static Player thePlayer;
	public static GameButton startButton, enterButton, clearButton, endButton;
	public static boolean startScreen, levScreen, playScreen, endScreen;
	public static String word;
	public static BackgroundObject satellite;
	private Helpers helpMe;
	
	public GameWorld(int midPointY){
		helpMe = new Helpers();
		thePlayer = new Player("Player 1");
		//startButton = new GameButton(helpMe.xPixelAdjuster(Gdx.graphics.getWidth()/2), Gdx.graphics.getHeight() * 0.46F, 50, 150);
		startButton = new GameButton((Gdx.graphics.getWidth()/2) - 125, Gdx.graphics.getHeight() * 0.46F, 80, 250);
		enterButton = new GameButton(Gdx.graphics.getWidth()- helpMe.xPixelAdjuster(210), Gdx.graphics.getHeight() - helpMe.yPixelAdjuster(210), helpMe.xPixelAdjuster(200), helpMe.yPixelAdjuster(200));
		System.out.println(helpMe.xPixelAdjuster(85));
		clearButton = new GameButton(helpMe.xPixelAdjuster(10), Gdx.graphics.getHeight() - helpMe.yPixelAdjuster(210), helpMe.xPixelAdjuster(200), helpMe.yPixelAdjuster(200));
		endButton = new GameButton(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight() * 0.46F, 80, 250);
		//satellite = new BackgroundObject((int)helpMe.xPixelAdjuster(125), (int)helpMe.yPixelAdjuster(100));
		satellite = new BackgroundObject(125, 100);
		startScreen = true;
		playScreen = false;
		endScreen = false;
		levScreen = false;
		word = "";
	}

	public void update(float delta) {
		satellite.update(delta);
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
			    	gameLetters[x].update(delta);
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
			    		}
			    		gameLetters[x].kill();
			    		word = "";
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
			            //int xLoc = (5 + (6 - letString.length()) + i) * 30 + 10;
			        	//int xLoc = ((Gdx.graphics.getWidth() / 6) * i) - (((6-letString.length() * 75) /2));  
			            //float xLoc = (Gdx.graphics.getWidth() / 2) - ((letString.length() * 75)/2) + (i*75);
			        	//float xLoc = (Gdx.graphics.getWidth() / 2) - ((letString.length() * helpMe.xPixelAdjuster(75))/2) + (i*helpMe.xPixelAdjuster(75));
			        	//System.out.println("xLoc is " + xLoc + ". xPixelAdjusted is" + helpMe.xPixelAdjuster(75));

						//commented out previous xLoc
						float xLoc = (Gdx.graphics.getWidth() / 2) - ((letString.length() * helpMe.xPixelAdjuster(142))/2) + (i*helpMe.xPixelAdjuster(142));
			        	gameLetters[i] = new FallingLetter(letString.charAt(i), xLoc, 1, helpMe.xPixelAdjuster(75));
			        }
				}
		    }
		}
	}
	
}
