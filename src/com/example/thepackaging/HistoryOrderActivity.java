package com.example.thepackaging;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class HistoryOrderActivity extends Activity {
	
	private Button Btn_back;
	private ListView listview1, listview2, listview3;
	public SQLiteActivity memberDAO;
	AdminManage admin;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_history);
        
        Btn_back = (Button)findViewById(R.id.back);
        listview1 = (ListView)findViewById(R.id.listView1);
        listview2 = (ListView)findViewById(R.id.listView2);
        listview3 = (ListView)findViewById(R.id.listView3);
        memberDAO = new SQLiteActivity(HistoryOrderActivity.this);
        
        Btn_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent  = new Intent();
				intent.setClass(HistoryOrderActivity.this, PersionalActivity.class);
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
	
	public void findorders()
	{
		List<Map<String, Object>> myorder1 = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> myorder2 = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> otherorder = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = null;
		SimpleAdapter listItemAdapter = null;
		SQLiteDatabase db = memberDAO.getReadableDatabase();
		Cursor c = db.rawQuery("select * from myorder", null);
		if(c.getCount()>0){
			while(c.moveToNext()){
				if(c.getString(8).equals("0"))
				{
					map = new HashMap<String, Object>();
					map.put("intro", c.getString(6));
					map.put("canteen", c.getString(2));
					map.put("meal", c.getString(1));
					myorder1.add(map);
				}
				else {
					map = new HashMap<String, Object>();
					map.put("name", c.getString(5));
					map.put("canteen", c.getString(2));
					map.put("meal", c.getString(1));
					myorder2.add(map);
				}
			}
		}
		
		listItemAdapter = new SimpleAdapter(this, 
				myorder1, 
				R.layout.myorder,
				new String[] { "intro", "canteen", "meal"},
				new int[] { R.id.intro, R.id.canteen, R.id.meal} 
		);
		listview1.setAdapter(listItemAdapter);
		
		listItemAdapter = new SimpleAdapter(this, 
				myorder2, 
				R.layout.order,
				new String[] { "name", "canteen", "meal"},
				new int[] { R.id.name, R.id.canteen, R.id.meal} 
		);
		listview2.setAdapter(listItemAdapter);
		
		c = db.rawQuery("select * from otherorder", null);
		if(c.getCount()>0){
			while(c.moveToNext()){
				if(c.getString(5).equals(admin.getname()))
				{
					map = new HashMap<String, Object>();
					map.put("name", c.getString(5));
					map.put("canteen", c.getString(2));
					map.put("meal", c.getString(1));
					otherorder.add(map);
				}
			}
		}
		
		listItemAdapter = new SimpleAdapter(this, 
				otherorder, 
				R.layout.order,
				new String[] { "name", "canteen", "meal"},
				new int[] { R.id.name, R.id.canteen, R.id.meal} 
		);
		listview3.setAdapter(listItemAdapter);
	}

}
