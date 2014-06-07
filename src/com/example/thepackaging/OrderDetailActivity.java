package com.example.thepackaging;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class OrderDetailActivity extends Activity{

	private TextView Text_meal;
	private TextView Text_canteen;
	private TextView Text_place;
	private TextView Text_intro;
	private TextView Text_name;
	private TextView Text_phone;
	private TextView Text_bname;
	private TextView Text_bphone;
	private Button Btn_acc;
	private Button Btn_back;
	public SQLiteActivity memberDAO;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ordermessage);
        
        Text_meal = (TextView)findViewById(R.id.meal);
        Text_canteen = (TextView)findViewById(R.id.canteen);
        Text_place = (TextView)findViewById(R.id.place);
        Text_intro = (TextView)findViewById(R.id.intro);
        Text_name = (TextView)findViewById(R.id.name);
        Text_phone = (TextView)findViewById(R.id.phone);
        Text_bname = (TextView)findViewById(R.id.bname);
        Text_bphone = (TextView)findViewById(R.id.bphone);
        Btn_acc = (Button)findViewById(R.id.accept);
        Btn_back = (Button)findViewById(R.id.back);
        
        memberDAO = new SQLiteActivity(OrderDetailActivity.this);
        
        Bundle bundle = this.getIntent().getExtras();
		final String id = bundle.getString("id");
		final String who = bundle.getString("who");
		
		if(who.equals("me"))
		{
			SQLiteDatabase db = memberDAO.getReadableDatabase();
			Cursor c = db.rawQuery("select * from myorder", null);
			if(c.getCount()>0){
				while(c.moveToNext()){
					if(c.getString(0).equals(id)){
						Text_meal.setText(c.getString(1));
						Text_canteen.setText(c.getString(2));
						Text_place.setText(c.getString(3));
						Text_intro.setText(c.getString(6));
						Text_name.setText(AdminManage.admin.getname());
						Text_phone.setText(AdminManage.admin.getphone());
						if(c.getString(8).equals("0"))
						{
							Btn_acc.setVisibility(View.INVISIBLE);
						}
						else
						{
							Text_bname.setText(c.getString(5));
							Text_bphone.setText(c.getString(4));
							Btn_acc.setVisibility(View.INVISIBLE);
						}
					}
				}
			}
		}
		else
		{
			SQLiteDatabase db = memberDAO.getReadableDatabase();
			Cursor c = db.rawQuery("select * from otherorder", null);
			if(c.getCount()>0){
				while(c.moveToNext()){
					if(c.getString(0).equals(id)){
						Text_meal.setText(c.getString(1));
						Text_canteen.setText(c.getString(2));
						Text_place.setText(c.getString(3));
						Text_intro.setText(c.getString(6));
						Text_name.setText(c.getString(5));
						Text_phone.setText(c.getString(4));
						if(c.getString(10).equals("0"))
						{
							Btn_acc.setVisibility(View.VISIBLE);
						}
						else
						{
							Text_bname.setText(c.getString(8));
							Text_bphone.setText(c.getString(7));
							Btn_acc.setVisibility(View.INVISIBLE);
						}
					}
				}
			}
		}
		
		Btn_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(who.equals("me"))
				{
					Intent intent  = new Intent();
					intent.setClass(OrderDetailActivity.this, HistoryOrderActivity.class);
					startActivity(intent);
					finish();
				}
				else{
					Intent intent  = new Intent();
					intent.setClass(OrderDetailActivity.this, HallActivity.class);
					startActivity(intent);
					finish();
				}
			}
		});
		Btn_acc.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				SQLiteDatabase db = memberDAO.getWritableDatabase();
				ContentValues values = new ContentValues();
				values.put("bname", AdminManage.admin.getname());
				values.put("bphone", AdminManage.admin.getphone());
				values.put("time", "1");
				String whereClause = "_id = ?";
				String[] whereArgs = {id};
				int row = db.update("otherorder", values, whereClause, whereArgs);
				db.close();
				
				Intent intent  = new Intent();
				intent.setClass(OrderDetailActivity.this, HistoryOrderActivity.class);
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
}
