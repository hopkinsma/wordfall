package com.prefect.wordhelpers;

import com.badlogic.gdx.Gdx;

public class Helpers {
	
	final private static float baseWidth = 1080;
	final private static float baseHeight = 1920;
	
	private float screenWidth = Gdx.graphics.getWidth();
	private float screenHeight = Gdx.graphics.getHeight();
	
	public Helpers(){
		
	}

	public float xPixelAdjuster(float xPixel) {
		//System.out.println("Screen width: " + Gdx.graphics.getWidth() + " xPixel: " + xPixel + " baseWidth: " + baseWidth);
		//System.out.println("xPixel/baseWidth = " + (xPixel/baseWidth));
		float fixedSize = screenWidth * (xPixel/baseWidth);
		return fixedSize;
	}
	
	public float yPixelAdjuster(float yPixel) {
		return screenHeight * (yPixel/baseHeight);
	}	
	
	public int getCharInt(char c) {
		switch (c) {
			case 'a': return 0;
			case 'b': return 1;
			case 'c': return 2;
			case 'd': return 3;
			case 'e': return 4;
			case 'f': return 5;
			case 'g': return 6;
			case 'h': return 7;
			case 'i': return 8;
			case 'j': return 9;
			case 'k': return 10;
			case 'l': return 11;
			case 'm': return 12;
			case 'n': return 13;
			case 'o': return 14;
			case 'p': return 15;
			case 'q': return 16;
			case 'r': return 17;
			case 's': return 18;
			case 't': return 19;
			case 'u': return 20;
			case 'v': return 21;
			case 'w': return 22;
			case 'x': return 23;
			case 'y': return 24;
			case 'z': return 25;
			default: return 0;
		}
	}
	

}
