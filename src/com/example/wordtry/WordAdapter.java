package com.example.wordtry;

import java.util.ArrayList;

import android.R.string;
import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WordAdapter extends CursorAdapter {
	
	CheckBox [] ch = new CheckBox[100];
	int i =0;
	public WordAdapter(Context context, Cursor c) {
		super(context, c);
		 for(i=0;i<100;i++)
				ch[i]=new CheckBox(context, null, i);
		 i=0;
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
		TextView wordTV = (TextView) view.findViewById(R.id.word_view);
		//Log.i("Word index", cursor.getColumnIndex("Word"));
		wordTV.setText(cursor.getString(cursor.getColumnIndex("Word")));
		//wordTV.setText("Sumit");
		
		TextView meaningTV = (TextView) view.findViewById(R.id.meaning_view);
		meaningTV.setText(cursor.getString(cursor.getColumnIndex("meaning")));
		//meaningTV.setText("Jain");
		//cursor.close();
	    i++;
	   	Log.i("Sumittttttttttttttttttttttt", "i m hereeeeeeeeeeeeeeee");					
//	    	LinearLayout l1 = (LinearLayout)  view.findViewById(R.id.my_activity_view);
//	    	l1.addView(ch[i]);
//	    	ch[i].setVisibility(View.VISIBLE);
//	    	ch[i].setWidth(25);
//	    	ch[i].setHeight(10);
//	    	
//	    	Log.i("Width", String.valueOf(ch[1].getWidth()));
//	    	Log.i("Visible", String.valueOf(ch[1].getVisibility()));
//	    	Log.i("height", String.valueOf(ch[1].getHeight()));
	    
	    TextView Counter = (TextView) view.findViewById(R.id.CBCounter_view);
	    
		Counter.setText(String.valueOf(cursor.getInt(0)));
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		View view = inflater.inflate(R.layout.rowlayout_wordlist_table, parent,false);
		return view;
	}
}
