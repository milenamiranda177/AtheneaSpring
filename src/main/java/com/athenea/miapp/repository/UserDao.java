package com.athenea.miapp.repository;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.athenea.miapp.domain.Product;
import com.athenea.miapp.domain.Role;
import com.athenea.miapp.domain.UserMaster;
import com.athenea.miapp.domain.ViewProductUser;
import com.athenea.miapp.domain.dto.UserMasterDTO;

import org.springframework.security.core.userdetails.User;

public interface UserDao {
	
	//Usuarios

    public List<UserMaster> getUserList();

    public void saveUser(UserMaster user);
    
    public User verifyLogin(String login);
    
    public UserMaster getUser(Integer idUser);
    
    public List<Role> getRoles();
    
    public UserMaster verifyLogin(UserMasterDTO user) throws NoSuchAlgorithmException;
    
    public UserMaster getUserByIdentificacion(String identificacion);
    
    public String deleteUser(Integer idUser);
    
    //Productos
    
    public List<Product> getProductList(Integer userId) ;
    
    public String saveProduct(Product product);
    
    public String deleteProduct(Integer userProductId);
    
    public List<ViewProductUser> getReport() ;

}