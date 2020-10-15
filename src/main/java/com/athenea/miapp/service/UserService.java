package com.athenea.miapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athenea.miapp.domain.Role;
import com.athenea.miapp.domain.UserMaster;

import org.springframework.security.core.userdetails.User;
import com.athenea.miapp.repository.UserDao;

@Service
public class UserService implements IUserService {

    private static final long serialVersionUID = 1L;
    
    @Autowired
    private UserDao userDao;

    public void setProductDao(UserDao productDao) {
        this.userDao = productDao;
    }
    private List<UserMaster> users;

	@Override
	public void createUser(UserMaster user) {
		userDao.saveUser(user);
		
	}
	
	@Override
	public List<UserMaster> getUsers() {
		users = userDao.getUserList();
		return users;
	}

	@Override
	public User verifyLogin(String login) {
		return userDao.verifyLogin(login);
	}
	
	@Override
	public List<Role> getRoles() {
		return userDao.getRoles();
	}
    
    
}
