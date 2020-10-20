package com.athenea.miapp.service;

import java.io.Serializable;
import java.util.List;
import com.athenea.miapp.domain.Product;
import com.athenea.miapp.domain.ViewProductUser;

public interface IProductService extends Serializable {

    public List<Product> getListProduct(Integer userId);
    public String saveProduct(Product product);
    public String deleteProduct(Integer productId);
    public List<ViewProductUser> getReport();

}
