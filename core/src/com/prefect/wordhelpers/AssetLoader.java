package com.prefect.wordhelpers;

import java.io.BufferedReader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.prefect.gameworld.WordList;


public class AssetLoader {
	
	public static Texture backTexture, letterTexture, buttonTexture, levTexture;
	
	public static TextureRegion bg;
	public static TextureRegion wordBubbles[];
	public static TextureRegion startButton;
	public static TextureRegion levButton;
	public static WordList wordDict;
	private static Helpers helpMe = new Helpers();
	
	public static void load(){
		
		backTexture = new Texture(Gdx.files.internal("data/backdrop.jpg"));
		//texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		letterTexture = new Texture(Gdx.files.internal("data/bubs.png"));
		letterTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		levTexture = new Texture(Gdx.files.internal("data/startLevel.png"));
		levTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		buttonTexture = new Texture(Gdx.files.internal("data/startButton.png"));
		buttonTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		 		
		
		bg = new TextureRegion(backTexture, 0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		bg.flip(false, true);
		
		startButton = new TextureRegion(buttonTexture, 0,0,215,69);
		startButton.flip(false,  true);
		
		levButton = new TextureRegion(levTexture, 0,0,215,69);
		levButton.flip(false, true);
		
		wordBubbles = new TextureRegion[25];
		
		float seventyFivePixelsX = helpMe.xPixelAdjuster(75);
		float seventyFivePixelsY = helpMe.yPixelAdjuster(75);
		
		System.out.println("seventyFivePixelsX : " + seventyFivePixelsX);
		System.out.println("seventyFivePixelsY : " + seventyFivePixelsY);
		
		for (int i = 0; i < 25; i++) {
			wordBubbles[i] = new TextureRegion(letterTexture, i * seventyFivePixelsX, 0, seventyFivePixelsX, seventyFivePixelsY);
			wordBubbles[i].flip(false,  true);
		}
		
		
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
	}

}
