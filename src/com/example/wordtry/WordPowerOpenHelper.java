package com.example.wordtry;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class WordPowerOpenHelper extends SQLiteOpenHelper {

	public WordPowerOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// 
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("create table mainwordlist" + "(_id integer primary key, Word text, meaning text,Sentence text)");
		Log.i("Word LIst Table Created","Yes");
		db.execSQL("create table Groups" + "(_id integer primary key, GroupName text)");
		Log.i("Groups Table Created","Yes");
		db.execSQL("create table Mapping" + "(mainId integer, GroupID integer)");
		Log.i("Mapping Table Created","Yes");
		db.execSQL("create table Stats" + "(_id integer primary key,ListName text, ExamDate Date, NoOfQuestion Integer, TotalMarks Integer, Correct Integer, Percentage REAL)");
		Log.i("Mapping Table Created","Yes");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS mainwordlist" );
		db.execSQL("DROP TABLE IF EXISTS Group" );
		db.execSQL("DROP TABLE IF EXISTS Mapping" );
		db.execSQL("DROP TABLE IF EXISTS Stats" );
		onCreate(db);
		
	}
	
	public Cursor getAllWords(String strQuery){
		//List<WordRecord> wRL = new ArrayList<WordRecord>();
		
		//String query = "Select * from mainwordlist";
		String query = strQuery;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor csr = db.rawQuery(query, null);		
		return csr;
	}
	
	public Cursor getWordsCount(String strQuery){
		//List<WordRecord> wRL = new ArrayList<WordRecord>();
		
		//String query = "Select * from mainwordlist";
		String query = strQuery;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor csr = db.rawQuery(query, null);
		
		Log.i("I m her for count", "I m her for count");
		return csr;
	}
	
	public void addWords(String strWords,String strMeaning,String strSentence){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("word", strWords);
		//Log.i("Add word", "Yessssss");
		cv.put("meaning", strMeaning);
		cv.put("sentence", strSentence);
		db.insert("mainwordlist", null, cv);
		db.close();
	}
	
	public void addGroup(String strGroupName){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("GroupName", strGroupName);
		Log.i("Add Group", strGroupName +"  Yessssss, New Grp Added");
		db.insert("Groups", null, cv);
		db.close();
	}
	
	public void addWordToList(Integer intMainID,Integer intGroupID){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("mainid", intMainID);
		cv.put("GroupID", intGroupID);		
		db.insert("Mapping", null, cv);
		db.close();
		Log.i("Add word to list", intMainID +"  Yessssss, New word Added");	
	}
	
	public void deleteWordFromList(Integer intMainID,Integer intGroupID){
		SQLiteDatabase db = this.getWritableDatabase();
		db.execSQL("delete from Mapping where mainid = " + intMainID +" and GroupID = "+ intGroupID);
		//Toast.makeText("word gonna deleted", "word gonna deleted", 0);
		//String[] whereArgs = {string1,string2,string3};
		db.delete("Mapping", "mainid = ?" + " and GroupID = ?",  new String [] { String.valueOf(intMainID),String.valueOf(intGroupID) });
		Log.i("Word Deleted", "Word Deleted");
		//Toast.makeText(this, "word gonna deleted", 0).show();
		db.close();
	}
	
	
	public void addDataToStats_DB(String ListName,String Date, Integer NoOfQuestions,Integer TotalMarks, Integer Correct, Double Percentage){
		Log.i("Add Data to Stats", ListName +"  Going to add");	
		Log.i("Total Marks", String.valueOf(TotalMarks));	
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("ListName", ListName);
		cv.put("ExamDate", Date);	
		cv.put("NoOfQuestion", NoOfQuestions);
		cv.put("Percentage", Percentage);
		cv.put("TotalMarks", TotalMarks);
		cv.put("Correct", Correct);
		db.insert("Stats", null, cv);
		db.close();
		Log.i("Add Data to Stats", ListName +"  Yessssss, New Data Added");	
	}
	
	
	
	
			
}
