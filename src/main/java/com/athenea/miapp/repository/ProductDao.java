package com.athenea.miapp.repository;

import java.util.List;

import com.athenea.miapp.domain.Product;

public interface ProductDao {

    public List<Product> getProductList(Integer userId);


}