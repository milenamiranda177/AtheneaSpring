package com.athenea.miapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athenea.miapp.domain.Product;
import com.athenea.miapp.repository.ProductDao;

@Service
public class ProductService implements IProductService {

    private static final long serialVersionUID = 1L;
    
    @Autowired
    private ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

	@Override
	public List<Product> getListProduct(Integer userId) {
		
		return productDao.getProductList(userId);
	}
    
	
    
    
}
