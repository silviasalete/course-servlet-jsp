package com.manager.model.dao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCompany implements Action {
	
	public String performs(HttpServletRequest request, HttpServletResponse response) {
			return "forward:/formNewCompany.jsp";
	}
}
