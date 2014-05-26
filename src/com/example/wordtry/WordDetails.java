package com.example.wordtry;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Path.FillType;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class WordDetails extends MainActivity {
	public Intent intent;
	public int intWordID;
	public String strList;
	public String strCountQuery;
	public int intWordsCount=0;
	public TextView tvWord;
	public TextView tvMeaning;
	public TextView tvSentence;
	public int [] arrSpecList;
	public int intCurrentWordPosition;
	public int intSpecWordCount;
	public int intGRPId;
	public WordPowerOpenHelper wp;
	public CommomFunctions cf;
	
	public static String OPERATION = "ADD" ;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.worddetailview);
		
		cf = new CommomFunctions(this);
		Log.i("At The Begin in Word detals", "Lets go further:");
		
		wp = new WordPowerOpenHelper(this, cf.DBName, null, 1);
		strCountQuery = "select Count(*) as Count from mainwordlist";
		Log.i("Reavched here 1 Aug", "Lets go further:");
		
		intWordsCount= getRecordCount(strCountQuery);
		Log.i("no of words", String.valueOf(intWordsCount));
		
		intent = getIntent();
		
		Log.i("Selected word ID", String.valueOf(intent.getIntExtra(MainList.W_ID, 1)));
		//intWordID= Integer.parseInt(intent.getStringExtra(MainList.W_ID));
		intWordID= intent.getIntExtra(MainList.W_ID,1);
		Button btn_REMOVE = (Button) findViewById(R.id.RemoveFromList);
		Button btn_ADD = (Button) findViewById(R.id.AddToList);
		if(intent.getStringExtra(MainList.WORD_LIST).equalsIgnoreCase("MyList")||intent.getStringExtra(MainList.WORD_LIST).equalsIgnoreCase("LearningList")||intent.getStringExtra(MainList.WORD_LIST).equalsIgnoreCase("ToughList")){
			
			if(intent.getStringExtra(MainList.WORD_LIST).equalsIgnoreCase("MyList")){
				strList = "My List";
				intGRPId = 1;
				btn_REMOVE.setVisibility(View.VISIBLE);
				btn_ADD.setText("Add to Learning List");
			}
			else if(intent.getStringExtra(MainList.WORD_LIST).equalsIgnoreCase("LearningList")){
				strList = "Learning List";
				intGRPId = 2;
				btn_ADD.setText("Add to My List");
				btn_REMOVE.setVisibility(View.VISIBLE);
			}
			else if(intent.getStringExtra(MainList.WORD_LIST).equalsIgnoreCase("ToughList")){
				strList = "Tough List";
				intGRPId = 3;
				btn_ADD.setText("Add to List");
				btn_REMOVE.setVisibility(View.VISIBLE);
			}
			intSpecWordCount= getRecordCount("select Count(*) as Count from mainwordlist where _ID in (select mainid from Mapping where GroupID ="+ intGRPId +")");
			arrSpecList = new int[intSpecWordCount];
			Log.i("Total words in Spec List", String.valueOf(intSpecWordCount));
			int intTemp=-1;
			Cursor csr = wp.getAllWords("select * from mainwordlist where _ID in (select mainid from Mapping where GroupID ="+ intGRPId +")");
			if (csr.moveToFirst()){
				do{						
					int ID = csr.getInt(0);					
					intTemp++;
					if (ID==intWordID){
						intCurrentWordPosition = intTemp;
						Log.i("Word id matched with selected word at position", String.valueOf(intCurrentWordPosition));
					}
					arrSpecList[intTemp]=ID;
					Log.i("My List word ID", String.valueOf(ID));
					Log.i("Entry in arrSpec at "+ intTemp , String.valueOf(ID));
				}while(csr.moveToNext());
			}
			csr.close();
		}
		else{
			strList = "Main List";
			btn_ADD.setText("Add to List");
			btn_REMOVE.setVisibility(View.INVISIBLE);			
		}		
		
		
		TextView tvWord = (TextView)findViewById(R.id.wordDetail_View);
		tvWord.setText(intent.getStringExtra(MainList.WORD_D));
		
		TextView tvMeaning = (TextView)findViewById(R.id.meaningDetail_View);
		tvMeaning.setText(intent.getStringExtra(MainList.MEANING_D));
		
		TextView tvSentence = (TextView)findViewById(R.id.sentenceDetail_View);
		tvSentence.setText(intent.getStringExtra(MainList.SENTENCE_D));
		
	}
		public int getRecordCount(String strQuery){
		try{
			int intTemp = 0;		
			Cursor csr = wp.getAllWords(strQuery);
			Log.i("Check point 2 , 1 Aug", String.valueOf(intTemp));
			if(csr.moveToFirst()){
			intTemp = csr.getInt(csr.getColumnIndex("Count"));
			Log.i("Record Count is , 1 Aug", String.valueOf(intTemp));
			}
			csr.close();		
			return intTemp;
		}
		catch(NullPointerException np){
			Log.i("Error",np.getMessage());
			return 0;
		}
		
	}
		
		public String[] getWordDetails(int intWordID){
			String[] arrWordDetails = new String[3];
			String strQuery = "select * from mainwordlist where _ID="+ intWordID ;
			Cursor csr = wp.getAllWords(strQuery);
			if (csr.moveToFirst()){
					 arrWordDetails[0] = csr.getString(1);
					 arrWordDetails[1] = csr.getString(2);
					 arrWordDetails[2] = csr.getString(3);
					Log.i("com.example.wordtry", arrWordDetails[0]);
					Log.i("com.example.wordtry", arrWordDetails[1]);
					Log.i("com.example.wordtry", arrWordDetails[2]);
				//}while(csr.moveToNext());
			}
			csr.close();
			return arrWordDetails;	
		}
		public void PreviousWord(View v){
			if(strList.equalsIgnoreCase("Main List")){
				if(intWordID>1){
					intWordID--;
				}
				else{
					intWordID = intWordsCount;
				}
			}
			else{
				
				if(intCurrentWordPosition>0){
					intCurrentWordPosition--;					
				}
				else{
					intCurrentWordPosition = intSpecWordCount-1;
				}	
				intWordID=arrSpecList[intCurrentWordPosition];
			}
			displayWordDetails(intWordID);
		}
		public void NextWord(View v){
			if(strList.equalsIgnoreCase("Main List")){
				if(intWordID<intWordsCount){
					intWordID++;
				}
				else{
					intWordID = 1;
				}
			}
			else{
				Log.i("Next clicked", String.valueOf(intCurrentWordPosition));
				if(intCurrentWordPosition<intSpecWordCount-1){
					intCurrentWordPosition++;					
				}
				else{
					intCurrentWordPosition = 0;
				}
				Log.i("incremented ... new position is ", String.valueOf(intCurrentWordPosition));
				intWordID=arrSpecList[intCurrentWordPosition];
				Log.i("incremented ... new word id is  ", String.valueOf(intWordID));				
			}
			displayWordDetails(intWordID);
		}
		
		public void displayWordDetails(int intWordID){
			String[] arrWordDetails= getWordDetails(intWordID);
			//tvWord = (TextView) findViewById(R.id.wordDetail_View);
			
			Log.i("Sumit Jain", arrWordDetails[0]);
			Log.i("Sumit Jain", arrWordDetails[1]);
			Log.i("Sumit Jain", arrWordDetails[2]);
			TextView tvWord = (TextView)findViewById(R.id.wordDetail_View);
			tvWord.setText(arrWordDetails[0]);
			//wtv.setText(String.valueOf(intWordsCount));
			
			TextView tvSentence = (TextView)findViewById(R.id.sentenceDetail_View);
			 tvSentence.setText(arrWordDetails[2]);
			
			TextView tvMeaning = (TextView)findViewById(R.id.meaningDetail_View);
			tvMeaning.setText(arrWordDetails[1]);
		}
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.display_all_lists, menu);
		return true;		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.add_word:
	        	//addWordsToList();
	            return true;
	        case R.id.MyList:
	        		if (OPERATION.equalsIgnoreCase("ADD")){
	        		//final WordPowerOpenHelper wp1 = new WordPowerOpenHelper(this, "WordPower18.db", null, 1);
	            	cf.addWordsToList(this,1,intWordID);
	            	//Toast.makeText(this, "The Word is added to My List", 0).show();
	        		//addWordsToList(1);
	        		//wp1.close();
	        		}
