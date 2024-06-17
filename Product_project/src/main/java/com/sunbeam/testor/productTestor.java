package com.sunbeam.testor;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;
import static com.sunbeam.utils.HibernateUtil.getFactory;

public class productTestor {

	public static void main(String []args)
	{
		try(SessionFactory sf=getFactory()){
		Scanner sc = new Scanner(System.in);
		ProductDao prod=new ProductDaoImpl();
//		System.out.println("Enter Category category, String productName, double price, int availQuantity");
//		Product p=new Product(Category.valueOf(sc.next().toUpperCase()),sc.next(),sc.nextDouble(),sc.nextInt());
//		prod.insertData(p);
		
		System.out.println("Enter Product id:");
		Product p = prod.getDataByProdId(sc.nextLong());
		System.out.println(p);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
