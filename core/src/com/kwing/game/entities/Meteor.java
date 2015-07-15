package com.kwing.game.entities;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.kwing.game.main.Game;

public class Meteor extends SpaceObject{

	public static final int MOVEMENTSPEED = 100;
	public static final int WIDTH = 150;
	public static final int HEIGHT = 150;
	public static final int HEALTH = 100;
	
	private int factor;
	private int type;
	private boolean destroyed;
	private boolean left, right;
	
	private Random random;
	private Player player;
	
	public Meteor(int type, Player player){
		this.type = type;
		
		if(player.getScore() > 1000)
			factor = 2;
		else if(player.getScore() > 4000)
			factor = 3;
		else
			factor = 1;
		
		
		
		destroyed = false;
		movementSpeed = MOVEMENTSPEED;
		width = WIDTH;
		height = HEIGHT;
		health = HEALTH * factor;
		
		lives = 3;
		random = new Random();
		initObject("PNG/Meteors/meteorBrown_big" + type + ".png", width, height, random.nextInt(Game.V_WIDTH - width) + 1, Game.V_HEIGHT);
	}
	
	public void update(float dt){
		
	//
		if(destroyed)
			Resources.Sounds.getMeteorExplosion().play();
	// meteor movement on screen	
		rectangle.y -= movementSpeed * dt;
	// lives = 2
		if(lives == 2 && destroyed){
			texture.dispose();
			texture = new Texture(Gdx.files.internal("PNG/Meteors/meteorBrown_med1.png"));
			rectangle.width = width / 2 ;
			rectangle.height = height / 2;
			health = HEALTH * factor - 40 * factor;  
			rectangle.x = x + rectangle.width / 2;
			movementSpeed += 10;
			
			if(random.nextInt(2) + 1 == 1)
				left = true;
			else
				right = true;
			
			destroyed = false;
		}
		else if(lives == 2 && !destroyed){
			rectangle.y -= movementSpeed * dt;
			
			if(right)
				rectangle.x += movementSpeed * dt;
			else if(left){
				rectangle.x -= movementSpeed * dt;
			}
			
			
		}
		
		// lives = 1
		if(lives == 1 && destroyed){
			texture.dispose();
			texture = new Texture(Gdx.files.internal("PNG/Meteors/meteorBrown_small1.png"));
			left = false;
			right = false;
			rectangle.width = width / 4;
			rectangle.height = height / 4;
			health = HEALTH * factor - 60 * factor;
			movementSpeed += 10;
			
			if(random.nextInt(2) + 1 == 1)
				left = true;
			else
				right = true;
			
			destroyed = false;
		}
		else if(lives == 1 && !destroyed){
			rectangle.y -= movementSpeed * dt;
			
			if(right)
				rectangle.x += movementSpeed * dt;
			else if(left){
				rectangle.x -= movementSpeed * dt;
			}
		}
		
	}
	
	public void render(SpriteBatch sb){
		sb.begin();
		sb.draw(texture, rectangle.x, rectangle.y, rectangle.width, rectangle.height);
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
}
