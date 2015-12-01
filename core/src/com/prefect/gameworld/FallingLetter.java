package com.prefect.gameworld;

import com.badlogic.gdx.Gdx;

public class FallingLetter {
	
	private boolean isSelected, isFalling;
	private float mySpeed;
	private float xPos, yPos;
	private float ceiling = Gdx.graphics.getWidth() * .06f;
	private float floor = Gdx.graphics.getHeight();
	private float xLength;
	private float yLength = (Gdx.graphics.getHeight() * 0.16f)/2;
	private char myLetter;
	
	public FallingLetter(char letter, float x, int speed, float xLength) {
		isFalling = true;
		myLetter = letter;
		xPos = x;
		yPos = ceiling;
		mySpeed = speed;
		isSelected = false;
		this.xLength = xLength;
	}

	public FallingLetter(char letter, float x, float y, float speed) {
		myLetter = letter;
		xPos = x;
		yPos = y;
		mySpeed = speed;
	}

	public float getX() {
		return xPos;
	}

	public float getY() {
		return yPos;
	}

	public char value() {
		return myLetter;
	}

	public void update(float delta) {
		if (!hitFloor()) {
			mySpeed = delta;
			yPos += mySpeed;
		}
	}

	public void kill() {
		isFalling = false;
		isSelected = false;
	}

	public boolean fallStatus() {
		return isFalling;
	}

	public boolean hitFloor() {
		if (yPos >= floor)
			return true;
		else 
			return false;
	}

	public void deselect() {
	    isSelected = false;
	}

	public void select() {
		isSelected = true;
	}
	
	public boolean checkSelected() {
		return isSelected;
	}
	
	public boolean checkClick(int x, int y) {
		
		if ((xPos) < x && x < (xPos + xLength)) {
			if ((yPos - yLength) < y && y < (yPos + yLength)) {					    
				return true;
			}
			else {
			    return false;
			}
		}
		else {
			return false;
		}
	}

	public int getIntValue() {
		switch (myLetter) {
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
