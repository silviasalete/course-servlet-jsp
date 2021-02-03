package com.manager.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.manager.model.bean.Company;
import com.manager.model.dao.DataBase;
import com.thoughtworks.xstream.XStream;

@WebServlet("/companies")
public class CompaniesService extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Company> companies = new DataBase().getCompanies();
		
//		Gson gson = new Gson();
//		String json = gson.toJson(companies);
//		
//		response.setContentType("application/json");
//		response.getWriter().print(json);
		
		XStream xstream = new XStream();
		xstream.alias("company",Company.class);
		String      xml = xstream.toXML(companies);
		
		response.setContentType("application/xml");
		response.getWriter().print(xml);
	}

}
