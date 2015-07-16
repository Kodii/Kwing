package com.kwing.game.entities.spaceObject.powers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.kwing.game.entities.Resources;
import com.kwing.game.entities.spaceObject.SpaceObject;

public class RegenPill extends PowerObject{
	
	public static final int PILL_CHANCE = 100; // percent chance of getting pill
	private static final int WIDTH = 22;
	private static final int HEIGHT = 21;
	private static final int POWER = 5;
	private static final int SCORE = 5;
	private static final int MOVEMENTSPEED = 75;

	private float x,y;
	private int score;
	
	double angle;

	public RegenPill(Rectangle rectangle, int type){
		this.rectangle = rectangle;
		
		setWidth(WIDTH);
		setHeight(HEIGHT);
		rectangle.width = getWidth();
		rectangle.height = getHeight();
		x = rectangle.x;
		y = rectangle.y;
		movementSpeed = MOVEMENTSPEED;
		
		switch(type){
		case 0:
			setTexture(Resources.Textures.getPillRed());
			power = POWER * 2;
			score = SCORE * 2;
			break;
		case 1:
			setTexture(Resources.Textures.getPillBlue());
			power = POWER * 4;
			score = SCORE * 4;
			break;
		case 2:
			setTexture(Resources.Textures.getPillYellow());
			power = POWER * 6;
			score = SCORE * 6;
			break;
		case 3:
			setTexture(Resources.Textures.getPillRed());
			power = POWER * 8;
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

		  rectangle.x = x +(float) (Math.cos(angle) * (getWidth() / 3) + (getWidth() / 2));
		  rectangle.y = y +(float) (Math.sin(angle) * (getHeight() / 3) + (getHeight() / 2));
		  y -= movementSpeed * dt;
	}
	
	public void render(SpriteBatch sb){
		sb.begin();
		sb.draw(getTexture(), rectangle.x, rectangle.y, rectangle.width, rectangle.height);
		sb.end();
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
