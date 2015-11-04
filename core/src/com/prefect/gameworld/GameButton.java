package com.prefect.gameworld;

public class GameButton {
	boolean highlighted = false;;
	int xPos, yPos;
	int height, width;
	
	public GameButton(int x, int y, int h, int w) {
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

	public boolean isLight() {
	    return highlighted;
	}
}

