package com.fastandroid.lib.download;

interface IDownloadService
 {	
	void startManage();
	
	void addTask(String url);
	
	void pauseTask(String url);
	
	void pauseAll();
	
	void deleteTask(String url);
	
	void continueTask(String url);
	
	void stopManage();
}
