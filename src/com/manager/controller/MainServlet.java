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
		
	}

}
