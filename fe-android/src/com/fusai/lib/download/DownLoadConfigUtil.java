package com.fusai.lib.download;

import java.util.ArrayList;
import java.util.List;

import com.fusai.MyApplication;
import com.fusai.common.StringUtils;

public class DownLoadConfigUtil {
	public static final String PREFERENCE_NAME = "com.yyxu.download";
	public static final int URL_COUNT = 3;
	public static final String KEY_URL = "url";

	public static void storeURL(int index, String url) {
		MyApplication.getApplication().getConfig()
				.putString(KEY_URL + index, url);
	}

	public static void clearURL(int index) {
		MyApplication.getApplication().getConfig().remove(KEY_URL + index);
	}

	public static String getURL(int index) {
		return MyApplication.getApplication().getConfig()
				.getString(KEY_URL + index, "");
	}

	public static List<String> getURLArray() {
		List<String> urlList = new ArrayList<String>();
		for (int i = 0; i < URL_COUNT; i++) {
			if (!StringUtils.isEmpty(getURL(i))) {
				urlList.add(getString(KEY_URL + i));
			}
		}
		return urlList;
	}

	private static String getString(String key) {
		return MyApplication.getApplication().getConfig()
				.getString(key, "");
	}

}
