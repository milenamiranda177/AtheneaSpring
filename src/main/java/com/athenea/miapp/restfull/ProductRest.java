package com.athenea.miapp.restfull;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.athenea.miapp.domain.Product;
import com.athenea.miapp.domain.ViewProductUser;
import com.athenea.miapp.service.ProductService;
import com.athenea.miapp.utils.UserURIConstants;

/**
 * RestFull para productos
 */
@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class ProductRest {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductRest.class);
	@Autowired
	ProductService service;
	
	@RequestMapping(value = UserURIConstants.ALL_PRODUCTS, method = RequestMethod.GET)
	public @ResponseBody List<Product> getProduts(@PathVariable("id") Integer userId) {
		logger.info("Start getAllProducts");
		return service.getListProduct(userId);
	}
	
	@RequestMapping(value = UserURIConstants.SAVE_PRODUCT, method = RequestMethod.POST)
	public @ResponseBody String saveProduct(@RequestBody Product product) {
		service.saveProduct(product);
		return "";
	}
	
	@RequestMapping(value = UserURIConstants.DELETE_PRODUCT, method = RequestMethod.DELETE)
	public @ResponseBody String deleteProduct(@PathVariable("id") Integer productId) {
		service.deleteProduct(productId);
		return "";
	}
	
	@RequestMapping(value = UserURIConstants.REPORT, method = RequestMethod.GET)
	public @ResponseBody List<ViewProductUser> getReport() {
		logger.info("Start getReport");
		return service.getReport();
	}
	
	
}
