package com.kwing.game.entities.huds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.kwing.game.entities.spaceObject.player.Player;
import com.kwing.game.entities.spaceObject.projectile.Projectile;
import com.kwing.game.entities.spaceObject.ships.Ship;
import com.kwing.game.main.Game;

public class Hud {
	
	private Player player;
	private Projectile projectile;
	private BitmapFont font18, font32;
	
	private int healthX, healthY;
	
	private int livesX, livesY;
	private int livesWidth, livesHeight;
	
	private int scoreX, scoreY;
	
	private int powerX, powerY;

	public Hud(Player player){
		
		this.player = player;
		
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Bonus/kenvector_future.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 18;
		font18 = generator.generateFont(parameter); // font size 12 pixels
		parameter.size = 32;
		font32 = generator.generateFont(parameter);
		generator.dispose(); // don't forget to dispose to avoid memory leaks!
		
		healthX = 30;
		healthY = Game.V_HEIGHT - 30;
		
		livesX = Game.V_WIDTH - 200;
		livesY = Game.V_HEIGHT - 30;
		livesWidth = 30;
		livesHeight = 30;
		
		scoreX = Game.V_WIDTH / 2;
		scoreY = 30;
	
		powerX = 30;
		powerY = healthY - 30;
		
	}
	
	public void update(float dt){
		
	}
	
	public void render(SpriteBatch sb){
		sb.begin();
		drawHealth(sb);
		drawLives(sb);
		drawScore(sb);
		drawPower(sb);
		sb.end();
	}
	
	private void drawHealth(SpriteBatch sb){
		font18.setColor(Color.RED);
		font18.draw(sb, "HEALTH: ", healthX, healthY);
		
		if(player.getHealth() > 75)
			font18.setColor(Color.GREEN);
		else if(player.getHealth() >= 50 && player.getHealth() <= 75)
			font18.setColor(Color.YELLOW);
		else if(player.getHealth() > 20 && player.getHealth() < 50)
			font18.setColor(Color.ORANGE);
		font18.draw(sb, Integer.toString(player.getHealth()), healthX + 100, healthY);
	}
	
	private void drawLives(SpriteBatch sb){
		
		font18.setColor(Color.RED);
		font18.draw(sb, "SHIPS: ", livesX, livesY);
		if(player.getLives() == 3){
			sb.draw(player.getTexture(), livesX + 80, livesY - livesHeight / 2, livesWidth, livesHeight);
			sb.draw(player.getTexture(), livesX + 120, livesY - livesHeight / 2, livesWidth, livesHeight);
			sb.draw(player.getTexture(), livesX + 160, livesY - livesHeight / 2, livesWidth, livesHeight);
		}else if(player.getLives() == 2){
			sb.draw(player.getTexture(), livesX + 80, livesY - livesHeight / 2, livesWidth, livesHeight);
			sb.draw(player.getTexture(), livesX + 120, livesY - livesHeight / 2, livesWidth, livesHeight);
		}else if(player.getLives() == 1)
			sb.draw(player.getTexture(), livesX + 80, livesY - livesHeight / 2, livesWidth, livesHeight);
		else{
			font18.setColor(Color.WHITE);
			font18.draw(sb, "NONE", livesX + 80, livesY);
		}
	}
	
	private void drawScore(SpriteBatch sb){
		font32.setColor(Color.WHITE);
		font32.draw(sb, Integer.toString(player.getScore()), scoreX - 16, scoreY);
	}
	
	private void drawPower(SpriteBatch sb){
		font18.setColor(Color.RED);
		font18.draw(sb, "POWER: ", powerX, powerY);
		font18.setColor(Color.WHITE);
		font18.draw(sb, Integer.toString(player.getPower()), powerX + 90, powerY);
	}
}





















