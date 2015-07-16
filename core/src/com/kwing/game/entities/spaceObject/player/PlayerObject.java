package com.kwing.game.entities.spaceObject.player;

import com.kwing.game.entities.spaceObject.SpaceObject;

public abstract class PlayerObject extends SpaceObject {
	
	protected int health;
	protected int lives;
	protected int power;
	
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
