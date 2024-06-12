package com.sunbeam.javabeans;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class LoginBean {
	private String email;
	private String password;
	private int status;
	private int id;
	private User user;
	
	public LoginBean() {
		// TODO Auto-generated constructor stub
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void updateStatusUser()
	{
		try(UserDao userdao= new UserDaoImpl())
		{
			
			userdao.updateStatus(user.getId(),true);
			//System.out.println("Id:"+user.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void authenticate() {
		// TODO Auto-generated method stub
		User user= new User();
		try(UserDao userdao= new UserDaoImpl())
		{
			user=userdao.findByEmail(email);
			
			if(user!=null && user.getPassword().equals(password) )
			{
				this.user=user;
			}
			else
			{
				this.user=null;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
