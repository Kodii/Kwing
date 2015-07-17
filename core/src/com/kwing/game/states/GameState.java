package com.kwing.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kwing.game.handlers.GameStateManager;
import com.kwing.game.main.Game;

public abstract class GameState {

	protected GameStateManager gameStateManager;
	protected Game game;
	protected SpriteBatch spriteBatch;
	protected OrthographicCamera orthographicCamera;
	
	protected GameState(GameStateManager gameStateManager){
		this.gameStateManager = gameStateManager;
		game = gameStateManager.getGame();
		spriteBatch = game.getSpriteBatch();
		orthographicCamera = game.getCamera();
		init();
	}
	
	
	public abstract void init();
	public abstract void handleInput();
	public abstract void update(float dt);
	public abstract void render();
	public abstract void dispose();


}
