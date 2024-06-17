package com.sunbeam.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunbeam.entities.Product;
import static com.sunbeam.utils.HibernateUtil.getFactory;

import java.io.Serializable;

public class ProductDaoImpl implements ProductDao {

	@Override
	public void insertData(Product p1) {
		// TODO Auto-generated method stub
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();	
		
		try {
			Serializable productId=session.save(p1);
			tx.commit();
			System.out.println("Product Inserted"+productId);
			
		}catch(RuntimeException e){
			if(tx!=null)
				tx.rollback();
			throw e;
				
		}
	}

	

	@Override
	public Product getDataByProdId(Long id) {
		// TODO Auto-generated method stub
		Product p=null;
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();	
		try {
			p=session.get(Product.class, id);
			tx.commit();
		}
		catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			
			throw e;
			
		}
		return p;
	}

}
