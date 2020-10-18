package com.athenea.miapp.repository;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.athenea.miapp.domain.Role;
import com.athenea.miapp.domain.UserMaster;
import com.athenea.miapp.domain.dto.UserMasterDTO;

import org.springframework.security.core.userdetails.User;

public interface UserDao {

    public List<UserMaster> getUserList();

    public void saveUser(UserMaster user);
    
    public User verifyLogin(String login);
    
    public List<Role> getRoles();
    
    public UserMaster verifyLogin(UserMasterDTO user) throws NoSuchAlgorithmException;

}