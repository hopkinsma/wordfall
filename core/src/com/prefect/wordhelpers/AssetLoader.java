package com.prefect.wordhelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
	
	public static Texture texture, tileTexture;
	
	public static TextureRegion bg;
	
	public static void load(){
		
		texture = new Texture(Gdx.files.internal("data/backdropIdea.jpg"));
		texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		//tileTexture = new Texture(Gdx.files.internal("data/tiles.jpg"));		
		
		bg = new TextureRegion(texture, 43,43,2,2);
		bg.flip(false, true);
		
	}
	
	public static void dispose() {
		texture.dispose();
	}

}
