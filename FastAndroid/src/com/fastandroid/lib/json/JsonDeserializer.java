package com.fastandroid.lib.json;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
/**
 * @description JSON反序列化，解析JSON格式字符串并封装成对象
 * @author 许友爻
 * @date 2014年6月18日 下午1:44:46
 * @version 1.0
 */
public class JsonDeserializer {
	public static Object convertFromJson(Object obj,Class<?> type) throws Exception {
		
		if (obj == null || obj.equals(JSONObject.NULL)) {
			return null;
		}
		else if (obj.getClass().equals(JSONArray.class)) {
			return parseJSONArray((JSONArray)obj, type);
		}
		else if (obj.getClass().equals(JSONObject.class)) {
			return parseJSONObject((JSONObject)obj, type);
		}
		else {
			return ScalarValueParser.parse(obj.toString(), type);
		}
	}
	
	private static Object parseJSONArray(JSONArray array, Class<?> type) throws Exception {
		
		ArrayList items = new ArrayList();
		for (int i = 0; i <= array.length() - 1; i++) {
			items.add(convertFromJson(array.get(i), type));
		}
		
		return items;
	}

	private static Object parseJSONObject(JSONObject obj, Class<?> type) throws Exception {
		
		Constructor<?> ctor = type.getConstructor();
		Object model = ctor.newInstance();
		
		
		for (EntityFieldMetadata field:EntityRepository.getInstance().getJsonFieldsForType(type)) {
			if (obj.has(field.jsonFieldName)) {
				Object value = convertFromJson(obj.get(field.jsonFieldName), field.type);
				if (value != null) {
					try {
						field.field.set(model, value);
					}
					catch (IllegalArgumentException ex) {
						throw new Exception(String.format("parse json: [%s] [%s]", field.field.toString(), value.getClass().getName()));
					}
				}
			}
		}
		return model;
	}
}
