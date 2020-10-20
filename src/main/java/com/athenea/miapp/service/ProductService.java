package com.athenea.miapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athenea.miapp.domain.Product;
import com.athenea.miapp.domain.ViewProductUser;
import com.athenea.miapp.repository.UserDao;

@Service
public class ProductService implements IProductService {

    private static final long serialVersionUID = 1L;
    
    @Autowired
    private UserDao userDao;


	@Override
	public List<Product> getListProduct(Integer userId) {
		return userDao.getProductList(userId);
	}
	
	@Override
	public String saveProduct(Product product) {
		userDao.saveProduct(product);
		return "";
	}

	@Override
	public String deleteProduct(Integer productId) {
		userDao.deleteProduct(productId);
		return "";
	}
	@Override
	public List<ViewProductUser> getReport(){
		return userDao.getReport();
	}
	
	
}
