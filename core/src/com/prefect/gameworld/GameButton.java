package com.prefect.gameworld;

public class GameButton {
	
	boolean highlighted = false;;
	float xPos, yPos;
	float height, width;
	
	public GameButton(float x, float y, float h, float w) {
	    xPos = x;
	    yPos = y;
	    height = h;
	    width = w;
	}

	public boolean containsPoint(int x, int y) {
		System.out.println("x: " + x + ", xPos: " + xPos + ", (xPos+width): " + (xPos + width) + ", width: " + width);
	    if ((xPos < x) && (x < (xPos + width))) {
			System.out.println("y: " + y + ", yPos: " + yPos + ", (yPos+height): " + (yPos + height) + ", height: " + height);
			if ((yPos < y) && (y < (yPos + height))) {
				highlighted = true;
				return true;
			}
			else {
				highlighted = false;
				return false;
			}
	    } else {
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

