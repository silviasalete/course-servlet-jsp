package com.manager.controller;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.manager.model.dao.ListCompanies;
import com.manager.model.dao.NewCompany;
import com.manager.model.dao.RemoveCompanies;
import com.manager.model.dao.UpdateCompanies;


@WebServlet("/mainServlet")
public class MainServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parameterAction = request.getParameter("action");
		
		if (parameterAction.equals("ListCompanies")) {
			
			ListCompanies listcompanies = new ListCompanies();
			listcompanies.performs(request,response);
			
		} else if(parameterAction.equals("RemoveCompanies")) {
			
			RemoveCompanies removeCompanies = new RemoveCompanies();
			removeCompanies.performs(request, response);
			
		} else if(parameterAction.equals("UpdateCompanies")) {
			
			UpdateCompanies updateCompanies = new UpdateCompanies();
			updateCompanies.performs(request, response);
			
		} else if(parameterAction.equals("NewCompany")) {
			
			NewCompany newCompany = new  NewCompany();
			
			newCompany.performs(request, response);
		}
			
	}

}
