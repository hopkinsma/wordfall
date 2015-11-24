package com.prefect.wordhelpers;

import com.badlogic.gdx.Gdx;

public class Helpers {
	
	final private static float baseWidth = 480;
	final private static float baseHeight = 640;
	
	private float screenWidth = Gdx.graphics.getWidth();
	private float screenHeight = Gdx.graphics.getHeight();
	
	public Helpers(){
		
	}
	//dsafsdf
	public float xPixelAdjuster(float xPixel) {
		//System.out.println("Screen width: " + Gdx.graphics.getWidth() + " xPixel: " + xPixel + " baseWidth: " + baseWidth);
		//System.out.println("xPixel/baseWidth = " + (xPixel/baseWidth));
		float fixedSize = screenWidth * (xPixel/baseWidth);
		return fixedSize;
	}
	
	public float yPixelAdjuster(float yPixel) {
		return screenHeight * (yPixel/baseHeight);
	}	
	

}
