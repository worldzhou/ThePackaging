package com.example.thepackaging;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class HallActivity extends Activity{
	
	private List<Map<String, Object>> mDataList = new ArrayList<Map<String, Object>>();
	
	private ListView mListView;
	private Button Btn_add;
	private Button Btn_per;
	private Button Btn_reflash;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hall);
        
        Btn_add = (Button)findViewById(R.id.add_order);
        Btn_per = (Button)findViewById(R.id.persional);
        Btn_reflash = (Button)findViewById(R.id.reflash);
        mListView = (ListView)findViewById(R.id.listView);
        
        setData();
        mListView.setOnItemClickListener(mItemClickListener);
        Btn_add.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent  = new Intent();
				intent.setClass(HallActivity.this, AddOrderActivity.class);
				startActivity(intent);
				finish();
			}
		});
        Btn_per.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent  = new Intent();
				intent.setClass(HallActivity.this, PersionalActivity.class);
				startActivity(intent);
				finish();
			}
		});
        
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
	
	private void setData() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "world");
		map.put("canteen", "¶þ·¹");
		map.put("meal", "Ã÷Â¯ÉÕÑ¼ÍÈ");
		mDataList.add(map);
		
		map = new HashMap<String, Object>();
		map.put("name", "angle");
		map.put("canteen", "¶þ·¹");
		map.put("meal", "Ã÷Â¯ÉÕÑ¼ÍÈ");
		mDataList.add(map);
		
		map = new HashMap<String, Object>();
		map.put("name", "ÀîËÄ");
		map.put("canteen", "¶þ·¹");
		map.put("meal", "Ã÷Â¯ÉÕÑ¼ÍÈ");
		mDataList.add(map);

		map = new HashMap<String, Object>();
		map.put("name", "ÍõÎå");
		map.put("canteen", "¶þ·¹");
		map.put("meal", "Ã÷Â¯ÉÕÑ¼ÍÈ");
		mDataList.add(map);

		map = new HashMap<String, Object>();
		map.put("name", "ÖìÁù");
		map.put("canteen", "¶þ·¹");
		map.put("meal", "Ã÷Â¯ÉÕÑ¼ÍÈ");
		mDataList.add(map);

		map = new HashMap<String, Object>();
		map.put("name", "×¿Æß");
		map.put("canteen", "¶þ·¹");
		map.put("meal", "Ã÷Â¯ÉÕÑ¼ÍÈ");
		mDataList.add(map);
		
		map = new HashMap<String, Object>();
		map.put("name", "×¿Æß");
		map.put("canteen", "¶þ·¹");
		map.put("meal", "Ã÷Â¯ÉÕÑ¼ÍÈ");
		mDataList.add(map);
		
		map = new HashMap<String, Object>();
		map.put("name", "×¿Æß");
		map.put("canteen", "¶þ·¹");
		map.put("meal", "Ã÷Â¯ÉÕÑ¼ÍÈ");
		mDataList.add(map);
		
		map = new HashMap<String, Object>();
		map.put("name", "");
		map.put("canteen", "");
		map.put("meal", "");
		mDataList.add(map);
		
		SimpleAdapter listItemAdapter = new SimpleAdapter(this, 
				mDataList, 
				R.layout.order,
				new String[] { "name", "canteen", "meal"},
				new int[] { R.id.name, R.id.canteen, R.id.meal} 
		);
		
		mListView.setAdapter(listItemAdapter);
	}
	
	private OnItemClickListener mItemClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			
			//Bundle bundle = new Bundle();
			//bundle.putString("itemName", (String) mDataList.get(arg2).get("name"));
		}
	
	};
}
