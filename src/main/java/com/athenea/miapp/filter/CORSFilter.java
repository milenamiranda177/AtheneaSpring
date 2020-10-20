package com.athenea.miapp.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class CORSFilter implements Filter {

	  @Override
	  public void init(FilterConfig filterConfig) throws ServletException {

	  }

	  @Override
	  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		  HttpServletRequest httpRequest = (HttpServletRequest) request;
		    Enumeration<String> headerNames = httpRequest.getHeaderNames();

		    if (headerNames != null) {
		        while (headerNames.hasMoreElements()) {
		            String name = headerNames.nextElement();
		            System.out.println("Header: " + name + " value:" + httpRequest.getHeader(name));
		        }
		    }
		  
		  HttpServletResponse httpResponse = (HttpServletResponse) response;
		  final String origin = "http://localhost:4200";

		  httpResponse.addHeader("Access-Control-Allow-Origin", origin);
		  httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE,OPTIONS");
		  httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
		  httpResponse.setHeader("Access-Control-Allow-Headers",
		            "Authorization, content-type, x-gwt-module-base, x-gwt-permutation, clientid, longpush");

	      
	      chain.doFilter(request, response);
	  }
	  
	 

	  @Override
	  public void destroy() {

	  }
	}
