package com.example.thepackaging;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class UpdateActivity extends Activity{
	
	private EditText Edit_name;
	private EditText Edit_intro;
	private RadioGroup radio_sex;
	private Button Btn_next;
	public SQLiteActivity memberDAO;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);
        
        Edit_name = (EditText)findViewById(R.id.name);
        Edit_intro = (EditText)findViewById(R.id.perintro);
        radio_sex = (RadioGroup)findViewById(R.id.radioGroup);
        Btn_next = (Button)findViewById(R.id.next);
        memberDAO = new SQLiteActivity(UpdateActivity.this);
        
        Btn_next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String str_name = Edit_name.getText().toString();
				String str_intro = Edit_intro.getText().toString();
				String str_sex = null;
				int selectId = radio_sex.getCheckedRadioButtonId();
				if(selectId == R.id.radio0)
					str_sex = "男";
				else
					str_sex = "女";
				if(!str_name.equals("") && !str_intro.equals(""))
				{
					SQLiteDatabase db = memberDAO.getWritableDatabase();
					ContentValues values = new ContentValues();
					values.put("name", str_name);
					values.put("sex", str_sex);
					values.put("intro", str_intro);
					String whereClause = "phone = ?";
					String[] whereArgs = {AdminManage.admin.getphone()};
					int row = db.update("users", values, whereClause, whereArgs);
					db.close();
					AdminManage.admin.setname(str_name);
					AdminManage.admin.setsex(str_sex);
					AdminManage.admin.setintro(str_intro);
					
					Intent intent  = new Intent();
					intent.setClass(UpdateActivity.this, HallActivity.class);
					startActivity(intent);
					finish();
				}
				else
				{
					Toast.makeText(UpdateActivity.this, "姓名或个人简介不能为空", Toast.LENGTH_SHORT).show();
				}
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
