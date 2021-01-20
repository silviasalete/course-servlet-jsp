package com.manager.model.bean;

public class User {

	public String login;
	public String password;
	 
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean validation(String login, String password) {
		
		if (!this.login.equals(login)) {
			return false;
		}
		

		if (!this.password.equals(password)) {
			return false;
		}
		
		return true;
	}
}
