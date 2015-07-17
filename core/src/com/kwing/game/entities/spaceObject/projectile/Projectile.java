package com.kwing.game.entities.spaceObject.projectile;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.kwing.game.entities.Resources;
import com.kwing.game.entities.spaceObject.SpaceObject;
import com.kwing.game.entities.spaceObject.player.Player;
import com.kwing.game.entities.spaceObject.powers.PowerObject;
import com.kwing.game.entities.spaceObject.ships.Ship;
import com.kwing.game.main.Game;

public class Projectile extends PowerObject{
	
	public static final int HIT_SCORE = 5; // value of bullet hit score
	public static final int SPEED = 500;
	
	
	private Rectangle rectangle;
	private Player player;
	private Sound shotSound;
	private boolean visible;
	

	public Projectile(){
		visible = false;
		power = player.getPower();
	}
	
	public Projectile(Player player){
		this.player = player;
		visible = true;
		movementSpeed = SPEED;
		power = player.getPower();
		
		if(player.getPower() <= 20)
			setTexture(Resources.Textures.getLaserBlue1());
		else if(player.getPower() > 20 && player.getPower() <= 60)
			setTexture(Resources.Textures.getLaserBlue2());
			
		
		rectangle = new Rectangle();
		
		rectangle.x = player.getRectangle().x + player.getRectangle().width / 2 - 6;
		rectangle.y = player.getRectangle().y + player.getRectangle().height;
		rectangle.width = getTexture().getWidth();
		rectangle.height = getTexture().getHeight();
		
		shotSound = Resources.Sounds.getShotSound();
		shotSound.play(0.3f);
		
	}
	
	public void update(float dt){
		rectangle.y += movementSpeed * dt;
		checkUpperBound();
	}
	
	private Boolean checkUpperBound(){
		if(rectangle.y > Game.V_HEIGHT && visible)
			visible = false;
		else
			visible = true;
		return visible;
	}
	
	public void render(SpriteBatch sb){
		sb.begin();
		sb.draw(getTexture(), rectangle.x, rectangle.y, rectangle.width, rectangle.height);
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
