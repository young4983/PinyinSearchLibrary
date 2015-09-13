package com.handsomezhou.appsearch.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.handsomezhou.appsearch.R;
import com.handsomezhou.appsearch.fragment.MainFragment;
import com.handsomezhou.appsearch.service.EasyHelperService;

@SuppressLint("ResourceAsColor")
public class MainActivity extends BaseSingleFragmentActivity {
	private static final String TAG = "MainActivity";
	private Context mContext;
	private MainFragment mMainFragment;

	private static final int DOUBLE_CLICK_EXIT_TIME_INTERVAL_MILLIS = 2000;// ms
	private static long mBackPressedTimeMillis;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		mContext = this;
		setFullScreen(false);
		initData();
		initView();
		initListener();
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void onResume() {
		super.onResume();

	}

	@Override
	protected void onPause() {

		super.onPause();
	}

	@Override
	protected Fragment createFragment() {

		return mMainFragment= new MainFragment();
	}

	@Override
	protected boolean isRealTimeLoadFragment() {

		return false;
	}

	@Override
	public void onBackPressed() {
		doubleClickExit();
	}

	private void initData() {

		return;
	}

	private void initView() {

		return;
	}

	private void initListener() {

		return;
	}

	private void doubleClickExit() {
		if (mBackPressedTimeMillis + DOUBLE_CLICK_EXIT_TIME_INTERVAL_MILLIS > System
				.currentTimeMillis()) {

			moveTaskToBack(true);
			EasyHelperService.startEasyHelperService(getApplicationContext());

		} else {
			String DoubleBackPressExitApp = mContext.getString(
					R.string.double_back_press_exit_app,
					mContext.getString(R.string.app_name));
			Toast.makeText(mContext, DoubleBackPressExitApp, Toast.LENGTH_SHORT)
					.show();
		}

		mBackPressedTimeMillis = System.currentTimeMillis();
	}

}