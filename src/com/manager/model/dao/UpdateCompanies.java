package com.manager.model.dao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.model.bean.Company;

public class UpdateCompanies implements Action {

	public String performs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String 		  parameterName = request.getParameter("name");
		String 		  parameterId = request.getParameter("id");
		Date openingDate = new Date();
		DataBase dataBase = new DataBase();
		
		try {

			String parameterOpeningDate = request.getParameter("openingDate");		
			SimpleDateFormat 		  sdf = new SimpleDateFormat("yyyy-MM-dd"); 
							  openingDate = sdf.parse(parameterOpeningDate); 
						
		} catch (ParseException e) {
			
			throw new ServletException(e);
			
		}

		Company company =dataBase.getCompanyById(Integer.valueOf(parameterId));
		
		company.setName(parameterName);
		company.setOpeningDate(openingDate); 
		
		dataBase.updateCompany(company); 

		return"redirect:mainServlet?action=ListCompanies";

	}
}
