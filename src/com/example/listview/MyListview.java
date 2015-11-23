package com.example.listview;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.fragmenttabhost.R;

public class MyListview extends ListActivity{

	private ListView lv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment1);
		
		Log.e("ee", "eeeee");
		
		lv=(ListView) findViewById(R.id.lv);
		MyAdapter mAdapter = new MyAdapter(this);
		lv.setAdapter(mAdapter);
		
		
	}
	
}
