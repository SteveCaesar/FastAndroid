/**
 * 
 */
package com.example.demo.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import com.example.demo.BaseActivity;
import com.fe_android.demo.R;
import com.fusai.lib.log.TALogger;

/**
 * @author 许友爻
 * @date 2014年6月20日 上午9:57:20
 * @version 1.0
 */
public class MainActivity extends BaseActivity {
	@InjectView(R.id.btn_database)
	Button btn_database;
	@InjectView(R.id.btn_network)
	Button btn_network;
	@InjectView(R.id.btn_appException)
	Button btn_appExButton;
	private String tag = MainActivity.class.getName();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//注入指定的注释字段和方法（开始注入的节奏。。）
		ButterKnife.inject(this);
		TALogger.i(this, "打开第一个activity");
	}
	
	@OnClick({ R.id.btn_database, R.id.btn_network,R.id.btn_appException,R.id.btn_exitApp})
	void on(View view) {
		Intent intent;
		switch (view.getId()) {
		case R.id.btn_database:
			intent = new Intent(this,DatabaseDemoActivity.class);
			startActivity(intent);
			break;
		case R.id.btn_network:
			intent = new Intent(this,NetworkActivity.class);
			startActivity(intent);
			break;
		case R.id.btn_appException:
			throw new RuntimeException();
		case R.id.btn_exitApp:
			application.exitApp(true);
			break;
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		TALogger.d(this,"onDestroy");
		/**
		 * 将@InjectView和@InjectViews的字段置为空。 
		 * */
		ButterKnife.reset(this);
	}
}