//	        		else if (OPERATION.equalsIgnoreCase("REMOVE")){
//	        			removeWordsFromList(1);
//	        		}
	        		return true;
	        case R.id.LearningList:
        		if (OPERATION.equalsIgnoreCase("ADD")){
        		//final WordPowerOpenHelper wp1 = new WordPowerOpenHelper(this, "WordPower18.db", null, 1);
            	cf.addWordsToList(this,2,intWordID);
            	//Toast.makeText(this, "The Word is added to Learning List", 0).show();
            //	wp1.close();
        		}
//        		else if (OPERATION.equalsIgnoreCase("REMOVE")){
//        			removeWordsFromList(2);
//        		}
	        	return true;
		default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	/*
	public void ShowAllLists(Menu menu){
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.add_word_to_list, menu);
		return true;
	}
	*/
	
	public void displayListMenuAdd(View v){
		Log.i("Add button is clicked",strList);
		if(strList.equalsIgnoreCase("My List")||strList.equalsIgnoreCase("Learning List")){
			if(strList.equalsIgnoreCase("MyList")){
				cf.addWordsToList(this,2,intWordID);
			}
			else{
				cf.addWordsToList(this,1,intWordID);
			}
		}
		else{
			openOptionsMenu();
			OPERATION = "ADD";
		}		
	}
	
	public void displayListMenuRemove(View v){
		//openOptionsMenu();
		//OPERATION = "REMOVE";
		if (strList.equalsIgnoreCase("My list")){
			cf.removeWordsFromList(this,1,intWordID);
			onBackPressed();
		}
		else if (strList.equalsIgnoreCase("Learning list")){
			cf.removeWordsFromList(this,2,intWordID);
			onBackPressed();
		}
		else if (strList.equalsIgnoreCase("Tough list")){
			cf.removeWordsFromList(this,3,intWordID);
			onBackPressed();
		}
	}
	
	public void addWordsToList(Integer intListNo){
					
		final WordPowerOpenHelper wp = new WordPowerOpenHelper(this, cf.DBName, null, 1);
		Log.i("Common Functions", "DB connection is open and values are " + intListNo + " and Word id is " + intWordID);
		wp.addWordToList(intWordID, intListNo);
		Toast.makeText(this, "The word is added to " + strList,0).show();
		
	}
	
}
