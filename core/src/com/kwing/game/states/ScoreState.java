package com.kwing.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.kwing.game.entities.Resources;
import com.kwing.game.entities.backgrounds.ScoreBackground;
import com.kwing.game.entities.score.ScoreBoard;
import com.kwing.game.handlers.GameStateManager;
import com.kwing.game.handlers.MyTextInputListener;
import com.kwing.game.main.Game;

public class ScoreState extends GameState {

	private ScoreBackground scoreBackground;
	private ScoreBoard scoreBoard;

	private MyTextInputListener listener;
	
	private FreeTypeFontGenerator generator;
	private FreeTypeFontParameter parameter;
	private BitmapFont font48;
	
	private int state;
	
	public ScoreState(GameStateManager gameStateManager, int state) {
		super(gameStateManager);
		this.state = state;
		init(this.state);
	}
	
	@Override
	public void init() {
		
	}

	public void init(int state) {
		scoreBackground = new ScoreBackground();
		generator = new FreeTypeFontGenerator(Gdx.files.internal("Bonus/kenvector_future.ttf"));
		parameter = new FreeTypeFontParameter();
		
		font48 = generateFont(48);
		
		Resources.Sounds.getScoreStateMusic().play();
		
		if(state == GameStateManager.PLAYSTATE){
			listener = new MyTextInputListener(gameStateManager.getPlayer());
			Gdx.input.getTextInput(listener, "Write your name", "", "NAME");
		}
		if(state == GameStateManager.MENUSTATE){
			scoreBoard = new ScoreBoard();
		}
		
		
	}
	
	private BitmapFont generateFont(int fontSize){
		BitmapFont font;
		parameter.size = fontSize;
		font = generator.generateFont(parameter);
		return font;
	}

	@Override
	public void update(float dt) {
		scoreBackground.update(dt);
		
		if(!Resources.Sounds.getScoreStateMusic().isPlaying())
			gameStateManager.setState(GameStateManager.MENUSTATE);
		
		if(state == GameStateManager.PLAYSTATE){
			if(listener.getName() != null){
				scoreBoard = new ScoreBoard();
			}
			
			if(!listener.isProcessing()){
				scoreBoard.update(dt);
				listener.setName(null); // reseting field to stop creating whole time scoreBoard object
			}
		}
		
		if(state == GameStateManager.MENUSTATE)
			scoreBoard.update(dt);
		
		
	}

	@Override
	public void render() {
		scoreBackground.render(spriteBatch);
		if(state == GameStateManager.PLAYSTATE && !listener.isProcessing()){
			scoreBoard.render(spriteBatch);
			renderScoreText(spriteBatch);
		}
		
		if(state == GameStateManager.MENUSTATE){
			scoreBoard.render(spriteBatch);
			renderScoreText(spriteBatch);
		}
		
	}
	
	private void renderScoreText(SpriteBatch spriteBatch){
		spriteBatch.begin();
		font48.draw(spriteBatch, "SCORES", 100, Game.V_HEIGHT - 100);
		spriteBatch.end();
	}
	
	@Override
	public void handleInput() {
		
	}

	@Override
	public void dispose() {
		generator.dispose();
	}
}
