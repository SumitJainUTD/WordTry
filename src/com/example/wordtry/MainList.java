package com.example.wordtry;

import java.util.ArrayList;
import java.util.Iterator;

import android.app.Activity;
import android.app.ListActivity;
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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainList extends Activity {
	WordAdapter wordAdapter;
	public final static String W_ID = "com.example.wordtry.MainList.ID";
	public final static String WORD_D = "com.example.wordtry.MainList.WORD";
	public final static String MEANING_D = "com.example.wordtry.MainList.MEANING";
	public final static String SENTENCE_D = "com.example.wordtry.MainList.SENTENCE";
	public final static String WORD_LIST = "com.example.wordtry.MainList.LIST";
	public final static String WORDS_COUNT = "com.example.wordtry.MainList.WORDS.COUNT";
	public WordPowerOpenHelper wp;
	public String strListName;
	public String strQuery;
	public static ListView listview;
	public CheckBox chkBx;
	public CommomFunctions cf;
	public static ArrayList<String> listOfItems;
	

	
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainlist_withmenu);
		
		 listview = (ListView) findViewById(R.id.word_list);
		
		 chkBx = (CheckBox)findViewById(R.id.checkBox_multiWords);
		 cf = new CommomFunctions(this);
		Intent intent = getIntent();
		//strListName = intent.getStringExtra(MainActivity.LISTNAME);
		listOfItems = new ArrayList<String>();
		strListName = intent.getStringExtra(Select_Alphabet.LISTNAME);
		Log.i("HELP", strListName);
		if (strListName.equalsIgnoreCase("MasterWordList_A") ){
			Log.i(strListName, "Successfully Reached Here");
			strQuery ="Select * from mainwordlist where Word LIKE  'a%'";
		}
		if (strListName.equalsIgnoreCase("MasterWordList_B") ){
			Log.i(strListName, "Successfully Reached Here");
			strQuery ="Select * from mainwordlist where Word LIKE  'b%'";
		}if (strListName.equalsIgnoreCase("MasterWordList_C") ){
			Log.i(strListName, "Successfully Reached Here");
			strQuery ="Select * from mainwordlist where Word LIKE  'c%'";
		}if (strListName.equalsIgnoreCase("MasterWordList_D") ){
			Log.i(strListName, "Successfully Reached Here");
			strQuery ="Select * from mainwordlist where Word LIKE  'd%'";
		}if (strListName.equalsIgnoreCase("MasterWordList_E") ){
			Log.i(strListName, "Successfully Reached Here");
			strQuery ="Select * from mainwordlist where Word LIKE  'e%'";
		}if (strListName.equalsIgnoreCase("MasterWordList_F") ){
			Log.i(strListName, "Successfully Reached Here");
			strQuery ="Select * from mainwordlist where Word LIKE  'f%'";
		}if (strListName.equalsIgnoreCase("MasterWordList_G") ){
			Log.i(strListName, "Successfully Reached Here");
			strQuery ="Select * from mainwordlist where Word LIKE  'g%'";
		}if (strListName.equalsIgnoreCase("MasterWordList_H") ){
			Log.i(strListName, "Successfully Reached Here");
			strQuery ="Select * from mainwordlist where Word LIKE  'h%'";
		}if (strListName.equalsIgnoreCase("MasterWordList_I") ){
			Log.i(strListName, "Successfully Reached Here");
			strQuery ="Select * from mainwordlist where Word LIKE  'i%'";
		}if (strListName.equalsIgnoreCase("MasterWordList_J") ){
			Log.i(strListName, "Successfully Reached Here");
			strQuery ="Select * from mainwordlist where Word LIKE  'j%'";
		}if (strListName.equalsIgnoreCase("MasterWordList_K") ){
			Log.i(strListName, "Successfully Reached Here");
			strQuery ="Select * from mainwordlist where Word LIKE  'k%'";
		}if (strListName.equalsIgnoreCase("MasterWordList_L") ){
			Log.i(strListName, "Successfully Reached Here");
			strQuery ="Select * from mainwordlist where Word LIKE  'l%'";
		}if (strListName.equalsIgnoreCase("MasterWordList_M") ){
			Log.i(strListName, "Successfully Reached Here");
			strQuery ="Select * from mainwordlist where Word LIKE  'm%'";
		}if (strListName.equalsIgnoreCase("MasterWordList_N") ){
			Log.i(strListName, "Successfully Reached Here");
			strQuery ="Select * from mainwordlist where Word LIKE  'n%'";
		}if (strListName.equalsIgnoreCase("MasterWordList_O") ){
			Log.i(strListName, "Successfully Reached Here");
			strQuery ="Select * from mainwordlist where Word LIKE  'o%'";
		}if (strListName.equalsIgnoreCase("MasterWordList_P") ){
			Log.i(strListName, "Successfully Reached Here");
			strQuery ="Select * from mainwordlist where Word LIKE  'p%'";
		}if (strListName.equalsIgnoreCase("MasterWordList_Q") ){
			Log.i(strListName, "Successfully Reached Here");
			strQuery ="Select * from mainwordlist where Word LIKE  'q%'";
		}if (strListName.equalsIgnoreCase("MasterWordList_R") ){
			Log.i(strListName, "Successfully Reached Here");
			strQuery ="Select * from mainwordlist where Word LIKE  'r%'";
		}if (strListName.equalsIgnoreCase("MasterWordList_S") ){
			Log.i(strListName, "Successfully Reached Here");
			strQuery ="Select * from mainwordlist where Word LIKE  's%'";
		}if (strListName.equalsIgnoreCase("MasterWordList_T") ){
			Log.i(strListName, "Successfully Reached Here");
			strQuery ="Select * from mainwordlist where Word LIKE  't%'";
		}if (strListName.equalsIgnoreCase("MasterWordList_U") ){
			Log.i(strListName, "Successfully Reached Here");
			strQuery ="Select * from mainwordlist where Word LIKE  'u%'";
		}if (strListName.equalsIgnoreCase("MasterWordList_V") ){
			Log.i(strListName, "Successfully Reached Here");
			strQuery ="Select * from mainwordlist where Word LIKE  'v%'";
		}if (strListName.equalsIgnoreCase("MasterWordList_W") ){
			Log.i(strListName, "Successfully Reached Here");
			strQuery ="Select * from mainwordlist where Word LIKE  'w%'";
		}if (strListName.equalsIgnoreCase("MasterWordList_X") ){
			Log.i(strListName, "Successfully Reached Here");
			strQuery ="Select * from mainwordlist where Word LIKE  'x%'";
		}if (strListName.equalsIgnoreCase("MasterWordList_Y") ){
			Log.i(strListName, "Successfully Reached Here");
			strQuery ="Select * from mainwordlist where Word LIKE  'y%'";
		}if (strListName.equalsIgnoreCase("MasterWordList_Z") ){
			Log.i(strListName, "Successfully Reached Here");
			strQuery ="Select * from mainwordlist where Word LIKE  'z%'";
		}else if (strListName.equalsIgnoreCase("MyList")){
			strQuery = "select * from mainwordlist where _id in (select mainid from Mapping where GroupID =1)";
			(findViewById(R.id.AddToMyList_ListView)).setVisibility(View.INVISIBLE);			
			(findViewById(R.id.AddToLearningList_Listview)).setVisibility(View.VISIBLE);
		}
		else if (strListName.equalsIgnoreCase("LearningList")){
			strQuery = "select * from mainwordlist where _id in (select mainid from Mapping where GroupID =2)";
			(findViewById(R.id.AddToMyList_ListView)).setVisibility(View.VISIBLE);			
			(findViewById(R.id.AddToLearningList_Listview)).setVisibility(View.INVISIBLE);
		}
		else if (strListName.equalsIgnoreCase("ToughList")){
			strQuery = "select * from mainwordlist where _id in (select mainid from Mapping where GroupID =3)";
		}
		cf.cfListView = listview;
		
		wp = new WordPowerOpenHelper(this, cf.DBName, null, 1);
		
		Cursor csr = wp.getAllWords(strQuery);
		
		Log.i("com.example.wordtry","Cursor returned");
