package com.kwing.game.entities;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Projectile extends SpaceObject{
	
	public static final int HIT_SCORE = 5; // value of bullet hit score
	public static final int SPEED = 500;
	
	
	private Rectangle rectangle;
	private Player player;
	private Ship ship;
	private Sound shotSound;
	private boolean visible;
	

	public Projectile(){
		visible = false;
		power = player.power;
	}
	
	public Projectile(Player player){
		this.player = player;
		visible = true;
		movementSpeed = SPEED;
		power = player.power;
		ship = player.getShip();
		
		if(player.getPower() <= 20)
			texture = Resources.Textures.getLaserBlue1();
		else if(player.getPower() > 20 && player.getPower() <= 60)
			texture = Resources.Textures.getLaserBlue2();
			
		
		rectangle = new Rectangle();
		
		rectangle.x = ship.rectangle.x + ship.rectangle.width / 2 - 6;
		rectangle.y = ship.rectangle.y + ship.rectangle.height;
		rectangle.width = texture.getWidth();
		rectangle.height = texture.getHeight();
		
		shotSound = Resources.Sounds.getShotSound();
		shotSound.play(0.3f);
		
	}
	
	public void update(float dt){
		rectangle.y += movementSpeed * dt;
	}
	
	public void render(SpriteBatch sb){
		sb.begin();
		sb.draw(texture, rectangle.x, rectangle.y, rectangle.width, rectangle.height);
		sb.end();
	}

	public Rectangle getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}
