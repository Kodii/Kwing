package com.kwing.game.states;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.kwing.game.entities.Resources;
import com.kwing.game.entities.Resources.Textures;
import com.kwing.game.entities.Ship;
import com.kwing.game.entities.menu.MenuBackground;
import com.kwing.game.handlers.GameStateManager;
import com.kwing.game.main.Game;

public class ChoseState extends GameState {
	
	private MenuBackground menuBG;
	private Ship playerShipBlue1, playerShipBlue2, playerShipBlue3;
	private ArrayList<Ship> ships;
	
	private BitmapFont font48;
	private Music startGameMusic;
	
	private int verticalSpace;
	private int horizontalSpace;
	private int spaceBeetwenShips;

	public ChoseState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		menuBG = new MenuBackground();
		ships = new ArrayList<Ship>();
		
		verticalSpace = (Game.V_HEIGHT / 2 - 30) - Ship.SHIP_HEIGHT;
		horizontalSpace = 150;
		spaceBeetwenShips = 200;
		
		playerShipBlue1 = createShip(Resources.Textures.getPlayerShipBlue1(), horizontalSpace, verticalSpace);
		playerShipBlue2 = createShip(Resources.Textures.getPlayerShipBlue2(), playerShipBlue1.getRectangle().x + spaceBeetwenShips, verticalSpace);
		playerShipBlue3 = createShip(Resources.Textures.getPlayerShipBlue3(), playerShipBlue2.getRectangle().x + spaceBeetwenShips, verticalSpace);
		
		startGameMusic = Resources.Sounds.getLevel();
		startGameMusic.play();
		startGameMusic.setLooping(true);
		
		generateFont();

	}
	
	private Ship createShip(Texture shipTexture, float x, float y){
		Ship ship = new Ship(shipTexture, x, y);
		ship.setOrthographicCamera(orthographicCamera);
		appendShip(ship);
		return ship;
	}
	private void appendShip(Ship ship){
		ships.add(ship);
	}
	
	private void generateFont(){
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Bonus/kenvector_future.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 48;
		font48 = generator.generateFont(parameter); // font size 12 pixels
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
				gameStateManager.addState(GameStateManager.PLAYSTATE, ships.get(i));
				gameStateManager.setState(GameStateManager.PLAYSTATE);
			}
		}
	}

	@Override
	public void render() {
		menuBG.render(spriteBatch);
		for(int i = 0; i < ships.size(); i++){
			ships.get(i).render(spriteBatch);
		}
		spriteBatch.begin();
		font48.draw(spriteBatch, "SELECT SHIP", 200, Game.V_HEIGHT / 2 + Game.V_WIDTH / 4);
		spriteBatch.end();
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
