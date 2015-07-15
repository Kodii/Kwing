package com.kwing.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.kwing.game.main.Game;

public class Player extends SpaceObject {
	
	public static final int MOVEMENTSPEED = 250;
	public static final int HEALTH = 100;
	public static final int LIVES = 3;
	public static final int SCORE = 0;
	public static final int POWER = 22;
	
	private OrthographicCamera cam;
	private Vector3 touchPos;

	private Ship ship;
	
	private Texture texture;
	private Rectangle rectangle;
	
	private float centerX, centerY;
	private int score;
	private boolean leftPressed;
	private boolean pickedUp;

	public Player(OrthographicCamera cam, Ship ship) {
		this.cam = cam;
		this.ship = ship;
		score = SCORE;
		lives = LIVES;
		health = HEALTH;
		power = POWER;
		ship.rectangle.x = Game.V_WIDTH / 2 - ship.width / 2;
		ship.rectangle.y = 200;
		ship.movementSpeed = MOVEMENTSPEED;
		this.rectangle = ship.getRectangle();
		touchPos = new Vector3();
		pickedUp = false;
		
	}

	public void update(float dt) {
		
		if(pickedUp){
			Resources.Sounds.getPickUp().play();
			pickedUp = false;
		}
		if (Gdx.input.isTouched()) {
			
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0); 
			cam.unproject(touchPos);

			if(touchPos.x < ship.rectangle.x + ship.width / 2){
				ship.rectangle.x -= ship.movementSpeed * dt;
			}
			if(touchPos.x > ship.rectangle.x + ship.width / 2){
				ship.rectangle.x += ship.movementSpeed * dt;
			}
			if(touchPos.y < ship.rectangle.y + ship.height / 2)
				ship.rectangle.y -= ship.movementSpeed * dt;
			if(touchPos.y > ship.rectangle.y + ship.height / 2)
				ship.rectangle.y += ship.movementSpeed * dt;
			
		}
		
		// setting screen bounds
		if(ship.rectangle.x < 0) 
			ship.rectangle.x = 0;
	    if(ship.rectangle.x > Game.V_WIDTH - ship.rectangle.width) 
	    	ship.rectangle.x = Game.V_WIDTH - ship.rectangle.width;
	    if(ship.rectangle.y < 0) 
	    	ship.rectangle.y = 0;
	    if(ship.rectangle.y > Game.V_HEIGHT - ship.rectangle.height) 
	    	ship.rectangle.y = Game.V_HEIGHT - ship.rectangle.height;
	}
	

	public void render(SpriteBatch sb) {

		sb.begin();
		sb.draw(ship.texture, ship.rectangle.x, ship.rectangle.y, ship.rectangle.width, ship.rectangle.height);
		sb.end();

	}
	
	public void setLeftPressed(boolean b) {
		leftPressed = b;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public Rectangle getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isPickedUp() {
		return pickedUp;
	}

	public void setPickedUp(boolean pickedUp) {
		this.pickedUp = pickedUp;
	}

}
