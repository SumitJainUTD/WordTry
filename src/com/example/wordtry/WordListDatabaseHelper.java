package com.example.wordtry;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class WordListDatabaseHelper  {
	
	private static final int DATABASE_VERSION=2;
	private static final String DATABASE_NAME = "wordpower.db";
	private static final String TABLE_NAME ="wordListmain";
	
	public static final String WORDPOWER_COLUMN_ID="ID";
	public static final String WORDPOWER_COLUMN_WORD="word";
	public static final String WORDPOWER_COLUMN_MEANING="meaning";
	public static final String WORDPOWER_COLUMN_SENTENCE="sentence";
	
	
	private WordPowerOpenHelper openHelper;
	private SQLiteDatabase db;
	
	public WordListDatabaseHelper(Context context){
		openHelper = new WordPowerOpenHelper(context);
		db= openHelper.getWritableDatabase();
	}
	private class WordPowerOpenHelper extends SQLiteOpenHelper{
		
		WordPowerOpenHelper(Context context){
			super(context,DATABASE_NAME,null,DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("CREATE TABLE" + TABLE_NAME + "("+WORDPOWER_COLUMN_ID+" integer primary key AUTOINCREMENT, "+ WORDPOWER_COLUMN_WORD+" text, "+WORDPOWER_COLUMN_MEANING+" text,"+WORDPOWER_COLUMN_SENTENCE+" text)");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
			onCreate(db);
		}
		
	}
	
		
	
}
