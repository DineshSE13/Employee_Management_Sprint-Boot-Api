package com.example.demo;

import java.util.List;

public interface EmployeeService {
EmployeeModel saveemp(EmployeeModel emp);
List<EmployeeModel> getallEmp();
EmployeeModel getempById(int id);  
EmployeeModel update(EmployeeModel emp,int id);
List<EmployeeModel> findBySalary(long salary) ;
void deleteemp(int id );
List<EmployeeModel> findByage(int age)  ;
}
