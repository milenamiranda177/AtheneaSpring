package com.athenea.miapp.filter;

import java.io.IOException;
import java.io.Serializable;
import java.net.http.HttpHeaders;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Component;


@Component
@Order(2)
public class AuthenticationFilter implements Filter{

	@Autowired
	//UserService service;
	
	private static final String HEADER_AUTHORIZACION_KEY = "authorization,content-type";
	private static final String AUTHENTICATION_SCHEME = "Basic";
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	
		HttpServletResponse httpresponse = (HttpServletResponse) response;
	    HttpServletRequest httprequest = (HttpServletRequest) request;

	    HttpServletRequest httpRequest = (HttpServletRequest) request;
	    Enumeration<String> headerNames = httpRequest.getHeaderNames();

	    if (headerNames != null) {
	        while (headerNames.hasMoreElements()) {
	            String name = headerNames.nextElement();
	            System.out.println("Header: " + name + " value:" + httpRequest.getHeader(name));
	        }
	    }


	    chain.doFilter(request, response);
		//Get request headers
		//String auth = httpRequest.getHeader("Authorization");
		
		//System.out.println("Aqui entra al filtro de autorización");
		//final String tokenBackend = request.getParameter("TokenCliente");
		
		/*if (auth == null || auth.isEmpty()) {
            //return;
        }*/
		
		//final String token = new String(Base64.decode(auth.replaceFirst(AUTHENTICATION_SCHEME + " ", "").getBytes()));
		
		/*if (token != tokenBackend) {
			//return;
		}*/
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}
