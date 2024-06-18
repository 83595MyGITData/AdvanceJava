package com.sunbeam.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;
import static com.sunbeam.utils.HibernateUtil.getFactory;

import java.io.Serializable;
import java.util.List;

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



	@Override
	public List <Product> getDataBetweenDates(double startPrice, double endPrice) {
		List <Product> prodlist=null;
		Session session=getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String jpql="Select p from Product p where p.price between :stprice and :eprice";
		try {
			  prodlist=session.createQuery(jpql, Product.class).setParameter("stprice",startPrice)
					  .setParameter("eprice",endPrice)
					  .getResultList();
			
			
			tx.commit();
		}catch(RuntimeException e){
			if(tx!=null)
				tx.rollback();
			throw e;
				
		}
		return prodlist;
	}



	public List<Product> getDataBetweenPriceAndCategory(double sPrice, double ePrice, Category cat) {
		List <Product> productList = null;
		Session session=getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String jpql="Select p from Product p where p.category=:category and p.price between :stprice and :eprice";
		try {
			productList=session.createQuery(jpql, Product.class).setParameter("stprice",sPrice)
					  .setParameter("eprice",ePrice)
					  .setParameter("category", cat)
					  .getResultList();
			
			tx.commit();
		}catch(RuntimeException e){
			if(tx!=null)
				tx.rollback();
			throw e;
				
		}
		
		return productList;
	}



	@Override
	public String getDiscountedProductsByPrice(Category cat,double discount) {
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();	
		String message="Apply Discount Failed";
		String jpql="Update Product p set p.price=p.price-:discount where p.category=:cat";
		
		try {
			int count=session.createQuery(jpql)
					.setParameter("discount",discount)
					.setParameter("cat", cat)
					.executeUpdate();
			tx.commit();
			message="Applied Discount"+count;
			
		}catch(RuntimeException e){
			if(tx!=null)
				tx.rollback();
			throw e;
				
		}
		return message;
	}



	@Override
	public String purchaseProduct(Long id, int reqquantity) {
		
		Product p=null;
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		String mess="Purchase Failed";
		
		try {
			p=session.get(Product.class, id);
			if(p.getAvail_Quantity()>0 && reqquantity<=p.getAvail_Quantity()) {
			
				int newquan= p.getAvail_Quantity()- reqquantity;
				p.setAvail_Quantity(newquan);
			tx.commit();
			mess="Item Purchased";
			}
			else {
				mess="Requested Quantity Not available";
			}
			
		}
		catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			
			throw e;
			
		}
		return mess;

	}



	@Override
	public String deleteProductByName(String ProdName) {
		
		String message="Delete Failed";
		Product prod=null;
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		String jpql="Select p from Product p where p.productName=:ProdName";
		
		try {
			prod = session.createQuery(jpql, Product.class)
					.setParameter("ProdName", ProdName).getSingleResult();
			if(prod!=null)
			{
				session.delete(prod);
				message="Delete Successful";
			}
			else {
				message="No data to delete";
			}
			tx.commit();
				
		}
		catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			
			throw e;
			
		}

		return message;
	}
	
	

}
