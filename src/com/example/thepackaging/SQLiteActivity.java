package com.example.thepackaging;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class SQLiteActivity extends SQLiteOpenHelper {

	public SQLiteActivity(Context context) {
		super(context, "packaging.db", null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String SQL_CREATE_TABLE = 
				"create table " + "users"
				+ " (_id integer primary key autoincrement,"
				+ " name TEXT,"
				+ " sex TEXT,"
				+ " image TEXT,"
				+ " phone TEXT,"
				+ " password TEXT,"
				+ " intro TEXT );";
		db.execSQL(SQL_CREATE_TABLE);
		SQL_CREATE_TABLE = 
				"create table " + "myorder"
				+ " (_id integer primary key autoincrement,"
				+ " foodname TEXT,"
				+ " canteen TEXT,"
				+ " place TEXT,"
				+ " bphone TEXT,"
				+ " bname TEXT,"
				+ " intro TEXT,"
				+ " bintro TEXT,"
				+ " time TEXT );";
		db.execSQL(SQL_CREATE_TABLE);
		SQL_CREATE_TABLE = 
				"create table " + "otherorder"
				+ " (_id integer primary key autoincrement,"
				+ " foodname TEXT,"
				+ " canteen TEXT,"
				+ " place TEXT,"
				+ " phone TEXT,"
				+ " name TEXT,"
				+ " intro TEXT,"
				+ " bphone TEXT,"
				+ " bname TEXT,"
				+ " bintro TEXT,"
				+ " time TEXT );";
		db.execSQL(SQL_CREATE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}	
}
