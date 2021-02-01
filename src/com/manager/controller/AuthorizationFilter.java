package com.manager.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter ("/mainServlet")
public class AuthorizationFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

		System.out.println("AuthorizationFilter");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String parameterAction = request.getParameter("action");
		
		HttpSession session = request.getSession();
		boolean userIsNotLogged = (session.getAttribute("user") == null);
		boolean isProtectedAction = !(parameterAction.equals("LoginForm") || parameterAction.equals("Login"));
		
		if (isProtectedAction && userIsNotLogged) {
			
			response.sendRedirect("redirect:mainServlet?action=LoginForm");
			return;
		}
		
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

	
}
