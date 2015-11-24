package com.prefect.gameworld;

import com.badlogic.gdx.Gdx;

public class BackgroundObject {
	float mySpeed;
	float xPos, yPos;
	float screenWidth = Gdx.graphics.getWidth();
	float screenHeight = Gdx.graphics.getHeight();
	float xLength = (Gdx.graphics.getWidth() * 0.16f)/2;
	float yLength = (Gdx.graphics.getHeight() * 0.16f)/2;
	int outTimer = 0;
	boolean onScreen;
	
	public BackgroundObject(int xLength, int yLength) {
		this.xLength = xLength;
		this.yLength = yLength;
		xPos = 0 - xLength;
		yPos = (float)Math.random() * screenHeight;
		mySpeed = 1;
		onScreen = true;
	}
	
	public BackgroundObject(float x, float y, float speed) {
		xPos = x;
		yPos = y;
		mySpeed = speed;
		onScreen = true;
	}

	public float getX() {
		return xPos;
	}

	public float getY() {
		return yPos;
	}


	public void update(float delta) {
		if (onScreen) {
			//mySpeed = delta;
			mySpeed = 2;
			yPos -= mySpeed;
			xPos += mySpeed;
			if ((xPos > screenWidth) || (yPos < (0 - yLength))) {
				onScreen = false;
				outTimer = (int)(Math.random() * 100) + 100;
				System.out.println("satellite timeout: " + outTimer);
			}			
		} else { //reset
			outTimer -=1;
			if (outTimer < 1) {
				xPos = 0 - xLength;
				yPos = (float)Math.random() * screenHeight;
				mySpeed = 1;
				onScreen = true;
			}
		}
	}

	public void kill() {
		onScreen = false;
	}

	
	public boolean checkClick(int x, int y) {				
		if ((xPos - xLength) < x && x < (xPos + xLength)) {
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

			
}

