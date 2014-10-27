package com.fusai.lib.download;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.fusai.common.StringUtils;

public class DownloadService extends Service {
	protected DownloadManager mDownloadManager;

	@Override
	public IBinder onBind(Intent intent) {
		return new DownloadServiceImpl();
	}

	@Override
	public void onCreate() {
		super.onCreate();
		mDownloadManager = DownloadManager.getDownloadManager();
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		return super.onStartCommand(intent, flags, startId);
	}

	private class DownloadServiceImpl extends IDownloadService.Stub {

		@Override
		public void startManage() throws RemoteException {

			mDownloadManager.startManage();
		}

		@Override
		public void addTask(String url) throws RemoteException {
			if (!StringUtils.isEmpty(url)) {
				mDownloadManager.addHandler(url);
			}

		}

		@Override
		public void pauseTask(String url) throws RemoteException {
			if (!StringUtils.isEmpty(url)) {
				mDownloadManager.pauseHandler(url);
			}
		}

		@Override
		public void deleteTask(String url) throws RemoteException {
			if (!StringUtils.isEmpty(url)) {
				mDownloadManager.deleteHandler(url);
			}
		}

		@Override
		public void continueTask(String url) throws RemoteException {
			if (!StringUtils.isEmpty(url)) {
				mDownloadManager.continueHandler(url);
			}
		}

		@Override
		public void pauseAll() throws RemoteException {
			mDownloadManager.pauseAllHandler();
		}

		@Override
		public void stopManage() throws RemoteException {
			mDownloadManager.close();
		}
	}
}
