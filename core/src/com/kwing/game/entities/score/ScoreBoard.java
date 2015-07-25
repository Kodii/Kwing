package com.kwing.game.entities.score;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.kwing.game.database.DatabaseConnection;
import com.kwing.game.database.DatabaseSelect;
import com.kwing.game.main.Game;

public class ScoreBoard {
	
	private ArrayList<Score> scores;
	private ArrayList<Score> hiScores;
	private Score playerScore;
	
	private FreeTypeFontGenerator generator;
	private FreeTypeFontParameter parameter;
	private BitmapFont font24;
	
	public ScoreBoard(){
		scores = new ArrayList<Score>();
		hiScores = new ArrayList<Score>();
		creatingScoreBoard();
		
		
		generator = new FreeTypeFontGenerator(Gdx.files.internal("Bonus/kenvector_future_thin.ttf"));
		parameter = new FreeTypeFontParameter();
		
		font24 = generateFont(24);
		generator.dispose();
		
		for(int i = 0; i < scores.size(); i++){
			scores.get(i).print();
		}
	}
	
	private void creatingScoreBoard(){
		String id, name, score;
		DatabaseConnection.connect();
			for(int i = 1; i <= DatabaseSelect.getScoresId() - 1; i++){
				id = DatabaseSelect.getScoreById(i).get(DatabaseConnection.COLUMN_ID).toString();
				name = DatabaseSelect.getScoreById(i).get(DatabaseConnection.COLUMN_NAME).toString();
				score = DatabaseSelect.getScoreById(i).get(DatabaseConnection.COLUMN_SCORE).toString();
				playerScore = new Score(id, name, score);
				scores.add(playerScore);
			}
		DatabaseConnection.dispose();
		creatingHighestScoreBoard(scores);
	}
	
	private void creatingHighestScoreBoard(ArrayList<Score> scoreList){
		Score temp;
		boolean flag = true;
		if(scoreList.size() > 1){
			while(flag){
				flag = false;
				for(int i = 0; i < scoreList.size() - 1; i++){
					if(Integer.parseInt(scoreList.get(i).getScore()) 
							< Integer.parseInt(scoreList.get(i + 1).getScore())){
						temp = scoreList.get(i);
						scoreList.set(i, scoreList.get(i + 1));
						scoreList.set(i + 1, temp);
						flag = true;
					}
				}
			}
		}
	}
	
	private BitmapFont generateFont(int fontSize){
		BitmapFont font;
		parameter.size = fontSize;
		font = generator.generateFont(parameter);
		return font;
	}
	
	public void update(float dt){
			
	}
	
	public void render(SpriteBatch spriteBatch){
		spriteBatch.begin();
		
		for(int i = 0; i < scores.size(); i++){
			font24.setColor(Color.WHITE);
			font24.draw(spriteBatch, Integer.toString(i + 1) + ". ", 100, (Game.V_HEIGHT - 200) - i * 40);
			font24.setColor(Color.YELLOW);
			font24.draw(spriteBatch, scores.get(i).getName(), 180, (Game.V_HEIGHT - 200) - i * 40);
			font24.setColor(Color.RED);
			font24.draw(spriteBatch, scores.get(i).getScore(), Game.V_WIDTH / 2 + 100, (Game.V_HEIGHT - 200) - i * 40);
		}
		
		spriteBatch.end();
	}
}
