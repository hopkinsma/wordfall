package com.prefect.gameworld;
// deez nuts
import com.badlogic.gdx.Gdx;

public class BackgroundObject {
	
	private float mySpeed;
	private float xPos, yPos;
	private float screenWidth = Gdx.graphics.getWidth();
	private float screenHeight = Gdx.graphics.getHeight();
	private float xLength = (Gdx.graphics.getWidth() * 0.16f)/2;
	private float yLength = (Gdx.graphics.getHeight() * 0.16f)/2;
	private int outTimer = 0;
	private boolean onScreen;
	
	public BackgroundObject(float xLength, float yLength) {
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
				//System.out.println("satellite timeout: " + outTimer);
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

