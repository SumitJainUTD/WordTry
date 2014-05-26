package com.example.wordtry;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class ExamSetting extends MainActivity {

	private Spinner listSpinner;
	private TextView strWordCount;
	private String strCountQuery;
	public int intWordsCount=0;
	public int intNoOfQuestions;
	public CommomFunctions cf;
	public static final String EXAMLIST = "com.example.wordtry.ExamSetting.ExamList";
	public static final String EXAMTOTALWORDSINSELECTEDLIST = "com.example.wordtry.ExamSetting.ExamTotalWords";
	public static final String EXAMNOQUESTIONS = "com.example.wordtry.ExamSetting.ExamQUESTIONS";
	public String strTestList1;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exam_setting);
		//addItemsToSpinner();
		cf =  new CommomFunctions(this);
		wp = new WordPowerOpenHelper(this, cf.DBName, null, 1);
		
		strWordCount = (TextView) findViewById(R.id.TotalWordsAvailable_Exam);
		listSpinner = (Spinner) findViewById(R.id.Choose_List);
		listSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {			
		
			@Override
			public void onItemSelected(AdapterView<?> parent, View itemSelected, int SelectedItemPostion,
					long SelectedId) {
				// TODO Auto-generated method stub
				//Toast.makeText(this, "Sumit Jain", Toast.LENGTH_LONG).show();
				strTestList1 =  parent.getItemAtPosition(SelectedItemPostion).toString();	
				Log.i("i m here",strTestList1);
				if (strTestList1.equalsIgnoreCase("My List")){
					strCountQuery = "select Count(*) as Count from mainwordlist where _id in (select mainid from Mapping where GroupID =1)";
				}
				else if (strTestList1.equalsIgnoreCase("Learning List")){
					strCountQuery = "select Count(*) as Count from mainwordlist where _id in (select mainid from Mapping where GroupID =2)";
					}
				else if (strTestList1.equalsIgnoreCase("Tough List")){
					strCountQuery = "select Count(*) as Count from mainwordlist where _id in (select mainid from Mapping where GroupID =3)";
					}
				else if (strTestList1.equalsIgnoreCase("Main List")){
					strCountQuery = "select Count(*) as Count from mainwordlist";
					}
				
				intWordsCount= cf.getRecordCount(strCountQuery,wp);
				strWordCount.setText("Words Available : " + intWordsCount);
				
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void onBackPressed() {
	    Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
	    startActivity(mainIntent);
	    Log.i("Back pressed","Refresh it");
	    return;
	}
	
	public int getRecordCountExam(String strQuery){
		
		int intTemp = 0;		
		Cursor csr = wp.getAllWords(strCountQuery);
		if(csr.moveToFirst()){
		intTemp = csr.getInt(csr.getColumnIndex("Count"));
		}
		csr.close();		
		return intTemp;
	}
	
	//@SuppressWarnings("deprecation")
	public void ShowExam(View v){
		Log.i("12 OCt check point ", "1111");
		EditText edt = (EditText) findViewById(R.id.NoOfExamQuestions);
		Toast.makeText(this, "Sumit Jain Exam 1", 0).show();
		if(edt.getText().toString().trim().equals("")){
			cf.ShowDialogOKButton(this,"Error", "Please Enter No Of Questions");
		}
		else{
			intNoOfQuestions = Integer.parseInt(edt.getText().toString());
			Log.i("no of question", String.valueOf(intNoOfQuestions));
			Log.i("no of question", edt.getText().toString());
			if(intNoOfQuestions<1){
				cf.ShowDialogOKButton(this,"Error", "Number of Question must be greater than 1");
			}
			else{
				if(intNoOfQuestions>intWordsCount){
					cf.ShowDialogOKButton(this,"Error", "Number of Question must be less than or equals to the no of words in the selected list.");
				}
				else{
					if(intWordsCount<5){
						cf.ShowDialogOKButton(this,"Error", "Minimun no of words required creating exam, are 5, please add more words to the selected list OR Select another list");
					}
					else{
						Log.i("12 OCT ", "2222222222");
						Toast.makeText(this, "Exam Created", 0).show();
						Toast.makeText(this, "Sumit Jain", 0).show();
						Intent intent = new Intent(getApplicationContext(),Exam.class);		
						intent.putExtra(EXAMLIST, strTestList1);
						intent.putExtra(EXAMNOQUESTIONS, intNoOfQuestions);
						intent.putExtra(EXAMTOTALWORDSINSELECTEDLIST, intWordsCount);
						startActivity(intent);
					}
				}
			}
		}
	}
	
	
	
}
