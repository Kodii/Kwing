package com.kwing.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.kwing.game.main.Game;
import com.kwing.game.states.ChoseState;

public class Ship extends SpaceObject{
	
	public static final int SHIP_WIDTH = 99;
	public static final int SHIP_HEIGHT = 75;
	//need this variable for send an object ship with choosen ship number to PlayState.
	private boolean state;
	private Vector3 touchPos;
	private OrthographicCamera orthographicCamera;
	
	public Ship(Texture texture, float x, float y){
		this.texture = texture;
		rectangle = new Rectangle();
		touchPos = new Vector3();
		
		state = false;
		
		createShip(x, y);
		
	}
	private void createShip(float x, float y){
		rectangle.width = SHIP_WIDTH;
		rectangle.height = SHIP_HEIGHT;
		rectangle.x = x;
		rectangle.y = y;
	}
	
	public void update(float dt){
		if (Gdx.input.isTouched()) {

			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			orthographicCamera.unproject(touchPos);
			
			if (touchPos.x > rectangle.x
					&& touchPos.x < (rectangle.x + rectangle.width)
					&& touchPos.y > rectangle.y
					&& touchPos.y < (rectangle.y + rectangle.height)) {
				state = true;
			}
		}
	}
	
	public void render(SpriteBatch sb){
		sb.begin();
		sb.draw(texture, rectangle.x, rectangle.y, rectangle.width, rectangle.height);
		sb.end();
	}
	
	public boolean getState(){
		return state;
	}
	
	public void setState(boolean b){
		state = b;
	}
	public OrthographicCamera getOrthographicCamera() {
		return orthographicCamera;
	}
	public void setOrthographicCamera(OrthographicCamera orthographicCamera) {
		this.orthographicCamera = orthographicCamera;
	}



}
