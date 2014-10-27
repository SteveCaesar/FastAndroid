package com.example.demo.model.adapter;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader.ImageContainer;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.example.demo.MyApplication;
import com.example.fastandroiddemo.R;
import com.fastandroid.lib.log.TALogger;
import com.fastandroid.mvc.view.RecyclingImageView;

public class ListImageAdapter extends BaseAdapter {
	private ArrayList<String> data = new ArrayList<String>();
	private MyApplication application = (MyApplication) MyApplication
			.getApplication();

	/**
	 * 获取数据
	 * */
	public ArrayList<String> getData() {
		return data;
	}

	/**
	 * 设置数据
	 * */
	public void setData(ArrayList<String> data) {
		this.data = data;
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TALogger.i(this, "position:" + position);
		ViewHolder holder = null;
		// 重用View，优化ListView方式之一
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = View.inflate(MyApplication.getApplication(),
					R.layout.ui_image, null);
			holder.riv_image = (RecyclingImageView) convertView
					.findViewById(R.id.riv_image);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
			//设置默认图片
			holder.riv_image.setImageResource(R.drawable.ic_launcher);
		}

		final String imageUrl = data.get(position);
		final RecyclingImageView riv_image = holder.riv_image;
		// 给 ImageView 设置一个 tag（防止图片错位）
		riv_image.setTag(imageUrl);
		// 加载图片
		application.getImageLoader().get(imageUrl, new ImageListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				//设置加载失败后显示的图片
				riv_image.setImageResource(R.drawable.load_image_error);
			}

			@Override
			public void onResponse(ImageContainer response, boolean isImmediate) {
				Bitmap bitmap = response.getBitmap();
				// 验证 tag 来设置图片，可以防止图片错位
				if (imageUrl.equals(riv_image.getTag()) && bitmap != null) {
					riv_image.setImageBitmap(bitmap);
				}
			}
		}, (int) riv_image.getWidth(), riv_image.getHeight());
		return convertView;
	}
	
	public static class ViewHolder {
		public RecyclingImageView riv_image;
	}
}
