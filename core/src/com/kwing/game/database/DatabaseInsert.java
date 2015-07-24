package com.kwing.game.database;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.sql.Database;
import com.badlogic.gdx.sql.SQLiteGdxException;

public class DatabaseInsert {
	
	private static Database dbHandler;

//	public static boolean insertScore(){
//		dbHandler = DatabaseConnection.getDbHandler();
//		try{
//			dbHandler.execSQL("INSERT INTO scores ('name', score) VALUES ('test', 12345)");
//		} catch (SQLiteGdxException e){
//			e.printStackTrace();
//		}
//		
//		return true;
//	}
	
	public static boolean insertScore(String name, int score){
		dbHandler = DatabaseConnection.getDbHandler();
		Gdx.app.log("score", "Trying to insert score");
		try{
			String scoreString = Integer.toString(score);
			dbHandler.execSQL("INSERT INTO scores (" + DatabaseConnection.COLUMN_NAME + ", " 
			+ DatabaseConnection.COLUMN_SCORE + ") VALUES ('" + name + "', " 
			+ scoreString + ")");
		}catch(SQLiteGdxException e){
			e.printStackTrace();
		}
		
		Gdx.app.log("Insert", "Added Successfully");
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
