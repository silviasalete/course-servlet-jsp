package com.manager.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.model.dao.AddCompany;
import com.manager.model.dao.ListCompanies;
import com.manager.model.dao.NewCompany;
import com.manager.model.dao.RemoveCompanies;
import com.manager.model.dao.ShowCompanies;
import com.manager.model.dao.UpdateCompanies;


@WebServlet("/mainServlet")
public class MainServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parameterAction = request.getParameter("action");
		String 			  view = null;
		
		if (parameterAction.equals("ListCompanies")) {
			
			ListCompanies listcompanies = new ListCompanies();
			view = listcompanies.performs(request,response);
			
		} else if(parameterAction.equals("RemoveCompanies")) {
			
			RemoveCompanies removeCompanies = new RemoveCompanies();
			view = removeCompanies.performs(request, response);
			
		} else if(parameterAction.equals("ShowCompanies")) {
			
			ShowCompanies showCompanies = new ShowCompanies();
			view = showCompanies.performs(request, response);
			
		} else if(parameterAction.equals("NewCompany")) {
			
			NewCompany newCompany = new  NewCompany();			
			view = newCompany.performs(request, response);
			
		} else if(parameterAction.equals("UpdateCompanies")) {
			
			UpdateCompanies updateCompanies = new UpdateCompanies();
			view = updateCompanies.performs(request,response);
			
		} else if(parameterAction.equals("AddCompany")) {
			
			AddCompany addCompany = new AddCompany();
			view = addCompany.permforms();
			
		}

		String[] typeOfAddress = view.split(":");
		
		if (typeOfAddress [0].equals("redirect")) {
			
			response.sendRedirect(typeOfAddress[1]);
			
		}else {
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view"+typeOfAddress[1]);		
			rd.forward(request, response);
		}


	}

}
