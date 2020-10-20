package com.athenea.miapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.athenea.miapp.domain.Product;
import com.athenea.miapp.repository.UserDao;

public class JPAProductDaoTests {

    private ApplicationContext context;
    private UserDao userDao;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
        userDao = (UserDao) context.getBean("userDao");
    }

   /* @Test
    public void testSaveUser() throws NoSuchAlgorithmException {
    	List<UserMaster> user = userDao.getUserList();
    	Integer countBefore = user.size();
    	
        UserMaster p = new UserMaster();
        p.setLogin("PEDRO");
        p.setEnabled(1);
        p.setPassword("12345");
        p.setFullname("PEDRO EL ESCAMOSO");
        p.setTipoidentificacion("CC");
        
        p.addAuthorities("ROLE_USER");
        
        userDao.saveUser(p);

        user = userDao.getUserList();
        Integer countAfter = user.size();
        assertNotSame(countBefore, countAfter);
    }*/
    
    @Test
    public void testSaveProduct() throws NoSuchAlgorithmException {
    	List<Product> user = userDao.getProductList(1);
    	Integer countBefore = user.size();
    	
        Product p = new Product();
        p.setEnabled(1);
        p.setTypeProduct("tarjeta_credito");
        p.setUserIdProduct(1);
        p.setValor("4444");

        
        userDao.saveProduct(p);

        user = userDao.getProductList(1);
        Integer countAfter = user.size();
        assertNotSame(countBefore, countAfter);
    }
}