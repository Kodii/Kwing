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
	
	private MenuBackground menuBG;
	private Menu menu;
	private Music intro;
	
	private boolean leftPressed;
	
	
	public MenuState(GameStateManager gsm){
		super(gsm);
	}

	@Override
	public void init() {
		menuBG = new MenuBackground();
		menu = new Menu(orthographicCamera);
		
		
		
		intro = Resources.Sounds.getIntro();
		intro.play();
		intro.setLooping(true);
	
	}

	@Override
	public void update(float dt) {
		handleInput();
		
		menuBG.update(dt);
		
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
		
		menuBG.render(spriteBatch);
		menu.render(spriteBatch);
		
		
	}

	@Override
	public void handleInput() {
		menu.setLeftPressed(Gdx.input.isButtonPressed(Input.Buttons.LEFT));
	}

	@Override
	public void dispose() {
		this.dispose();
		intro.dispose();
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	

}
