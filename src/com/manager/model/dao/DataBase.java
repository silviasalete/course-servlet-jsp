package com.manager.model.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.manager.model.bean.Company;

public class DataBase {
	
	private static List<Company> list = new ArrayList<>();
	Random 				 		 rand = new Random();
	int 		   		   upperbound = 25;
	
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

		company.setId(rand.nextInt(upperbound));
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
				list.remove(company);
			}
		}

	} 
}
