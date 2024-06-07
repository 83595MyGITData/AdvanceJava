package com.sunbeam.Testor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sunbeam.Dao.CandidateDaoImpl;
import com.sunbeam.Dao.UserDaoImpl;
import com.sunbeam.Entity.Candidate;

public class testot_candidate {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List Candidatelist;
		CandidateDaoImpl candidatedao= null;
		int choice;
		Scanner sc = new Scanner (System.in);
		do {
			
			System.out.println("");
			System.out.println("Enter Choice:");
			choice = sc.nextInt();
			switch(choice)
			{
			
			
			case 1:
				List Candidatelist= new ArrayList();
				
				System.out.println("Enter id:");
				int id = sc.nextInt();
				System.out.println("Enter name:");
				String name=sc.next();
				System.out.println("Enter party:");
				String party=sc.next();
				System.out.println("Enter vote:");
				int vote = sc.nextInt();
				
				
				Candidate candidate= new Candidate(id,name,party,vote);
				Candidatelist.add(candidate);
				try {
					candidatedao.save(candidate);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;
				
			case 2:
				List<Candidate> Candidatelist1= new ArrayList();

				try {
					Candidatelist1 = candidatedao.getAllCandidates();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				break;
			
			}
			
		}while(choice!=0);

}

}
