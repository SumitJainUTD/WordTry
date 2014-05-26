package com.example.wordtry;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class Select_Alphabet extends MainActivity {
	
	private static final int LENGTH_SHORT = 0;
	public static final String LISTNAME = "com.example.wordtry.LISTNAME";
	
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_alphabet_table);	
	}
	
	@Override
	public void onBackPressed() {

	    Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
	    startActivity(mainIntent);
	    Log.i("Back pressed","Refresh it");
	    return;
	}   
	
	public void ShowList_A(View v){
		try{
		Toast.makeText(this, "List A",LENGTH_SHORT).show();
		Intent NewINt = new Intent(getApplicationContext(),MainList.class);
		NewINt.putExtra(LISTNAME, "MasterWordList_A");
		startActivity(NewINt);
		}
		catch(Exception e){
			Toast.makeText(this, e.getMessage(),LENGTH_SHORT).show();
		}
		Toast.makeText(this, "Show Main list button is clicked",LENGTH_SHORT).show();
	}

	public void ShowList_B(View v){
		try{
		Toast.makeText(this, "List B",LENGTH_SHORT).show();
		Intent NewINt = new Intent(getApplicationContext(),MainList.class);
		NewINt.putExtra(LISTNAME, "MasterWordList_B");
		startActivity(NewINt);
		}
		catch(Exception e){
			Toast.makeText(this, e.getMessage(),LENGTH_SHORT).show();
		}
		Toast.makeText(this, "Show Main list button is clicked",LENGTH_SHORT).show();
	}
	
	public void ShowList_C(View v){
		try{
		Toast.makeText(this, "List C",LENGTH_SHORT).show();
		Intent NewINt = new Intent(getApplicationContext(),MainList.class);
		NewINt.putExtra(LISTNAME, "MasterWordList_C");
		startActivity(NewINt);
		}
		catch(Exception e){
			Toast.makeText(this, e.getMessage(),LENGTH_SHORT).show();
		}
		Toast.makeText(this, "Show Main list button is clicked",LENGTH_SHORT).show();
	}
	public void ShowList_D(View v){
		try{
		Toast.makeText(this, "List D",LENGTH_SHORT).show();
		Intent NewINt = new Intent(getApplicationContext(),MainList.class);
		NewINt.putExtra(LISTNAME, "MasterWordList_D");
		startActivity(NewINt);
		}
		catch(Exception e){
			Toast.makeText(this, e.getMessage(),LENGTH_SHORT).show();
		}
		Toast.makeText(this, "Show Main list button is clicked",LENGTH_SHORT).show();
	}
	public void ShowList_E(View v){
		try{
		Toast.makeText(this, "List E",LENGTH_SHORT).show();
		Intent NewINt = new Intent(getApplicationContext(),MainList.class);
		NewINt.putExtra(LISTNAME, "MasterWordList_E");
		startActivity(NewINt);
		}
		catch(Exception e){
			Toast.makeText(this, e.getMessage(),LENGTH_SHORT).show();
		}
		Toast.makeText(this, "Show Main list button is clicked",LENGTH_SHORT).show();
	}
	public void ShowList_F(View v){
		try{
		Toast.makeText(this, "List F",LENGTH_SHORT).show();
		Intent NewINt = new Intent(getApplicationContext(),MainList.class);
		NewINt.putExtra(LISTNAME, "MasterWordList_F");
		startActivity(NewINt);
		}
		catch(Exception e){
			Toast.makeText(this, e.getMessage(),LENGTH_SHORT).show();
		}
		Toast.makeText(this, "Show Main list button is clicked",LENGTH_SHORT).show();
	}
	public void ShowList_G(View v){
		try{
		Toast.makeText(this, "List G",LENGTH_SHORT).show();
		Intent NewINt = new Intent(getApplicationContext(),MainList.class);
		NewINt.putExtra(LISTNAME, "MasterWordList_G");
		startActivity(NewINt);
		}
		catch(Exception e){
			Toast.makeText(this, e.getMessage(),LENGTH_SHORT).show();
		}
		Toast.makeText(this, "Show Main list button is clicked",LENGTH_SHORT).show();
	}
	public void ShowList_H(View v){
		try{
		Toast.makeText(this, "List H",LENGTH_SHORT).show();
		Intent NewINt = new Intent(getApplicationContext(),MainList.class);
		NewINt.putExtra(LISTNAME, "MasterWordList_H");
		startActivity(NewINt);
		}
		catch(Exception e){
			Toast.makeText(this, e.getMessage(),LENGTH_SHORT).show();
		}
		Toast.makeText(this, "Show Main list button is clicked",LENGTH_SHORT).show();
	}
	public void ShowList_I(View v){
		try{
		Toast.makeText(this, "List I",LENGTH_SHORT).show();
		Intent NewINt = new Intent(getApplicationContext(),MainList.class);
		NewINt.putExtra(LISTNAME, "MasterWordList_I");
		startActivity(NewINt);
		}
		catch(Exception e){
			Toast.makeText(this, e.getMessage(),LENGTH_SHORT).show();
		}
		Toast.makeText(this, "Show Main list button is clicked",LENGTH_SHORT).show();
	}
	public void ShowList_J(View v){
		try{
		Toast.makeText(this, "List J",LENGTH_SHORT).show();
		Intent NewINt = new Intent(getApplicationContext(),MainList.class);
		NewINt.putExtra(LISTNAME, "MasterWordList_J");
		startActivity(NewINt);
		}
		catch(Exception e){
			Toast.makeText(this, e.getMessage(),LENGTH_SHORT).show();
		}
		Toast.makeText(this, "Show Main list button is clicked",LENGTH_SHORT).show();
	}
	public void ShowList_K(View v){
		try{
		Toast.makeText(this, "List K",LENGTH_SHORT).show();
		Intent NewINt = new Intent(getApplicationContext(),MainList.class);
		NewINt.putExtra(LISTNAME, "MasterWordList_K");
		startActivity(NewINt);
		}
		catch(Exception e){
			Toast.makeText(this, e.getMessage(),LENGTH_SHORT).show();
		}
		Toast.makeText(this, "Show Main list button is clicked",LENGTH_SHORT).show();
	}
	public void ShowList_L(View v){
		try{
		Toast.makeText(this, "List L",LENGTH_SHORT).show();
		Intent NewINt = new Intent(getApplicationContext(),MainList.class);
		NewINt.putExtra(LISTNAME, "MasterWordList_L");
		startActivity(NewINt);
		}
		catch(Exception e){
			Toast.makeText(this, e.getMessage(),LENGTH_SHORT).show();
		}
		Toast.makeText(this, "Show Main list button is clicked",LENGTH_SHORT).show();
	}
	public void ShowList_M(View v){
		try{
		Toast.makeText(this, "List M",LENGTH_SHORT).show();
		Intent NewINt = new Intent(getApplicationContext(),MainList.class);
		NewINt.putExtra(LISTNAME, "MasterWordList_M");
		startActivity(NewINt);
		}
		catch(Exception e){
			Toast.makeText(this, e.getMessage(),LENGTH_SHORT).show();
		}
		Toast.makeText(this, "Show Main list button is clicked",LENGTH_SHORT).show();
	}
	public void ShowList_N(View v){
		try{
		Toast.makeText(this, "List N",LENGTH_SHORT).show();
		Intent NewINt = new Intent(getApplicationContext(),MainList.class);
		NewINt.putExtra(LISTNAME, "MasterWordList_N");
		startActivity(NewINt);
		}
		catch(Exception e){
			Toast.makeText(this, e.getMessage(),LENGTH_SHORT).show();
		}
		Toast.makeText(this, "Show Main list button is clicked",LENGTH_SHORT).show();
	}
	public void ShowList_O(View v){
		try{
		Toast.makeText(this, "List O",LENGTH_SHORT).show();
		Intent NewINt = new Intent(getApplicationContext(),MainList.class);
		NewINt.putExtra(LISTNAME, "MasterWordList_O");
		startActivity(NewINt);
		}
		catch(Exception e){
			Toast.makeText(this, e.getMessage(),LENGTH_SHORT).show();
		}
		Toast.makeText(this, "Show Main list button is clicked",LENGTH_SHORT).show();
	}
	public void ShowList_P(View v){
		try{
		Toast.makeText(this, "List P",LENGTH_SHORT).show();
		Intent NewINt = new Intent(getApplicationContext(),MainList.class);
		NewINt.putExtra(LISTNAME, "MasterWordList_P");
		startActivity(NewINt);
		}
		catch(Exception e){
			Toast.makeText(this, e.getMessage(),LENGTH_SHORT).show();
		}
		Toast.makeText(this, "Show Main list button is clicked",LENGTH_SHORT).show();
	}
	public void ShowList_Q(View v){
		try{
		Toast.makeText(this, "List Q",LENGTH_SHORT).show();
		Intent NewINt = new Intent(getApplicationContext(),MainList.class);
		NewINt.putExtra(LISTNAME, "MasterWordList_Q");
		startActivity(NewINt);
		}
		catch(Exception e){
			Toast.makeText(this, e.getMessage(),LENGTH_SHORT).show();
		}
		Toast.makeText(this, "Show Main list button is clicked",LENGTH_SHORT).show();
	}
	public void ShowList_R(View v){
		try{
		Toast.makeText(this, "List R",LENGTH_SHORT).show();
		Intent NewINt = new Intent(getApplicationContext(),MainList.class);
		NewINt.putExtra(LISTNAME, "MasterWordList_R");
		startActivity(NewINt);
		}
		catch(Exception e){
			Toast.makeText(this, e.getMessage(),LENGTH_SHORT).show();
		}
		Toast.makeText(this, "Show Main list button is clicked",LENGTH_SHORT).show();
	}
	public void ShowList_S(View v){
		try{
		Toast.makeText(this, "List S",LENGTH_SHORT).show();
		Intent NewINt = new Intent(getApplicationContext(),MainList.class);
		NewINt.putExtra(LISTNAME, "MasterWordList_S");
		startActivity(NewINt);
		}
		catch(Exception e){
			Toast.makeText(this, e.getMessage(),LENGTH_SHORT).show();
		}
		Toast.makeText(this, "Show Main list button is clicked",LENGTH_SHORT).show();
	}
	public void ShowList_T(View v){
		try{
		Toast.makeText(this, "List T",LENGTH_SHORT).show();
		Intent NewINt = new Intent(getApplicationContext(),MainList.class);
		NewINt.putExtra(LISTNAME, "MasterWordList_T");
		startActivity(NewINt);
		}
		catch(Exception e){
			Toast.makeText(this, e.getMessage(),LENGTH_SHORT).show();
		}
		Toast.makeText(this, "Show Main list button is clicked",LENGTH_SHORT).show();
	}
	public void ShowList_U(View v){
		try{
		Toast.makeText(this, "List U",LENGTH_SHORT).show();
		Intent NewINt = new Intent(getApplicationContext(),MainList.class);
		NewINt.putExtra(LISTNAME, "MasterWordList_U");
		startActivity(NewINt);
		}
		catch(Exception e){
			Toast.makeText(this, e.getMessage(),LENGTH_SHORT).show();
		}
		Toast.makeText(this, "Show Main list button is clicked",LENGTH_SHORT).show();
	}
	public void ShowList_V(View v){
		try{
		Toast.makeText(this, "List V",LENGTH_SHORT).show();
		Intent NewINt = new Intent(getApplicationContext(),MainList.class);
		NewINt.putExtra(LISTNAME, "MasterWordList_V");
		startActivity(NewINt);
		}
		catch(Exception e){
			Toast.makeText(this, e.getMessage(),LENGTH_SHORT).show();
		}
		Toast.makeText(this, "Show Main list button is clicked",LENGTH_SHORT).show();
	}
	public void ShowList_W(View v){
		try{
		Toast.makeText(this, "List W",LENGTH_SHORT).show();
		Intent NewINt = new Intent(getApplicationContext(),MainList.class);
		NewINt.putExtra(LISTNAME, "MasterWordList_W");
		startActivity(NewINt);
		}
		catch(Exception e){
			Toast.makeText(this, e.getMessage(),LENGTH_SHORT).show();
		}
		Toast.makeText(this, "Show Main list button is clicked",LENGTH_SHORT).show();
	}
	public void ShowList_X(View v){
		try{
		Toast.makeText(this, "List X",LENGTH_SHORT).show();
		Intent NewINt = new Intent(getApplicationContext(),MainList.class);
		NewINt.putExtra(LISTNAME, "MasterWordList_X");
		startActivity(NewINt);
		}
		catch(Exception e){
			Toast.makeText(this, e.getMessage(),LENGTH_SHORT).show();
		}
		Toast.makeText(this, "Show Main list button is clicked",LENGTH_SHORT).show();
	}
	public void ShowList_Y(View v){
		try{
		Toast.makeText(this, "List Y",LENGTH_SHORT).show();
		Intent NewINt = new Intent(getApplicationContext(),MainList.class);
		NewINt.putExtra(LISTNAME, "MasterWordList_Y");
		startActivity(NewINt);
		}
		catch(Exception e){
			Toast.makeText(this, e.getMessage(),LENGTH_SHORT).show();
		}
		Toast.makeText(this, "Show Main list button is clicked",LENGTH_SHORT).show();
	}
	public void ShowList_Z(View v){
		try{
		Toast.makeText(this, "List Z",LENGTH_SHORT).show();
		Intent NewINt = new Intent(getApplicationContext(),MainList.class);
		NewINt.putExtra(LISTNAME, "MasterWordList_Z");
		startActivity(NewINt);
		}
		catch(Exception e){
			Toast.makeText(this, e.getMessage(),LENGTH_SHORT).show();
		}
		Toast.makeText(this, "Show Main list button is clicked",LENGTH_SHORT).show();
	}
	
}
