package com.kwing.game.entities.spaceObject.ships;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.kwing.game.entities.spaceObject.SpaceObject;

public class Ship extends SpaceObject{
	
	public static final int SHIP_WIDTH = 99;
	public static final int SHIP_HEIGHT = 75;
	private boolean bound;
	private Vector3 touchedPosition;
	private OrthographicCamera orthographicCamera;
	
	public Ship(Texture texture, float x, float y){
		this.setTexture(texture);
		rectangle = new Rectangle();
		touchedPosition = new Vector3();
		
		bound = false;
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

			touchedPosition.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			orthographicCamera.unproject(touchedPosition);
			
			checkShipBounds();
		}
	}
	
	private void checkShipBounds(){
		if (touchedPosition.x > rectangle.x
				&& touchedPosition.x < (rectangle.x + rectangle.width)
				&& touchedPosition.y > rectangle.y
				&& touchedPosition.y < (rectangle.y + rectangle.height)) {
			setBound(true);
		}
		else
			setBound(false);
	}
	
	public void render(SpriteBatch sb){
		sb.begin();
		sb.draw(getTexture(), rectangle.x, rectangle.y, rectangle.width, rectangle.height);
		sb.end();
	}
	
	public OrthographicCamera getOrthographicCamera() {
		return orthographicCamera;
	}
	public void setOrthographicCamera(OrthographicCamera orthographicCamera) {
		this.orthographicCamera = orthographicCamera;
	}

	public boolean isBound() {
		return bound;
	}

	public void setBound(boolean bound) {
		this.bound = bound;
	}



}
