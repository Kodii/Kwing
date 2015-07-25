package com.kwing.game.handlers;

import com.badlogic.gdx.Input.TextInputListener;
import com.kwing.game.database.DatabaseConnection;
import com.kwing.game.database.DatabaseInsert;
import com.kwing.game.entities.spaceObject.player.Player;

public class MyTextInputListener implements TextInputListener {
	
	private int score;
	private String name;
	private boolean processing = true;
	
	public MyTextInputListener(Player player) {
		score = player.getScore();
		DatabaseConnection.connect();
	}
	
	@Override
	public void input(String text) {
		name = text;
		processing = false;
		DatabaseInsert.insertScore(name, score);
		DatabaseConnection.dispose();
		
	}

	@Override
	public void canceled() {
		name = "annonymous";
		processing = false;
		DatabaseInsert.insertScore(name, score);
		DatabaseConnection.dispose();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isProcessing() {
		return processing;
	}

	public void setProcessing(boolean processing) {
		this.processing = processing;
	}
}
