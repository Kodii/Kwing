package com.kwing.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.kwing.game.entities.Resources;
import com.kwing.game.entities.backgrounds.MenuBackground;
import com.kwing.game.entities.menu.Menu;
import com.kwing.game.handlers.GameStateManager;
import com.kwing.game.main.Game;

public class MenuState extends GameState {
	
	private MenuBackground menuBackground;
	private Menu menu;
	private Music intro;
	
	public MenuState(GameStateManager gameStateManager){
		super(gameStateManager);
	}

	@Override
	public void init() {
		menuBackground = new MenuBackground();
		menu = new Menu(orthographicCamera);
		
		intro = Resources.Sounds.getIntro();
		intro.play();
		intro.setLooping(true);
	
	}

	@Override
	public void update(float dt) {
		handleInput();
		
		menuBackground.update(dt);
		
		menu.update(dt);
		
		if(menu.getState()){
			gameStateManager.addState(GameStateManager.CHOSESTATE);
			gameStateManager.setState(GameStateManager.CHOSESTATE);
			menu.setState(false);
			
			intro.stop();
		}
	}

	@Override
	public void render() {
		
		menuBackground.render(spriteBatch);
		
		menu.render(spriteBatch);
		
		
	}

	@Override
	public void handleInput() {
	}

	@Override
	public void dispose() {
//		this.dispose();
		intro.dispose();
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	

}
