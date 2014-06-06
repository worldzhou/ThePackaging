package com.example.thepackaging;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddOrderActivity extends Activity{
	
	private Button Btn_ok;
	private Button Btn_back;
	private EditText Edit_place;
	private EditText Edit_meal;
	private EditText Edit_information;
	private Spinner spinner;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_order);
        
        Btn_ok = (Button)findViewById(R.id.ok);
        Btn_back = (Button)findViewById(R.id.back);
        Edit_place = (EditText)findViewById(R.id.place);
        Edit_meal = (EditText)findViewById(R.id.meal);
        Edit_information = (EditText)findViewById(R.id.information);
        spinner = (Spinner)findViewById(R.id.spinner);
        
        Btn_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent  = new Intent();
				intent.setClass(AddOrderActivity.this, HallActivity.class);
				startActivity(intent);
				finish();
			}
		});
        
        Btn_ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String str_place = Edit_place.getText().toString();
				String str_meal = Edit_meal.getText().toString();
				String str_infor = Edit_information.getText().toString();
				
				if(!str_place.equals("") && !str_meal.equals("")){
					Intent intent  = new Intent();
					intent.setClass(AddOrderActivity.this, HistoryOrderActivity.class);
					startActivity(intent);
					finish();
				}
				else {
					Toast.makeText(AddOrderActivity.this, "送餐地点和餐名不能为空", Toast.LENGTH_SHORT).show();
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
