package com.athenea.miapp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.athenea.miapp.domain.Product;

@Repository(value = "productDao")
public class JPAProductDao implements ProductDao {

    private EntityManager em = null;
    
    private List<Product> listRoles;

   
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }


	@Override
	public List<Product> getProductList(Integer userId) {
		List<Product> listProduct = em.createQuery("SELECT p FROM Product p where p.userId = :userId")
                .setParameter("userId", userId).getResultList();
		 if (!listProduct.isEmpty()) {
			 return listProduct;
		 }
		 return null;
	}

    
    
    

	

}
