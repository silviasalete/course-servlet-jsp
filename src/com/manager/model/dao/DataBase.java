package com.manager.model.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.manager.model.bean.Company;
import com.manager.model.bean.User;

public class DataBase {
	
	private static   List<Company> list = new ArrayList<>();
	private static   List<User> listUser = new ArrayList<>();
	
	private static Integer sequenialKey = 1; 
	
	static {
		Company company1 = new Company();
		company1.setName("Company 1");
		company1.setId(sequenialKey++);
		Company company2 = new Company();
		company2.setName("Company 2");
		company2.setId(sequenialKey++);
		
		list.add(company1);
		list.add(company2);
	}
	
	public void add(Company company) { 

		company.setId(DataBase.sequenialKey++);
		list.add(company);
		
	}
 
	public List<Company> getCompanies() {
		
		return DataBase.list;
		
	}
	
	public void removeCompany(Integer id) {
		
		Iterator<Company> iterator = list.iterator();
		
		while(iterator.hasNext()) {
			
			Company company = iterator.next();
			
			if(company.getId() == id) {

				iterator.remove();

			}
		}

	}

	public void updateCompany(Company company) {

		
	}

	public Company getCompanyById(Integer id) {

		for (Company company : list) {
			if (company.getId() ==  id) {
				return company;
			}
		}
		return null;
	} 
}
