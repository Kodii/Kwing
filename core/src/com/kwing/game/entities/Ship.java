package com.kwing.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.kwing.game.main.Game;

public class Ship extends SpaceObject{
	
	//need this variable for send an object ship with choosen ship number to PlayState.
	
	private boolean state;
	private Vector3 touchPos;
	
	private OrthographicCamera cam;
	
	public Ship(String s, int width, int height, int x, int y, OrthographicCamera cam){
		super(s, width, height, x, y);
		initObject();
		this.cam = cam;
		state = false;
		touchPos = new Vector3();
		
	}
	
	public void update(float dt){
		if (Gdx.input.isTouched()) {

			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			cam.unproject(touchPos);
			
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



}
