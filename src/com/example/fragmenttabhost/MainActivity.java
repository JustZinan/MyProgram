package com.example.fragmenttabhost;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import com.example.fragment.Fragment1;
import com.example.fragment.Fragment2;
import com.example.fragment.Fragment3;
import com.example.fragment.Fragment4;
import com.example.fragment.Fragment5;

/**
 * 
 * @author zqy
 * 
 */
public class MainActivity extends FragmentActivity {

	private FragmentTabHost mTabHost;


	private LayoutInflater mLayoutInflater;


	private Class mFragmentArray[] = { Fragment1.class, Fragment2.class,
			Fragment3.class, Fragment4.class, Fragment5.class };

	private int mImageArray[] = { R.drawable.tab_home_btn,
			R.drawable.tab_message_btn, R.drawable.tab_selfinfo_btn,
			R.drawable.tab_square_btn, R.drawable.tab_more_btn };

	private String mTextArray[] = { "首页", "消息", "好友", "附近", "更多" };

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();
	}


	private void initView() {
		mLayoutInflater = LayoutInflater.from(this);


		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

		int count = mFragmentArray.length;
		for (int i = 0; i < count; i++) {

			TabSpec tabSpec = mTabHost.newTabSpec(mTextArray[i])
					.setIndicator(getTabItemView(i));

			mTabHost.addTab(tabSpec, mFragmentArray[i], null);

			mTabHost.getTabWidget().getChildAt(i)
					.setBackgroundResource(R.drawable.selector_tab_background);
		}
	}

	private View getTabItemView(int index) {
		View view = mLayoutInflater.inflate(R.layout.tab_item_view, null);
		ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
		imageView.setImageResource(mImageArray[index]);
		TextView textView = (TextView) view.findViewById(R.id.textview);
		textView.setText(mTextArray[index]);

		return view;
	}

}
