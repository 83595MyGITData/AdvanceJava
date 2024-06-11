package com.sunbeam.javabeans;

import java.sql.Date;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class RegisterBean {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String dob;
	
	public RegisterBean()
	{
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public void registerUser() {
		Date date =Date.valueOf(dob);
		
		User u=new User(firstName,lastName,email,password,date,0,"voter");
		System.out.println(u.toString());
		try(UserDao user = new UserDaoImpl();)
		{
			user.save(u);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
