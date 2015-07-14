package com.kwing.game.handlers;

import java.util.ArrayList;

import com.kwing.game.entities.Ship;
import com.kwing.game.main.Game;
import com.kwing.game.states.ChoseState;
import com.kwing.game.states.GameState;
import com.kwing.game.states.MenuState;
import com.kwing.game.states.PlayState;

public class GameStateManager {
	
	public static final int MENUSTATE = 0;
	public static final int CHOSESTATE = 1;
	public static final int PLAYSTATE = 2;
	
	// current game state
	private ArrayList<GameState> gameStates;
	private int currentState;
	private Game game;
	
	private Ship ship;

	public GameStateManager(Game game) {
		this.game = game;
		gameStates = new ArrayList<GameState>();
		currentState = MENUSTATE;
		gameStates.add(MENUSTATE, new MenuState(this));
	}

	public void setState(int state) {
		currentState = state;
		gameStates.get(currentState).init();
	}
	
	public void addState(int state){
		if(state == MENUSTATE){
			gameStates.add(MENUSTATE, new MenuState(this));
		}
		if(state == CHOSESTATE){
			gameStates.add(CHOSESTATE,  new ChoseState(this));
		}
		
	}
	
	public void addState(int state, Ship ship){
		if(state == PLAYSTATE){
			this.ship = ship;
			gameStates.add(PLAYSTATE, new PlayState(this, ship));
		}
	}
	

	public void update(float dt) {
		gameStates.get(currentState).update(dt);
	}

	public void render() {
		gameStates.get(currentState).render();
	}

	public Game getGame() {
		return game;
	}

	public ArrayList<GameState> getGameStates() {
		return gameStates;
	}

}
