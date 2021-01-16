package com.manager.model.dao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.model.bean.Company;

public class ListCompanies {

	public void performs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("listing comines");
		
		DataBase  	dataBase = new DataBase();
		
		List<Company> list 	 = dataBase.getCompanies(); 
		
		request.setAttribute("listCompanies", list);

		RequestDispatcher rd = request.getRequestDispatcher("/listCompanies.jsp");
		
		rd.forward(request, response);

	}
}