package com.arghya.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.arghya.practice.dao.MyLaptop;
import com.arghya.practice.dao.MyRepository;
import com.arghya.practice.model.Laptop;
import com.arghya.practice.model.Student;

@SpringBootApplication
public class PracticeRest1Application implements CommandLineRunner{

	@Autowired
	MyRepository repo;
	
	@Autowired
	MyLaptop r;
	
	public static void main(String[] args) {
		SpringApplication.run(PracticeRest1Application.class, args);
				
	}
	
	public void run(String... args) throws Exception
	{
		Laptop laptop1 = new Laptop();
		laptop1.setLid(101);
		laptop1.setLname("Dell");
		
		Laptop laptop2 = new Laptop();
		laptop2.setLid(102);
		laptop2.setLname("HP");
		
		Student student1 = new Student();
		student1.setRoll(1);
		student1.setName("Arghya");
		student1.setAddress("Ekterpur");
		
		Student student2 = new Student();
		student2.setRoll(2);
		student2.setName("Arpan");
		student2.setAddress("Kamarhati");
		
		
		laptop1.getStudent().add(student2);
		laptop2.getStudent().add(student1);
		student1.getLaptop().add(laptop1);
		student2.getLaptop().add(laptop2);
		r.save(laptop1);
		r.save(laptop2);
		repo.save(student1);
		repo.save(student2);
	}

}
