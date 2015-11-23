package com.example.listview;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.fragmenttabhost.R;

public class MyAdapter extends BaseAdapter{
	
	private LayoutInflater mInflater;
	ArrayList<HashMap<String,Object>> listItem;

	public MyAdapter(Context context) {
		this.mInflater = LayoutInflater.from(context);
	}
	
	private ArrayList<HashMap<String, Object>> getDate(){
		ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
		for(int i=0; i<30; i++){
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("ItemTitle","第"+i+"行");
			map.put("ItemText", "这是第"+i+"行");
			listItem.add(map);
		}
		
		return listItem;
	}
	
	@Override
	public int getCount() {
		return getDate().size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		
		if(convertView == null){
			convertView = mInflater.inflate(R.layout.list_item, null);
			holder = new ViewHolder();
			holder.title = (TextView) convertView.findViewById(R.id.ItemTitle);
			holder.text = (TextView) convertView.findViewById(R.id.ItemText);
			holder.btn = (Button) convertView.findViewById(R.id.list_btn);
			convertView.setTag(holder);
		}else {
			holder = (ViewHolder)convertView.getTag();
		}
		holder.title.setText(getDate().get(position).get("ItemTitle").toString());
		holder.text.setText(getDate().get(position).get("ItemText").toString());
		holder.btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		return parent;
	}
	
	public final class ViewHolder{
		public TextView title;
		public TextView text;
		public Button btn;
	}

}
