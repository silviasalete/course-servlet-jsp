package com.manager.model.dao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveCompanies implements Action {

	public String performs(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String parameterId = request.getParameter("id");
		Integer 		id = Integer.valueOf(parameterId);		
		DataBase  dataBase = new DataBase();
		dataBase.removeCompany(id);
		 
		return "redirect:mainServlet?action=ListCompanies";
	}
}
