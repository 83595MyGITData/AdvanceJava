package com.sunbeam.javabeans;

import java.util.List;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class CandidateListBean {
	private List<Candidate> candList;
	public CandidateListBean() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Candidate> getCandList() {
		return candList;
	}

	public void setCandList(List<Candidate> candList) {
		this.candList = candList;
	}

	public void displayCandidate()
	{
		try(CandidateDao candao= new CandidateDaoImpl())
		{
			candList=candao.findAll();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
