package com.kwing.game.states;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kwing.game.handlers.GameStateManager;
import com.kwing.game.main.Game;

public abstract class GameState {

	protected GameStateManager gsm;
	protected Game game;
	
	protected SpriteBatch sb;
	protected OrthographicCamera cam;
	
	protected ArrayList<Texture> regenPillsTextures;
	protected ArrayList<Texture> projectilesTextures;
	
	protected GameState(GameStateManager gsm){
		this.gsm = gsm;
		game = gsm.getGame();
		sb = game.getSpriteBatch();
		cam = game.getCamera();
		regenPillsTextures = new ArrayList<Texture>();
		projectilesTextures = new ArrayList<Texture>();
		init();
	}
	
	public abstract void init();
	public abstract void handleInput();
	public abstract void update(float dt);
	public abstract void render();
	public abstract void dispose();
}
