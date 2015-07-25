package com.kwing.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class Resources {
	
	public static class Textures{
		
		private static Texture background = new Texture(Gdx.files.internal("Backgrounds/purple.png"));
		private static Texture backgroundBlue = new Texture(Gdx.files.internal("Backgrounds/blue.png"));
		private static Texture title = new Texture(Gdx.files.internal("PNG/title.png"));
		private static Texture startButton = new Texture(Gdx.files.internal("PNG/Buttons/startButton.png"));
		private static Texture scoreButton = new Texture(Gdx.files.internal("PNG/Buttons/scoreButton.png"));
		
		private static Texture playerShipBlue1 = new Texture(Gdx.files.internal("PNG/playerShip1_blue.png"));
		private static Texture playerShipBlue2 = new Texture(Gdx.files.internal("PNG/playerShip2_blue.png"));
		private static Texture playerShipBlue3 = new Texture(Gdx.files.internal("PNG/playerShip3_blue.png"));

		private static Texture pillBlue = new Texture(Gdx.files.internal("PNG/Power-ups/pill_blue.png"));
		private static Texture pillGreen = new Texture(Gdx.files.internal("PNG/Power-ups/pill_green.png"));
		private static Texture pillRed = new Texture(Gdx.files.internal("PNG/Power-ups/pill_red.png"));
		private static Texture pillYellow = new Texture(Gdx.files.internal("PNG/Power-ups/pill_yellow.png"));
		
		private static Texture powerUpBlueBolt = new Texture(Gdx.files.internal("PNG/Power-ups/powerupBlue_bolt.png"));

		private static Texture laserBlue1 = new Texture(Gdx.files.internal("Lasers/laserBlue1.png"));
		private static Texture laserBlue2 = new Texture(Gdx.files.internal("Lasers/laserBlue2.png"));
		private static Texture laserBlue3 = new Texture(Gdx.files.internal("Lasers/laserBlue3.png"));
		private static Texture laserBlue4 = new Texture(Gdx.files.internal("Lasers/laserBlue4.png"));
		private static Texture laserBlue5 = new Texture(Gdx.files.internal("Lasers/laserBlue5.png"));
		private static Texture laserBlue6 = new Texture(Gdx.files.internal("Lasers/laserBlue6.png"));
		
		private static Texture meteorBrownBig1 = new Texture(Gdx.files.internal("PNG/Meteors/meteorBrown_big1.png"));
		private static Texture meteorBrownBig2 = new Texture(Gdx.files.internal("PNG/Meteors/meteorBrown_big2.png"));
		private static Texture meteorBrownBig3 = new Texture(Gdx.files.internal("PNG/Meteors/meteorBrown_big3.png"));
		private static Texture meteorBrownBig4 = new Texture(Gdx.files.internal("PNG/Meteors/meteorBrown_big4.png"));
		private static Texture meteorBrownMedium = new Texture(Gdx.files.internal("PNG/Meteors/meteorBrown_med1.png"));
		private static Texture meteorBrownSmall = new Texture(Gdx.files.internal("PNG/Meteors/meteorBrown_small1.png"));
		
		public static Texture getBackground() {
			return background;
		}
		public static void setBackground(Texture background) {
			Textures.background = background;
		}
		public static Texture getBackgroundBlue() {
			return backgroundBlue;
		}
		public static void setBackgroundBlue(Texture backgroundBlue) {
			Textures.backgroundBlue = backgroundBlue;
		}
		public static Texture getTitle() {
			return title;
		}
		public static void setTitle(Texture title) {
			Textures.title = title;
		}
		public static Texture getStartButton() {
			return startButton;
		}
		public static void setStartButton(Texture startButton) {
			Textures.startButton = startButton;
		}
		public static Texture getScoreButton() {
			return scoreButton;
		}
		public static void setScoreButton(Texture scoreButton) {
			Textures.scoreButton = scoreButton;
		}
		public static Texture getPlayerShipBlue1() {
			return playerShipBlue1;
		}
		public static void setPlayerShipBlue1(Texture playerShipBlue1) {
			Textures.playerShipBlue1 = playerShipBlue1;
		}
		public static Texture getPlayerShipBlue2() {
			return playerShipBlue2;
		}
		public static void setPlayerShipBlue2(Texture playerShipBlue2) {
			Textures.playerShipBlue2 = playerShipBlue2;
		}
		public static Texture getPlayerShipBlue3() {
			return playerShipBlue3;
		}
		public static void setPlayerShipBlue3(Texture playerShipBlue3) {
			Textures.playerShipBlue3 = playerShipBlue3;
		}
		/*public static Texture getPlayerShip(int type){
			switch(type){
			case SHIP_BLUE1:
				return Textures.playerShipBlue1;
			case SHIP_BLUE2:
				return Textures.playerShipBlue2;
			case SHIP_BLUE3:
				return Textures.playerShipBlue3;
			default:
				return null;
			}
		}*/
		public static Texture getPillBlue() {
			return pillBlue;
		}
		public static void setPillBlue(Texture pillBlue) {
			Textures.pillBlue = pillBlue;
		}
		public static Texture getPillGreen() {
			return pillGreen;
		}
		public static void setPillGreen(Texture pillGreen) {
			Textures.pillGreen = pillGreen;
		}
		public static Texture getPillRed() {
			return pillRed;
		}
		public static void setPillRed(Texture pillRed) {
			Textures.pillRed = pillRed;
		}
		public static Texture getPillYellow() {
			return pillYellow;
		}
		public static void setPillYellow(Texture pillYellow) {
			Textures.pillYellow = pillYellow;
		}
		public static Texture getPill(int type){
			switch(type){
			case 1:
				return Textures.pillBlue;
			case 2:
				return Textures.pillGreen;
			case 3:
				return Textures.pillYellow;
			case 4:
				return Textures.pillRed;
			default:
				return null;
			}
		}
		public static Texture getPowerUpBlueBolt() {
			return powerUpBlueBolt;
		}
		public static void setPowerUpBlueBolt(Texture powerUpBlueBolt) {
			Textures.powerUpBlueBolt = powerUpBlueBolt;
		}
		public static Texture getLaserBlue1() {
			return laserBlue1;
		}
		public static void setLaserBlue1(Texture laserBlue1) {
			Textures.laserBlue1 = laserBlue1;
		}
		public static Texture getLaserBlue2() {
			return laserBlue2;
		}
		public static void setLaserBlue2(Texture laserBlue2) {
			Textures.laserBlue2 = laserBlue2;
		}
		public static Texture getLaserBlue3() {
			return laserBlue3;
		}
		public static void setLaserBlue3(Texture laserBlue3) {
			Textures.laserBlue3 = laserBlue3;
		}
		public static Texture getLaserBlue4() {
			return laserBlue4;
		}
		public static Texture getMeteorBrownBig1() {
			return meteorBrownBig1;
		}
		public static void setMeteorBrownBig1(Texture meteorBrownBig1) {
			Textures.meteorBrownBig1 = meteorBrownBig1;
		}
		public static Texture getMeteorBrownBig2() {
			return meteorBrownBig2;
		}
		public static void setMeteorBrownBig2(Texture meteorBrownBig2) {
			Textures.meteorBrownBig2 = meteorBrownBig2;
		}
		public static Texture getMeteorBrownBig3() {
			return meteorBrownBig3;
		}
		public static void setMeteorBrownBig3(Texture meteorBrownBig3) {
			Textures.meteorBrownBig3 = meteorBrownBig3;
		}
		public static Texture getMeteorBrownBig4() {
			return meteorBrownBig4;
		}
		public static void setMeteorBrownBig4(Texture meteorBrownBig4) {
			Textures.meteorBrownBig4 = meteorBrownBig4;
		}
		public static Texture getMeteorBrownBig(int type){
			switch(type){
			case 1:
				return Textures.meteorBrownBig1;
			case 2:
				return Textures.meteorBrownBig2;
			case 3:
				return Textures.meteorBrownBig3;
			case 4:
				return Textures.meteorBrownBig4;
			default:
				return null;
			}
		}
		public static Texture getMeteorBrownMedium() {
			return meteorBrownMedium;
		}
		public static void setMeteorBrownMedium(Texture meteorBrownMedium) {
			Textures.meteorBrownMedium = meteorBrownMedium;
		}
		public static Texture getMeteorBrownSmall() {
			return meteorBrownSmall;
		}
		public static void setMeteorBrownSmall(Texture meteorBrownSmall) {
			Textures.meteorBrownSmall = meteorBrownSmall;
		}
		public static void setLaserBlue4(Texture laserBlue4) {
			Textures.laserBlue4 = laserBlue4;
		}
		public static Texture getLaserBlue5() {
			return laserBlue5;
		}
		public static void setLaserBlue5(Texture laserBlue5) {
			Textures.laserBlue5 = laserBlue5;
		}
		public static Texture getLaserBlue6() {
			return laserBlue6;
		}
		public static void setLaserBlue6(Texture laserBlue6) {
			Textures.laserBlue6 = laserBlue6;
		}
	}
	
	public static class Sounds{
		
		private static Music intro = Gdx.audio.newMusic(Gdx.files.internal("Sounds/intro.ogg"));
		private static Music level = Gdx.audio.newMusic(Gdx.files.internal("Sounds/level1.ogg"));
		private static Music scoreStateMusic = Gdx.audio.newMusic(Gdx.files.internal("Sounds/credits.ogg"));
		private static Sound shotSound = Gdx.audio.newSound(Gdx.files.internal("Sounds/sfx_laser2.ogg"));
		private static Sound pickUp = Gdx.audio.newSound(Gdx.files.internal("Sounds/sfx_pickedUp.ogg"));
		private static Sound lostHealth = Gdx.audio.newSound(Gdx.files.internal("Sounds/sfx_lose.ogg"));
		private static Sound meteorExplosion = Gdx.audio.newSound(Gdx.files.internal("Sounds/explosion.wav"));
		
				
		public static Music getIntro() {
			return intro;
		}
		public static void setIntro(Music intro) {
			Sounds.intro = intro;
		}
		public static Music getLevel() {
			return level;
		}
		public static void setLevel(Music level) {
			Sounds.level = level;
		}
		public static Music getScoreStateMusic() {
			return scoreStateMusic;
		}
		public static void setScoreStateMusic(Music scoreStateMusic) {
			Sounds.scoreStateMusic = scoreStateMusic;
		}
		public static Sound getShotSound() {
			return shotSound;
		}
		public static void setShotSound(Sound shotSound) {
			Sounds.shotSound = shotSound;
		}
		public static Sound getPickUp() {
			return pickUp;
		}
		public static void setPickUp(Sound pickUp) {
			Sounds.pickUp = pickUp;
		}
		public static Sound getLostHealth() {
			return lostHealth;
		}
		public static void setLostHealth(Sound lostHealth) {
			Sounds.lostHealth = lostHealth;
		}
		public static Sound getMeteorExplosion() {
			return meteorExplosion;
		}
		public static void setMeteorExplosion(Sound meteorExplosion) {
			Sounds.meteorExplosion = meteorExplosion;
		}
	}
}
