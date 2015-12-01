package com.prefect.wordhelpers;

import java.io.BufferedReader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.prefect.gameworld.WordList;


public class AssetLoader {
	
	public static Texture backTexture, letterTexture, smLetterTexture, buttonTexture, levTexture, gameOverTexture, clearEnterTexture, satTexture;
	
	public static TextureRegion bg;
	public static TextureRegion wordBubbles[][];
	public static TextureRegion smLetters[];
	public static TextureRegion startButton;
	public static TextureRegion levButton;
	public static TextureRegion enterButton;
	public static TextureRegion clearButton;
	public static TextureRegion gameOverButton;
	public static TextureRegion satellite; 
	public static WordList wordDict;
	private static Helpers helpMe = new Helpers();
	
	public static void load(){
		
		backTexture = new Texture(Gdx.files.internal("data/icePlanetBG.png"));
		//texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		letterTexture = new Texture(Gdx.files.internal("data/bubs.png"));
		letterTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		smLetterTexture = new Texture(Gdx.files.internal("data/activeletters.png"));
		smLetterTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		clearEnterTexture = new Texture(Gdx.files.internal("data/clearenter.png"));
		clearEnterTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		levTexture = new Texture(Gdx.files.internal("data/startLevel.png"));
		levTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		buttonTexture = new Texture(Gdx.files.internal("data/startButton.png"));
		buttonTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		 		
		gameOverTexture = new Texture(Gdx.files.internal("data/deadScreen.png"));
		gameOverTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		satTexture = new Texture(Gdx.files.internal("data/sputnik.png"));
		satTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		bg = new TextureRegion(backTexture, 0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		bg.flip(false, true);
		
		startButton = new TextureRegion(buttonTexture, 0,0,250,80);
		startButton.flip(false,  true);
		
		levButton = new TextureRegion(levTexture, 0,0,250,80);
		levButton.flip(false, true);
		
		gameOverButton = new TextureRegion(gameOverTexture, 0, 0, 250, 80);
		gameOverButton.flip(false,  true);
		
		satellite = new TextureRegion(satTexture, 0, 0, 125, 100);
		satellite.flip(false, true);
		
		wordBubbles = new TextureRegion[26][2];
		
		//float seventyFivePixelsX = helpMe.xPixelAdjuster(75);
		//float seventyFivePixelsY = helpMe.yPixelAdjuster(75);
		
		//System.out.println("seventyFivePixelsX : " + seventyFivePixelsX);
		//System.out.println("seventyFivePixelsY : " + seventyFivePixelsY);
		
		for (int i = 0; i < 26; i++) {
			wordBubbles[i][0] = new TextureRegion(letterTexture, i * 75, 0, 75, 75);
			wordBubbles[i][0].flip(false,  true);
			wordBubbles[i][1] = new TextureRegion(letterTexture, i * 75, 75, 75, 75);
			wordBubbles[i][1].flip(false,  true);
		}
		
		
		smLetters = new TextureRegion[26];
		for (int i = 0; i < 26; i++) {
			smLetters[i] = new TextureRegion(smLetterTexture, i * 50, 0, 50, 50);
			smLetters[i].flip(false,  true);
		}
		
		enterButton = new TextureRegion(clearEnterTexture, 112, 0, 112, 112);
		enterButton.flip(false,  true);
		clearButton = new TextureRegion(clearEnterTexture, 0, 0, 112, 112);
		clearButton.flip(false,  true);
		
		//read in the dictionary
		wordDict = new WordList();
		FileHandle handle = Gdx.files.internal("data/dict.txt");
		
		//String  thisLine = null;
		try{
			//FileReader fileReader = new FileReader(Gdx.files.internal("data/dict.txt"));
			//InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(handle.reader());
			boolean endof = false;
			String inLine = null;
			while (!endof) {
			    inLine = br.readLine();
			    if (inLine == null) {
			        endof = true;
			    }
			    else {
			        wordDict.addWord(inLine);
			    	//System.out.println(inLine);
			    }
			}      
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void dispose() {
		backTexture.dispose();
		letterTexture.dispose();
		buttonTexture.dispose();
		levTexture.dispose();
		smLetterTexture.dispose();
		clearEnterTexture.dispose();
		satTexture.dispose();
		gameOverTexture.dispose();
		
	}

}
