package com.manager.model.dao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manager.model.bean.User;

public class Login implements Action {

	@Override
	public String performs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String    login = request.getParameter("login");
		String password = request.getParameter("password"); 
		
		System.out.println("Logging in "+login);
		
		DataBase database = new DataBase();		
		User user = database.isUser(login,password);
		
		if (user != null) {
			System.out.println("User exists");
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return "redirect:mainServlet?action=ListCompanies";
		}else {
			return "redirect:mainServlet?action=LoginForm";
		}
	
	
	}

}
