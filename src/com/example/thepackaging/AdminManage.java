package com.example.thepackaging;

public class AdminManage {
	public static AdminManage admin;
	private String phone;
	private String password;
	private String name;
	private String sex;
	private String intro;
	public AdminManage(String phone,String password,String name, String sex, String intro){
		this.phone = phone;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.intro = intro;
	}
	
	public String getphone()
	{
		return phone;
	}
	public void setphone(String phone)
	{
		this.phone = phone;
	}
	public String getpassword()
	{
		return password;
	}
	public void setpassword(String password)
	{
		this.password = password;
	}
	public String getname()
	{
		return name;
	}
	public void setname(String name)
	{
		this.name = name;
	}
	public String getsex()
	{
		return sex;
	}
	public void setsex(String sex)
	{
		this.sex = sex;
	}
	public String getintro()
	{
		return intro;
	}
	public void setintro(String intro)
	{
		this.intro = intro;
	}
}
