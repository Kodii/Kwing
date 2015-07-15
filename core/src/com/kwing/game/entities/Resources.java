package com.kwing.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;

public class Resources {
	
	public static class Textures{
		
		private static Texture pillBlue = new Texture(Gdx.files.internal("PNG/Power-ups/pill_blue.png"));
		private static Texture pillGreen = new Texture(Gdx.files.internal("PNG/Power-ups/pill_blue.png"));
		private static Texture pillRed = new Texture(Gdx.files.internal("PNG/Power-ups/pill_blue.png"));
		private static Texture pillYellow = new Texture(Gdx.files.internal("PNG/Power-ups/pill_blue.png"));
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
