package com.athenea.miapp.service;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.security.core.userdetails.User;

import com.athenea.miapp.domain.Role;
import com.athenea.miapp.domain.UserMaster;
import com.athenea.miapp.domain.dto.UserMasterDTO;

public interface IUserService extends Serializable {

    public void createUser(UserMaster user);
    public User verifyLogin(String login);
    public List<UserMaster> getUsers();
    public List<Role> getRoles();
    public UserMaster verifyLogin(UserMasterDTO user) throws NoSuchAlgorithmException;
    public UserMaster getUser(Integer idUser);
    public UserMaster getUserByIdentificacion(String identificacion);
    public String deleteUser(Integer idUser);

}
