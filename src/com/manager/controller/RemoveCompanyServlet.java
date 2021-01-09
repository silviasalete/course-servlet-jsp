package com.manager.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.model.dao.DataBase;
 
@WebServlet("/removeCompany")
public class RemoveCompanyServlet extends HttpServlet {   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parameterId = request.getParameter("id");
		DataBase dataBase = new DataBase();
		dataBase.removeCompany(Integer.parseInt(parameterId));
		 
		response.sendRedirect("listCompanies");
	}  

}
