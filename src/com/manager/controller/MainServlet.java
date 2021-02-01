package com.manager.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manager.model.dao.Action;
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
		
//		HttpSession session = request.getSession();
//		boolean userIsNotLogged = (session.getAttribute("user") == null);
//		boolean isProtectedAction = !(parameterAction.equals("LoginForm") || parameterAction.equals("Login"));
//		
//		if (isProtectedAction && userIsNotLogged) {
//			
//			response.sendRedirect("redirect:mainServlet?action=LoginForm");
//			return;
//		}
		
		String nameClass = "com.manager.model.dao." + parameterAction;
		String view;
		
		try {
			Class auxClass = Class.forName(nameClass);
			Object object = auxClass.newInstance();
			Action action = (Action) object;
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

}
