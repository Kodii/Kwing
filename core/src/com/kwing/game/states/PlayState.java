package com.kwing.game.states;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.kwing.game.entities.Hud;
import com.kwing.game.entities.Meteor;
import com.kwing.game.entities.Player;
import com.kwing.game.entities.Projectile;
import com.kwing.game.entities.Resources;
import com.kwing.game.entities.Ship;
import com.kwing.game.entities.play.Background;
import com.kwing.game.entities.play.powers.RegenPill;
import com.kwing.game.handlers.GameStateManager;
import com.kwing.game.main.Game;

public class PlayState extends GameState {
	
	private Player player;
	private Background background;
	private Projectile projectile;
	private Ship ship;
	private Meteor meteor;
	private Hud hud;
	private RegenPill regenPill;
	private Random random;
	private BitmapFont font48;

	private ArrayList<Projectile> projectiles;
	private ArrayList<Meteor> meteors;
	private ArrayList<RegenPill> regenPills;
	
	private boolean start = false;
	
	private int delayTime;
	private int spawnTime;
	private int randomNumber;
	// TODO SKONCZYLEM NA USTAWIANIU FACTORA W KLASIE METEOR, TERAZ TRZEBA DOROBIC
	// POZIOMY MOCY.
	public PlayState(GameStateManager gsm, Ship ship){
		super(gsm);
		this.ship = ship;
		
		delayTime = 0;
		spawnTime = 0;
		
		random = new Random();
		background = new Background();
		player = new Player(cam, ship);
		projectiles = new ArrayList<Projectile>();
		meteors = new ArrayList<Meteor>();
		hud = new Hud(player);
		regenPills = new ArrayList<RegenPill>();
		
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Bonus/kenvector_future.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 48;
		font48 = generator.generateFont(parameter); // font size 12 pixels
		generator.dispose(); // don't forget to dispose to avoid memory leaks!
	
	}
	
	
	@Override
	public void init() {
		
	}
	
	@Override
	public void handleInput() {
		
	}

	@Override
	public void update(float dt) {
		background.update(dt);
	
		
		if(start && player.getLives() >= 0){
			player.update(dt);
			hud.update(dt);
			
			if(player.getHealth() <= 0){
				player.setLives(player.getLives() - 1);
				player.setHealth(100 + 1);
				start = false;
			}
			
			spawnTime += 1;
			if(spawnTime == 100){
				meteor = new Meteor(new Random().nextInt(4) + 1, player);
				meteors.add(meteor);
				spawnTime = 0;
			}

			for(int i = 0; i < meteors.size(); i++){
				meteors.get(i).update(dt); // updating meteor 
			//player>>meteor collision
				if(player.getRectangle().overlaps(meteors.get(i).getRectangle())){ 
					
					player.setHealth(player.getHealth() - 1);
					player.setLostHealth(true);
				}
				
				if(meteors.get(i).getRectangle().y < -200){ // removing meteors which reaches lower border
					meteors.remove(i);
				}
			}
			delayTime += 1;
			if (Gdx.input.isTouched()) {
			// shooting , creating projectiles
				if (delayTime > 8){
					delayTime = 0;
					projectile = new Projectile(player);
					projectiles.add(projectile);
				}
			}
			
		// bullet >> meteor collision
			for(int i = 0; i < projectiles.size(); i++){
				projectiles.get(i).update(dt);
				if(projectiles.get(i).getRectangle().y > Game.V_HEIGHT && projectiles.get(i).isVisible()){
					projectiles.remove(i);
					break;
				}
				if(meteors.size() > 0)
					for(int j = 0; j < meteors.size(); j++){
					// bullet >> meteor collision
						if(projectiles.get(i).getRectangle().overlaps(meteors.get(j).getRectangle()) && projectiles.get(i).isVisible()){
							
							meteors.get(j).setHealth(meteors.get(j).getHealth() - projectiles.get(i).getPower()); // taking meteor hp dependable of projectile power
							player.setScore(player.getScore() + Projectile.HIT_SCORE); // adding a score when meteor has been hit
							projectiles.get(i).setVisible(false); // setting bullet invisible for no collison and later removal.
						
						// adding score to player
							if(meteors.get(j).getHealth() < 0){
								switch(meteors.get(j).getLives()){
								case 3: 
									player.setScore(player.getScore() + 10 * meteors.get(j).getFactor());
									break;
								case 2: 
									player.setScore(player.getScore() + 20 * meteors.get(j).getFactor());
									break;
								case 1: 
									player.setScore(player.getScore() + 30 * meteors.get(j).getFactor());
									break;
								default:
										break;
								}
								
								meteors.get(j).setLives(meteors.get(j).getLives() - 1);
								meteors.get(j).setDestroyed(true);
								
								if(meteors.get(j).getLives() == 0){
								//creating regen pills after full meteor destroy
									
									if(random.nextInt(100) + 1 < RegenPill.PILL_CHANCE){
										randomNumber = random.nextInt(4);
										regenPill = new RegenPill(meteors.get(j).getRectangle(), randomNumber); // random number 0-3
										regenPills.add(regenPill);
									}
									Resources.Sounds.getMeteorExplosion().play();
									meteors.remove(j);
								}
							}
						}
				}
			}
		//regenPills update and collision
			if(regenPills.size() > 0){
				for(int i = 0; i < regenPills.size(); i++){
					regenPills.get(i).update(dt);
					
					if(player.getRectangle().overlaps(regenPills.get(i).getRectangle())){ 
							
						player.setPickedUp(true);
						if(player.getHealth() < 100){ // if health is less than full, then increase it.
							player.setHealth(player.getHealth() + regenPills.get(i).getHealth());
							if(player.getHealth() > 100) // checking if it isnt reached maximum hp
								player.setHealth(100);
						}
						player.setScore(player.getScore() + regenPills.get(i).getScore()); // adding score dependant of pill type
						regenPills.remove(i);
					}
				}
			}
			
			for(int i = 0; i < projectiles.size(); i++){
				if(!projectiles.get(i).isVisible())
					projectiles.remove(i);
			}
			
			
		}
		else{
			meteors.clear();
			projectiles.clear();
			regenPills.clear();
			player.getRectangle().setPosition(Game.V_WIDTH / 2 - player.getShip().getRectangle().width / 2, 200);
			delayTime += 1;
			if (Gdx.input.isTouched()) {
				
				if (delayTime > 50){
					delayTime = 0;
					start = true;
				}
			}
		}
		 
	}

	@Override
	public void render() {
		background.render(sb);
		
		
		if(!start){
			player.render(sb);	
			sb.begin();
			font48.draw(sb, "TAP TO START", 200, Game.V_HEIGHT / 2 + Game.V_WIDTH / 4);
			sb.end();
		}
		else{
			
			
			for(int i = 0; i < meteors.size(); i++){
				meteors.get(i).render(sb);
			}
			for(int i = 0; i < regenPills.size(); i++){
				regenPills.get(i).render(sb);
			}
			player.render(sb);	
			for(int i = 0; i < projectiles.size(); i++){
				projectiles.get(i).render(sb);
			}
			hud.render(sb);
		}
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}


}
