package com.sunbeam.javabeans;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class LoginBean {
	
	private String email;
	private String password;
	private User usr;
	
	public LoginBean()
	{
		
	}
	
	
	
	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public User getUsr() {
		return usr;
	}



	public void setUsr(User usr) {
		this.usr = usr;
	}



	


	public void authenticate() {
	try(UserDao user = new UserDaoImpl();)
	{
		usr = user.findByEmail(email);
		
		if(usr!=null && this.getPassword().equals(usr.getPassword()))
		{
			this.usr=usr;
		}
		else
		{
			this.usr=null;
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	

}
