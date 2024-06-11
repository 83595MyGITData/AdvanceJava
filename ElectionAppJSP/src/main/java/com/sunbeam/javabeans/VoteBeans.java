package com.sunbeam.javabeans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class VoteBeans {
	private int id;
	private int count;
	private int status;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	private int uid;
	public VoteBeans() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void castVote()
	{
		//System.out.println("InsidecastVote"+id);
		try(CandidateDao canddao= new CandidateDaoImpl();UserDao user= new UserDaoImpl();)
		{
			count= canddao.incrementVote(id);
			
			if(count==1)
			user.updateStatus(uid, true);
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

}
