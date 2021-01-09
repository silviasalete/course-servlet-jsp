package com.manager.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.manager.model.bean.Company;

public class DataBase {
	
	private static List<Company> list = new ArrayList<>();
	
	static {
		Company company1 = new Company();
		company1.setName("Company 1");
		company1.setId(1);
		Company company2 = new Company();
		company2.setName("Company 2");
		company2.setId(2);
		
		list.add(company1);
		list.add(company2);
	}
	
	public void add(Company company) { 
		
		list.add(company);
		
	}
 
	public List<Company> getCompanies() {
		
		return DataBase.list;
		
	}
	
	public void remove(int id) {
		Company company = list.get(id);
		list.remove(company); 
	}
}
