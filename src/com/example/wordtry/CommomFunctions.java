package com.example.wordtry;

import android.app.AlertDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class CommomFunctions extends MainActivity {
	
	public String strList;
	public Context cxt;
	public String DBName;
	public ListView cfListView;
	public CommomFunctions(){
		
	}
	
	public CommomFunctions( Context cxt){
		this.cxt = cxt;
		DBName = "WordPower30.db";
	}

	public void addWordsToList(Context cxt, int intListNo, int intWordID){
		Log.i("Common Functions", "Add word to list");
		switch(intListNo){
		case 1:
			strList = "My List";
			break;
		case 2:
			strList = "Learning List";
			break;
		case 3:
			strList = "Tough List";
			break;
		}			
		final WordPowerOpenHelper wp = new WordPowerOpenHelper(cxt, DBName, null, 1);
		Log.i("Common Functions", "DB connection is open and values are " + intListNo + " and Word id is " + intWordID);
		if(blnWordAlreadyExist(intWordID,intListNo,wp)){
			ShowToast(cxt, "Already Added", 0);
		}
		else{
			wp.addWordToList(intWordID, intListNo);
			ShowToast(cxt, "The Word is added to "+ strList, 0);
		}
		
		//Toast.makeText(this, "The word is added",0).show();
		
	}
	
	public void addWordsToListBulk(Context cxt, int intListNo, int intWordID){
		Log.i("Common Functions", "Add word to list");
		switch(intListNo){
		case 1:
			strList = "My List";
			break;
		case 2:
			strList = "Learning List";
			break;
		case 3:
			strList = "Tough List";
			break;
		}			
		final WordPowerOpenHelper wp = new WordPowerOpenHelper(cxt, DBName, null, 1);
		Log.i("Common Functions", "DB connection is open and values are " + intListNo + " and Word id is " + intWordID);
		if(blnWordAlreadyExist(intWordID,intListNo,wp)){
			//ShowToast(cxt, "Already Added", 0);
		}
		else{
			wp.addWordToList(intWordID, intListNo);
			//ShowToast(cxt, "The Word is added to"+ strList, 0);
		}
		
		//Toast.makeText(this, "The word is added",0).show();
		
	}
	
	
	public boolean blnWordAlreadyExist(int intWORDID, int intGrpId,WordPowerOpenHelper wp ){
		String strQuery = "Select Count(*) as Count from (select * from mainwordlist where _ID in (select mainid from Mapping where GroupID ="+ intGrpId +")) where _ID = "+ intWORDID;
		//Cursor csr = wp.getAllWords(strQuery);
		//if(csr.getCount()==0){
		if(getRecordCount(strQuery, wp)==0){
			return false;
		}
		else return true;
	}

	public void removeWordsFromList(Context cxt, int intListNo, int intWordID){
		Log.i("Common Functions", "Remove word from list");
		switch(intListNo){
		case 1:
			strList = "My List";
		case 2:
			strList = "Learning List";
		case 3:
			strList = "Tough List";
		}
		final WordPowerOpenHelper wp = new WordPowerOpenHelper(cxt, DBName, null, 1);
		wp.deleteWordFromList(intWordID, intListNo);
		//Toast.makeText(this, "Deleted",0).show();
		this.finish();		
	}
	public void goHome(ContextWrapper cxt){
		Intent mainIntent = new Intent(cxt, MainActivity.class);
	    startActivity(mainIntent);
	}
	
	
	public int getRecordCount(String strQuery, WordPowerOpenHelper wp){		
		Log.i("Common Functions", "GET WORD COUNT");
		int intTemp = 0;		
		Cursor csr = wp.getAllWords(strQuery);
		if(csr.moveToFirst()){
		intTemp = csr.getInt(csr.getColumnIndex("Count"));
		}
		csr.close();		
		return intTemp;
	}
	
	public int[] getRandomList(int number){
		int[] arrTempR = new int[number];
		Log.i("no of words", String.valueOf(number));		
		int counter = 0;
		int tempNum;
		while(counter < number){
			tempNum = 1 + (int)(Math.random()*number);
			//Log.i("random no found",String.valueOf(tempNum));
			if(tempNum > number)
				tempNum--;
			if(checkExistance_getRandomList(arrTempR,tempNum)==false){
				arrTempR[counter]=tempNum;
				counter++;
				//Log.i("random no added",String.valueOf(tempNum));
			}
		}
		for (int i =0; i<arrTempR.length;i++){
			Log.i("Elements", String.valueOf(arrTempR[i]));
		}
		//Log.i("Array size", String.valueOf(arrRandom.length));
		return arrTempR;
	}
	
	public int[] getRandomListForExam(int number, int TotalWords){
		int[] arrTempR = new int[number];
		Log.i("no of words", String.valueOf(number));		
		int counter = 0;
		int tempNum;
		while(counter < number){
			tempNum = 1 + (int)(Math.random()*TotalWords);
			//Log.i("random no found",String.valueOf(tempNum));
			if(tempNum > TotalWords)
				tempNum--;
			if(checkExistance_getRandomList(arrTempR,tempNum)==false){
				arrTempR[counter]=tempNum;
				counter++;
				//Log.i("random no added",String.valueOf(tempNum));
			}
		}
		for (int i =0; i<arrTempR.length;i++){
			Log.i("Elements", String.valueOf(arrTempR[i]));
		}
		//Log.i("Array size", String.valueOf(arrRandom.length));
		return arrTempR;
	}
	
	public int[] getOptionsForWords(int TotalWords, int intWordID){
		int number =4;
		int[] arrTempR = new int[number];
		Log.i("no of words", String.valueOf(number));	
		arrTempR[0] = intWordID;
		int counter = 1;
		int tempNum;
		while(counter < number){
			tempNum = 1 + (int)(Math.random()*TotalWords);
			//Log.i("random no found",String.valueOf(tempNum));
			if(tempNum > TotalWords)
				tempNum--;
			if(checkExistance_getRandomList(arrTempR,tempNum)==false && tempNum!=intWordID ){
				arrTempR[counter]=tempNum;
				counter++;
				//Log.i("random no added",String.valueOf(tempNum));
			}
		}
		for (int i =0; i<arrTempR.length;i++){
			Log.i("Elements", String.valueOf(arrTempR[i]));
		}
		//Log.i("Array size", String.valueOf(arrRandom.length));
		return arrTempR;
	}
	
	public boolean checkExistance_getRandomList(int[] arrTemp, int val){
		//Log.i("Array size", String.valueOf(arrTemp.length));
		boolean blnResult = false;
		
		for(int i =0;i<arrTemp.length;i++ ){
			if(arrTemp[i]==val){
				blnResult=true;
				break;
			}
		}
		return blnResult;
		
	}
	
	public String[] getWordDetails(int intWordID,WordPowerOpenHelper wp){
		String[] arrWordDetails = new String[4];
		String strQuery = "select * from mainwordlist where _ID="+ intWordID ;
		Log.i("12 OCT 99999999999", "9999999999999999");
		Cursor csr = wp.getAllWords(strQuery);
		if (csr.moveToFirst()){
				 arrWordDetails[0] = csr.getString(1);//word
				 arrWordDetails[1] = csr.getString(2);  // meaning
				 arrWordDetails[2] = csr.getString(3); // sentence
				 arrWordDetails[3] = csr.getString(0); /// word id
				Log.i("12 OCT ", arrWordDetails[0]);
				Log.i("12 OCT ", arrWordDetails[1]);
				Log.i("12 OCT ", arrWordDetails[2]);
			//}while(csr.moveToNext());
		}
		csr.close();
		return arrWordDetails;	
	}
	
	public void ShowToast(Context cxt, String strMsg, int intDuration ){
		Toast.makeText(cxt, strMsg, intDuration).show();
	}

	public void ShowToast(OnClickListener onClickListener, String strMsg,
			int intDuration) {
		// TODO Auto-generated method stub
		
	}
	
	@SuppressWarnings("deprecation")
	public void ShowDialogOKButton(final Context cxt,final String strTitle, final String strMessage){
		
		final Handler handler = new Handler() {
	        @Override
	        public void handleMessage(Message mesg) {
	            throw new RuntimeException();
	        } 
	    };
		// TODO Auto-generated method stub
		AlertDialog ad = new AlertDialog.Builder(cxt).create();  
	    ad.setCancelable(false); // This blocks the 'BACK' button  
	    ad.setMessage(strMessage);  
	    ad.setTitle(strTitle);
	    ad.setButton("OK", new DialogInterface.OnClickListener() {  
	        @Override  
	        public void onClick(DialogInterface dialog, int which) {  
	            dialog.dismiss();         
	            handler.sendMessage(handler.obtainMessage());
	        }  
	    });  
	    ad.show();
	
	    try { Looper.loop(); }
	    catch(RuntimeException e2) {}
  
	}
	
	public void addDATAToStats_CF(Context cxt, String strListName, String strDate, int intNoOfQuestions,int intTotalMarks, int intCorrect, double dblPercentage){
		Log.i("Total Marks", String.valueOf(intTotalMarks));		
		final WordPowerOpenHelper wp = new WordPowerOpenHelper(cxt, DBName, null, 1);
		wp.addDataToStats_DB(strListName, strDate, intNoOfQuestions,intTotalMarks, intCorrect, dblPercentage);
		//ShowToast(cxt, "The Word is added to"+ strList, 0);
		}
		
		//Toast.makeText(this, "The word is added",0).show();
	
	public void clearAllCheckBoxes(View v){
		ListView mainListView = (ListView)v.findViewById(R.id.word_list);	
		
		
		if(mainListView==null){
			Log.i("006062014 99999999999", "NULLLLLLLLLLLLLLL");
		}
		CheckBox cb;    
		Log.i("006062014 99999999999", String.valueOf(mainListView.getAdapter().getCount()));
		for (int x = 0; x<mainListView.getAdapter().getCount();x++){
       	 //ViewGroup item = (ViewGroup)mainListView.getChildAt(x);
			TableLayout tL = (TableLayout)mainListView.getAdapter().getView(x, null, mainListView);//.findViewById(R.id.word_list);
			
			if(tL==null){
				Log.i("006062014 999988888888888888999", "NULLLLLLLLLLLLLLL");
			}
			
				//Log.i("TableLayout Count", String.valueOf(tL.getChildCount()));
			TableRow tR= (TableRow) tL.getChildAt(0);
			//Log.i("Table First Row Count", String.valueOf(tR.getChildCount()));
			TextView tvp = (TextView)tR.getChildAt(0);
			//Log.i("Text View Data", (String) tvp.getText());
			cb = (CheckBox) tR.getChildAt(1);
			//Log.i("CheckBox ID", String.valueOf(cb.getId()));
			//Log.i("Before CheckBox status", String.valueOf(cb.isChecked()));
			//TextView tvp1 = (TextView)tR.getChildAt(1);
			//Log.i("Checking this Text View Data", (String) tvp1.getText());
			

			//cb = (CheckBox) lv.findViewById(R.id.checkBox_multiWords);
			//cb = (CheckBox) mainListView.getChildAt(x).findViewById(R.id.checkBox_multiWords);
//       	cb = (CheckBox)item.findViewById(R.id.checkBox_multiWords);
			cb.setChecked(false);
			cb.refreshDrawableState();
			tR.refreshDrawableState();
			tL.refreshDrawableState();
			
			
			//Log.i("After CheckBox status", String.valueOf(cb.isChecked()));
//       	cb.refreshDrawableState();
       }
	
        Log.i("x<mainListView.getChildCount()",String.valueOf(mainListView.getChildCount()));
//        for (int x = 0; x<mainListView.getChildCount();x++){
//        	 ViewGroup item = (ViewGroup)mainListView.getChildAt(x);findViewById(R.id.checkBox_multiWords);
//        	cb = (CheckBox)item.findViewById(R.id.checkBox_multiWords);
//        	cb.setChecked(false);
//        	cb.refreshDrawableState();
//        }
		
	}
		
}

	


