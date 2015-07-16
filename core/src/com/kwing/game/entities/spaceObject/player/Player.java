package com.kwing.game.entities.spaceObject.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.kwing.game.entities.Resources;
import com.kwing.game.main.Game;

public class Player extends PlayerObject {
	
	public static final int MOVEMENTSPEED = 250;
	public static final int HEALTH = 100;
	public static final int LIVES = 3;
	public static final int SCORE = 0;
	public static final int POWER = 20;
	
	private OrthographicCamera cam;
	private Vector3 touchPos;

	private Ship ship;
	
	private Texture texture;
	private Rectangle rectangle;
	
	private float centerX, centerY;
	private int score;
	private boolean leftPressed;
	private boolean pickedUp;
	private boolean lostHealth;

	public Player(OrthographicCamera cam, Ship ship) {
		this.cam = cam;
		this.ship = ship;
		score = SCORE;
		lives = LIVES;
		health = HEALTH;
		power = POWER;
		ship.getRectangle().x = Game.V_WIDTH / 2 - ship.getWidth() / 2;
		ship.getRectangle().y = 200;
		ship.setMovementSpeed(MOVEMENTSPEED);
		this.rectangle = ship.getRectangle();
		touchPos = new Vector3();
		
		pickedUp = false;
		lostHealth = false;
		
	}

	public void update(float dt) {
		
		if(pickedUp){
			Resources.Sounds.getPickUp().play();
			pickedUp = false;
		}
		
		if(lostHealth){
			Resources.Sounds.getLostHealth().play();
			lostHealth = false;
		}
		if (Gdx.input.isTouched()) {
			
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0); 
			cam.unproject(touchPos);

			if(touchPos.x < ship.getRectangle().x + ship.getWidth() / 2){
				ship.getRectangle().x -= ship.getMovementSpeed() * dt;
			}
			if(touchPos.x > ship.getRectangle().x + ship.getWidth() / 2){
				ship.getRectangle().x += ship.getMovementSpeed() * dt;
			}
			if(touchPos.y < ship.getRectangle().y + ship.getHeight() / 2)
				ship.getRectangle().y -= ship.getMovementSpeed() * dt;
			if(touchPos.y > ship.getRectangle().y + ship.getHeight() / 2)
				ship.getRectangle().y += ship.getMovementSpeed() * dt;
			
		}
		
		// setting screen bounds
		if(ship.getRectangle().x < 0) 
			ship.getRectangle().x = 0;
	    if(ship.getRectangle().x > Game.V_WIDTH - ship.getRectangle().width) 
	    	ship.getRectangle().x = Game.V_WIDTH - ship.getRectangle().width;
	    if(ship.getRectangle().y < 0) 
	    	ship.getRectangle().y = 0;
	    if(ship.getRectangle().y > Game.V_HEIGHT - ship.getRectangle().height) 
	    	ship.getRectangle().y = Game.V_HEIGHT - ship.getRectangle().height;
	}
	

	public void render(SpriteBatch sb) {

		sb.begin();
		sb.draw(ship.getTexture(), ship.getRectangle().x, ship.getRectangle().y, ship.getRectangle().width, ship.getRectangle().height);
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

	public boolean isLostHealth() {
		return lostHealth;
	}

	public void setLostHealth(boolean lostHealth) {
		this.lostHealth = lostHealth;
	}

}
