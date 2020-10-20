package com.athenea.miapp.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athenea.miapp.domain.Role;
import com.athenea.miapp.domain.UserMaster;
import com.athenea.miapp.domain.dto.UserMasterDTO;

import org.springframework.security.core.userdetails.User;
import com.athenea.miapp.repository.UserDao;

@Service
public class UserService implements IUserService {

    private static final long serialVersionUID = 1L;
    
    @Autowired
    private UserDao userDao;

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
	
	@Override
	public UserMaster verifyLogin(UserMasterDTO user) throws NoSuchAlgorithmException {
		return userDao.verifyLogin(user);
	}

	@Override
	public UserMaster getUserByIdentificacion(String identificacion) {
		return userDao.getUserByIdentificacion(identificacion);
	}

	@Override
	public UserMaster getUser(Integer idUser) {
		return userDao.getUser(idUser);
		 
	}
	
	@Override
	public String deleteUser(Integer idUser) {
		userDao.deleteUser(idUser);
		return "";
	}
	
	
    
    
}
