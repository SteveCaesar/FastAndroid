package com.example.demo.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import com.example.fastandroiddemo.R;
import com.fastandroid.lib.download.DownLoadCallback;
import com.fastandroid.lib.download.DownloadManager;
import com.fastandroid.lib.log.TALogger;

/**
 * @description
 * @author 许友爻
 * @date 2014年7月18日下午5:09:29
 * @version 1.0
 */
public class SimpleDownloadActivity extends Activity {
	@InjectView(R.id.btn_start)
	Button btn_start;
	@InjectView(R.id.btn_pause)
	Button btn_pause;
	@InjectView(R.id.btn_stop)
	Button btn_stop;
	@InjectView(R.id.tv_progress)
	TextView tv_progress;
	private DownloadManager mDownloadManager;
	// private static String url =
	// "http://img.yingyonghui.com/apk/16457/com.rovio.angrybirdsspace.ads.1332528395706.apk";
	private static String url = "http://119.161.240.137:9080/Qingqiezi/fe-jiaxin.apk";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_download);
		ButterKnife.inject(this);
		mDownloadManager = DownloadManager.getDownloadManager();
	}

	@OnClick({ R.id.btn_start, R.id.btn_pause, R.id.btn_stop })
	void onClick(View view) {
		switch (view.getId()) {
		case R.id.btn_start:
			startCom();
			break;
		case R.id.btn_pause:
			pauseCom();
			break;
		case R.id.btn_stop:
			stopCom();
			break;
		}
	}

	/**
	 * 开始下载
	 * */
	private void startCom() {
		mDownloadManager.addHandler(url);
		mDownloadManager.setDownLoadCallback(new DownLoadCallback() {
			@Override
			public void onLoading(String url, long totalSize, long currentSize,
					long speed) {
				if (currentSize == 0)
					return;
				long downloadPercent = currentSize * 100 / totalSize;
				tv_progress.setText(downloadPercent + "--------" + speed
						+ "kbps");
				TALogger.d(this, downloadPercent + "--------" + speed + "kbps");
			}

			@Override
			public void onSuccess(String url) {
				tv_progress.setText("下载成功了！");
				TALogger.d(this, "onSuccess");
			}

			@Override
			public void onFinish(String url) {
				TALogger.d(this, "onFinish");
			}

			@Override
			public void onAdd(String url, Boolean isInterrupt) {
				TALogger.d(this, "onAdd");
			}
		});
	}

	/**
	 * 暂停下载
	 * */
	private void pauseCom() {
		mDownloadManager.pauseHandler(url);
	}

	/**
	 * 停止下载
	 * */
	private void stopCom() {
		mDownloadManager.deleteHandler(url);
		tv_progress.setText("0");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// 将@InjectView和@InjectViews的字段置为空。
		ButterKnife.reset(this);
	}
}
