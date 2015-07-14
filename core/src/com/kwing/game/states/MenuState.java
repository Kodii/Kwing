package com.kwing.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.kwing.game.entities.menu.Menu;
import com.kwing.game.entities.menu.MenuBackground;
import com.kwing.game.handlers.GameStateManager;

public class MenuState extends GameState {
	
	private MenuBackground menuBG;
	private Menu menu;
	
	
	private boolean leftPressed;
	
	public MenuState(GameStateManager gsm){
		super(gsm);
	}

	@Override
	public void init() {
		menuBG = new MenuBackground();
		menu = new Menu(cam);
	}

	@Override
	public void update(float dt) {
		handleInput();
		
		menuBG.update(dt);
		
		menu.update(dt);
		
		if(menu.getState()){
			gsm.addState(GameStateManager.CHOSESTATE);
			gsm.setState(GameStateManager.CHOSESTATE);
			menu.setState(false);
		}
	}

	@Override
	public void render() {
		
		menuBG.render(sb);
		menu.render(sb);
		
	}

	@Override
	public void handleInput() {
		menu.setLeftPressed(Gdx.input.isButtonPressed(Input.Buttons.LEFT));
	}

	@Override
	public void dispose() {
		this.dispose();
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	

}
