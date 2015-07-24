package com.kwing.game.database;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.sql.Database;
import com.badlogic.gdx.sql.DatabaseCursor;
import com.badlogic.gdx.sql.SQLiteGdxException;

import javafx.scene.chart.PieChart.Data;

public class DatabaseSelect {
	
	private static Database dbHandler;
	
	public static void all(){
		dbHandler = DatabaseConnection.getDbHandler();
		DatabaseCursor cursor = null;
		
		try{
			cursor = dbHandler.rawQuery("SELECT * FROM scores");
		}catch(SQLiteGdxException e){
			e.printStackTrace();
		}
		
		while (cursor.next()) {
			System.out.println(String.valueOf(cursor.getInt(2)));
		}
		
		try {
			cursor = dbHandler.rawQuery(cursor, "SELECT * FROM scores");
		} catch (SQLiteGdxException e) {
			e.printStackTrace();
		}
	}
	
	public static int getScoresId(){
		int rowId = -1;
		DatabaseCursor cursor = null;
		
		Gdx.app.log("scores ID", "Trying to get last ID");
		
		try{
			dbHandler = DatabaseConnection.getDbHandler();
			cursor = dbHandler.rawQuery("SELECT MAX(" + DatabaseConnection.COLUMN_ID + ") from scores");
			cursor.next();
			rowId = cursor.getInt(0);
			
			if (rowId == 0){
	               return 1;
	           }else{
	               return rowId + 1;
	           }
		}catch(SQLiteGdxException e){
			e.printStackTrace();
		}
		
		Gdx.app.log("scores ID", "Success");
		return rowId;
	}
	
	public static HashMap getScoreById(int scoreId){
		DatabaseCursor cursor = null;
		HashMap<String, String> score = new HashMap<String, String>();
		String scoreIdString = Integer.toString(scoreId);
		Gdx.app.log("score", "Trying to get score by id");
		
		try{
			dbHandler = DatabaseConnection.getDbHandler();
			cursor = dbHandler.rawQuery("SELECT " + DatabaseConnection.COLUMN_ID + ", "
					+ DatabaseConnection.COLUMN_NAME + ", " + DatabaseConnection.COLUMN_SCORE
					+ " FROM scores WHERE " + DatabaseConnection.COLUMN_ID + "=" + scoreIdString);
			
			if(cursor.next() == true){
				score.put("id", Integer.toString(cursor.getInt(0)));
				score.put("name", cursor.getString(1));
				score.put("score", Integer.toString(cursor.getInt(2)));
			}
			
			
		}catch(SQLiteGdxException e){
			e.printStackTrace();
		}
		
		Gdx.app.log("score", "success");
		return score;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
