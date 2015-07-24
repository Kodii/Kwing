package com.kwing.game.database;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.sql.Database;
import com.badlogic.gdx.sql.DatabaseFactory;
import com.badlogic.gdx.sql.SQLiteGdxException;

public class DatabaseTest {

	private Database dbHandler;
	
	public static final String TABLE_SCORES = "scores";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_SCORE = "score";
	
	private static final String DATABASE_NAME = "scores.db";
	private static final int DATABASE_VERSION = 1;
	
	// Database creation sql statement
	private static final String DATABASE_CREATE = "create table if not exists "
			+ TABLE_SCORES + "(" + COLUMN_ID + " integer primary key autoincrement, "
			+ COLUMN_NAME + " text not null, " + COLUMN_SCORE + " Integer not null);";
	
	public DatabaseTest(){
		Gdx.app.log("DatabaseTest", "creation started");
		dbHandler = DatabaseFactory.getNewDatabase(DATABASE_NAME, DATABASE_VERSION, DATABASE_CREATE, null);
		
		dbHandler.setupDatabase();
		try{
			dbHandler.openOrCreateDatabase();
			dbHandler.execSQL(DATABASE_CREATE);
		}catch(SQLiteGdxException e){
			e.printStackTrace();
		}
		
		Gdx.app.log("DatabaseTest", "created successfilly");
		
		
		
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
