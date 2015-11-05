package com.prefect.wordhelpers;

import java.io.BufferedReader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.prefect.gameworld.WordList;


public class AssetLoader {
	
	public static Texture texture, tileTexture;
	
	public static TextureRegion bg;
	public static WordList wordDict;
	
	public static void load(){
		
		texture = new Texture(Gdx.files.internal("data/wordfall2.jpg"));
		//texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		//tileTexture = new Texture(Gdx.files.internal("data/tiles.jpg"));		
		
		bg = new TextureRegion(texture, 0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		bg.flip(false, true);
		
		
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
		texture.dispose();
	}

}
