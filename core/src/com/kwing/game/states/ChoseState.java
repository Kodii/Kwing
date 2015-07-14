package com.kwing.game.states;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.kwing.game.entities.Ship;
import com.kwing.game.entities.menu.MenuBackground;
import com.kwing.game.handlers.GameStateManager;
import com.kwing.game.main.Game;

public class ChoseState extends GameState {
	
	private MenuBackground menuBG;
	private Ship ship;
	private ArrayList<Ship> ships;
	
	private BitmapFont font12;

	
	public ChoseState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		menuBG = new MenuBackground();
		
		ships = new ArrayList<Ship>();
		ships.add(new Ship("PNG/playerShip1_blue.png", 99, 75, 150, (Game.V_HEIGHT / 2 - 30) - 75 / 2, cam));
		ships.add(new Ship("PNG/playerShip2_blue.png", 99, 75, Game.V_WIDTH / 2 - 99 / 2, (Game.V_HEIGHT / 2 - 30) - 75 / 2, cam));
		ships.add(new Ship("PNG/playerShip3_blue.png", 99, 75, Game.V_WIDTH - 150 - 99, (Game.V_HEIGHT / 2 - 30) - 75 / 2, cam));
		
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Bonus/kenvector_future.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 48;
		font12 = generator.generateFont(parameter); // font size 12 pixels
		generator.dispose(); // don't forget to dispose to avoid memory leaks!

	}


	@Override
	public void update(float dt) {
		menuBG.update(dt);
		for(int i = 0; i < ships.size(); i++){
			ships.get(i).update(dt);
		}
		for(int i = 0; i < ships.size(); i++){
			if(ships.get(i).getState()){
				ships.get(i).setState(false);
				gsm.addState(GameStateManager.PLAYSTATE, ships.get(i));
				gsm.setState(GameStateManager.PLAYSTATE);
			}
		}
	}

	@Override
	public void render() {
		menuBG.render(sb);
		for(int i = 0; i < ships.size(); i++){
			ships.get(i).render(sb);
		}
		sb.begin();
		font12.draw(sb, "SELECT SHIP", 200, Game.V_HEIGHT / 2 + Game.V_WIDTH / 4);
		sb.end();
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}


}
