package com.kwing.game.states;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.kwing.game.entities.Collision;
import com.kwing.game.entities.Resources;
import com.kwing.game.entities.backgrounds.PlayBackground;
import com.kwing.game.entities.huds.Hud;
import com.kwing.game.entities.spaceObject.meteors.Meteor;
import com.kwing.game.entities.spaceObject.player.Player;
import com.kwing.game.entities.spaceObject.powers.PowerUp;
import com.kwing.game.entities.spaceObject.powers.RegenPill;
import com.kwing.game.entities.spaceObject.projectile.Projectile;
import com.kwing.game.entities.spaceObject.ships.Ship;
import com.kwing.game.handlers.GameStateManager;
import com.kwing.game.main.Game;

public class PlayState extends GameState {
	
	private PlayBackground background;
	private Player player;
	private Projectile projectile;
	private Ship ship;
	private Meteor meteor;
	private Hud hud;
	private RegenPill regenPill;
	private PowerUp powerUp;
	private Random random;
	
	private FreeTypeFontGenerator generator;
	private FreeTypeFontParameter parameter;
	private BitmapFont font48;

	private ArrayList<Projectile> projectiles;
	private ArrayList<Meteor> meteors;
	private ArrayList<RegenPill> regenPills;
	private ArrayList<PowerUp> powerUps;
	
	private boolean start;
	private int delayTime;
	private int spawnTime;
	private int randomPillType;
	// TODO SKONCZYLEM NA USTAWIANIU FACTORA W KLASIE METEOR, TERAZ TRZEBA DOROBIC
	// POZIOMY MOCY.
	public PlayState(GameStateManager gameStateManager){
		super(gameStateManager);
	}
	
	@Override
	public void init() {
		ship = gameStateManager.getShip();
		player = new Player(orthographicCamera, ship);
		random = new Random();
		background = new PlayBackground();
		
		projectiles = new ArrayList<Projectile>();
		meteors = new ArrayList<Meteor>();
		hud = new Hud(player);
		regenPills = new ArrayList<RegenPill>();
		powerUps = new ArrayList<PowerUp>();
		
		generator = new FreeTypeFontGenerator(Gdx.files.internal("Bonus/kenvector_future.ttf"));
		parameter = new FreeTypeFontParameter();
		
		delayTime = 0;
		spawnTime = 0;
		start = false;
		
		font48 = generateFont(48);
		
	}
	
	private BitmapFont generateFont(int fontSize){
		BitmapFont font;
		parameter.size = fontSize;
		font = generator.generateFont(parameter);
		return font;
	}
	
	@Override
	public void handleInput() {
		
	}
	private void spawnMeteor(){
		spawnTime += 1;
		if(spawnTime == 100){
			meteor = new Meteor(new Random().nextInt(4) + 1, player);
			meteors.add(meteor);
			spawnTime = 0;
		}
	}

	@Override
	public void update(float dt) {
		background.update(dt);
	
		if(start && player.getLives() > 0){
			player.update(dt);
			hud.update(dt);
			
			if(player.isDead()){
				player.reset(this);
			}
			
			spawnMeteor();
			
			for(int i = 0; i < meteors.size(); i++){
				meteors.get(i).update(dt);
				
				if(Collision.checkPlayerTouchedMeteor(player, meteors.get(i)))
					player.loseHealth();
				
				if(!meteors.get(i).isVisible())
					meteors.remove(i);
			}
			
			if (player.isShooting()) {
					projectiles.add(player.getProjectile());
			}
			for(int i = 0; i < projectiles.size(); i++){
				projectiles.get(i).update(dt);
				if(meteors.size() > 0)
					for(int j = 0; j < meteors.size(); j++){
						if(Collision.checkProjectileTouchedVisibleMeteor(projectiles.get(i), meteors.get(j)) ){
							meteors.get(j).loseHealth(projectiles.get(i));
							player.addScore(meteors.get(j));
							if(meteors.get(j).checkHealthIsNull()){
								meteors.get(j).destroy();
								player.addScore(meteors.get(j));
								if(meteors.get(j).checkIsAnihilated()){
									meteors.get(j).playSoundIfDestroyed();
									
									if(random.nextInt(2) + 1 == 1){
										if(RegenPill.spawnChance()){
											regenPill = RegenPill.spawnRandomPill(meteors.get(j));
											regenPills.add(regenPill);
										}
									}else{
										if(PowerUp.spawnChance()){
											powerUp = PowerUp.spawnPowerUp(meteors.get(j));
											powerUps.add(powerUp);
										}
									}
									meteors.remove(j);
								}
							}
						}//TODO SPROBOWAC SKROCIC TA CZESC
					}
				if(!projectiles.get(i).isVisible())
					projectiles.remove(i);
			}
			if(regenPills.size() > 0){
				for(int i = 0; i < regenPills.size(); i++){
					regenPills.get(i).update(dt);
					
					if(Collision.checkPlayerTouchedRegenPill(player, regenPills.get(i))){ 
						player.addHealth(regenPills.get(i));
						player.addScore(regenPills.get(i));
						regenPills.remove(i);
					}
					//TODO fix clearing memory by visibility
				}
			}
			if(powerUps.size() > 0){//TODO TUTAJ
				for(int i = 0; i < powerUps.size(); i++){
					powerUps.get(i).update(dt);
					
					if(Collision.checkPlayerTouchedPowerUp(player, powerUps.get(i))){
						player.addPower(powerUps.get(i));
						player.addScore(powerUps.get(i));
						powerUps.remove(i);
					}
					//TODO fix clearing memory by visibility
				}
			}
		}
		else{
			meteors.clear();
			projectiles.clear();
			regenPills.clear();
			powerUps.clear();
			delayTime += 1;
			if (Gdx.input.isTouched()) {
				if (delayTime > 50){
					delayTime = 0;
					start = true;
				}
			}
		}
		
		if(player.getLives() == 0){
			Resources.Sounds.getLevel().stop();
			gameStateManager.addState(GameStateManager.SCORESTATE, player);
			gameStateManager.setState(GameStateManager.SCORESTATE);
		}
		 
	}
	
	@Override
	public void render() {
		background.render(spriteBatch);
		
		
		if(!start){
			player.render(spriteBatch);	
			spriteBatch.begin();
			font48.draw(spriteBatch, "TAP TO START", 200, Game.V_HEIGHT / 2 + Game.V_WIDTH / 4);
			spriteBatch.end();
		}
		else{
			for(int i = 0; i < meteors.size(); i++){
				meteors.get(i).render(spriteBatch);
			}
			for(int i = 0; i < regenPills.size(); i++){
				regenPills.get(i).render(spriteBatch);
			}
			for(int i = 0; i < powerUps.size(); i++){
				powerUps.get(i).render(spriteBatch);
			}
			player.render(spriteBatch);	
			for(int i = 0; i < projectiles.size(); i++){
				projectiles.get(i).render(spriteBatch);
			}
			hud.render(spriteBatch);
		}
	}

	@Override
	public void dispose() {
		generator.dispose();
	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}


}
