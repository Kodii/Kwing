package com.kwing.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.kwing.game.entities.Resources;
import com.kwing.game.entities.menu.Menu;
import com.kwing.game.entities.menu.MenuBackground;
import com.kwing.game.handlers.GameStateManager;

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
		menu = new Menu(cam);
		
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
			gsm.addState(GameStateManager.CHOSESTATE);
			gsm.setState(GameStateManager.CHOSESTATE);
			menu.setState(false);
			
			intro.stop();
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
		intro.dispose();
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	

}
