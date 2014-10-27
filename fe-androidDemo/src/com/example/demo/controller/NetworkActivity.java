package com.example.demo.controller;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageContainer;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.android.volley.toolbox.StringRequest;
import com.example.demo.BaseActivity;
import com.example.demo.model.http.request.NetworkEntity;
import com.fe_android.demo.R;
import com.fusai.lib.http.volley.JsonToObjectRequest;
import com.fusai.lib.log.TALogger;
import com.fusai.mvc.view.RecyclingImageView;

/**
 * @author 许友爻
 * @date 2014年6月23日 下午1:11:49
 * @version 1.0
 */
public class NetworkActivity extends BaseActivity {
	@InjectView(R.id.riv_image)
	RecyclingImageView rim_image;
	@InjectView(R.id.btn_getText)
	Button btn_getText;
	@InjectView(R.id.btn_getImage)
	Button btn_getImage;
	@InjectView(R.id.btn_getImage2)
	Button btn_getImage2;
	@InjectView(R.id.btn_getListImage)
	Button btn_getListImage;
	@InjectView(R.id.btn_jsonToObject)
	Button btn_jsonToObject;
	@InjectView(R.id.btn_download)
	Button btn_download;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_network);
		ButterKnife.inject(this);// 开始视图注入
	}

	@OnClick({ R.id.btn_getText, R.id.btn_getImage,R.id.btn_getImage2,R.id.btn_getListImage,
			R.id.btn_jsonToObject, R.id.btn_download })
	void onClick(View view) {
		Intent intent;
		switch (view.getId()) {
		case R.id.btn_getText:
			getString();
			break;
		case R.id.btn_getImage:
			getImage();
			break;
		case R.id.btn_getImage2:
			getImage2();
			break;
		case R.id.btn_jsonToObject:
			getJsonToObject();
			break;
		case R.id.btn_getListImage:
			intent = new Intent(NetworkActivity.this, ListImageActivity.class);
			startActivity(intent);
			break;
		case R.id.btn_download:
			intent = new Intent(NetworkActivity.this,
					SimpleDownloadActivity.class);
			startActivity(intent);
			break;
		}
	}

	/**
	 * 获取字符串
	 * */
	private void getString() {
		Response.Listener<String> listener = new Response.Listener<String>() {
			@Override
			public void onResponse(String str) {
				// 如果此activity被finish则不执行方法
				if (NetworkActivity.this.isFinishing())
					return;
				TALogger.i(this, str);
			}
		};
		Response.ErrorListener errorListener = new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError ex) {
				TALogger.e(this, ex.getMessage());
			}
		};

		application
				.getRequestQueue()
				.add(new StringRequest(
						Method.GET,
						"http://192.168.1.12:8080/interfaceTest/servletTest?action=test1",
						listener, errorListener).setShouldCache(true).setTag(
						this));
	}

	/**
	 * 获取网络的JSON数据然后转换成object对象
	 * */
	public void getJsonToObject() {
		Response.Listener<NetworkEntity> listener = new Response.Listener<NetworkEntity>() {
			@Override
			public void onResponse(NetworkEntity obj) {
				if (NetworkActivity.this.isFinishing())
					return;
				NetworkEntity entity = obj;
				String currentPage = entity.currentPage;
			}
		};

		Response.ErrorListener errorListener = new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError ex) {
				TALogger.e(this, ex.getMessage());
			}
		};

		application
				.getRequestQueue()
				.add(new JsonToObjectRequest<NetworkEntity>(
						Method.GET,
						"http://119.161.240.137:9080/Qingqiezi/UserPage?action=getQiandaoInfo&username=18600248840&currentPage=1",
						NetworkEntity.class, listener, errorListener)
						.setShouldCache(true).setTag(this));
	}

	/**
	 * 注入式获取图片
	 * */
	private void getImage() {
		String requestUrl = "http://e.hiphotos.baidu.com/image/pic/item/c995d143ad4bd1130751f5dc58afa40f4afb05bb.jpg";
		application.getImageLoader().get(
				requestUrl,
				ImageLoader.getImageListener(rim_image, R.drawable.ic_launcher,
						R.drawable.load_image_error));
	}

	/**
	 * 普通方式获取图片
	 * */
	private void getImage2() {
		String requestUrl = "http://e.hiphotos.baidu.com/image/pic/item/c995d143ad4bd1130751f5dc58afa40f4afb05bb.jpg";
		application.getImageLoader().get(requestUrl, new ImageListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				Toast.makeText(NetworkActivity.this, "onErrorResponse", 0)
						.show();
			}

			@Override
			public void onResponse(ImageContainer response, boolean isImmediate) {
				Bitmap bitmap = response.getBitmap();
				if (bitmap == null) {
					Toast.makeText(NetworkActivity.this, "bitmap is null", 0)
							.show();
				} else {
					rim_image.setImageBitmap(bitmap);
				}
			}
		});
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// 终止所有设置此tag的请求
		application.getRequestQueue().cancelAll(this);
		// 将@InjectView和@InjectViews的字段置为空。
		ButterKnife.reset(this);
	}
}
