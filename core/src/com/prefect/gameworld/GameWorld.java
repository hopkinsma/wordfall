package com.prefect.gameworld;


public class GameWorld {
	
	public FallingLetter gameLetters[];
	public Player thePlayer;
	public GameButton startButton;
	public static boolean startScreen, playScreen, endScreen;
	
	public GameWorld(int midPointY){
		gameLetters = new FallingLetter[6];
		thePlayer = new Player("Player 1");
		startButton = new GameButton(20, 20, 100, 20);
		startScreen = true;
		playScreen = false;
		endScreen = false;
	}

	public void update(float delta) {
		
	}
	
}
