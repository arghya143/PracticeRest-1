package com.arghya.practice.model;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
public class Student {
	
	@Id
	private int roll;
	private String name;
	private String address;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Laptop> laptop = new HashSet<>();
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	

	public Student(int roll, String name, String address, Set<Laptop> laptop) {
		super();
		this.roll = roll;
		this.name = name;
		this.address = address;
		this.laptop = laptop;
	}



	public int getRoll() {
		return roll;
	}
	
	public void setRoll(int roll) {
		this.roll = roll;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	

	public Set<Laptop> getLaptop() {
		return laptop;
	}



	public void setLaptop(Set<Laptop> laptop) {
		this.laptop = laptop;
	}



	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", address=" + address + ", laptop=" + laptop + "]";
	}


}
