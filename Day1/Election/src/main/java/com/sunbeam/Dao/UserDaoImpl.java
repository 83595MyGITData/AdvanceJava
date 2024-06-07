package com.sunbeam.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.Entity.User;


   
public class UserDaoImpl {
	
	 private Connection connection;

	    public UserDaoImpl(Connection connection) {
	        this.connection = connection;
	    }

	
	public int save(User user) throws Exception
	{
		String sql = "INSERT INTO users (id,first_name,last_name,email,password,dob,status,role) VALUES (?,?,?,?,?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, user.getId());
            statement.setString(2, user.getFirst_name());
            statement.setString(3, user.getLast_name() );
            statement.setString(4, user.getEmail());
           // statement.setString(5, user.getDob());
            statement.setString(6, user.getPassword());
            statement.setInt(7, user.getStatus());
            statement.setString(8, user.getRole());
            statement.executeUpdate();
        }
		
		return 0;
	} 
	
	


}
