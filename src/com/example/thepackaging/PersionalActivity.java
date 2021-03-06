package com.example.thepackaging;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PersionalActivity  extends Activity {
	
	private Button Btn_back;
	private Button Btn_history;
	private TextView Text_name;
	private EditText Text_intro;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.persional);
        
        Btn_back = (Button)findViewById(R.id.back);
        Btn_history = (Button)findViewById(R.id.history);
        Text_name = (TextView)findViewById(R.id.name);
        Text_intro = (EditText)findViewById(R.id.intro);
        System.out.println(AdminManage.admin.getname());
        Text_name.setText(AdminManage.admin.getname());
        Text_intro.setText(AdminManage.admin.getintro());
        
        Btn_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent  = new Intent();
				intent.setClass(PersionalActivity.this, HallActivity.class);
				startActivity(intent);
				finish();
			}
		});
        Btn_history.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent  = new Intent();
				intent.setClass(PersionalActivity.this, HistoryOrderActivity.class);
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
