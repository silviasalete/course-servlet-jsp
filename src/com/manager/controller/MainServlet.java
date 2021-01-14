package com.manager.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mainServlet")
public class MainServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parameterAction = request.getParameter("action");
		
		if (parameterAction.equals("ListCompanies")) {
			System.out.println("listing comines");
		} else if(parameterAction.equals("RemoveCompanies")) {
			System.out.println("removing companies");
		} else if(parameterAction.equals("ShowCompanies")) {
			System.out.println("showing companies");
		}
			
	}

}
