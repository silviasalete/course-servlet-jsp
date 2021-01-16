package com.manager.model.dao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveCompanies {

	public void performs(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		System.out.println("removing companies");
		
		String parameterId = request.getParameter("id");
		Integer 		id = Integer.valueOf(parameterId);		
		DataBase  dataBase = new DataBase();
		dataBase.removeCompany(id);
		 
		response.sendRedirect("mainServlet?action=ListCompanies");
	}
}
