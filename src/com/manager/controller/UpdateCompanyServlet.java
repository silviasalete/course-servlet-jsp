package com.manager.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.model.bean.Company;
import com.manager.model.dao.DataBase;

@WebServlet("/updateCompany")
public class UpdateCompanyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 

		String 		  parameterName = req.getParameter("name");
		String parameterOpeningDate = req.getParameter("openingDate");
		
		
		
	}

}
