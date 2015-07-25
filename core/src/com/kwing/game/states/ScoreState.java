package com.kwing.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
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
	
	public ScoreState(GameStateManager gameStateManager) {
		super(gameStateManager);
	}

	@Override
	public void init() {
		scoreBackground = new ScoreBackground();
		
		listener = new MyTextInputListener(gameStateManager.getPlayer());
		Gdx.input.getTextInput(listener, "Write your name", "", "NAME");
		
		generator = new FreeTypeFontGenerator(Gdx.files.internal("Bonus/kenvector_future.ttf"));
		parameter = new FreeTypeFontParameter();
		
		font48 = generateFont(48);
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
		
		if(listener.getName() != null){
			scoreBoard = new ScoreBoard();
		}
		
		if(!listener.isProcessing()){
			scoreBoard.update(dt);
			listener.setName(null); // reseting field to stop creating whole time scoreBoard object
		}
		
	}

	@Override
	public void render() {
		scoreBackground.render(spriteBatch);
		
		if(!listener.isProcessing()){
			scoreBoard.render(spriteBatch);
			
			spriteBatch.begin();
			font48.draw(spriteBatch, "SCORES", 100, Game.V_HEIGHT - 100);
			spriteBatch.end();
		}
		
	}
	
	@Override
	public void handleInput() {
		
	}

	@Override
	public void dispose() {
		generator.dispose();
	}

}
