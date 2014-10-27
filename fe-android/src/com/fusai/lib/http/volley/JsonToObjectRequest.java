package com.fusai.lib.http.volley;

import org.json.JSONArray;
import org.json.JSONObject;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.fusai.lib.json.JsonDeserializer;

/**
 * @description 请求网络获取JSON格式的字符串，解析JSON后把对应的值封装给T类型的对象。
 * @author 许友爻
 * @date 2014年6月18日 下午1:40:46
 * @version 1.0
 */
public class JsonToObjectRequest<T> extends Request<T> {

	private final Listener<T> mListener;

	private Class<T> mClass;

	public JsonToObjectRequest(int method, String url, Class<T> clazz,
			Listener<T> listener, ErrorListener errorListener) {
		super(method, url, errorListener);
		mClass = clazz;
		mListener = listener;
	}

	public JsonToObjectRequest(String url, Class<T> clazz,
			Listener<T> listener, ErrorListener errorListener) {
		this(Method.GET, url, clazz, listener, errorListener);
	}

	@Override
	protected Response<T> parseNetworkResponse(NetworkResponse response) {
		try {
			String jsonString = new String(response.data,
					HttpHeaderParser.parseCharset(response.headers));
			return Response.success((T) new JsonDeserializer().convertFromJson(
					jsonString.startsWith("[") ? new JSONArray(jsonString)
							: new JSONObject(jsonString), mClass),
					HttpHeaderParser.parseCacheHeaders(response));
		} catch (Exception e) {
			return Response.error(new ParseError(e));
		}
	}

	@Override
	protected void deliverResponse(T response) {
		mListener.onResponse(response);
	}
}