package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepo extends JpaRepository<EmployeeModel, Integer>{

	public List<EmployeeModel> findByage(int age);
	public List<EmployeeModel> findBySalary(long salary );
}
