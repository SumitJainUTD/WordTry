package com.example.wordtry;

import android.R.integer;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class TestSetting extends MainActivity {
	
	private Spinner listSpinner;
	private static final int LENGTH_SHORT = 0;
	public String strTestList="Main List";
	public String strTestOrder="Random";
	public String strCountQuery;
	public int intWordsCount=0;
	public TextView strWordCount;
	public WordPowerOpenHelper wp;
	public CommomFunctions cf;
	public static final String TESTLIST = "com.example.wordtry.TestingSetting.TestList";
	public static final String TESTORDER = "com.example.wordtry.TestingSetting.TestOrder";
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_setting);
		//addItemsToSpinner();
		cf = new CommomFunctions(this);
		wp = new WordPowerOpenHelper(this,cf.DBName, null, 1);
		
		strWordCount = (TextView) findViewById(R.id.WordAvailable);
		listSpinner = (Spinner) findViewById(R.id.Choose_List);
		listSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View itemSelected, int SelectedItemPostion,
					long SelectedId) {
				// TODO Auto-generated method stub
				//Toast.makeText(this, "Sumit Jain", Toast.LENGTH_LONG).show();
				String strTestList1 =  parent.getItemAtPosition(SelectedItemPostion).toString();	
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

	public void onClickRadioButton(View view){
		boolean isChecked = ((RadioButton) view).isChecked();
		
		switch(view.getId()){
		case R.id.Random :
			strTestOrder = "Random";
		case R.id.Ordered:
			strTestOrder = "Ordered";
		}
	}
	
	public void ShowTest(View view){
		
		if (intWordsCount<1){
			Toast.makeText(this,"No words in this list, Please Select another List",1).show();
		}
		else{
			
		
			strTestList = listSpinner.getSelectedItem().toString();
			RadioButton rd_Random = (RadioButton) findViewById(R.id.Random);
			if (rd_Random.isChecked()){
				strTestOrder = "Random";
			}
			else{
				strTestOrder = "Ordered";
			}
			
			Toast.makeText(this, strTestList, 0).show();
			Toast.makeText(this, strTestOrder, 0).show();
			Intent intent = new Intent(getApplicationContext(),Test.class);
			intent.putExtra(TESTLIST, strTestList);
			intent.putExtra(TESTORDER, strTestOrder);
			startActivity(intent);
		}
		
	}
	/*
	public void addItemsToSpinner(){
		
		listSpinner= (Spinner) findViewById(R.id.Choose_List);
		//ArrayAdapter<String> adapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,R.array.List_Names);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.List_Names, android.R.layout.simple_spinner_item);

		adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		listSpinner.setAdapter(adapter);
	}
	*/
	public int getRecordCount(String strQuery){
		
		int intTemp = 0;		
		Cursor csr = wp.getAllWords(strCountQuery);
		if(csr.moveToFirst()){
		intTemp = csr.getInt(csr.getColumnIndex("Count"));
		}
		csr.close();		
		return intTemp;
	}

}

