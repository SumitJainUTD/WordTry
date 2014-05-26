package com.example.wordtry;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Stats extends Activity {
	StatsAdapter statAdapter;
	
	public WordPowerOpenHelper wp;
	public String strListName;
	public String strQuery;
	public ListView listviewstats;
	public CommomFunctions cf;
	public Intent intent;

	
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.statslist);
		
		listviewstats = (ListView) findViewById(R.id.stats_list);
		 cf = new CommomFunctions(this);
		intent = getIntent();
		strQuery ="Select * from Stats ORDER BY _ID DESC";
		wp = new WordPowerOpenHelper(this, cf.DBName, null, 1);
		
		Cursor csr = wp.getAllWords(strQuery);
		
		Log.i("com.example.wordtry","Cursor returned");
//		
		statAdapter = new StatsAdapter(this,csr);
		listviewstats.setAdapter(statAdapter);		
	}

	@Override
	protected void onResume(){
		super.onResume();
		Cursor csr = wp.getAllWords(strQuery);		
		statAdapter = new StatsAdapter(this,csr);
		listviewstats.setAdapter(statAdapter);
	}
	
	public void onBackPressed() {		
			Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
		    startActivity(mainIntent);	   	     
	}   

	
}


