package com.athenea.miapp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class CORSFilter implements Filter {

	  @Override
	  public void init(FilterConfig filterConfig) throws ServletException {

	  }

	  @Override
	  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	      HttpServletResponse httpResponse = (HttpServletResponse) response;
	      httpResponse.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
	      httpResponse.addHeader("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS");       
	      
	      
	      httpResponse.addHeader("Access-Control-Allow-Credentials", "true");
	      httpResponse.addHeader("Access-Control-Allow-Headers", "Content-Type,X-Requested-With,accept,Origin,Access-Control-Allow-Origin,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization,Cookie");
	      httpResponse.addHeader("Access-Control-Expose-Headers", "Location, Content-Disposition");
	      httpResponse.addHeader("Access-Control-Allow-Methods", "POST, PUT, GET, DELETE, HEAD, OPTIONS");
	      httpResponse.addHeader("Access-Control-Max-Age", "1209600");
	      chain.doFilter(request, response);
	  }

	  @Override
	  public void destroy() {

	  }
	}
