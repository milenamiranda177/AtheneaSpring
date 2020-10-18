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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Component;

import com.athenea.miapp.service.UserService;

@Component
public class AuthenticationFilter implements Filter{

	@Autowired
	UserService service;
	
	private static final String HEADER_AUTHORIZACION_KEY = "Authorization";
	private static final String AUTHENTICATION_SCHEME = "Basic";
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		//Get request headers
		String auth = httpRequest.getHeader(HEADER_AUTHORIZACION_KEY);
		
		System.out.println("Aqui entra al filtro de autorización");
		final String tokenBackend = request.getParameter("TokenCliente");
		
		if (auth == null || auth.isEmpty()) {
            return;
        }
		
		final String token = new String(Base64.decode(auth.replaceFirst(AUTHENTICATION_SCHEME + " ", "").getBytes()));
		
		if (token != tokenBackend) {
			return;
		}
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}
