package com.kwing.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;

public class Resources {
	
	public static class Textures{
		
		private static Texture background = new Texture(Gdx.files.internal("Backgrounds/purple.png"));
		
		private static Texture pillBlue = new Texture(Gdx.files.internal("PNG/Power-ups/pill_blue.png"));
		private static Texture pillGreen = new Texture(Gdx.files.internal("PNG/Power-ups/pill_green.png"));
		private static Texture pillRed = new Texture(Gdx.files.internal("PNG/Power-ups/pill_red.png"));
		private static Texture pillYellow = new Texture(Gdx.files.internal("PNG/Power-ups/pill_yellow.png"));
		
		private static Texture laserBlue1 = new Texture(Gdx.files.internal("Lasers/laserBlue1.png"));
		private static Texture laserBlue2 = new Texture(Gdx.files.internal("Lasers/laserBlue2.png"));
		private static Texture laserBlue3 = new Texture(Gdx.files.internal("Lasers/laserBlue3.png"));
		private static Texture laserBlue4 = new Texture(Gdx.files.internal("Lasers/laserBlue4.png"));
		private static Texture laserBlue5 = new Texture(Gdx.files.internal("Lasers/laserBlue5.png"));
		private static Texture laserBlue6 = new Texture(Gdx.files.internal("Lasers/laserBlue6.png"));
		
		
		
		public static Texture getBackground() {
			return background;
		}
		public static void setBackground(Texture background) {
			Textures.background = background;
		}
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
		
	}
	
	
	

}
