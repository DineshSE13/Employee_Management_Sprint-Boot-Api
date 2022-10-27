package com.example.demo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api", method = { RequestMethod.GET, RequestMethod.POST })

public class Controller {
	private EmployeeService empservice;

	public Controller(EmployeeService empservice) {
		super();
		this.empservice = empservice;
	}

	@PostMapping("/employee")
	public ResponseEntity<EmployeeModel> saveemployee(@RequestBody @Valid EmployeeModel emp) {
		return new ResponseEntity<EmployeeModel>(empservice.saveemp(emp), HttpStatus.CREATED);
	}

	@GetMapping("/allemployee")

	public List<EmployeeModel> getallEmp() {

		return empservice.getallEmp();
	}

	@GetMapping("/empById/{id}")

	public ResponseEntity<EmployeeModel> getempById(@PathVariable("id") int empid) {

		return new ResponseEntity<EmployeeModel>(empservice.getempById(empid), HttpStatus.OK);
	}

	@GetMapping("/empByAge/{age}")
	
	public ResponseEntity< List<EmployeeModel>> getempByAge(@PathVariable("age") int empage)   {
		return new ResponseEntity<List<EmployeeModel>> (empservice.findByage(empage),HttpStatus.OK);
	}

	@GetMapping("/empBySalary/{salary}")

	public List<EmployeeModel> getempBySalary(@PathVariable("salary") long empsalary)  {
		return empservice.findBySalary(empsalary);
	}

	@PutMapping("/update/{id}")

	public ResponseEntity<EmployeeModel> updateemployee(@PathVariable("id") int id, @RequestBody EmployeeModel emp) {
		return new ResponseEntity<EmployeeModel>(empservice.update(emp,id), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int empid) {
		empservice.deleteemp(empid);
		return new ResponseEntity<String>(empid + " " + "deleted Successfully", HttpStatus.OK);
	}
}
