package com.fastandroid.lib.config;

import java.util.Map;
import java.util.Set;

import com.fastandroid.MyApplication;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * @description
 * @author 许友爻
 * @date 2014年7月15日下午2:02:52
 * @version 1.0
 */
public class PreferenceConfig {
	private SharedPreferences config;
	private Editor edit;
	/**
	 * 
	 */
	public PreferenceConfig(String name,int mode) {
		this.config=MyApplication.getApplication().getSharedPreferences(name,mode);
		this.edit=this.config.edit();
	}
	
	/**
	 * @return 返回器
	 */
	public Editor getEdit() {
		return this.edit;
	}

	public boolean getBoolean(String key, boolean defValue) {
		return this.config.getBoolean(key, defValue);
	}

	public float getFloat(String key, float defValue) {
		return this.config.getFloat(key, defValue);
	}

	public int getInt(String key, int defValue) {
		return this.config.getInt(key, defValue);
	}

	public long getLong(String key, long defValue) {
		return this.config.getLong(key, defValue);
	}

	public String getString(String key, String defValue) {
		return this.config.getString(key, defValue);
	}

	@SuppressLint("NewApi")
	public Set<String> getStringSet(String key, Set<String> defValues) {
		return this.config.getStringSet(key, defValues);
	}

	public Map<String, ?> getAll() {
		return this.config.getAll();
	}

	public void putBoolean(String key, boolean value) {
		this.edit.putBoolean(key, value).commit();
	}

	public void putFloat(String key, float value) {
		this.edit.putFloat(key, value).commit();
	}

	public void putInt(String key, int value) {
		this.edit.putInt(key, value).commit();
	}

	public void putLong(String key, long value) {
		this.edit.putLong(key, value).commit();
	}

	public void putString(String key, String value) {
		this.edit.putString(key, value).commit();
	}

	@SuppressLint("NewApi") 
	public void putStringSet(String key, Set<String> values) {
		this.edit.putStringSet(key,values).commit();
	}
	
	public void remove(String key){
		this.edit.remove(key).commit();
	}
}
