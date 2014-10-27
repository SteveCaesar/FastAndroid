package com.example.demo;

import android.app.Activity;
import android.os.Bundle;

/**
 * @Description 所有activity得继承此类
 * @author 许友爻
 * @date 2014年6月23日 下午2:34:40
 * @version 1.0
 */
public class BaseActivity extends Activity{
	protected MyApplication application;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	 	application=(MyApplication) MyApplication.getApplication();
	 	application.getAppManager().addActivity(this);
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		application.getAppManager().removeActivity(this);
	}
}
