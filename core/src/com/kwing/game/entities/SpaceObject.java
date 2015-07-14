package com.kwing.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public abstract class SpaceObject {

	protected String s;
	protected int width, height;
	protected float x, y;
	protected Texture texture;
	protected Rectangle rectangle;
	protected int health;
	protected int lives;
	protected int power;
	
	protected int movementSpeed;
	
	public SpaceObject(){
		
	}
	
	public SpaceObject(String s, int width, int height, int x, int y){
		this.s = s;
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		
	}
	
	protected void initObject(){
		texture = new Texture(Gdx.files.internal(s));
		rectangle = new Rectangle();
		rectangle.width = width;
		rectangle.height = height;
		rectangle.x = x;
		rectangle.y = y;
	}
	
	protected void initObject(String s, int width, int height, int x, int y){
		this.x = x;
		texture = new Texture(Gdx.files.internal(s));
		rectangle = new Rectangle();
		rectangle.width = width;
		rectangle.height = height;
		rectangle.x = x;
		rectangle.y = y;
		
	}

	public Rectangle getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public int getMovementSpeed() {
		return movementSpeed;
	}

	public void setMovementSpeed(int movementSpeed) {
		this.movementSpeed = movementSpeed;
	}

	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

}
