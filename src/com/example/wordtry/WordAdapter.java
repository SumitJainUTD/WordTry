package com.example.wordtry;

import java.util.ArrayList;

import android.R.string;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class WordAdapter extends CursorAdapter implements OnClickListener {
	
	public Context cxt;
	public ArrayList<Boolean> itemChecked = new ArrayList<Boolean>();
	
	public CommomFunctions cf;
	public Boolean blnFirstTimeChecked = false;
	public MainList ml;
	public ListView listV;
	public boolean blnAllWordsDeleted = false;
	public int noOfCheckBoxesDisplayed;
	
	CheckBox [] ch = new CheckBox[100];
	int i =0;
	public WordAdapter(Context context, Cursor c) {
		super(context, c);
		 cxt = context;
		// TODO Auto-generated constructor stub
		 noOfCheckBoxesDisplayed = c.getCount();
		 for(int i=0;i<c.getCount();i++){
				itemChecked.add(i,false);
			}
		 Log.i("29052014", String.valueOf(c.getCount()));
		 cf = new CommomFunctions();
		 ml = new MainList();
		 listV = MainList.listview;

	}

	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		// TODO Auto-generated method stub
		TextView wordTV = (TextView) view.findViewById(R.id.word_view);
		wordTV.setText(cursor.getString(cursor.getColumnIndex("Word")));

		TextView meaningTV = (TextView) view.findViewById(R.id.meaning_view);
		meaningTV.setText(cursor.getString(cursor.getColumnIndex("meaning")));
		
		final int position = cursor.getPosition();
		final CheckBox checkBx = (CheckBox)view.findViewById(R.id.checkBox_multiWords);
		
		
		
		checkBx.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				CheckBox cb = (CheckBox)v.findViewById(R.id.checkBox_multiWords);
				
					TableLayout temp = (TableLayout)v.getParent().getParent();
					int x = temp.getChildCount();
					Log.i("com.example.wordtry.ChildCount",String.valueOf(x));
					TableRow tr = (TableRow) temp.getChildAt(0);
					Log.i("com.example.wordtry.RowChildCount",String.valueOf(tr.getChildCount()));
					TextView tvp = (TextView)tr.getChildAt(0);
					Log.i("com.example.wordtry.CheckPoint","2606_1254");
					//TableRow tvp = (TableRow)temp.getChildAt(0);
					//tvp.get
					String strClickedWord = tvp.getText().toString();
					Log.i("CLICKED ON THE WORD ",strClickedWord);
				// TODO Auto-generated method stub
				if (cb.isChecked()) {
	                itemChecked.set(position, true);
	                MainList.listOfItems.add(strClickedWord);
	                Log.i("29052014","i m checked at "+String.valueOf(position));
	                // do some operations here
	            } else if (!cb.isChecked()) {
	                itemChecked.set(position, false);
	                MainList.listOfItems.remove(strClickedWord);
	                // do some operations here
	            }
				Log.i("290514 list view count ","YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
				
				
			}
		});
		checkBx.setChecked(itemChecked.get(position));
		
	}
	

//	@Override
//	public View getView(final int position, View convertView, ViewGroup parent){
//		View view = null;
//		if(convertView==null){
//			LayoutInflater inflater = (LayoutInflater) cxt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//			view = inflater.inflate(R.layout.rowlayout_wordlist_table, null);
//			//viewHolder vH = new viewHolder();
//			}
//		
//		return view;
//	}
	
	


	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		View view = inflater.inflate(R.layout.rowlayout_wordlist_table, parent,false);
		//		checkBx.setOnCheckedChangeListener(new OnCheckedChangeListener() {		
//			
//			
////			public void onClick(View v) {
////				// TODO Auto-generated method stub
////				
////			}
////			
//			@Override
//			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
//				// TODO Auto-generated method stub
//				if (checkBx.isChecked()) {
//	                itemChecked.set(position, true);
//	                Log.i("29052014","i m checked at "+String.valueOf(position));
//	                // do some operations here
//	            } else if (!checkBx.isChecked()) {
//	                itemChecked.set(position, false);
//	                // do some operations here
//	            }
//
//			}
//		});
		//checkBx.setChecked(itemChecked.get(position));
		
//		if(blnFirstTimeChecked){
//			ListView lv = (ListView)view.findViewById(R.id.word_list); 
//			if(lv==null){
//				Log.i("290514 list view count ","NULLLLLLLLLLLLLLLLLLLLLLLLLLLL");
//			}
//			Log.i("290514 list view count ","XXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
//			Log.i("290514 list view count ",String.valueOf(lv.getChildCount()));
////			Log.i("290514 Boolean array size ",String.valueOf(itemChecked.size()));
////			for (int x = 0; x<lv.getChildCount();x++){
////	            CheckBox c = (CheckBox)lv.getChildAt(x).findViewById(R.id.checkBox_multiWords);
////	            c.setChecked(itemChecked.get(position));
////			}
////	            
//
//		}
//		
		return view;
	}
	
	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}
