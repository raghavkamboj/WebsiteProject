package com.quizwebsite.core.usermodel;

public class User {
	
	private String username;
	private String pass;
	
	public User(String pass, String username)
	{
		super();
		this.pass=pass;
		this.username=username;
	}
	
	public User()
	{
		super();
	}
	
	public String getUsername()
	{
		return this.username;
	}
	
	
	public String getPass()
	{
		return this.pass;
	}
	
	public void setUsername(String username)
	{
		this.username=username;
	}
	
	public void setPass(String pass)
	{
		this.pass=pass;
	}
}