package com.kwing.game.handlers;

public class GameKeys {

	private static boolean[] keys;
	
	private static final int NUM_KEYS = 3;
	public static final int LEFT = 0;
	public static final int RIGHT = 1;
	public static final int SPACE = 2;
	
	static{
		keys = new boolean[NUM_KEYS];
	}
	
	public static void setKey(int k, boolean b){
		keys[k] = b;
	}
	
	public static boolean isDown(int k){
		return keys[k];
	}
}