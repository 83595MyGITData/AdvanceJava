package com.sunbeam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.entities.Product;

@Service
@Transactional 
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao prodDao ;

	@Override
	public List<Product> getAllProducts() {
		
		return prodDao.findAll();
	}

	@Override
	public Product addProduct(Product p) {
		// TODO Auto-generated method stub
		return prodDao.save(p);
	}

	@Override
	public Product getProduct(Long id) {
		// TODO Auto-generated method stub
		return prodDao.findById(id).orElseThrow(()-> new RuntimeException("Invalid Product"));
	}

	@Override
	public String deleteProductbyId(Long id) {
		
		if(prodDao.existsById(id))
		{
			prodDao.deleteById(id);
			return "Deleted Successfully";
		}
		else
		{
			return "Product does not exists";
		}
		
	}

	@Override
	public String updateProductbyId(Long id,Product prod) {
		// TODO Auto-generated method stub
		if(prodDao.existsById(id))
		{
			prodDao.save(prod);
			return "Product Details Updated Successfully";
		}
		return "Product does not exists";
	}
	
	
}
	
