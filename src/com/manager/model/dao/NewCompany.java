package com.manager.model.dao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.model.bean.Company;

public class NewCompany implements Action {

	public String performs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Adding new compan");
		
		Date 		  openingDate = null;
		Company 		  company = new Company();
		DataBase 		 dataBase = new DataBase(); 
		String   	  nameCompany = request.getParameter("name"); 
		
		try {
			
			String   parameterOpeningDate = request.getParameter("openingDate");			
			SimpleDateFormat 		  sdf = new SimpleDateFormat("yyyy-MM-dd"); 
							  openingDate = sdf.parse(parameterOpeningDate); 
						
		} catch (ParseException e) {
			
			throw new ServletException(e);
			
		}
		
		company.setName(nameCompany);
		company.setOpeningDate(openingDate);
		
		dataBase.add(company); 

		request.setAttribute("nameCompany", company.getName());
		
		return "redirect:mainServlet?action=ListCompanies";

	}
}
