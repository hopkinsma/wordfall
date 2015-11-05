package com.prefect.gameworld;

public class FallingLetter {
	boolean isSelected, isFalling;
	float mySpeed;
	int xPos, yPos;
	int ceiling = 40;
	int floor = 400;
	int sideLength = 30;
	char myLetter;
	
	public FallingLetter(char letter, int x, int speed) {
	isFalling = true;
	myLetter = letter;
	xPos = x;
	yPos = ceiling;
	mySpeed = speed;
	}

	public FallingLetter(char letter, int x, int y, float speed) {
	myLetter = letter;
	xPos = x;
	yPos = y;
	mySpeed = speed;
	}

	public int getX() {
		return xPos;
	}

	public int getY() {
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
		if ((x > xPos) && (x < (xPos + sideLength))) {
			if ((y > yPos) && (y < (yPos + sideLength))) {					    return true;
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
			default: return -1;
		}
	}		
		
}
