/*************************************************************************************************
 * 版权所有 (C)2015,  
 * 
 * 文件名称：RegistActivity1.java
 * 内容摘要：RegistActivity1.java
 * 当前版本：TODO
 * 作        者：李加蒙
 * 完成日期：2015-11-3 下午10:13:15
 * 修改记录：
 * 修改日期：2015-11-3 下午10:13:15
 * 版   本 号：
 * 修   改 人：
 * 修改内容：
 ************************************************************************************************/
package com.xh.shopping.ui.activity;

import java.util.HashMap;
import java.util.Map;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.xh.shopping.R;
import com.xh.shopping.constant.Constant;
import com.xh.shopping.serve.JSONDataService;
import com.xh.shopping.util.ToastUtil;
import com.xh.shopping.util.UIHelper;

/**
 @filename文件名称：RegistActivity1.java
 @content
 */
/**
 * @FileName 文件名称：RegistActivity1.java
 * @Contents 内容摘要： 注册Activity
 */
@SuppressLint("HandlerLeak")
public class TestRegistActivity extends FragmentActivity {
	private EditText user, psw1, psw2;

	private Button button;

	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			String json = (String) msg.obj;
			System.out.println("返回结果:" + json);
			ToastUtil.makeToast(TestRegistActivity.this, json);
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regist);
		findView();
	}

	private void findView() {
		user = (EditText) findViewById(R.id.user);
		psw1 = (EditText) findViewById(R.id.psw1);
		psw2 = (EditText) findViewById(R.id.psw2);
		button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (UIHelper.isEdittextHasData(user)) {
					ToastUtil.makeToast(TestRegistActivity.this, "账号不可为空");
					return;
				}
				if (UIHelper.isEdittextHasData(psw1)) {
					ToastUtil.makeToast(TestRegistActivity.this, "密码不可为空");
					return;
				}
				if (UIHelper.isEdittextHasData(psw2)) {
					ToastUtil.makeToast(TestRegistActivity.this, "确认密码不可为空");
					return;
				}
				if (!psw1.getText().toString().trim()
						.equals(psw2.getText().toString().trim())) {
					ToastUtil.makeToast(TestRegistActivity.this, "密码和确认密码不同");
					return;
				}

				Map<String, String> map = new HashMap<String, String>();
				map.put("username", user.getText().toString().trim());
				map.put("password", psw1.getText().toString().trim());
				map.put("password2", psw2.getText().toString().trim());
				map.put("phone", user.getText().toString().trim());

				JSONDataService service = new JSONDataService(Constant
						.getService(Constant.API_REGISTER), map, handler);
				service.start();
			}
		});
	}

}
