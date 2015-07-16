package com.kwing.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public abstract class SpaceObject{

	protected String textureString;
	private int width;
	private int height;
	protected float x, y;
	private Texture texture;
	protected Rectangle rectangle;
	protected int health;
	protected int lives;
	protected int power;
	
	protected int movementSpeed;
	
	public SpaceObject(){
		
	}
	
	protected void initObject(String s, int width, int height, int x, int y){
		this.x = x;
		setTexture(new Texture(Gdx.files.internal(s)));
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

}
