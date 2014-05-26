package com.example.wordtry;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class StatsAdapter  extends CursorAdapter {
	
	public StatsAdapter(Context context, Cursor c) {
		super(context, c);
		// TODO Auto-generated constructor stub
	}

	//public WordAdapter(Context context,Cursor csr){
		
		/*wRecord.add(new WordRecord("Word1", "Meaning1", "Sentence1"));
		wRecord.add(new WordRecord("Word2", "Meaning2", "Sentence2"));
		wRecord.add(new WordRecord("Word3", "Meaning3", "Sentence3"));
		wRecord.add(new WordRecord("Word4", "Meaning4", "Sentence4"));
		wRecord.add(new WordRecord("Word5", "Meaning5", "Sentence5"));
		wRecord.add(new WordRecord("Word1", "Meaning1", "Sentence1"));
		wRecord.add(new WordRecord("Word2", "Meaning2", "Sentence2"));
		wRecord.add(new WordRecord("Word3", "Meaning3", "Sentence3"));
		wRecord.add(new WordRecord("Word4", "Meaning4", "Sentence4"));
		wRecord.add(new WordRecord("Word5", "Meaning5", "Sentence5"));
		wRecord.add(new WordRecord("Word1", "Meaning1", "Sentence1"));
		wRecord.add(new WordRecord("Word2", "Meaning2", "Sentence2"));
		wRecord.add(new WordRecord("Word3", "Meaning3", "Sentence3"));
		wRecord.add(new WordRecord("Word4", "Meaning4", "Sentence4"));
		wRecord.add(new WordRecord("Word5", "Meaning5", "Sentence5"));*/
		//super(context,csr);
	//}
//	private ArrayList<WordRecord> wRecord = new ArrayList<WordRecord>();
//	@Override
//	public int getCount() {
//		// TODO Auto-generated method stub
//		return wRecord.size();
//	}
//
//	@Override
//	public Object getItem(int index) {
//		// TODO Auto-generated method stub
//		return getItem(index);
//	}
//
//	@Override
//	public long getItemId(int index) {
//		// TODO Auto-generated method stub
//		return index;
//	}
//
//	@Override
//	public View getView(int index, View view, ViewGroup parent) {
//		// TODO Auto-generated method stub
////		if (view==null){
////			
////		}
////		
////		WordRecord word = wRecord.get(index);
////		
////		TextView wordTV = (TextView) view.findViewById(R.id.word_view);
////		wordTV.setText(word.getWord());
////		
////		TextView meaningTV = (TextView) view.findViewById(R.id.meaning_view);
////		meaningTV.setText(word.getMeaning());
////		
//		return view;
//	}

	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		// TODO Auto-generated method stub
		
		TextView ListName = (TextView) view.findViewById(R.id.ListName);
		Log.i("Stats,,, Before filling the values", "I m here");
		ListName.setText(cursor.getString(cursor.getColumnIndex("ListName")));
		//wordTV.setText("Sumit");
		
		TextView meaningTV = (TextView) view.findViewById(R.id.Date);
		meaningTV.setText(cursor.getString(cursor.getColumnIndex("ExamDate")));
		
		TextView NoOfQuestion = (TextView) view.findViewById(R.id.NoOfQuestion);
		NoOfQuestion.setText(cursor.getString(cursor.getColumnIndex("NoOfQuestion")));
		
		TextView TotalMarks = (TextView) view.findViewById(R.id.TotalMarks);
		TotalMarks.setText(cursor.getString(cursor.getColumnIndex("TotalMarks")));
		
		TextView Correct = (TextView) view.findViewById(R.id.Correct);
		Correct.setText(cursor.getString(cursor.getColumnIndex("Correct")));
		
		TextView PercentageScore = (TextView) view.findViewById(R.id.PercentageScore);
		PercentageScore.setText(cursor.getString(cursor.getColumnIndex("Percentage")));
		
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		View view = inflater.inflate(R.layout.statslayout, parent,false);
		return view;
	}
}