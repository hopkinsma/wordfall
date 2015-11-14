package com.prefect.wordhelpers;

import com.badlogic.gdx.Gdx;

public class Helpers {
	
	final private static int baseWidth = 480;
	final private static int baseHeight = 640;
	
	private float screenWidth = Gdx.graphics.getWidth();
	private float screenHeight = Gdx.graphics.getHeight();
	
	public Helpers(){
		
	}
	
	public float xPixelAdjuster(int xPixel) {
		return screenWidth * (xPixel/baseWidth);
	}
	
	public float yPixelAdjuster(int yPixel) {
		return screenHeight * (yPixel/baseHeight);
	}	
	

}
