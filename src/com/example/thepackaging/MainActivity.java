package com.example.thepackaging;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button Sign;
	private Button Login;
	private EditText Edit_phone;
	private EditText Edit_password;
	
	public SQLiteActivity memberDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Sign = (Button)findViewById(R.id.sign);
        Login = (Button)findViewById(R.id.login);
        Edit_phone = (EditText)findViewById(R.id.phone);
        Edit_password = (EditText)findViewById(R.id.password);
        memberDAO = new SQLiteActivity(MainActivity.this);
        
        Sign.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent  = new Intent();
				intent.setClass(MainActivity.this, SignInActivity.class);
				startActivity(intent);
				finish();
			}
		});
        Login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String str_phone = Edit_phone.getText().toString();
				String str_password = Edit_password.getText().toString();
				
				if(!str_phone.equals("") && !str_password.equals(""))
				{
					if(str_phone.length() == 11){
						SQLiteDatabase db = memberDAO.getReadableDatabase();
						Cursor c = db.rawQuery("select * from users", null);
						boolean flag = true;
						if(c.getCount()>0){
							while(c.moveToNext()){
								System.out.println();
								if(c.getString(4).equals(str_phone)){
									flag = false;
									if(c.getString(5).equals(str_password)){
										if(c.getString(1).equals(""))
										{
											AdminManage Admin = new AdminManage(str_phone, str_password, "", "", "");
											Intent intent  = new Intent();
											intent.setClass(MainActivity.this, UpdateActivity.class);
											startActivity(intent);
											finish();
										}
										else {
											AdminManage Admin = new AdminManage(str_phone, str_password, c.getString(1), c.getString(2), c.getString(6));
											
											Intent intent  = new Intent();
											intent.setClass(MainActivity.this, HallActivity.class);
											startActivity(intent);
											finish();
										}
									}
									else {
										Toast.makeText(MainActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
									}
								}
							}
						}
						if(flag){
							Toast.makeText(MainActivity.this, "用户不存在", Toast.LENGTH_SHORT).show();
						}
					}
					else {
						Toast.makeText(MainActivity.this, "请输入正确的电话", Toast.LENGTH_SHORT).show();
					}
				}
				else
				{
					Toast.makeText(MainActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
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
