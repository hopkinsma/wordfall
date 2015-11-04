package com.prefect.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.prefect.gameworld.GameRenderer;
import com.prefect.gameworld.GameWorld;
import com.prefect.wordhelpers.InputHandler;

public class GameScreen implements Screen{
	
	private GameWorld world;
	private GameRenderer renderer;
	private float runTime;
	
	public GameScreen() {
		
		float screenWidth = Gdx.graphics.getWidth();
		float screenHeight = Gdx.graphics.getHeight();
		//float gameWidth = 136;
		float gameWidth = screenWidth;
		//float gameHeight = screenHeight / (screenWidth / gameWidth);		
		float gameHeight = screenHeight;
		int midPointY = (int) (gameHeight / 2);

		world = new GameWorld(midPointY);
		renderer = new GameRenderer(world, (int) gameHeight, (int) gameWidth, midPointY);
		
		Gdx.input.setInputProcessor(new InputHandler());
		
	}
	
	@Override
	public void render(float delta) {
		runTime += delta;
		world.update(delta);
		renderer.render(runTime);
	}
	
	//controls the resizing of the different environments
    @Override
    public void resize(int width, int height) {
    	System.out.println("width: " + width);
    	System.out.println("height: " + height);
        GameRenderer.viewport.update(width, height);
        System.out.println("check");
    	System.out.println("GameRenderer.cam.viewportWidth: " + GameRenderer.cam.viewportWidth);
    	System.out.println("GameRenderer.cam.viewportHeight: " + GameRenderer.cam.viewportHeight);
        GameRenderer.cam.position.set(GameRenderer.cam.viewportWidth / 2, GameRenderer.cam.viewportHeight / 2, 0);
    }

    @Override
    public void show() {
        Gdx.app.log("GameScreen", "show called");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen", "hide called");     
    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "pause called");        
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "resume called");       
    }

    @Override
    public void dispose() {
        // Leave blank
    }
	

}
