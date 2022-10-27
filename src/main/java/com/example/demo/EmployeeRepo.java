package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EmployeeRepo extends JpaRepository<EmployeeModel, Integer>{

	public List<EmployeeModel> findByage(int age);
	public List<EmployeeModel> findBySalary(long salary );
}
