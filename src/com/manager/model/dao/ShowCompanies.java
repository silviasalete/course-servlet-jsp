package com.manager.model.dao;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.model.bean.Company;

public class ShowCompanies {

	public void performs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
		System.out.println("updating companies");
		
		String 	 parameterId = request.getParameter("id");
		Integer           id = Integer.valueOf(parameterId);
		DataBase 	dataBase = new DataBase();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Company 	 company = dataBase.getCompanyById(id);
		String 		    date = sdf.format(company.getOpeningDate());

		request.setAttribute("company", company);
		request.setAttribute("dateFormat", date);

		RequestDispatcher rd = request.getRequestDispatcher("/formUpdateCompany.jsp");
		
		rd.forward(request, response);

	}
}
