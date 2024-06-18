package com.sunbeam.testor;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;
import static com.sunbeam.utils.HibernateUtil.getFactory;

public class getDiscountedProduct {

	public static void main(String []args)
	{
		try(SessionFactory sf=getFactory()){
		Scanner sc = new Scanner(System.in);
		ProductDao prod=new ProductDaoImpl();
		
		System.out.println("Enter Category and Discount:" );
		System.out.println(prod.getDiscountedProductsByPrice(Category.valueOf(sc.next().toUpperCase()),sc.nextDouble()));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
