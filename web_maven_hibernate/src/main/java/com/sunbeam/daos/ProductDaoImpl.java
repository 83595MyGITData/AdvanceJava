package com.sunbeam.daos;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;

public class ProductDaoImpl implements ProductDao{
	
	@Override
	public String addProduct(Long categoryId, Product newProduct) {
		// TODO Auto-generated method stub
		String msg="product add failed..";
		Session session= getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try
		{
			Category category = session.get(Category.class, categoryId);
			if(category!=null)
			{
				category.addProduct(newProduct);
				msg="product added";
			}
			
			tx.commit();
		}
		catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			
			throw e;
		}
		return msg;
	}
	public List<Product> getAllProducts() {
		List<Product> products = null;
		String jpql = "select p from Product p";
		// 1. get session from SF (getCurrentSession)
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			products = session.createQuery(jpql, Product.class).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return products;
	}

	@Override
	public String purchaseProduct(Long productId,int quant) {
		String message="Product purchase Failed .. Try Again";
		Session session = getFactory().getCurrentSession();
		Transaction tx=session.getTransaction();
		try {
			Product prod=session.get(Product.class, productId);
			if(prod!=null)
			{
				if(prod.getAvailQuantity()>=quant)
				{
					prod.setAvailQuantity(prod.getAvailQuantity()-quant);
					message="Product Purchased Successfully";

				}
				else {
					message="Requested Quantity not available";
				}
			}
			
			tx.commit();
		}
		catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return null;
	}
	
}
