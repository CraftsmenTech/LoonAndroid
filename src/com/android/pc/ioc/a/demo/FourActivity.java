package com.android.pc.ioc.a.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.pc.ioc.inject.InjectBinder;
import com.android.pc.ioc.inject.InjectView;
import com.android.pc.ioc.view.listener.OnClick;
import com.android.pc.util.Handler_Inject;
import com.wash.activity.R;


/**
 * 支持这种注解 单独对某个View进行注解
 * 记住 此种情况下 会和Activity本身的setContentView中的注解想混淆
 * 最好在其他类中使用
 * @author gdpancheng@gmail.com 2014-5-20 下午11:01:02
 */
public class FourActivity extends Activity {
	
	@InjectView(binders = @InjectBinder(method = "click", listeners = { OnClick.class }))
	TextView test;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    
	    LayoutInflater layoutInflater = LayoutInflater.from(this);
	    View v = layoutInflater.inflate(R.layout.activity_main4, null);
	    Handler_Inject.injectOrther(this, v);
	    setContentView(v);
	}
	
	private void click(){
		Toast.makeText(this, "点击了------------", Toast.LENGTH_SHORT).show();
	}
}
