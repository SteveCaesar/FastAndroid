package com.fastandroid.lib.json;
/**
 * @description 基本数据类型解析
 * @author 许友爻
 * @date 2014年6月18日 下午5:45:40
 * @version 1.0
 */
public class ScalarValueParser {
	
	public static Object parse(String s, Class<?> type) throws Exception {
		
		if (type.equals(String.class)) {
			return s;
		}
		else if (type.equals(int.class)) {
			return Integer.valueOf(s);
		}
		else if (type.equals(double.class)) {
			return Double.valueOf(s);
		}
		else if (type.equals(boolean.class)) {
			return Boolean.valueOf(s);
		}
		
		throw new Exception("ScalarValueParser.parse()");
	}

//	public static Date parseDate(String s) {
//
//		if (s == null || s.length() == 0) {
//			return null;
//		}	
//		
//		if (!s.startsWith("/Date(")) {
//			return null;
//		}
//		
//		
//		String time = s.substring(6, s.length() - 2);
//		int positionOfPlus = time.indexOf("+");
//		
//		String milliseconds = time.substring(0, positionOfPlus);
//		
//		Date date = new Date();
//		date.setTime(Long.valueOf(milliseconds));
//		
//		return date;
//	}
}
