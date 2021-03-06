package com.kwing.game.handlers;

import java.util.ArrayList;

import com.kwing.game.entities.spaceObject.player.Player;
import com.kwing.game.entities.spaceObject.ships.Ship;
import com.kwing.game.main.Game;
import com.kwing.game.states.BlankState;
import com.kwing.game.states.ChoseState;
import com.kwing.game.states.GameState;
import com.kwing.game.states.MenuState;
import com.kwing.game.states.PlayState;
import com.kwing.game.states.ScoreState;

public class GameStateManager {
	
	public static final int MENUSTATE = 0;
	public static final int CHOSESTATE = 1;
	public static final int PLAYSTATE = 2;
	public static final int SCORESTATE = 3;
	
	// current game state
	private ArrayList<GameState> gameStates;
	private int currentState;
	private Game game;
	private Ship ship;
	private Player player;

	public GameStateManager(Game game) {
		this.game = game;
		gameStates = new ArrayList<GameState>();
		
		for(int i = 0; i < 4; i++){
			gameStates.add(new BlankState(this));
		}
		
		currentState = MENUSTATE;
		gameStates.add(MENUSTATE, new MenuState(this));
		setState(MENUSTATE);
	}

	public void setState(int state) {
		currentState = state;
		gameStates.get(currentState).init();
	}
	
	public void addState(int state){
		if(state == MENUSTATE){
			gameStates.set(MENUSTATE, new MenuState(this));
		}
		if(state == CHOSESTATE){
			gameStates.set(CHOSESTATE,  new ChoseState(this));
		}
		if(state == SCORESTATE){
			gameStates.set(SCORESTATE,  new ScoreState(this, MENUSTATE));
		}
		
	}
	
	public void addState(int state, Ship ship){
		if(state == PLAYSTATE){
			this.ship = ship;
			gameStates.set(PLAYSTATE, new PlayState(this));
		}
	}
	
	public void addState(int state, Player player){
		if(state == SCORESTATE){
			this.player= player;
			gameStates.set(SCORESTATE, new ScoreState(this, PLAYSTATE));
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

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
