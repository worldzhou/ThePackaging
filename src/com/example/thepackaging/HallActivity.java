package com.example.thepackaging;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
	public SQLiteActivity memberDAO;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hall);
        
        Btn_add = (Button)findViewById(R.id.add_order);
        Btn_per = (Button)findViewById(R.id.persional);
        Btn_reflash = (Button)findViewById(R.id.reflash);
        mListView = (ListView)findViewById(R.id.listView);
        memberDAO = new SQLiteActivity(HallActivity.this);
        
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
		/*String[] meal = new String[]{"À±×Ó¼¦·¹","ºìÉÕ¶¹¸¯·¹","¶¹½ÇÇÑ×Ó·¹"};
		String[] canteen = new String[]{"ËÄ·¹","Ò»·¹","¶þ·¹"};
		String[] place = new String[]{"É÷6","ÖÁ2","¹«½Ì"};
		String[] name = new String[]{"Ð¡Ð¡³¬","CC","ÃÔÄã±ù"};
		String[] phone = new String[]{"13838383838","12020202020","213213213222"};
		String[] intro = new String[]{"¼Ó·¹¼ÓÌÀ","ÉÙ·¹","¼Ó·¹£¬Ð»Ð»£¡"};
		for(int i=0;i<3;i++){
			SQLiteDatabase db = memberDAO.getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put("foodname", meal[i]);
			values.put("canteen", canteen[i]);
			values.put("place", place[i]);
			values.put("intro", intro[i]);
			values.put("name", name[i]);
			values.put("phone", phone[i]);
			values.put("time", "0");
			long rid = db.insert("otherorder", null, values);
			db.close();
		}
		*/
		addTotest();
		Map<String, Object> map = null;
		SQLiteDatabase db = memberDAO.getReadableDatabase();
		Cursor c = db.rawQuery("select * from otherorder", null);
		if(c.getCount()>0){
			while(c.moveToNext()){
				if(c.getString(10).equals("0"))
				{
					map = new HashMap<String, Object>();
					map.put("id", c.getString(0));
					map.put("name", c.getString(5));
					map.put("canteen", c.getString(2));
					map.put("meal", c.getString(1));
					mDataList.add(map);
				}
			}
		}
		
		SimpleAdapter listItemAdapter = new SimpleAdapter(this, 
				mDataList, 
				R.layout.order,
				new String[] { "name", "canteen", "meal"},
				new int[] { R.id.name, R.id.canteen, R.id.meal} 
		);
		
		mListView.setAdapter(listItemAdapter);
	}
	public void addTotest()
	{
		
		
	}
	
	private OnItemClickListener mItemClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			Bundle bundle = new Bundle();
			bundle.putString("id", (String) mDataList.get(arg2).get("id"));
			bundle.putString("who", "others");
			
			Intent intent = new Intent();
			intent.setClass(HallActivity.this, OrderDetailActivity.class);
			intent.putExtras(bundle);
			startActivity(intent);
			finish();
		}
	
	};
}
