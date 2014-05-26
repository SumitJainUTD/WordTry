package com.example.wordtry;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Exam extends MainActivity{
	
	public int intNoOfQuestions;
	public int intCurrentQuestionCounter;
	public WordPowerOpenHelper wp;
	public CommomFunctions cf;
	public String strList;
	public int RandomIndexCounter;
	public int[] arrRandomWords;
	public int[] arrRandomizeOptions;
	public int [] arrSpecList;
	public int[] arrOptions = new int[4];
	public int intGRPId;
	public int intWordID;
	public String strHint;
	public int intSpecWordCount;
	public TextView wtv;
	public TextView Opt1;
	public TextView Opt2;
	public TextView Opt3;
	public TextView Opt4;
	public TextView QuesNo;
	public TextView Score;
	public int intCorrectAnswer;
	public String strCorrectAnswer;
	public int intTotalWords;
	public int intCurrentQuestionScore=2;
	public int intScored=0;
	public int intTotalMarks;
	public Boolean blnHitUsed;
	public int intTotalPoint;
	public double percentage;
	public static final String STATSFROMEXAM = "com.example.wordtry.STATSEXAM";
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exam);
		Log.i("12 OCt ","3333333333333333333");
		RandomIndexCounter =0;
		cf = new CommomFunctions(this);
		Opt1 = (TextView) findViewById(R.id.Option_1);
		Opt2 = (TextView) findViewById(R.id.Option_2);
		Opt3 = (TextView) findViewById(R.id.Option_3);
		Opt4 = (TextView) findViewById(R.id.Option_4);
		Score = (TextView) findViewById(R.id.Score);
		QuesNo = (TextView) findViewById(R.id.QueNoNumber);
		
		wp = new WordPowerOpenHelper(this, "WordPower30.db", null, 1);
		Intent intent = getIntent();
		
		strList = intent.getStringExtra(ExamSetting.EXAMLIST);
		intNoOfQuestions = intent.getIntExtra(ExamSetting.EXAMNOQUESTIONS, 1);
		intTotalPoint = intNoOfQuestions*2;
		intTotalWords = intent.getIntExtra(ExamSetting.EXAMTOTALWORDSINSELECTEDLIST, 1);
		Log.i("12 OCT ","444444444444");
		Log.i("No Of Questions",String.valueOf(intNoOfQuestions));
		// = cf.getRandomList(intNoOfQuestions);
		Log.i("Check point",strList);
		if(strList.equalsIgnoreCase("My List")||strList.equalsIgnoreCase("Learning List")||strList.equalsIgnoreCase("Tough List")){
			
			if(strList.equalsIgnoreCase("My List")){
				strList = "My List";
				intGRPId = 1;
				//btn_REMOVE.setVisibility(View.VISIBLE);
			}
			else if(strList.equalsIgnoreCase("Learning List")){
				strList = "Learning List";
				intGRPId = 2;
				//btn_REMOVE.setVisibility(View.VISIBLE);
			}
			else if(strList.equalsIgnoreCase("Tough List")){
				strList = "Tough List";
				intGRPId = 3;
				//btn_REMOVE.setVisibility(View.VISIBLE);
			}
			Log.i("Check point", "4");
			intSpecWordCount= cf.getRecordCount("select Count(*) as Count from mainwordlist where _ID in (select mainid from Mapping where GroupID ="+ intGRPId +")",wp);
			arrSpecList = new int[intSpecWordCount];
			int intTemp=-1;
			Cursor csr = wp.getAllWords("select * from mainwordlist where _ID in (select mainid from Mapping where GroupID ="+ intGRPId +")");
			if (csr.moveToFirst()){
				do{						
					int ID = csr.getInt(0);					
					intTemp++;
					arrSpecList[intTemp]=ID;					
				}while(csr.moveToNext());
			}
			csr.close();
		}
		else{
			strList = "Main List";						
		}
		Log.i("Check point","13");
		if(strList.equalsIgnoreCase("Main List")){			
			Log.i("Check point","1");
			RandomIndexCounter =0;
			arrRandomWords = cf.getRandomListForExam(intNoOfQuestions,intTotalWords);
			Log.i("Check point","2");
			Log.i("now here, array vlaue ",String.valueOf(arrRandomWords[RandomIndexCounter]));
			intWordID = (Integer) arrRandomWords[RandomIndexCounter];
			Log.i("Check point","3");
			Log.i("Check point New 9 Aug",String.valueOf(intWordID));
		}
		else{
			RandomIndexCounter =0;
			arrRandomWords = cf.getRandomListForExam(intNoOfQuestions,intTotalWords);
			Log.i("now here, array vlaue ",String.valueOf(arrSpecList[(Integer) arrRandomWords[RandomIndexCounter]-1]));
			intWordID = arrSpecList[(Integer) arrRandomWords[RandomIndexCounter]-1];
		}
		
		displayDetails();
		QuesNo.setText(RandomIndexCounter+1+"/"+intNoOfQuestions);
		Score.setText(intScored+"/"+intTotalPoint);
		
		Opt1.setOnClickListener(new View.OnClickListener() {

	        @Override
	        public void onClick(View v) {
	        	Log.i("Check point","Option 1 is clicked");
	        	if (intCorrectAnswer==1){
	        		Log.i("CORRECT", " Option 1 is Correct");
	        		intScored = intScored + intCurrentQuestionScore;
	        		Score.setText(intScored+"/"+intTotalPoint);
	        		displayNext();
	        		
	        	}
	        	else{
	        		WrongAnswer();
	        	}
	        	
	        }
	    });
		
		Opt2.setOnClickListener(new View.OnClickListener() {

	        @Override
	        public void onClick(View v) {
	        	Log.i("Check point","Option 2 is clicked");
	        	if (intCorrectAnswer==2){
	        		Log.i("CORRECT", " Option 2 is Correct");
	        		intScored = intScored + intCurrentQuestionScore;
	        		Score.setText(intScored+"/"+intTotalPoint);
	        		displayNext();
	        	}
	        	else{
	        		WrongAnswer();
	        	}
	        	
	        }
	    });
		
		Opt3.setOnClickListener(new View.OnClickListener() {

	        @Override
	        public void onClick(View v) {
	        	Log.i("Check point","Option 3 is clicked");
	        	if (intCorrectAnswer==3){
	        		Log.i("CORRECT", " Option 3 is Correct");	    
	        		intScored = intScored + intCurrentQuestionScore;
	        		Score.setText(intScored+"/"+intTotalPoint);
	        		displayNext();
	        	}
	        	else{
	        		WrongAnswer();
	        	}
	        	
	        }
	    });
		
		Opt4.setOnClickListener(new View.OnClickListener() {

	        @Override
	        public void onClick(View v) {
	        	Log.i("Check point","Option 4 is clicked");
	        	if (intCorrectAnswer==4){
	        		Log.i("CORRECT", " Option 4 is Correct");	 
	        		intScored = intScored + intCurrentQuestionScore;
	        		Score.setText(intScored+"/"+intTotalPoint);
	        		displayNext();
	        	}
	        	else{
	        		WrongAnswer();
	        	}
	        	
	        }
	    });
	}	
	
	public void displayHint(View v){
		cf.ShowDialogOKButton(this, "Hint", strHint);
		intCurrentQuestionScore=1;
	}
	
	public void displayNext(){
		
		if(strList.equalsIgnoreCase("Main List")){			
			Log.i("Check point","1");
			RandomIndexCounter++;
			if(RandomIndexCounter<intNoOfQuestions){
				Log.i("now here, array vlaue ",String.valueOf(arrRandomWords[RandomIndexCounter]));
				intWordID = (Integer) arrRandomWords[RandomIndexCounter];
				Log.i("Check point","3");
				displayDetails();
				intCurrentQuestionScore=2;
			}
			else{
				ExamEnd();
			}
		}
		else{
			RandomIndexCounter++;
			if(RandomIndexCounter<intNoOfQuestions){
				Log.i("now here, array vlaue ",String.valueOf(arrSpecList[(Integer) arrRandomWords[RandomIndexCounter]-1]));
				intWordID = arrSpecList[(Integer) arrRandomWords[RandomIndexCounter]-1];
				displayDetails();
			}
			else{
				ExamEnd();
			}
			
		}
		
	}
	
	public void ExamEnd(){
		Toast.makeText(this, "Exam Over", 0).show();
		Date dte = new Date(); 
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy")  ;
		Log.i("Total Point ", String.valueOf(intTotalPoint) );  	
		Log.i("Total scored ", String.valueOf(intScored) );  	
		Log.i("division", String.valueOf(intScored/intTotalPoint));  	
		percentage = (intScored*100/intTotalPoint);
		Log.i("percentage Point ", String.valueOf(percentage) );  	
		cf.addDATAToStats_CF(this,strList, sdf.format(dte), intNoOfQuestions,intTotalPoint, intScored, percentage);
		Intent mainIntent = new Intent(getApplicationContext(), Stats.class);
		mainIntent.putExtra(STATSFROMEXAM, true);
	    startActivity(mainIntent);
	}
	
	public void WrongAnswer(){
		cf.ShowDialogOKButton(this, "INCORRECT", "Sorry, Its Incorrect, Correct Answer is: \n\n\n' " + strCorrectAnswer+" ' \n\n\n This Word will be added to Tough List");
		cf.addWordsToList(this,3,intWordID);		
		displayNext();		
	}	
	public void displayDetails(){
		Log.i("Check Point 5","5555555");
		String[] arrWordDetails= cf.getWordDetails(intWordID,wp);
		Log.i("Check Point 6","666666");
		wtv = (TextView) findViewById(R.id.wordExam_View);
		wtv.setText(arrWordDetails[0]);
		
		strHint = arrWordDetails[2];
		strCorrectAnswer = arrWordDetails[1];
		
		arrOptions = cf.getOptionsForWords(intTotalWords, intWordID);
		Log.i("12 OCT ","555555555555555");
		arrRandomizeOptions = cf.getRandomList(4);
		Log.i("12 OCT ","666666666666666666");
		
		String[] arrOptionDetails= cf.getWordDetails(arrOptions[arrRandomizeOptions[0]-1],wp);
		Log.i("12 OCT ","7777777777777");
		Log.i("12 OCT 8888888",arrOptionDetails[1]);
		Opt1.setText(arrOptionDetails[1]);
		Log.i("12 OCT 8888888",arrOptionDetails[3]);
		int Temp1 = Integer.parseInt( arrOptionDetails[3]);
		Log.i("12 OCT ","8888888888");
		arrOptionDetails= cf.getWordDetails(arrOptions[arrRandomizeOptions[1]-1],wp);
		Opt2.setText(arrOptionDetails[1]);
		int Temp2 = Integer.parseInt( arrOptionDetails[3]);
		Log.i("12 OCT ","9999999");
		arrOptionDetails= cf.getWordDetails(arrOptions[arrRandomizeOptions[2]-1],wp);
		Opt3.setText(arrOptionDetails[1]);
		int Temp3 = Integer.parseInt( arrOptionDetails[3]);
		Log.i("12 OCT ","99999");
		arrOptionDetails= cf.getWordDetails(arrOptions[arrRandomizeOptions[3]-1],wp);
		Opt4.setText(arrOptionDetails[1]);
		int Temp4 = Integer.parseInt( arrOptionDetails[3]);
		
		if (Temp1==intWordID){
			intCorrectAnswer =1;
		}
		else if (Temp2==intWordID){
			intCorrectAnswer =2;
		}
		else if (Temp3==intWordID){
			intCorrectAnswer =3;
		}
		else if (Temp4==intWordID){
			intCorrectAnswer =4;
		}
		
		QuesNo.setText(RandomIndexCounter+1+"/"+intNoOfQuestions);
	}
	
	public void addToToughList(View v){
		cf.addWordsToList(this,3,intWordID);	
		Toast.makeText(this, "The Word is added to Tough List", 0).show();
	}
}

