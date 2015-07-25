package com.kwing.game.entities.spaceObject.powers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.kwing.game.entities.Resources;
import com.kwing.game.entities.spaceObject.meteors.Meteor;

public class PowerUp extends PowerObject{
	
	public static final int POWER_CHANCE = 100;
	public static final int POWER = 5;
	
	private static final int WIDTH = 34;
	private static final int HEIGHT = 33;
	private static final int SCORE = 5;
	private static final int MOVEMENTSPEED = 75;
	
	private float x, y;
	double angle;
	
	public PowerUp(Rectangle rectangle){
		this.rectangle = rectangle;
		movementSpeed = MOVEMENTSPEED;
		createPowerUp(rectangle.x, rectangle.y);
	}
	
	private void createPowerUp(float x, float y){
		texture = Resources.Textures.getPowerUpBlueBolt();
		this.x = x;
		this.y = y;
		rectangle.width = WIDTH;
		rectangle.height = HEIGHT;
	}
	
	public static boolean spawnChance(){
		boolean statement;
		if(Math.random() * 100 < POWER_CHANCE)
			statement = true;
		else 
			statement = false;
		return statement;
	}
	
	public static PowerUp spawnPowerUp(Meteor meteor){
		return new PowerUp(meteor.getRectangle());
	}
	
	public void update(float dt){
		angle += 0.1;
		if(angle > (2* Math.PI))
			angle = 0.0;

		  rectangle.x = x +(float) (Math.cos(angle) * (rectangle.width / 3) + (rectangle.width / 2));
		  rectangle.y = y +(float) (Math.sin(angle) * (rectangle.height / 3) + (rectangle.height / 2));
		  y -= movementSpeed * dt;
	}
	
	public void render(SpriteBatch spriteBatch){
		spriteBatch.begin();
		spriteBatch.draw(texture, rectangle.x, rectangle.y, rectangle.width, rectangle.height);
		spriteBatch.end();
	}

}
