package com.kwing.game.entities.spaceObject.meteors;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.kwing.game.entities.Resources;
import com.kwing.game.entities.spaceObject.player.Player;
import com.kwing.game.entities.spaceObject.projectile.Projectile;
import com.kwing.game.main.Game;

public class Meteor extends MeteorObject{

	public static final int MOVEMENTSPEED = 100;
	public static final int WIDTH = 150;
	public static final int HEIGHT = 150;
	public static final int HEALTH = 100;
	public static final int POWER = 1;
	public static final int SCORE = 10;
	
	private Random random;
	
	private int factor;
	private boolean destroyed;
	private boolean left, right;
	private boolean visible;
	private boolean anihilated;
	
	public Meteor(int type, Player player){
		random = new Random();
		rectangle = new Rectangle();
		texture = Resources.Textures.getMeteorBrownBig(type);
		
		movementSpeed = MOVEMENTSPEED;
		//TODO fix balance
		if(player.getPower() > 35 && player.getPower() <= 50){
			factor = 2;
			movementSpeed = 110;
		}
		else if(player.getPower() > 50 && player.getPower() <= 70){
			factor = 3;
			movementSpeed = 125;
		}
		else if(player.getPower() > 70 && player.getPower() <= 90){
			factor = 5;
			movementSpeed = 140;
		}
		else if(player.getPower() > 90){
			factor = 6;
			movementSpeed = 150;
		}
		else
			factor = 1;
		destroyed = false;
		width = WIDTH;
		height = HEIGHT;
		health = HEALTH * factor;
		score = SCORE * factor;
		lives = 3;
		visible = true;
		
		x = random.nextInt(Game.V_WIDTH - getWidth()) + 1;
		y = Game.V_HEIGHT;
		createMeteor(x, y);
	}
	
	private void createMeteor(float x, float y){
		rectangle.x = x;
		rectangle.y = y;
		rectangle.width = width;
		rectangle.height = height;
	}
	
	public void update(float dt){
		// meteor movement on screen	
		playSoundIfDestroyed();
		move(dt);
		
		if(destroyed){
			reduceMeteorToSmaller();
			setMovementFlag();
		}
		
		checkDownwardBound();
			
	}
	
	public void playSoundIfDestroyed(){
		if(destroyed || anihilated)
			Resources.Sounds.getMeteorExplosion().play();
	}
	
	private boolean checkDownwardBound(){
		if(rectangle.y < 0 - rectangle.height)
			visible = false;
		else
			visible = true;
		return visible;
	}
	
	private void move(float dt){
		if(lives > 0 && !destroyed){
			rectangle.y -= movementSpeed * dt;
			if(right)
				rectangle.x += movementSpeed * dt;
			else if(left){
				rectangle.x -= movementSpeed * dt;
			}
		}
	}
	
	private void reduceMeteorToSmaller(){
		if(lives == 2){
			texture = Resources.Textures.getMeteorBrownMedium();
			health = HEALTH * factor - 30 * factor;
			score += (SCORE + 10) * factor;
		}
		if(lives == 1){
			texture = Resources.Textures.getMeteorBrownSmall();
			health = HEALTH * factor - 50 * factor;
			score += (SCORE + 20) * factor;
		}
		rectangle.width = rectangle.width / 2;
		rectangle.height = rectangle.height / 2;
		rectangle.x = rectangle.x + rectangle.width / 2;
		movementSpeed += 20;
		destroyed = false;
	}
	
	private void setMovementFlag(){
		if(destroyed)
			left = false;
		else
			right = false;
		
		if(random.nextInt(2) == 1)
			left = true;
		else
			right = true;
	}
	
	public void loseHealth(Projectile projectile){
		health -= projectile.getPower();
		projectile.setVisible(false);
	}
	
	public Boolean checkHealthIsNull(){
		boolean statement;
		if(health < 0)
			statement = true;
		else
			statement = false;
		return statement;
	}
	
	public Boolean checkIsAnihilated(){
		if(lives <= 0)
			anihilated = true;
		else 
			anihilated = false;
		return anihilated;
	}
	
	public void destroy(){
		lives -= 1;
		destroyed = true;
	}
	
	public void render(SpriteBatch sb){
		sb.begin();
		sb.draw(getTexture(), rectangle.x, rectangle.y, rectangle.width, rectangle.height);
		sb.end();
	}

	public boolean isDestroyed() {
		return destroyed;
	}

	public void setDestroyed(boolean alive) {
		this.destroyed = alive;
	}

	public int getFactor() {
		return factor;
	}

	public void setFactor(int factor) {
		this.factor = factor;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	

}
