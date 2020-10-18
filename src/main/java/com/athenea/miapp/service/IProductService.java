package com.athenea.miapp.service;

import java.io.Serializable;
import java.util.List;
import com.athenea.miapp.domain.Product;

public interface IProductService extends Serializable {

    public List<Product> getListProduct(Integer userId);

}
