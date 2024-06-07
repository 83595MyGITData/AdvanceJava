package com.sunbeam.Testor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sunbeam.Dao.UserDaoImpl;
import com.sunbeam.Entity.User;

public class testor_user {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List Userlist;
		UserDaoImpl userdao=null;
		int choice;
		Scanner sc = new Scanner (System.in);
		do {
			
			System.out.println("");
			System.out.println("Enter Choice:");
			choice = sc.nextInt();
			switch(choice)
			{
			case 1:
				Userlist=new ArrayList();
				System.out.println("Enter Id:");
				int id = sc.nextInt();
				System.out.println("Enter first_name:");
				String first_name=sc.next();
				System.out.println("Enter last_name:");
				String last_name=sc.next();
				System.out.println("Enter email:");
				String email=sc.next();
				System.out.println("Enter Password:");
				String password=sc.next();
				
				System.out.println("Enter dob:(DD/MM/YYY)");
				String date=sc.next();
				LocalDate dob=LocalDate.parse(date);
						
				System.out.println("Enter status:");
				int status = sc.nextInt();	
				System.out.println("Enter Role:");
				String role=sc.next();
				
				User user = new User(id,first_name,last_name,email,password,dob,status,role);
				Userlist.add(user);
				try {
					userdao.save(user);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				break;
			
			case 2:
				break;
			
			}
			
		}while(choice!=0);

}
}
