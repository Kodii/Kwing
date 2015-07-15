package com.kwing.game.entities.play.powers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.kwing.game.entities.Resources;
import com.kwing.game.entities.SpaceObject;

public class RegenPill extends SpaceObject {
	
	public static final int PILL_CHANCE = 100; // percent chance of getting pill
	private static final int WIDTH = 22;
	private static final int HEIGHT = 21;
	private static final int HEALTH = 5;
	private static final int SCORE = 5;
	private static final int MOVEMENTSPEED = 75;

	private float x,y;
	private int score;
	
	double angle;

	public RegenPill(Rectangle rectangle, int type){
		this.rectangle = rectangle;
		
		width = WIDTH;
		height = HEIGHT;
		rectangle.width = width;
		rectangle.height = height;
		x = rectangle.x;
		y = rectangle.y;
		movementSpeed = MOVEMENTSPEED;
		
		switch(type){
		case 0:
			texture = Resources.Textures.getPillRed();
			health = HEALTH * 2;
			score = SCORE * 2;
			break;
		case 1:
			texture = Resources.Textures.getPillBlue();
			health = HEALTH * 4;
			score = SCORE * 4;
			break;
		case 2:
			texture = Resources.Textures.getPillYellow();
			health = HEALTH * 6;
			score = SCORE * 6;
			break;
		case 3:
			texture = Resources.Textures.getPillRed();
			health = HEALTH * 8;
			score = SCORE * 8;
			break;
		default:
			break;
		}
	}
	
	public void update(float dt){
		angle += 0.1;
		if(angle > (2* Math.PI))
			angle = 0.0;

		  rectangle.x = x +(float) (Math.cos(angle) * (width / 3) + (width / 2));
		  rectangle.y = y +(float) (Math.sin(angle) * (height / 3) + (height / 2));
		  y -= movementSpeed * dt;
	}
	
	public void render(SpriteBatch sb){
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
}
