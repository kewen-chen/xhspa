/*************************************************************************************************
 * ��Ȩ���� (C)2015,  
 * 
 * �ļ����ƣ�RegisterActivity.java
 * ����ժҪ��RegisterActivity.java
 * ��ǰ�汾��TODO
 * ��        �ߣ������
 * ������ڣ�2015-11-3 ����9:35:16
 * �޸ļ�¼��
 * �޸����ڣ�2015-11-3 ����9:35:16
 * ��   �� �ţ�
 * ��   �� �ˣ�
 * �޸����ݣ�
 ************************************************************************************************/
package com.xh.shopping.ui.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

import com.xh.shopping.ui.activity.fragment.RegistFragment;

/**
 * @FileName �ļ����ƣ�RegisterActivity.java
 * @Content ����ժҪ��ע�����
 */
public class RegistActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		RegistFragment registFragment = new RegistFragment();
//		FragmentManager manager = registFragment.getFragmentManager();
	}

}
