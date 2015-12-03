package com.kwing.game.entities.spaceObject.powers;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.kwing.game.entities.Resources;
import com.kwing.game.entities.spaceObject.meteors.Meteor;

public class RegenPill extends PowerObject{
	
	public static final int PILL_CHANCE = 50; // percent chance of getting pill
	private static final int WIDTH = 22;
	private static final int HEIGHT = 21;
	private static final int POWER = 7;
	private static final int SCORE = 7;
	private static final int MOVEMENTSPEED = 75;
	
	private float x,y;
	private int score;
	
	double angle;
	
	public RegenPill(Rectangle rectangle, int type){
		this.rectangle = rectangle;
		movementSpeed = MOVEMENTSPEED;
		createPill(rectangle.x, rectangle.y, type);
	}
	
	private void createPill(float x, float y, int type){
		texture = Resources.Textures.getPill(type);
		this.x = x;
		this.y = y;
		rectangle.width = WIDTH;
		rectangle.height = HEIGHT;
		power = POWER * type;
		score = SCORE * type;
		visible = true;
	}
	
	public void update(float dt){
		angle += 0.1;
		if(angle > (2* Math.PI))
			angle = 0.0;

		rectangle.x = x +(float) (Math.cos(angle) * (rectangle.width / 3) + (rectangle.width / 2));
		rectangle.y = y +(float) (Math.sin(angle) * (rectangle.height / 3) + (rectangle.height / 2));
		y -= movementSpeed * dt;
		  
	}
	
	public void render(SpriteBatch sb){
		sb.begin();
		sb.draw(getTexture(), rectangle.x, rectangle.y, rectangle.width, rectangle.height);
		sb.end();
	}
	
	public static boolean spawnChance(){
		boolean statement;
		if(Math.random() * 100 < PILL_CHANCE)
			statement = true;
		else 
			statement = false;
		return statement;
	}
	
	public static RegenPill spawnRandomPill(Meteor meteor){
		return new RegenPill(meteor.getRectangle(), new Random().nextInt(4) + 1);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
