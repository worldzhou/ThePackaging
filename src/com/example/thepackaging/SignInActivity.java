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
import android.widget.Toast;

public class SignInActivity extends Activity{
	
	private Button Btn_back;
	private Button Btn_sign;
	private EditText Edit_phone;
	private EditText Edit_password;
	private EditText Edit_passwordagain;
	
	public SQLiteActivity memberDAO;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        
        Btn_sign = (Button)findViewById(R.id.sign_in);
        Btn_back = (Button)findViewById(R.id.back);
        Edit_phone = (EditText)findViewById(R.id.phone);
        Edit_password = (EditText)findViewById(R.id.password);
        Edit_passwordagain = (EditText)findViewById(R.id.passwordsure);
        memberDAO = new SQLiteActivity(SignInActivity.this);
        
        Btn_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent  = new Intent();
				intent.setClass(SignInActivity.this, MainActivity.class);
				startActivity(intent);
				finish();
			}
		});
        
        Btn_sign.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String str_phone = Edit_phone.getText().toString();
				String str_password = Edit_password.getText().toString();
				String str_password2 = Edit_passwordagain.getText().toString();
				if(!str_phone.equals("") && !str_password.equals("") && !str_password2.equals(""))
				{
					if(str_password.equals(str_password2)){
						if(str_phone.length() == 11){
							
							SQLiteDatabase db = memberDAO.getWritableDatabase();
							ContentValues values = new ContentValues();
							values.put("phone", str_phone);
							values.put("password", str_password);
							long rid = db.insert("users", null, values);
							db.close();
							Toast.makeText(SignInActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
							
							Intent intent  = new Intent();
							intent.setClass(SignInActivity.this, MainActivity.class);
							startActivity(intent);
							finish();
						}
						else {
							Toast.makeText(SignInActivity.this, "请输入正确的电话", Toast.LENGTH_SHORT).show();
						}
					}
					else {
						Toast.makeText(SignInActivity.this, "两次输入的密码不同", Toast.LENGTH_SHORT).show();
					}
				}
				else
				{
					Toast.makeText(SignInActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
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
