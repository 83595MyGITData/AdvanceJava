package com.sunbeam.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sunbeam.Entity.Candidate;
import com.sunbeam.Entity.User;

public class CandidateDaoImpl {
	private Connection connection;

    public CandidateDaoImpl(Connection connection) {
        this.connection = connection;
    }

	
	public int save(Candidate c) throws Exception
	{
		String sql = "INSERT INTO users (id,name,party,vote) VALUES (?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, c.getId());
            statement.setString(2, c.getName());
            statement.setString(3, c.getParty() );
            statement.setInt(4, c.getVote() );
           
            statement.executeUpdate();
        }
		
		
	 return 0;
	}
	
	public List<Candidate> getAllCandidates() throws SQLException {
        List<Candidate> Candidatelist = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
            	int id =resultSet.getInt(1);
                String name = resultSet.getString(2);
                String party = resultSet.getString(3);
            	int vote =resultSet.getInt(4);

                Candidate candidate = new Candidate(id,name,party,vote);
                Candidatelist.add(candidate);
                
                
            }
        }
        
        for(Candidate can: Candidatelist) {
			System.out.println(can);
			}
        return Candidatelist;
    }

	
	

	

}
