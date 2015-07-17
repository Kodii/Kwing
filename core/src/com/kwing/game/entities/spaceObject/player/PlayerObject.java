package com.kwing.game.entities.spaceObject.player;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.kwing.game.entities.spaceObject.SpaceObject;

public abstract class PlayerObject extends SpaceObject {
	
	protected OrthographicCamera orthographicCamera;
	protected int health;
	protected int lives;
	protected int power;
	protected float startPositionX;
	protected float startPositionY;
	
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getLives() {
		return lives;
	}
	public void setLives(int lives) {
		this.lives = lives;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	
}
