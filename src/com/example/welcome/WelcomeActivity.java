package com.example.welcome;

import com.example.fragmenttabhost.MainActivity;
import com.example.fragmenttabhost.R;
import com.example.fragmenttabhost.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class WelcomeActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_welcome);
		
		init();
	}

	private void init() {
		// 读取SharedPreferences中需要的数据
		// 使用SharedPreferences来记录程序的使用次数
		SharedPreferences preferences = getSharedPreferences(
				SHAREDPREFERENCES_NAME, MODE_PRIVATE);

		// 取得相应的值，如果没有该值，说明还未写入，用true作为默认值
		isFirstIn = preferences.getBoolean("isFirstIn", true);

		// 判断程序与第几次运行，如果是第一次运行则跳转到引导界面，否则跳转到主界面
		if (!isFirstIn) {
			// 使用Handler的postDelayed方法，3秒后执行跳转到MainActivity
			mHandler.sendEmptyMessageDelayed(GO_HOME, SPLASH_DELAY_MILLIS);
		} else {
			mHandler.sendEmptyMessageDelayed(GO_GUIDE, SPLASH_DELAY_MILLIS);
		}
		
	}

	boolean isFirstIn = false;
	
	private static final int GO_HOME = 1000;
	private static final int GO_GUIDE = 1001;
	
	private static final long SPLASH_DELAY_MILLIS = 3000;
	private static final String SHAREDPREFERENCES_NAME = "first_pref";
	
	private Handler mHandler = new Handler() {
		
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case GO_HOME:
				goHome();
				break;
			case GO_GUIDE:
				goGuide();
				break;
			}
			super.handleMessage(msg);
		}
		

		private void goGuide() {
			// TODO Auto-generated method stub
			Intent intent = new Intent(WelcomeActivity.this, GuideActivity.class);
			WelcomeActivity.this.startActivity(intent);
			WelcomeActivity.this.finish();
		}

		private void goHome() {
			Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
			WelcomeActivity.this.startActivity(intent);
			WelcomeActivity.this.finish();
			
		}
		
	};
	
	
}
