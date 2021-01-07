package com.manager.controller;

import java.io.IOException; 
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.model.bean.Company;
import com.manager.model.dao.DataBase;  

@WebServlet("/listCompanies")
public class ListCompaniesServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		DataBase  	dataBase = new DataBase();
		
		List<Company> list 	 = dataBase.getCompanies(); 
		
		request.setAttribute("listCompanies", list);

		RequestDispatcher rd = request.getRequestDispatcher("/listCompanies.jsp");
		
		rd.forward(request, response);

	}

}
