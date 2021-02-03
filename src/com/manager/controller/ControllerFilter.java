package com.manager.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.model.dao.Action;

//@WebFilter("/mainServlet")
public class ControllerFilter implements Filter {

	@Override
	public void destroy() {
		 
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		 
		System.out.println("ControllerFilter");
		
		HttpServletRequest   request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String       parameterAction = request.getParameter("action");		
		String             nameClass = "com.manager.model.dao." + parameterAction;
		String                  view;
		
		try {
			
			Class auxClass = Class.forName(nameClass);
			Object  object = auxClass.newInstance();
			Action  action = (Action) object;
			          view = action.performs(request, response);
			          
		} catch (Exception e) {
			
			throw new ServletException(e);
			
		}

		String[] typeOfAddress = view.split(":");
		
		if (typeOfAddress [0].equals("redirect")) {
			
			response.sendRedirect(typeOfAddress[1]);
			
		}else {
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view"+typeOfAddress[1]);		
			rd.forward(request, response);
		}  
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		 
		
	}

}
