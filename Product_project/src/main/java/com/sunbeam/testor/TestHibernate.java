package com.sunbeam.testor;

import org.hibernate.SessionFactory;
import static com.sunbeam.utils.HibernateUtil.getFactory;


public class TestHibernate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (SessionFactory sf = getFactory()) {
			System.out.println("Hibernate up n running .....");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
