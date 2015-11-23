package com.example.base;

import com.example.fragmenttabhost.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.LinearLayout;

public class TitleBar extends RelativeLayout{
	
	private Context mContext;
	private LinearLayout mLeftLayout;
	private LinearLayout mRightLayout;
	private ImageButton mLeftBtn;
	private ImageButton mRightBtn;
	
	public TitleBar(Context context) {
		super(context);
		init(context);
	}
	
	public TitleBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	private void init(Context context) {
		mContext = context;
		LayoutInflater.from(mContext).inflate(R.layout.layout_title_bar, this, true);
		mLeftLayout = (LinearLayout) findViewById(R.id.left_layout);
		mRightLayout = (LinearLayout) findViewById(R.id.right_layout);
		mLeftBtn = (ImageButton) findViewById(R.id.left_btn);
		mRightBtn = (ImageButton) findViewById(R.id.right_btn);
	}
	
}
