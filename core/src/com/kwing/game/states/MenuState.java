package com.kwing.game.states;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.kwing.game.entities.Resources;
import com.kwing.game.entities.backgrounds.MenuBackground;
import com.kwing.game.entities.menu.Menu;
import com.kwing.game.handlers.GameStateManager;

public class MenuState extends GameState {
	
	private MenuBackground menuBackground;
	private Menu menu;
	private Music intro;
	
	public MenuState(GameStateManager gameStateManager){
		super(gameStateManager);
	}

	@Override
	public void init() {
		menu = new Menu(orthographicCamera);
		menuBackground = new MenuBackground();
		
		intro = Resources.Sounds.getIntro();
		intro.play();
		intro.setLooping(true);
		
	}

	@Override
	public void update(float dt) {
		handleInput();
		
		menuBackground.update(dt);
		
		menu.update(dt);
		
		if(menu.getState() == GameStateManager.CHOSESTATE){
			gameStateManager.addState(GameStateManager.CHOSESTATE);
			gameStateManager.setState(GameStateManager.CHOSESTATE);
			intro.stop();
		}
		
		if(menu.getState() == GameStateManager.SCORESTATE){
			gameStateManager.addState(GameStateManager.SCORESTATE);
			gameStateManager.setState(GameStateManager.SCORESTATE);
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
		intro.dispose();
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	

}
