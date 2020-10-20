package com.athenea.miapp.restfull;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value = UserURIConstants.GET_USER, method = RequestMethod.GET)
	public @ResponseBody UserMaster getUser(@PathVariable("id") Integer userId) {
		logger.info("Start getUser ");
		return service.getUser(userId);
	}
	
	@RequestMapping(value = UserURIConstants.SAVE_USER, method = RequestMethod.POST)
	public @ResponseBody ResponseEntity saveUser(@RequestBody UserMaster user) {
		logger.info("Start saveUser ");
		UserMaster master = service.getUserByIdentificacion(user.getLogin());
		if (master == null ) {
			user.addAuthorities(user.getAuthorities().get(0).getAuthority());
			user.getAuthorities().remove(0);
			service.createUser(user);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@RequestMapping(value = UserURIConstants.SAVE_USER, method = RequestMethod.PUT)
	public @ResponseBody ResponseEntity updateSave(@RequestBody UserMaster user) {
		if (!user.getAuthorities().isEmpty()) {
			user.addAuthorities(user.getAuthorities().get(0).getAuthority());
			user.getAuthorities().remove(0);
		}
		service.createUser(user);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = UserURIConstants.DELETE_USER, method = RequestMethod.DELETE)
	public @ResponseBody String deleteProduct(@PathVariable("id") Integer idUser) {
		service.deleteUser(idUser);
		return "";
	}
	
}
