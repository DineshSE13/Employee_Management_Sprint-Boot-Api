package com.example.demo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "emp")
public class EmployeeModel {

	@Id
	@GeneratedValue
	private int id;
	@NotNull(message = "Name shouldn't be null")
	private String name;
	@Min(18)
	@Max(58)
	private int age;
	@NotNull(message = "Salary shouldn't be blank")
	private long salary;

	@NotNull(message = "address shouldn't be null ")
	@OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "add_fk", referencedColumnName = "id")
	private List<Address> address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	
	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public EmployeeModel() {
		super();
	}

	public EmployeeModel(int id, String name, int age, long salary, List<Address> address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.address = address;
	}

}
