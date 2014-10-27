package com.fastandroid.lib.json;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;
/**
 * @description JSON序列化，解析对象并转成JSON格式字符串
 * @author 许友爻
 * @date 2014年6月18日 下午1:45:46
 * @version 1.0
 */
public class JsonSerializer {

	public static Object convertToJson(Object obj) throws Exception {
		if (obj.getClass().equals(String.class)
				|| obj.getClass().equals(Integer.class)
				|| obj.getClass().equals(Double.class)
				|| obj.getClass().equals(Boolean.class)
				|| obj.getClass().equals(Date.class)) {
			return obj;
		} else if (obj instanceof HashMap) {
			return toJsonObject((HashMap) obj);
		} else if (obj instanceof ArrayList) {
			return toJsonArray((ArrayList) obj);
		} else {
			return toJsonObject(obj);
		}
	}

	private static JSONObject toJsonObject(HashMap hashMap) throws Exception {

		JSONObject json = new JSONObject();

		for (Object key : hashMap.keySet()) {
			json.put(key.toString(), convertToJson(hashMap.get(key)));
		}

		return json;
	}

	private static JSONArray toJsonArray(ArrayList items) throws Exception {

		if (items == null) {
			return null;
		}

		JSONArray array = new JSONArray();
		int index = 0;
		for (Object item : items) {
			array.put(index, convertToJson(item));
			index++;
		}

		return array;
	}

	private static JSONObject toJsonObject(Object obj) throws Exception {

		if (obj == null) {
			return null;
		}

		JSONObject json = null;

		for (EntityFieldMetadata field : EntityRepository.getInstance()
				.getJsonFieldsForType(obj.getClass())) {
			Object value = field.field.get(obj);
			if (value != null) {
				if (json == null) {
					json = new JSONObject();
				}
				json.put(field.jsonFieldName, convertToJson(value));
			}
		}

		return json;
	}
}
