package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceimpl implements EmployeeService {

	private EmployeeRepo emprepo;

	public EmployeeServiceimpl(EmployeeRepo emprepo) {
		super();
		this.emprepo = emprepo;
	}

	@Override
	public EmployeeModel saveemp(EmployeeModel emp) {
		return emprepo.save(emp);
	}

	@Override
	public List<EmployeeModel> getallEmp() {
		return emprepo.findAll();
	}

	@Override
	public EmployeeModel getempById(int id) {
		return emprepo.findById(id).orElseThrow(() -> new ExceptionHandle("Employee", "ID", id));

	}

	@Override
	public EmployeeModel update(EmployeeModel emp,int id) {
		EmployeeModel exist = emprepo.findById(id)
				.orElseThrow(() -> new ExceptionHandle("Employee", "id", id));
		exist.setName(emp.getName());
		exist.setAge(emp.getAge());
		exist.setSalary(emp.getSalary());
		emprepo.save(exist);
		return exist;
	}

	@Override
	public void deleteemp(int id) {
		emprepo.findById(id).orElseThrow(() -> new ExceptionHandle("Employee", "Id", id));
		emprepo.deleteById(id);
	}

	@Override
	public List<EmployeeModel> findByage(int age) throws ExceptionHandle {
		List<EmployeeModel> empage = emprepo.findByage(age);
			return empage;
		
	}

	@Override
	public List<EmployeeModel> findBySalary(long salary) throws ExceptionHandle {
		List<EmployeeModel> empsalary= emprepo.findBySalary(salary);
			return empsalary;
		
	}
	
}
