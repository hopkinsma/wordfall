package com.prefect.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.prefect.gameworld.GameWorld;
import com.prefect.wordhelpers.AssetLoader;
import com.prefect.wordhelpers.Helpers;

public class GameRenderer {
	
	public static GameWorld myWorld;
	public static OrthographicCamera cam;
	private ShapeRenderer shapeRenderer;
	private SpriteBatch batcher;
	private BitmapFont font;
	
	private Sprite startBut, levBut, entBut, clearBut, endBut, satellite;
	private Sprite bg;
	private Sprite letters[];
	private Sprite lettersSelected[];
	private Sprite smLetters[];
	private Sprite dispLetters[];
	
	private static int gameHeight;
	private static int gameWidth;
	
	private static Helpers helpMe = new Helpers();
	
	public static Viewport viewport;
	
	public GameRenderer(GameWorld world, int gameHeight, int gameWidth, int midPointY) {
		
		myWorld = world;
		this.gameHeight = gameHeight;
		this.gameWidth = gameWidth;
		
		batcher = new SpriteBatch();
		
		bg = new Sprite(AssetLoader.bg);
		helpMe = new Helpers();
		
		
		
		
		letters = new Sprite[26];
		for (int i = 0; i < 26; i++) {
			letters[i] = new Sprite(AssetLoader.wordBubbles[i][0]);
			double seventyFivePixelsX = helpMe.xPixelAdjuster(30);
			float seventyFivePixelsY = helpMe.yPixelAdjuster(30);
			//System.out.println("x size: " + seventyFivePixelsX + "/y size: " + seventyFivePixelsY);
			letters[i].setSize((float) seventyFivePixelsX, seventyFivePixelsY);
			letters[i].setScale((float) Gdx.graphics.getWidth(), (float) Gdx.graphics.getHeight());
			//System.out.println("Letter height: " + letters[i].getHeight());
		}
		
		lettersSelected = new Sprite[26];
		for (int i = 0; i < 26; i++) {
			lettersSelected[i] = new Sprite(AssetLoader.wordBubbles[i][1]);
			double seventyFivePixelsX = helpMe.xPixelAdjuster(75);
			float seventyFivePixelsY = helpMe.yPixelAdjuster(75);
			//System.out.println("x size: " + seventyFivePixelsX + "/y size: " + seventyFivePixelsY);
			lettersSelected[i].setSize((float)seventyFivePixelsX,  seventyFivePixelsY);			
		}
		
		smLetters = new Sprite[26];
		for (int i = 0; i < 26; i++) {
			smLetters[i] = new Sprite(AssetLoader.smLetters[i]);
			smLetters[i].setSize(helpMe.xPixelAdjuster(50), helpMe.yPixelAdjuster(50));
		}
		
		
		startBut = new Sprite(AssetLoader.startButton);		
		levBut = new Sprite(AssetLoader.levButton);
		entBut = new Sprite(AssetLoader.enterButton);
		clearBut = new Sprite(AssetLoader.clearButton);
		endBut = new Sprite(AssetLoader.gameOverButton);
		satellite = new Sprite(AssetLoader.satellite);
		
		
		cam = new OrthographicCamera();
		cam.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		viewport = new FillViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), cam);
		viewport.apply();
		cam.position.set(cam.viewportWidth/2, cam.viewportHeight/2, 0);
		
		//attach batcher to camera
		batcher.setProjectionMatrix(cam.combined);
		
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);
		
	}
	
	public void render(float runTime) {
		
		
		cam.update();
		//System.out.println("runTime: " + runTime);
		// we will move the outside of the loop for performance later.
		//Character character = myWorld.getCharacter();
		
		// fill the entire screen with black, to prevent potential flickering
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// being shapeRenderer
		shapeRenderer.begin(ShapeType.Filled);
		
		// draw background color
		shapeRenderer.setColor(80 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
		shapeRenderer.rect(0, 0, gameWidth,gameHeight);
		

        // End ShapeRenderer
        shapeRenderer.end();
		
        // Begin SpriteBatch
        batcher.setProjectionMatrix(cam.combined);
        batcher.begin();
        // Disable transparency
        // This is good for performance when drawing images that do not require
        // transparency.
        batcher.disableBlending();
        
        //if (GameWorld.startScreen) {
        	//batcher.draw(bg, 0, 0, 640, 480);
        	//all of the following ratios are determined by these screen settings
        //batcher.draw(bg, 0, 0);//, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        //batcher.draw(bg, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        //bg.setPosition(0, 0);
        bg.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        bg.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        bg.draw(batcher);
        //}
        
        	
        batcher.enableBlending();
        
        
        //draw the text
        font = new BitmapFont(true);
        font.setColor(Color.WHITE);
        //satellite.setBounds(GameWorld.satellite.getX(), GameWorld.satellite.getY(), GameWorld.satellite.getX() + (int)(Math.random() * 100), GameWorld.satellite.getY() + (int)(Math.random() * 100));
        //satellite.draw(batcher);
        batcher.draw(satellite, GameWorld.satellite.getX(), GameWorld.satellite.getY());
        
        if (GameWorld.startScreen) {
        	
        	batcher.draw(startBut, helpMe.xPixelAdjuster(290), helpMe.yPixelAdjuster(880), helpMe.xPixelAdjuster(500), helpMe.yPixelAdjuster(160));
        	
        } else if (GameWorld.levScreen) {
        	
        	batcher.draw(levBut, helpMe.xPixelAdjuster(290), helpMe.yPixelAdjuster(880), helpMe.xPixelAdjuster(500), helpMe.yPixelAdjuster(160));
        	
        } else if (GameWorld.playScreen) {
        	
        	font.draw(batcher, GameWorld.thePlayer.getName(), Gdx.graphics.getWidth() * 0.03f, Gdx.graphics.getHeight() * 0.04f);
        	font.draw(batcher, "Life: " + GameWorld.thePlayer.getLife(), Gdx.graphics.getWidth() * 0.85f, Gdx.graphics.getHeight() * 0.04f);        	
        	font.draw(batcher, "Score: " + GameWorld.thePlayer.getScore(), Gdx.graphics.getWidth() * 0.47f, Gdx.graphics.getHeight() * 0.04f);
        	
        	for (int x = 0; x < GameWorld.gameLetters.length; x++) {
        		
        		if (GameWorld.gameLetters[x].fallStatus()) {
        			
        			if (!GameWorld.gameLetters[x].checkSelected()) {
        				batcher.draw(letters[GameWorld.gameLetters[x].getIntValue()], GameWorld.gameLetters[x].getX(), GameWorld.gameLetters[x].getY(), helpMe.xPixelAdjuster(142), helpMe.yPixelAdjuster(142));
        			} else {
        				batcher.draw(lettersSelected[GameWorld.gameLetters[x].getIntValue()], GameWorld.gameLetters[x].getX(), GameWorld.gameLetters[x].getY(), helpMe.xPixelAdjuster(142), helpMe.yPixelAdjuster(142));
        			}	
        		}
        	}
        	
        	dispLetters = new Sprite[GameWorld.word.length()];
        	
        	for (int x = 0; x < GameWorld.word.length(); x++) {
        		
        		dispLetters[x] = smLetters[helpMe.getCharInt(GameWorld.word.charAt(x))];
        		dispLetters[x].setSize(helpMe.xPixelAdjuster(50), helpMe.yPixelAdjuster(50));
        		float yPos = Gdx.graphics.getHeight() - (helpMe.xPixelAdjuster(50 + 10));
        		float xPos = (Gdx.graphics.getWidth() / 2) - ((GameWorld.word.length() * helpMe.xPixelAdjuster(50))/2) + (x*helpMe.xPixelAdjuster(50));
        		batcher.draw(dispLetters[x], xPos, yPos);		
        	}
        	
        	batcher.draw(clearBut, GameWorld.clearButton.getX(), GameWorld.clearButton.getY(), helpMe.xPixelAdjuster(GameWorld.clearButton.getWidth()), helpMe.yPixelAdjuster(GameWorld.clearButton.getHeight()));
        	batcher.draw(entBut, GameWorld.enterButton.getX(), GameWorld.enterButton.getY(), helpMe.xPixelAdjuster(GameWorld.enterButton.getWidth()), helpMe.yPixelAdjuster(GameWorld.enterButton.getHeight()));
        	
        } else if (GameWorld.endScreen) {
        	batcher.draw(endBut, (Gdx.graphics.getWidth()/2) - (250/2), (Gdx.graphics.getHeight()/2) - (80/80));
        }
        
        // End SpriteBatch
        batcher.end();	
        
        
	}

	public static int getGameHeight() {
		return gameHeight;
	}

	public static int getGameWidth() {
		return gameWidth;
	}
	
	public void dispose() {
		System.out.println("Disposing from GameRenderer");
		shapeRenderer.dispose();
		batcher.dispose();
		font.dispose();
	}
}
