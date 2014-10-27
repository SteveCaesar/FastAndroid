package com.example.demo.test;

import android.content.Context;
import android.test.AndroidTestCase;

import com.example.fastandroiddemo.R;
import com.fastandroid.common.StringUtils;
import com.fastandroid.lib.log.TALogger;

public class CommonTest extends AndroidTestCase {
	private String TAG=CommonTest.class.getName();
	public void dipTopx() {
		float width = getContext().getResources().getDimension(
				R.dimen.img_width);
		TALogger.i(this,"从dimens.xml获取的px"+width);
		TALogger.i(this,"200dip=="+dip2px(getContext(),200)+"px");
		
	}
	 /** 
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素) 
     */  
    private static int dip2px(Context context, float dpValue) {  
        final float scale = context.getResources().getDisplayMetrics().density;  
        return (int) (dpValue * scale + 0.5f);  
    }  
  
    /** 
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp 
     */  
    private static int px2dip(Context context, float pxValue) {  
        final float scale = context.getResources().getDisplayMetrics().density;  
        return (int) (pxValue / scale + 0.5f);  
    }  
    
    public void hashKeyForDisk(){
    	TALogger.d(TAG,StringUtils.hashKeyForDisk("我爱你"));
    }
//    public void hashKeyForDisk(){
//    	TALogger.d(TAG,StringUtils.hashKeyForDisk("我爱你"));
//    }
}
