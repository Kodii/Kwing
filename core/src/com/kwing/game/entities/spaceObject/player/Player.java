package com.kwing.game.entities.spaceObject.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.kwing.game.entities.Resources;
import com.kwing.game.entities.spaceObject.meteors.Meteor;
import com.kwing.game.entities.spaceObject.powers.PowerUp;
import com.kwing.game.entities.spaceObject.powers.RegenPill;
import com.kwing.game.entities.spaceObject.projectile.Projectile;
import com.kwing.game.entities.spaceObject.ships.Ship;
import com.kwing.game.main.Game;
import com.kwing.game.states.PlayState;

public class Player extends PlayerObject {
	
	public static final int MOVEMENTSPEED = 250;
	public static final int HEALTH = 100;
	public static final int LIVES = 1;
	public static final int SCORE = 0;
	public static final int POWER = 20;
	public static final int MAX_POWER = 100;
	
	private Ship ship;
	private Projectile projectile;
	private Vector3 touchPosition;
	
	private int score;
	private int shotDelay;
	private boolean pickedUp;
	private boolean lostHealthSound;
	private boolean dead;
	private boolean shooting;

	public Player(OrthographicCamera orthographicCamera, Ship ship) {
		this.orthographicCamera = orthographicCamera;
		this.ship = ship;
		rectangle = ship.getRectangle();
		texture = ship.getTexture();
		touchPosition = new Vector3();
		
		movementSpeed = MOVEMENTSPEED;
		health = HEALTH;
		lives = LIVES;
		score = SCORE;
		power = POWER;
		startPositionX = Game.V_WIDTH / 2 - rectangle.width / 2;
		startPositionY = 200;
		
		rectangle.x = startPositionX;
		rectangle.y = startPositionY;
		
		pickedUp = false;
		lostHealthSound = false;
		dead = false;
		shooting = false;
	}
	
	public void update(float dt) {
		
		shooting = false;
		playSound();
		checkDead();

		if (Gdx.input.isTouched()) {
			
			touchPosition.set(Gdx.input.getX(), Gdx.input.getY(), 0); 
			orthographicCamera.unproject(touchPosition);

			movePlayer(touchPosition, rectangle, dt);
			checkScreenBounds();
			
			
			shotDelay += 1;
			if (shotDelay > 8){
				shotDelay = 0;
				shooting = true;
				shot();
			}
			
			
		}
	}
	
	private void playSound(){
		if(pickedUp){
			Resources.Sounds.getPickUp().play();
			pickedUp = false;
		}
		
		if(lostHealthSound){
			Resources.Sounds.getLostHealth().play();
			lostHealthSound = false;
		}
	}
	
	private void checkDead(){
		if(health <= 0)
			dead = true;
		else
			dead = false;
	}
	
	private void movePlayer(Vector3 touchPosition, Rectangle rectangle, float dt){
		if(touchPosition.x < rectangle.x + rectangle.width / 2)
			rectangle.x -= movementSpeed * dt;
		if(touchPosition.x > rectangle.x + rectangle.width / 2)
			rectangle.x += movementSpeed * dt;
		if(touchPosition.y < rectangle.y + rectangle.height / 2)
			rectangle.y -= movementSpeed * dt;
		if(touchPosition.y > rectangle.y + rectangle.height / 2)
			rectangle.y += movementSpeed * dt;
	}
	
	private void checkScreenBounds(){
		if(rectangle.x < 0) 
			rectangle.x = 0;
	    if(rectangle.x > Game.V_WIDTH - rectangle.width) 
	    	rectangle.x = Game.V_WIDTH - rectangle.width;
	    if(rectangle.y < 0) 
	    	rectangle.y = 0;
	    if(rectangle.y > Game.V_HEIGHT - rectangle.height) 
	    	rectangle.y = Game.V_HEIGHT - rectangle.height;
	}
	
	private void shot(){
		projectile = new Projectile(this);
	}
	
	public void reset(PlayState playState){
		lives--;
		health = HEALTH + 1;
		rectangle.x = startPositionX;
		rectangle.y = startPositionY;
		playState.setStart(false);
	}
	
	public void loseHealth(){
		health -= Meteor.POWER;
		lostHealthSound = true;
	}
	
	public void addScore(Meteor meteor){
		if(!meteor.isDestroyed())
			score += Projectile.HIT_SCORE;
		else
			score += meteor.getScore();
	}
	
	public void addScore(RegenPill regenPill){
		score += regenPill.getScore();
	}
	
	public void addScore(PowerUp powerUp){
		score += PowerUp.SCORE;
	}
	
	public void addHealth(RegenPill regenPill){
		if(health < HEALTH)
			health += regenPill.getPower();
		if(health >= HEALTH)
			health = HEALTH;
		pickedUp = true;
	}
	
	public void addPower(PowerUp powerUp){
		if(power < MAX_POWER)
			power += PowerUp.POWER;
		if(power >= MAX_POWER)
			power = MAX_POWER;
		pickedUp = true;
	}

	public void render(SpriteBatch sb) {
		sb.begin();
		sb.draw(texture, rectangle.x, rectangle.y, rectangle.width, rectangle.height);
		sb.end();
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

	public boolean isLostHealthSound() {
		return lostHealthSound;
	}

	public void setLostHealthSound(boolean lostHealth) {
		this.lostHealthSound = lostHealth;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	public Projectile getProjectile() {
		return projectile;
	}

	public void setProjectile(Projectile projectile) {
		this.projectile = projectile;
	}

	public boolean isShooting() {
		return shooting;
	}

	public void setShooting(boolean shooting) {
		this.shooting = shooting;
	}
}
