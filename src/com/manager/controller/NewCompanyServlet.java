package com.manager.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.model.bean.Company;
import com.manager.model.dao.DataBase;
 
@WebServlet("/newCompany")
public class NewCompanyServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L; 
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 

		Date 		  openingDate = null;
		Company 		  company = new Company();
		DataBase 		 dataBase = new DataBase(); 
		String   	  nameCompany = request.getParameter("name"); 
		Random 				 rand = new Random();
		int 		   upperbound = 25;
		
		try {
			
			String   parameterOpeningDate = request.getParameter("openingDate");			
			SimpleDateFormat 		  sdf = new SimpleDateFormat("yyyy-MM-dd");
							  openingDate = sdf.parse(parameterOpeningDate);
						
		} catch (ParseException e) {
			
			throw new ServletException(e);
			
		}
		
		company.setId(rand.nextInt(upperbound));
		company.setName(nameCompany);
		company.setOpeningDate(openingDate);
		
		dataBase.add(company); 

		request.setAttribute("nameCompany", company.getName());
		
		response.sendRedirect("listCompanies");

//		RequestDispatcher rd = request.getRequestDispatcher("/listCompanies");
//		rd.forward(request,response);
//		
	}

}
