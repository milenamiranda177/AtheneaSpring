package com.athenea.miapp.restfull;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.athenea.miapp.domain.UserMaster;
import com.athenea.miapp.domain.dto.UserMasterDTO;
import com.athenea.miapp.service.UserService;
import com.athenea.miapp.utils.UserURIConstants;

/**
 * RestFull para usuarios
 */
@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class UserRest {
	
	private static final Logger logger = LoggerFactory.getLogger(UserRest.class);
	@Autowired
	UserService service;
	
	@RequestMapping(value = UserURIConstants.ALL_USERS, method = RequestMethod.GET)
	public @ResponseBody List<UserMaster> getUsers() {
		logger.info("Start getAllUsers");
		return service.getUsers();
	}
	
	@RequestMapping(value = UserURIConstants.LOGIN, method = RequestMethod.POST)
	public @ResponseBody UserMaster login(@RequestBody UserMasterDTO user, HttpServletRequest request ) throws NoSuchAlgorithmException {
		logger.info("Start getAllUsers");
		return service.verifyLogin(user);
	}
	
}
