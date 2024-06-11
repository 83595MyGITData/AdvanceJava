package com.sunbeam.javabeans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;

public class DeleteCandidateBean {
	private int id;
	private int count;
	
	public DeleteCandidateBean() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public void DeleteCand()
	{	System.out.println("id"+id);
		try(CandidateDao cand = new CandidateDaoImpl();){
			count = cand.deleteById(id);
			System.out.println(count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
