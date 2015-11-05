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

public class GameRenderer {
	
	public static GameWorld myWorld;
	public static OrthographicCamera cam;
	private ShapeRenderer shapeRenderer;
	private SpriteBatch batcher;
	private BitmapFont font;
	
	private Sprite bg;
	
	private static int gameHeight;
	private static int gameWidth;
	
	public static Viewport viewport;
	
	public GameRenderer(GameWorld world, int gameHeight, int gameWidth, int midPointY) {
		
		myWorld = world;
		this.gameHeight = gameHeight;
		this.gameWidth = gameWidth;
		
		batcher = new SpriteBatch();
		bg = new Sprite(AssetLoader.bg);	
		
		cam = new OrthographicCamera();
		cam.setToOrtho(true, gameWidth, gameHeight);

		//the following parameters are set as the same size as the desktop
		//viewport = new FillViewport(672, 672, cam);
		viewport = new FillViewport(640, 480, cam);
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
        	batcher.draw(bg, 0, 0, 640, 480);
        //}
        
        	
        batcher.enableBlending();
        
        //draw the text
        font = new BitmapFont(true);
        font.setColor(Color.RED);
        if (GameWorld.startScreen) {
        	font.draw(batcher, "Cool start screen here", 300, 220);
        } else if (GameWorld.levScreen) {
        	font.draw(batcher, "Click to start level", 300, 220);
        } else if (GameWorld.playScreen) {
        	font.draw(batcher, GameWorld.thePlayer.getName(), 20, 460);
        	font.draw(batcher, "Life: " + GameWorld.thePlayer.getLife(), 580, 460);
        	font.draw(batcher, "Word: " + GameWorld.word, 200, 460);
        	for (int x = 0; x < GameWorld.gameLetters.length; x++) {
        		String letter = Character.toString(GameWorld.gameLetters[x].value());
        		font.draw(batcher, letter, GameWorld.gameLetters[x].getX(), GameWorld.gameLetters[x].getY());
        	}
        } else if (GameWorld.endScreen) {
        	font.draw(batcher, "You died, Sucka.", 300, 220);
        }
        // End SpriteBatch
        batcher.end();	
        
        //draw the buttons
        //shapeRenderer.begin(ShapeType.Filled);
        //if (GameWorld.startScreen) {
		//	shapeRenderer.setColor(200 / 255.0f, 80 / 255.0f, 200 / 255.0f, 1);
		//	shapeRenderer.rect(GameWorld.startButton.getX(), GameWorld.startButton.getY(), GameWorld.startButton.getWidth(),GameWorld.startButton.getHeight());
		//}
        //shapeRenderer.end();
        
        //draw text
        
	}

	public static int getGameHeight() {
		return gameHeight;
	}

	public static int getGameWidth() {
		return gameWidth;
	}
	
}