//		
		wordAdapter = new WordAdapter(this,csr);
		
		//listview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		listview.setAdapter(wordAdapter);
		listview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		//listview.getAdapter().
		
		//initialize all the check box status as false
				
		 

//		CheckBox box = (CheckBox)findViewById(R.id.checkBox_multiWords);
//		
//		chkBx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//			
//			@Override
//			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//				// TODO Auto-generated method stub
//				if(isChecked){
//					Log.i("com.example.wordtry.checkPoint","2905_1018");
//				}
//			}
//		});
		
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			//
			String strWord;
			Integer intID;
			String strMeaning;
			String strSentence;
			@Override
			public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
					long id) {
				// TODO Auto-generated method stub
				//Toast.makeText(this, "yessss", "LENGTH_SHORT").show();
				//LinearLayout temp = (LinearLayout)itemClicked;
				//TableLayout temp = (TableLayout)itemClicked;
				Log.i("com.example.wordtry.checkPoint","2606_1244");
				TableLayout temp = (TableLayout)itemClicked;
				int x = temp.getChildCount();
				Log.i("com.example.wordtry.ChildCount",String.valueOf(x));
				TableRow tr = (TableRow) temp.getChildAt(0);
				Log.i("com.example.wordtry.RowChildCount",String.valueOf(tr.getChildCount()));
				TextView tvp = (TextView)tr.getChildAt(0);
				Log.i("com.example.wordtry.CheckPoint","2606_1254");
				//TableRow tvp = (TableRow)temp.getChildAt(0);
				//tvp.get
				String strClickedWord = tvp.getText().toString();
				Log.i("com.example.wordtry",strClickedWord);
				Cursor csr = wp.getAllWords("Select * from mainwordlist where Word = '"+ strClickedWord+"'");
				Log.i("com.example.wordtry","Cursor returned");
				if (csr.moveToFirst()){
					//do
						//
						 intID= csr.getInt(0);
						 strWord = csr.getString(1);
						 strMeaning = csr.getString(2);
						 strSentence = csr.getString(3);
						Log.i("com.example.wordtry", strWord);
						Log.i("com.example.wordtry", String.valueOf(intID));
						Log.i("com.example.wordtry", strMeaning);
						Log.i("com.example.wordtry", strSentence);
					//}while(csr.moveToNext());
				}
				csr.close();
				wp.close();
				Intent intent = new Intent(MainList.this,WordDetails.class);
				intent.putExtra(W_ID,intID);
				intent.putExtra(WORD_D, strWord);
				intent.putExtra(MEANING_D, strMeaning);
				intent.putExtra(SENTENCE_D, strSentence);
				intent.putExtra(WORD_LIST, strListName);
				startActivity(intent);
				
			}
		});
		
	}


	
	@Override
	protected void onResume(){
		super.onResume();
		Cursor csr = wp.getAllWords(strQuery);		
		wordAdapter = new WordAdapter(this,csr);
		listview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		listview.setAdapter(wordAdapter);
	}
	
	public void diplayHomePage(View v){
		//cf.goHome(getApplicationContext());
		Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
	    startActivity(mainIntent);
	}
	
	public void addToLearningListBulk(View v){
		int addedWordsCount=0;
		Iterator iterator = (Iterator) listOfItems.iterator();
        while (iterator.hasNext()) {
          String strClickedWord = (String) iterator.next();
          Log.i("com.example.wordtry",strClickedWord);
        	
			Cursor csr = wp.getAllWords("Select * from mainwordlist where Word = '"+ strClickedWord+"'");
			Log.i("com.example.wordtry","Cursor returned");
              	
				if (csr.moveToFirst()){
					int intID= csr.getInt(0);
					Log.i("com.example.wordtry Words", csr.getString(1));
					cf.addWordsToListBulk(this, 2, intID);
					addedWordsCount++;
				}
  				csr.close();
  				wp.close();
  				
  }
          listOfItems.clear();
          if(addedWordsCount==0){
        	  cf.ShowToast(this, "Please select words", 0);
          }
          else if(addedWordsCount>1){
        	  cf.ShowToast(this, String.valueOf(addedWordsCount) + " words are added to Learning List", 0);
          }
          else{
        	  cf.ShowToast(this, String.valueOf(addedWordsCount) + " word is added to Learning List", 0);
          }
          
          	cf.clearAllCheckBoxes(v.getRootView());
          	listOfItems.clear();
  			//finish();
  			//startActivity(getIntent());
          

	}
	public void addToMyListBulk(View v){
		int addedWordsCount=0;
		Iterator iterator = (Iterator) listOfItems.iterator();
        while (iterator.hasNext()) {
          String strClickedWord = (String) iterator.next();
          Log.i("com.example.wordtry",strClickedWord);
        	
			Cursor csr = wp.getAllWords("Select * from mainwordlist where Word = '"+ strClickedWord+"'");
			Log.i("com.example.wordtry","Cursor returned");
              	
				if (csr.moveToFirst()){
					int intID= csr.getInt(0);
					Log.i("com.example.wordtry Words", csr.getString(1));
					cf.addWordsToListBulk(this, 1, intID);
					addedWordsCount++;
				}
  				csr.close();
  				wp.close();
  				
  }
          listOfItems.clear();
          if(addedWordsCount==0){
        	  cf.ShowToast(this, "Please select words", 0);
          }
          else if(addedWordsCount>1){
        	  cf.ShowToast(this, String.valueOf(addedWordsCount) + " words are added to My List", 0);
          }
          else{
        	  cf.ShowToast(this, String.valueOf(addedWordsCount) + " word is added to My List", 0);
          }
          
          	cf.clearAllCheckBoxes(v.getRootView());
          	listOfItems.clear();
  			//finish();
  			//startActivity(getIntent());
          
	}
	
	public void clearAll(View v){
		cf.clearAllCheckBoxes(v.getRootView());
		listOfItems.clear();
		wordAdapter.notifyDataSetChanged();
		listview.setAdapter(wordAdapter);
		//finish();
		//startActivity(getIntent());
		//ListView list = L
	}
	
	public void onBackPressed() {

		if(strListName.equalsIgnoreCase("MyList")||strListName.equalsIgnoreCase("LearningList")||strListName.equalsIgnoreCase("ToughList")){
	    Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
	    startActivity(mainIntent);
	    Log.i("Back pressed","Refresh it");
	    return;
		}
		else{
			Intent mainIntent = new Intent(getApplicationContext(), Select_Alphabet.class);
		    startActivity(mainIntent);
		    return;
		}
			
	}   
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.mail_list_menu, menu);
		return true;		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection		
	    switch (item.getItemId()) {
	        case R.id.select_words:
//	        	CheckBox cb;
//	            ListView mainListView = listview;
//	            Log.i("x<mainListView.getChildCount()",String.valueOf(mainListView.getChildCount()));
//	            for (int x = 0; x<mainListView.getChildCount();x++){
//	                cb = (CheckBox)mainListView.getChildAt(x).findViewById(R.id.checkBox_multiWords);
//	                //if(cb.isChecked()){
//	                Log.i("CheckBoxxxxxxx","Checked");	                	
//                	TableLayout tl = (TableLayout)mainListView.getChildAt(x);;
////    				int x = temp.getChildCount();
////    				Log.i("com.example.wordtry.ChildCount",String.valueOf(x));
//    				TableRow tr1 = (TableRow) tl.getChildAt(x);
//    				Log.i("com.example.wordtry.RowChildCount",String.valueOf(tr1.getChildCount()));
//    				TextView tvp = (TextView)tr1.getChildAt(x);
//    				Log.i("com.example.wordtry.CheckPoint","2606_1254");
//    				//TableRow tvp = (TableRow)temp.getChildAt(0);
//    				//tvp.get
//    				String strClickedWord = tvp.getText().toString();
//    				Log.i("com.example.wordtry",strClickedWord);
//        	
	        Iterator iterator = (Iterator) listOfItems.iterator();
	          while (iterator.hasNext()) {
                String strClickedWord = (String) iterator.next();
                Log.i("com.example.wordtry",strClickedWord);
	          	
				Cursor csr = wp.getAllWords("Select * from mainwordlist where Word = '"+ strClickedWord+"'");
				Log.i("com.example.wordtry","Cursor returned");
	                	
    				if (csr.moveToFirst()){
    					int intID= csr.getInt(0);
    					Log.i("com.example.wordtry Words", csr.getString(1));
    					cf.addWordsToList(this, 1, intID);
    				}
	    				csr.close();
	    				wp.close();
	              //}
	    
	                //break;
	    }
	            listOfItems.clear();
	            return true;
		default:
	            return super.onOptionsItemSelected(item);
	            
	    }
	}
}


