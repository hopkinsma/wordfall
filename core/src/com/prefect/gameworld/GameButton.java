package com.prefect.gameworld;

public class GameButton {
	
	private boolean highlighted = false;;
	private float xPos, yPos;
	private float height, width;
	
	public GameButton(float x, float y, float h, float w) {
	    xPos = x;
	    yPos = y;
	    height = h;
	    width = w;
	}

	public boolean containsPoint(int x, int y) {
	    if ((x > xPos) && (x < (xPos + width))) {
	    	if ((y > yPos) && (y < (yPos + height))) {
	    		highlighted = true;
	    		return true;
	    	} 
	    	else {
	    		highlighted = false;
	    		return false;
	    	}
	    }
	    else {
	    	highlighted = false;
	    	return false;
	    }
	}
	
	public float getX() {
		return xPos;
	}
	
	public float getY() {
		return yPos;
	}

	public float getHeight() {
		return height;
	}
	
	public float getWidth() {
		return width;
	}
	
	public boolean isLight() {
	    return highlighted;
	}
}

