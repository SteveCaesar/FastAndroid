package com.example.demo.controller;

import java.util.ArrayList;

import android.os.Bundle;
import android.widget.ListView;
import butterknife.ButterKnife;
import butterknife.InjectView;

import com.example.demo.BaseActivity;
import com.example.demo.model.adapter.ListImageAdapter;
import com.fe_android.demo.R;

public class ListImageActivity extends BaseActivity {
	@InjectView(R.id.lv_image)
	ListView lv_image;
	private ListImageAdapter adapter = new ListImageAdapter();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_image);
		ButterKnife.inject(this);
		final ArrayList<String> array = new ArrayList<String>();
		array.add("http://h.hiphotos.baidu.com/image/pic/item/908fa0ec08fa513d190da9373f6d55fbb3fbd9b0.jpg");
		array.add("http://a.hiphotos.baidu.com/image/pic/item/42166d224f4a20a40eb9f92e92529822730ed0b0.jpg");
		array.add("http://f.hiphotos.baidu.com/image/pic/item/08f790529822720e4169271379cb0a46f31fabb0.jpg");
		array.add("http://h.hiphotos.baidu.com/image/pic/item/314e251f95cad1c8600939ce7d3e6709c83d51ad.jpg");
		array.add("http://d.hiphotos.baidu.com/image/pic/item/0b55b319ebc4b74548c672ffcdfc1e178b82158c.jpg");
		array.add("http://c.hiphotos.baidu.com/image/pic/item/1f178a82b9014a90e46c8354ab773912b21bee8d.jpg");
		array.add("http://h.hiphotos.baidu.com/image/pic/item/728da9773912b31ba73e08c08418367adbb4e18d.jpg");
		array.add("http://g.hiphotos.baidu.com/image/pic/item/377adab44aed2e7395bb43c58501a18b86d6fa8d.jpg");
		array.add("http://h.hiphotos.baidu.com/image/pic/item/0b55b319ebc4b745ec91ceb3cdfc1e178a821509.jpg");
		array.add("http://b.hiphotos.baidu.com/image/pic/item/4b90f603738da9778075ff8eb251f8198618e339.jpg");
		array.add("http://b.hiphotos.baidu.com/image/pic/item/8718367adab44aedef14c741b11c8701a18bfb39.jpg");
		array.add("http://e.hiphotos.baidu.com/image/pic/item/83025aafa40f4bfb5fd5e7f1014f78f0f7361809.jpg");
		array.add("http://f.hiphotos.baidu.com/image/pic/item/2f738bd4b31c870164d7cb43257f9e2f0708ff36.jpg");
		array.add("http://c.hiphotos.baidu.com/image/pic/item/0df431adcbef7609c9765c732cdda3cc7dd99ed9.jpg");
		array.add("http://h.hiphotos.baidu.com/image/pic/item/e850352ac65c10383cd50b2eb0119313b17e89b7.jpg");
		array.add("http://b.hiphotos.baidu.com/image/pic/item/64380cd7912397ddd8d25de85b82b2b7d1a287b7.jpg");
		array.add("http://h.hiphotos.baidu.com/image/pic/item/738b4710b912c8fc14b13321fe039245d7882198.jpg");
		array.add("http://c.hiphotos.baidu.com/image/pic/item/7dd98d1001e93901aba948d279ec54e737d196b7.jpg");
		array.add("http://f.hiphotos.baidu.com/image/w%3D230/sign=a99761ff95dda144da096bb182b6d009/95eef01f3a292df545be69f9be315c6035a873d9.jpg");
		array.add("http://c.hiphotos.baidu.com/image/pic/item/d009b3de9c82d158fef51839820a19d8bd3e42c6.jpg");
		array.add("http://e.hiphotos.baidu.com/image/pic/item/6d81800a19d8bc3ef5e0543d808ba61ea9d34558.jpg");
		array.add("http://g.hiphotos.baidu.com/image/pic/item/9358d109b3de9c82ef9dab786e81800a18d84348.jpg");
		array.add("http://c.hiphotos.baidu.com/image/pic/item/d058ccbf6c81800a5b1ddbf9b33533fa838b4748.jpg");
		array.add("http://a.hiphotos.baidu.com/image/pic/item/314e251f95cad1c8f753aed07d3e6709c83d5158.jpg");
		array.add("http://b.hiphotos.baidu.com/image/pic/item/2cf5e0fe9925bc316da5536f5cdf8db1ca137048.jpg");
		array.add("http://g.hiphotos.baidu.com/image/pic/item/500fd9f9d72a60597ba724f32a34349b023bbaa0.jpg");
		array.add("http://f.hiphotos.baidu.com/image/pic/item/359b033b5bb5c9ea7044c60ad739b6003bf3b3a0.jpg");
		array.add("http://g.hiphotos.baidu.com/image/pic/item/63d9f2d3572c11df9f527aca612762d0f603c25c.jpg");
		array.add("http://e.hiphotos.baidu.com/image/pic/item/faedab64034f78f0f35c5f1a7b310a55b2191c87.jpg");
		array.add("http://d.hiphotos.baidu.com/image/pic/item/8b13632762d0f703aa3150350afa513d2797c55c.jpg");
		array.add("http://f.hiphotos.baidu.com/image/pic/item/503d269759ee3d6db044ff5141166d224e4adeae.jpg");
		array.add("http://d.hiphotos.baidu.com/image/w%3D230/sign=6ebe0da1950a304e5222a7f9e1c9a7c3/0824ab18972bd407a65baa5879899e510eb309f2.jpg");
		array.add("http://a.hiphotos.baidu.com/image/pic/item/d31b0ef41bd5ad6e55b81d4f83cb39dbb7fd3cd5.jpg");
		array.add("http://f.hiphotos.baidu.com/image/pic/item/50da81cb39dbb6fddf1a9c830b24ab18962b37d5.jpg");
		array.add("http://c.hiphotos.baidu.com/image/w%3D230/sign=696f8f68fe039245a1b5e60cb795a4a8/024f78f0f736afc3d39046c0b119ebc4b64512f2.jpg");
		array.add("http://h.hiphotos.baidu.com/image/pic/item/0b55b319ebc4b745ec08ceb3cdfc1e178b8215f2.jpg");
		array.add("http://d.hiphotos.baidu.com/image/pic/item/21a4462309f79052d34582d70ef3d7ca7acbd585.jpg");
		array.add("http://h.hiphotos.baidu.com/image/pic/item/9922720e0cf3d7ca34acfa9ff01fbe096a63a985.jpg");
		array.add("http://c.hiphotos.baidu.com/image/w%3D230/sign=9065a7f513dfa9ecfd2e511452d2f754/242dd42a2834349b618dab6ccbea15ce37d3be54.jpg");
		array.add("http://a.hiphotos.baidu.com/image/pic/item/f7246b600c338744b39fea95530fd9f9d62aa085.jpg");
		adapter.setData(array);
		lv_image.setAdapter(adapter);
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		ButterKnife.reset(this);
	}
}
