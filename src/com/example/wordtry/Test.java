package com.example.wordtry;

import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Test extends MainActivity {
	
	public String strList = "MainList";
	public String strSequence = "Order";
	public int intWordID;
	public int intGRPId;
	public int RandomWordIndexCounter;
	public int[] RandomWords;
	public String strCountQuery;
	public int intWordsCount=0;
	public WordPowerOpenHelper wp;
	public TextView wtv =null;
	public TextView mtv=null;
	public TextView stv=null;
	public int [] arrSpecList;
	public  int intSpecWordCount;
	public int intStartingWordPosition;
	public CommomFunctions cf;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test);
		
		cf = new CommomFunctions(this);
		Log.i("Black Screen", cf.DBName);
		wp = new WordPowerOpenHelper(this, cf.DBName, null, 1);
		strCountQuery = "select Count(*) as Count from mainwordlist";
				
		intWordsCount= cf.getRecordCount(strCountQuery,wp);
		
		Intent intent = getIntent();
		
		if(intent.getStringExtra(TestSetting.TESTLIST).equalsIgnoreCase("My List")||intent.getStringExtra(TestSetting.TESTLIST).equalsIgnoreCase("Learning List")||intent.getStringExtra(TestSetting.TESTLIST).equalsIgnoreCase("Tough List")){
			
			if(intent.getStringExtra(TestSetting.TESTLIST).equalsIgnoreCase("My List")){
				strList = "My List";
				intGRPId = 1;
				//btn_REMOVE.setVisibility(View.VISIBLE);
			}
			else if(intent.getStringExtra(TestSetting.TESTLIST).equalsIgnoreCase("Learning List")){
				strList = "Learning List";
				intGRPId = 2;
				//btn_REMOVE.setVisibility(View.VISIBLE);
			}
			else if(intent.getStringExtra(TestSetting.TESTLIST).equalsIgnoreCase("Tough List")){
				strList = "Tough List";
				intGRPId = 3;
				//btn_REMOVE.setVisibility(View.VISIBLE);
			}
			intSpecWordCount= cf.getRecordCount("select Count(*) as Count from mainwordlist where _ID in (select mainid from Mapping where GroupID ="+ intGRPId +")",wp);
			arrSpecList = new int[intSpecWordCount];
			Log.i("Total words in Spec List", String.valueOf(intSpecWordCount));
			int intTemp=-1;
			Cursor csr = wp.getAllWords("select * from mainwordlist where _ID in (select mainid from Mapping where GroupID ="+ intGRPId +")");
			if (csr.moveToFirst()){
				do{						
					int ID = csr.getInt(0);					
					intTemp++;
					arrSpecList[intTemp]=ID;
					Log.i("My List word ID", String.valueOf(ID));
					Log.i("Entry in arrSpec at "+ intTemp , String.valueOf(ID));
				}while(csr.moveToNext());
			}
			csr.close();
		}
		else{
			strList = "Main List";
			//btn_REMOVE.setVisibility(View.INVISIBLE);			
		}	
		String strTemp2 = intent.getStringExtra(TestSetting.TESTORDER);
		Log.i("Test Order",strTemp2);
		if(strList.equalsIgnoreCase("Main List")){
			if (strTemp2.equalsIgnoreCase("Ordered") ){
				intWordID = 1;	
				strSequence = "Order";
			}
			else{
				Log.i("Check point","1");
				RandomWordIndexCounter =0;
				RandomWords = cf.getRandomList(intWordsCount);
				Log.i("Check point","2");
				Log.i("now here, array vlaue ",String.valueOf(RandomWords[RandomWordIndexCounter]));
				intWordID = (Integer) RandomWords[RandomWordIndexCounter];
				Log.i("Check point","3");
				strSequence = "Random";
			}
		}
		else{
			if (strTemp2.equalsIgnoreCase("Ordered") ){
				intStartingWordPosition = 0;
				intWordID = arrSpecList[intStartingWordPosition];
				strSequence = "Order";
			}
			else{
				RandomWordIndexCounter =0;
				RandomWords = cf.getRandomList(intSpecWordCount);
				Log.i("now here, array vlaue ",String.valueOf(arrSpecList[(Integer) RandomWords[RandomWordIndexCounter]-1]));
				intWordID = arrSpecList[(Integer) RandomWords[RandomWordIndexCounter]-1];
				strSequence = "Random";
			}
		}
		String[] arrWordDetails= cf.getWordDetails(intWordID,wp);
				
		wtv = (TextView) findViewById(R.id.wordDetail_View);
		wtv.setText(arrWordDetails[0]);
		
		mtv = (TextView) findViewById(R.id.meaningDetail_View);  // Remember this meaning and sentence are working Opposite,,,, couldnt find why
		mtv.setText(arrWordDetails[1]);
		
		stv = (TextView) findViewById(R.id.sentenceDetail_View); // Remember this meaning and sentence are working Opposite,,,, couldnt find why
		stv.setText(arrWordDetails[2]);
	}
	
	
	
	public int getRecordCount(String strQuery){
		
		int intTemp = 0;		
		Cursor csr = wp.getAllWords(strQuery);
		if(csr.moveToFirst()){
		intTemp = csr.getInt(csr.getColumnIndex("Count"));
		}
		csr.close();		
		return intTemp;
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
	
	
	/*
	public Object[] getRandomList(int number){
		Log.i("no of words", String.valueOf(number));
		HashSet<Integer> randomSet = new HashSet<Integer>();
		int counter = 0;
		int tempNum;
		while(counter < 4){
			tempNum = 1 + (int)(Math.random()*number);
			//Log.i("random no found",String.valueOf(tempNum));
			if(tempNum > number)
				tempNum--;
			if(randomSet.add(tempNum)){
				counter++;
				Log.i("random no added",String.valueOf(tempNum));
			}
		}
		Log.i("Counter11111", String.valueOf(counter));
		
		int tempSize = randomSet.size();
		int [] arrRandom = new int [tempSize];
		int tempCounter =0;
		for(Integer val : randomSet){
			arrRandom[tempCounter++]=val;
			Log.i("Entry in array :" ,String.valueOf( val));
		}
		/*
		Iterator itr = randomSet.iterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next());
            arrRandom[tempCounter]=(Integer) itr.next();
            tempCounter++;
        }
        
		Object[] arrRandomWords = randomSet.toArray();
		
		Log.i("Values of Array", String.valueOf(arrRandomWords[0]) + "  " + String.valueOf(arrRandomWords[1]) + "  " + String.valueOf(arrRandomWords[2]) + "  " + String.valueOf(arrRandomWords[3]));
		Log.i("Values of Array", String.valueOf(arrRandom[0]) + "  " + String.valueOf(arrRandom[1]) + "  " + String.valueOf(arrRandom[2]) + "  " + String.valueOf(arrRandom[3]));
		//Log.i("Array size", String.valueOf(arrRandom.length));
		return arrRandomWords;
	}
	*/
	
	public void displayNextWord(View v){
		
			mtv.setVisibility(View.INVISIBLE);
			stv.setVisibility(View.INVISIBLE);
			if(strList.equalsIgnoreCase("Main List")){
				if (strSequence.equalsIgnoreCase("Order") ){
					if (intWordID <intWordsCount){ 
						intWordID++;		
						}
					else{
						intWordID=1;
					}
				}
				else if  (strSequence.equalsIgnoreCase("Random") ){
					if (RandomWordIndexCounter <intWordsCount-1){ 
						RandomWordIndexCounter++;								
						}
					else{
						RandomWordIndexCounter=0;
					}
					intWordID = (Integer) RandomWords[RandomWordIndexCounter];
				}
			}
			else{
				if (strSequence.equalsIgnoreCase("Order") ){
					if (intStartingWordPosition <intSpecWordCount-1){ 
						intStartingWordPosition++;							
						}
					else{
						intStartingWordPosition=0;
					}
					intWordID = arrSpecList[intStartingWordPosition];
				}
				else if  (strSequence.equalsIgnoreCase("Random") ){
					if (RandomWordIndexCounter <intSpecWordCount-1){ 
						RandomWordIndexCounter++;
						}	
					else{
						RandomWordIndexCounter=0;
					}
					intWordID = arrSpecList[(Integer) RandomWords[RandomWordIndexCounter]-1];		
				}
			}
		displayWordDetails(intWordID);
	}
	
	public void displayPreviousWord(View v){
		mtv.setVisibility(View.VISIBLE);
		stv.setVisibility(View.VISIBLE);
		if(strList.equalsIgnoreCase("Main List")){
			if (strSequence.equalsIgnoreCase("Order") ){
				if (intWordID >1){ 
				intWordID--;		
				}
				else{
					intWordID =intWordsCount;
				}
			}
			else if  (strSequence.equalsIgnoreCase("Random") ){
				if (RandomWordIndexCounter >0){ 
					RandomWordIndexCounter--;						
				}
				else{
					RandomWordIndexCounter = intWordsCount-1;
				}
				intWordID = (Integer) RandomWords[RandomWordIndexCounter];	
			}
		}
		else{
			if (strSequence.equalsIgnoreCase("Order") ){
				if (intStartingWordPosition >0){ 
					intStartingWordPosition--;		
				}
				else{
					intStartingWordPosition = intSpecWordCount-1;
				}	
				intWordID = arrSpecList[intStartingWordPosition];
			}
			else if  (strSequence.equalsIgnoreCase("Random") ){
				if (RandomWordIndexCounter >0){ 
					RandomWordIndexCounter--;
				}
				else{
					RandomWordIndexCounter = intSpecWordCount-1;
				}
				intWordID = arrSpecList[(Integer) RandomWords[RandomWordIndexCounter]-1];	
			}
		}
		displayWordDetails(intWordID);
	}
	
	public void displayWordDetails(int intWordID){
		String[] arrWordDetails= cf.getWordDetails(intWordID,wp);
		wtv = (TextView) findViewById(R.id.wordDetail_View);
		wtv.setText(arrWordDetails[0]);
		//wtv.setText(String.valueOf(intWordsCount));
		
		stv = (TextView) findViewById(R.id.sentenceDetail_View); // Remember this meaning and sentence are working Opposite,,,, couldnt find why
		stv.setText(arrWordDetails[1]);
		
		mtv = (TextView) findViewById(R.id.meaningDetail_View); // Remember this meaning and sentence are working Opposite,,,, couldnt find why
		mtv.setText(arrWordDetails[2]);	
	}
	
	public void display_all(View v){
		mtv.setVisibility(0);
		stv.setVisibility(0);
	}
	
	public void displayHint(View v){
		mtv.setVisibility(0);
		//stv.setVisibility(0);
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
	        
	        case R.id.MyList:	
	        		cf.addWordsToList(this,1,intWordID);	
	        		//Toast.makeText(this, "The Word is added to My List", 0).show();
	            	return true;
	        case R.id.LearningList:
	        	cf.addWordsToList(this,2,intWordID);
	        	//Toast.makeText(this, "The Word is added to Learning List", 0).show();
	        	return true;
		default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	public void displayListMenuAdd(View v){
		openOptionsMenu();		
	}


	
}